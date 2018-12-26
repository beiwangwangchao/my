package com.inlee.util.codegenerate;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 代码生成器
 * @author inlee
 * 根据表名生成dao、service等等，采用freemarker制作模板文件
 */
public class FreeMarker {
	public static void main(String[] args) throws Exception{
		FreeMarker marker = new FreeMarker();
		marker.init();
		
		final String driver    = "com.mysql.jdbc.Driver";
		final String url       = "jdbc:mysql://192.168.3.249:3306/yaokood2";
		final String user      = "root";
		final String password  = "123456";
		
		// 生成 dao、service
		Map<String,List<String>> tables = marker.getTables(driver, url, user, password);
		if(null!= tables && tables.size()>0){
			Iterator<Map.Entry<String,List<String>>> iter =tables.entrySet().iterator();
			while(iter.hasNext()){
				Map.Entry<String,List<String>> entry = iter.next();
				String key = entry.getKey().split("_")[1];
				String first = key.substring(0, 1).toUpperCase();
				String rest = key.substring(1, key.length());
				String tableName = new StringBuffer(first).append(rest).toString();
				marker.process(marker,tableName);
			}
		}
		// 生成entity src/main/java/ 这个参数是必须的，按照maven格式来生成
		marker.getnerateEntity("E:/workspace/easyim/easyim-register-moudles/easyim-register-mapper/", "src/main/java/com/inlee/easyim/register/entity/", tables);
		// 生成mapper
		marker.getnerateMapper("E:/workspace/easyim/easyim-register-moudles/easyim-register-mapper/", "src/main/resources/", tables);
		
	}
	private String workSpace = "E:/workspaces";// 工作空间，项目目录
	private String templateFile  = workSpace+"/inlee-utils/src/main/resources/template/";
	private Configuration cfg=null;
	
	public void init() throws Exception{
		cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File(templateFile));
	}
	
	public void process(FreeMarker mark,String entity_name) throws Exception{
		Map<String,String> root = new HashMap<String,String>();  
	    root.put("entity_name", entity_name);  
		// 生成DAO
		String projectPath = workSpace+"/";
		String fileName    = entity_name+"Mapper.java";
		String savePath    = "easyim/easyim-register-moudles/easyim-register-mapper/src/main/java/com/inlee/easyim/register/mapper/";
		Template tem       = cfg.getTemplate("Mapper.ftl");
		mark.buildTemplate(root, projectPath, savePath, fileName, tem);
		System.out.println(entity_name+"Mapper生成成功!");
	}
	// 根据模板文件生成代码
	public void buildTemplate(Map<String,String> root, String projectPath, String savePath,String fileName, Template template){
		 String realFileName = projectPath + savePath + fileName;
	     File file=new File(realFileName);
         if(file.exists()){
        	System.out.println("文件："+fileName+"已存在");
        	return ;
         }
         String realSavePath = projectPath + savePath;  
         File newsDir = new File(realSavePath);  
         if (!newsDir.exists()) {  
             newsDir.mkdirs();  
         } 
         try {  
             // SYSTEM_ENCODING = "UTF-8";  
             Writer out = new OutputStreamWriter(new FileOutputStream(  
                     realFileName),"UTF-8");  
             template.process(root, out);  
         } catch (Exception e) {  
             e.printStackTrace();  
         } 
	}
	/**
	 * 获取数据库中所有的表和字段
	 * @param driver
	 * @param url
	 * @param user
	 * @param password
	 * @return 返回一个map，key是表名，value是字段列表，其中字段格式: 字段名:是否自增:数据类型  ex: ename:YES:-5
	 *         字段数据类型是封装成的一个类，值是数字类型，有可能有负值
	 */
	public Map<String,List<String>> getTables(String driver,String url,String user,String password){
	 	try {
    		Map<String,List<String>> map = new HashMap<String,List<String>>();
			  Class.forName(driver);
			  // 获取链接
			  Connection connection = DriverManager.getConnection(url, user, password);
			  String currentCatalog=connection.getCatalog();
			  ResultSet resultSet = connection.getMetaData().getTables(currentCatalog, null, null, new String[]{"TABLE"});
			  ResultSet rs = null;
			  while(resultSet.next()){
                String tableName=resultSet.getObject(3).toString();
                rs = connection.getMetaData().getColumns(currentCatalog, null, tableName, null);
                List<String> list = new ArrayList<String>();
                while(rs.next()){
                	list.add(rs.getString(4)+":"+rs.getString("IS_AUTOINCREMENT")+":"+rs.getString("DATA_TYPE"));
                }
                map.put(tableName, list);
			  } 
			  rs.close();
			  resultSet.close();
			  connection.close();
			  return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
	}
	/**
	 * 根据表名、字段名 生成entity和get、set方法
	 * @param projectPath
	 * @param savePath
	 * @param map
	 * @throws IOException 
	 */
	public void getnerateEntity(String projectPath,String savePath,Map<String,List<String>> map) throws IOException{
		String fileName;
		// 根据表名生成entity，表名首字母大写并用作文件名类名
		for(Map.Entry<String, List<String>> entry:map.entrySet()){
			String tableName = entry.getKey();
			fileName = tableName.substring(tableName.indexOf("_")+1);
			if(fileName.contains("_")){
				String names[] = fileName.split("_");
				for (int i =0;i<names.length;i++) {
					if(i==0){
						fileName = names[i].substring(0,1).toUpperCase()+names[i].substring(1);
						continue;
					}
					fileName += names[i].substring(0,1).toUpperCase()+names[i].substring(1);
				}
			}else{
				fileName = fileName.substring(0,1).toUpperCase()+fileName.substring(1);
			}
			File path = new File(projectPath+savePath);
			if(!path.exists())
				path.mkdirs(); // 
			File file = new File(projectPath+savePath+fileName+".java");
			if(file.exists()){
				System.err.println("entity:"+fileName+"已存在！");
				continue;
			}
			
			StringBuilder sb = new StringBuilder();
			// 包名就是目录名称，去除：src/main/java
			sb.append("package "+savePath.substring(14,savePath.length()-1).replaceAll("/", ".")+";\r\n");
			sb.append("\r\n");
			sb.append("import java.io.Serializable;");
			sb.append("\r\n");
			sb.append("/**");
			sb.append("\r\n");
			sb.append("* 代码生成器自动生成,Date:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			sb.append("\r\n");
			sb.append("* @author inlee");
			sb.append("\r\n");
			sb.append("*/");
			sb.append("\r\n");
			sb.append("public class "+fileName+" implements Serializable {\r\n");
			List<String> list = entry.getValue();
			
			// 表字段生成属性,字段格式--字段名:是否自增:数据类型,分隔符-->":"
			for (String str : list) {
				String string[] = str.split(":");
				String columnName = string[0];//列名
				String oldColumn = columnName;
			//	String isAuto = string[1];//是否自增
				Integer type = Integer.valueOf(string[2]);
				
				// 将数据库类型替换成java的对象类型
				String newName = " ";
				String newType = " ";
				switch(type){
				case Types.BIGINT:
					newType = "Long";
					newName = "Long "+oldColumn;
					sb.append("\tprivate Long "+oldColumn+";\r\n");
					break;
				case Types.SMALLINT:
				case Types.INTEGER:
					newType = "Integer";
					newName = "Integer "+oldColumn;
					sb.append("\tprivate Integer "+oldColumn+";\r\n");
					break;
				case Types.TINYINT:
				case Types.BOOLEAN:
				case Types.BIT:
					newType = "Boolean";
					newName = "Boolean "+oldColumn;
					sb.append("\tprivate Boolean "+oldColumn+";\r\n");
					break;
				case Types.VARCHAR:
				case Types.LONGVARCHAR:
				case Types.LONGNVARCHAR:
					newType = "String";
					newName = "String "+oldColumn;
					sb.append("\tprivate String "+oldColumn+";\r\n");
					break;
				case Types.DATE:
				case Types.TIMESTAMP:
				case Types.TIME:
					newType = "Calendar";
					newName = "Calendar "+oldColumn;
					sb.append("\tprivate Calendar "+oldColumn+";\r\n");
					break;
				case Types.DOUBLE:
					newType = "Double";
					newName = "Double "+oldColumn;
					sb.append("\tprivate Double "+oldColumn+";\r\n");
					break;
				case Types.FLOAT:
					newType = "Float";
					newName = "Float "+oldColumn;
					sb.append("\tprivate Float "+oldColumn+";\r\n");
					break;
				}
				
				// 生成 get、set方法
				sb.append("\r\n");
				String setter = columnName.substring(0,1).toUpperCase()+columnName.substring(1);
				sb.append("\tpublic void set"+setter+"("+newName+") {\r\n");
				sb.append("\t\tthis."+oldColumn+" = "+oldColumn+";\r\n");
				sb.append("\t}");
				sb.append("\r\n");
				sb.append("\tpublic "+newType+" get"+setter+"() {\r\n");
				sb.append("\t\treturn "+oldColumn+";\r\n");
				sb.append("\t}\r\n");
				sb.append("\r\n");
			}
			sb.append("}");
			FileWriter fw = new FileWriter(file);
			fw.append(sb.toString());
			fw.close();
			System.out.println("entity"+fileName+" gernerate success!");
		  }
	}
	/**
	 * 根据表名生成mapper.xml的增、删、改、查 
	 * @param projectPath
	 * @param savePath
	 * @param map
	 * @throws IOException
	 */
	public void getnerateMapper(String projectPath,String savePath,Map<String,List<String>> map) throws IOException{
		String fileName;
		// 根据表名生成entity，表名首字母大写并用作文件名类名
		for(Map.Entry<String, List<String>> entry:map.entrySet()){
			String tableName = entry.getKey();
			fileName = tableName.substring(tableName.indexOf("_")+1);
			if(fileName.contains("_")){
				String names[] = fileName.split("_");
				for (int i =0;i<names.length;i++) {
					if(i==0){
						fileName = names[i].substring(0,1).toUpperCase()+names[i].substring(1);
						continue;
					}
					fileName += names[i].substring(0,1).toUpperCase()+names[i].substring(1);
				}
			}else{
				fileName = fileName.substring(0,1).toUpperCase()+fileName.substring(1);
			}
			File path = new File(projectPath+savePath);
			if(!path.exists())
				path.mkdirs(); // 
			File file = new File(projectPath+savePath+fileName+"Mapper.xml");
			if(file.exists()){
				System.err.println("mapper:"+fileName+".xml 已存在！");
				continue;
			}
			StringBuilder sb = new StringBuilder();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("\r\n");
			sb.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">");
			sb.append("\r\n");
			sb.append("<mapper namespace=\"com.inlee.easyim.register.mapper."+fileName+"Mapper"+"\">");
			sb.append("\r\n");
			sb.append("<insert id=\"add\" parameterType=\""+fileName+"\">");
			sb.append("\r\n");
			// add
			sb.append("INSERT INTO ").append(tableName).append("(");
			List<String> list = entry.getValue();
			
			for(int i=0,len=list.size();i<len;i++){
				String string[] = list.get(i).split(":");
				String columnName = string[0];//列名
				if("id".equals(columnName)) continue;
				sb.append(columnName);
				if(i <len-1)
				sb.append(",");
			}
			sb.append(")");
			sb.append(" VALUES(");
			for(int i=0,len=list.size();i<len;i++){
				String string[] = list.get(i).split(":");
				String columnName = string[0];//列名
				if("id".equals(columnName)) continue;
				sb.append("#{");
				sb.append(columnName);
				sb.append("}");
				if(i <len-1)
					sb.append(",");
			}
			sb.append(")");
			sb.append("\r\n");
			sb.append("</insert>");
			sb.append("\r\n");
			// delete
			sb.append("<delete id=\"delete\" parameterType=\"long\">");
			sb.append("\r\n");
			sb.append("DELETE FROM ").append(tableName).append(" WHERE id=").append(" ${_parameter}");
			sb.append("\r\n");
			sb.append("</delete>");
			sb.append("\r\n");
			// update
			sb.append("<update id=\"update\" parameterType=\""+fileName+"\">");
			sb.append("\r\n");
			sb.append("UPDATE ").append(tableName).append(" SET ");
			for(int i=0,len=list.size();i<len;i++){
				String string[] = list.get(i).split(":");
				String columnName = string[0];//列名
				if("id".equals(columnName)) continue;
				sb.append(columnName).append("=").append("#{").append(columnName).append("}");
				if(i <len-1)
					sb.append(",");
			}
			sb.append(" WHERE id = #{id}");
			sb.append("\r\n");
			sb.append("</update>");
			sb.append("\r\n");
			// search
			sb.append("<select id=\"findById\" parameterType=\"Map\" resultType=\""+fileName+"\">");
			sb.append("\r\n");
			sb.append("SELECT ");
			for(int i=0,len=list.size();i<len;i++){
				String string[] = list.get(i).split(":");
				String columnName = string[0];//列名
				sb.append(columnName);
				if(i <len-1)
					sb.append(",");
			}
			sb.append(" FROM ").append(tableName).append(" WHERE id=").append("#{_parameter}");
			sb.append("\r\n");
			sb.append("</select>");
			sb.append("\r\n");
			// find by prop
			sb.append("<select id=\"findByProperty\" parameterType=\"Map\" resultType=\""+fileName+"\">");
			sb.append("\r\n");
			sb.append("SELECT ");
			for(int i=0,len=list.size();i<len;i++){
				String string[] = list.get(i).split(":");
				String columnName = string[0];//列名
				sb.append(columnName);
				if(i <len-1)
					sb.append(",");
			}
			sb.append(" FROM ").append(tableName).append(" WHERE 1=1 ");
			sb.append("\r\n");
			for(int i=0,len=list.size();i<len;i++){
				String string[] = list.get(i).split(":");
				String columnName = string[0];//列名
				sb.append("<if test=\""+columnName+" !=null\">");
				sb.append("\r\n");
				sb.append(" AND ").append(columnName).append("=").append("#{").append(columnName).append("}");
				sb.append("\r\n");
				sb.append("</if>");
				sb.append("\r\n");
			}
			sb.append("\r\n");
			sb.append("</select>");
			sb.append("\r\n");
			sb.append("</mapper>");
			FileWriter fw = new FileWriter(file);
			fw.append(sb.toString());
			fw.close();
			System.out.println("Map "+fileName +"success!");
		}
		
	}
}
