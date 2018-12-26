package com.inlee.util.codegenerate;

import com.inlee.util.codegenerate.bean.EntityBean;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.*;

public class FreeMarker1 {
	private static final String gPath = "E:\\xiaopeng\\code\\crm";
	/**
	 * 遍历数据库表
	 * 拆分生成entity生成getter、setter
	 * 生成mapper
	 * 生成mapper.xml
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// 生成entity
			String tmpFilePath = "E:\\xiaopeng\\git\\crm\\crm-doc\\crm-doc\\inlee-utils-for-crm\\src\\main\\resources\\template";

			Configuration cfg=new Configuration();
			cfg.setDirectoryForTemplateLoading(new File(tmpFilePath));
			final String driver    = "com.mysql.jdbc.Driver";
			final String url       = "jdbc:mysql://db_srv:3306/crmnew?Unicode=true&characterEncoding=UTF-8";
			final String user      = "root";
			final String password  = "Hugaint2017";
			Map<String,List<EntityBean>> map = getDatas(driver,url,user,password);
		//	genHttpEntity(cfg);
		//	genEntity(map,cfg);
            genEntityLombok(map, cfg);
			genMapper(map,cfg);
			genXmlMapper(map,cfg);
			genController(map,cfg);
			//Biz目录
			bizService(map,cfg);
		//	apiService(map, cfg);
		//	apiServiceImpl(map, cfg);
        //    genEntityJson(map, cfg);
			System.out.println("ok啦！全部搞定！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void genEntity(Map<String,List<EntityBean>> map,Configuration cfg) throws IOException{
        String savePath = gPath+"entity/";
        if(null!=map &&map.size()>0){
            Iterator<Map.Entry<String,List<EntityBean>>> iter1 =map.entrySet().iterator();
            while(iter1.hasNext()){
                Map.Entry<String,List<EntityBean>> entry1 = iter1.next();
                // 生成entity
                Template temEntity= cfg.getTemplate("Entity.ftl");
                //
                File file=new File(savePath+entry1.getKey()+".java");
                if(file.exists()){
                    System.out.println(entry1.getKey()+"  已经存在! ");
                    continue;
                }
                File newsDir = new File(savePath);
                if (!newsDir.exists()) {
                    newsDir.mkdirs();
                }
                Map root = new HashMap();
                root.put("entity_name", entry1.getKey());
                root.put("beans", entry1.getValue());
                try {
                    Writer out = new OutputStreamWriter(new FileOutputStream(  savePath+entry1.getKey()+".java"),"UTF-8");
                    temEntity.process(root, out);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void genEntityJson(Map<String,List<EntityBean>> map,Configuration cfg) throws IOException{
        String savePath = gPath+"json/";
        if(null!=map &&map.size()>0){
            Iterator<Map.Entry<String,List<EntityBean>>> iter1 =map.entrySet().iterator();
            while(iter1.hasNext()){
                Map.Entry<String,List<EntityBean>> entry1 = iter1.next();
                // 生成entity
                Template temEntity= cfg.getTemplate("EntityJson.ftl");
                //
                File file=new File(savePath+entry1.getKey()+".java");
                if(file.exists()){
                    System.out.println(entry1.getKey()+"  已经存在! ");
                    continue;
                }
                File newsDir = new File(savePath);
                if (!newsDir.exists()) {
                    newsDir.mkdirs();
                }
                Map root = new HashMap();
                root.put("entity_name", entry1.getKey());
                root.put("beans", entry1.getValue());
                try {
                    Writer out = new OutputStreamWriter(new FileOutputStream(  savePath+entry1.getKey()+"Json.java"),"UTF-8");
                    temEntity.process(root, out);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void genEntityLombok(Map<String,List<EntityBean>> map,Configuration cfg) throws IOException{
        String savePath = gPath+"lombok/";
        if(null!=map &&map.size()>0){
            Iterator<Map.Entry<String,List<EntityBean>>> iter1 =map.entrySet().iterator();
            while(iter1.hasNext()){
                Map.Entry<String,List<EntityBean>> entry1 = iter1.next();
                // 生成entity
                Template temEntity= cfg.getTemplate("EntityLombok.ftl");
                //
                File file=new File(savePath+entry1.getKey()+".java");
                if(file.exists()){
                    System.out.println(entry1.getKey()+"  已经存在! ");
                    continue;
                }
                File newsDir = new File(savePath);
                if (!newsDir.exists()) {
                    newsDir.mkdirs();
                }
                Map root = new HashMap();
                root.put("entity_name", entry1.getKey());
                root.put("beans", entry1.getValue());
                try {
                    Writer out = new OutputStreamWriter(new FileOutputStream(  savePath+entry1.getKey()+".java"),"UTF-8");
                    temEntity.process(root, out);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
	public static void genMapper(Map<String,List<EntityBean>> map,Configuration cfg) throws IOException{
		String savePath = gPath+"mapper/";
		if(null!=map &&map.size()>0){
			Iterator<Map.Entry<String,List<EntityBean>>> iter1 =map.entrySet().iterator();
			while(iter1.hasNext()){
				Map.Entry<String,List<EntityBean>> entry1 = iter1.next();
				// 生成entity
				Template temEntity= cfg.getTemplate("Mapper.ftl");
				File file=new File(savePath+entry1.getKey()+"Mapper.java");
				if(file.exists()){
					System.out.println(entry1.getKey()+"  已经存在! ");
					continue;
				}
			    File newsDir = new File(savePath);  
		        if (!newsDir.exists()) {  
		             newsDir.mkdirs();  
		        }
		        Map root = new HashMap();
		        root.put("entity_name", entry1.getKey());
		        try {  
		             Writer out = new OutputStreamWriter(new FileOutputStream(  savePath+entry1.getKey()+"Mapper.java"),"UTF-8");  
		             temEntity.process(root, out);  
		         } catch (Exception e) {  
		             e.printStackTrace();  
		         }
			}
		}
	}
	public static void genXmlMapper(Map<String,List<EntityBean>> map,Configuration cfg) throws IOException{
		String savePath = gPath+"xml/";
		if(null!=map &&map.size()>0){
			Iterator<Map.Entry<String,List<EntityBean>>> iter1 =map.entrySet().iterator();
			while(iter1.hasNext()){
				Map.Entry<String,List<EntityBean>> entry1 = iter1.next();
				// 生成entity
				Template temEntity= cfg.getTemplate("XmlMapper.ftl");
				File file=new File(savePath+entry1.getKey()+"Mapper.xml");
				if(file.exists()){
					System.out.println(entry1.getKey()+"  已经存在! ");
					continue;
				}
			    File newsDir = new File(savePath);  
		        if (!newsDir.exists()) {  
		             newsDir.mkdirs();  
		        }
		        Map root = new HashMap();
		        root.put("beans",entry1.getValue());
		        root.put("entity_name", entry1.getKey());
		        root.put("entity_name_low", entry1.getKey().substring(0,1).toLowerCase()+entry1.getKey().substring(1,entry1.getKey().length()));
		        root.put("entity_key", entry1.getValue().get(0).getKeyName());
		        root.put("entity_table_name", entry1.getValue().get(0).getTableName());
		        root.put("entity_key_field_name", entry1.getValue().get(0).getFiledName());
		        try {  
		             Writer out = new OutputStreamWriter(new FileOutputStream(savePath+entry1.getKey()+"Mapper.xml"),"UTF-8");  
		             temEntity.process(root, out);  
		         } catch (Exception e) {  
		             e.printStackTrace();  
		         }
			}
		}
	}
	public static void genController(Map<String,List<EntityBean>> map,Configuration cfg) throws IOException{
		String savePath = gPath+"controller/";
		if(null!=map &&map.size()>0){
			Iterator<Map.Entry<String,List<EntityBean>>> iter1 =map.entrySet().iterator();
			while(iter1.hasNext()){
				Map.Entry<String,List<EntityBean>> entry1 = iter1.next();
				// 生成entity
				Template temEntity= cfg.getTemplate("Controller.ftl");
				File file=new File(savePath+entry1.getKey()+"Controller.java");
				if(file.exists()){
					System.out.println(entry1.getKey()+"  已经存在! ");
					continue;
				}
			    File newsDir = new File(savePath);  
		        if (!newsDir.exists()) {  
		             newsDir.mkdirs();  
		        }
		        Map root = new HashMap();
		        root.put("beans",entry1.getValue());
		        root.put("entity_name", entry1.getKey());
		        root.put("entity_name_low", entry1.getKey().substring(0,1).toLowerCase()+entry1.getKey().substring(1,entry1.getKey().length()));
		        root.put("entity_key", entry1.getValue().get(0).getKeyName());
		        root.put("entity_table_name", entry1.getValue().get(0).getTableName());
		        root.put("entity_key_field_name", entry1.getValue().get(0).getFiledName());
		        try {  
		             Writer out = new OutputStreamWriter(new FileOutputStream(savePath+entry1.getKey()+"Controller.java"),"UTF-8");
		             temEntity.process(root, out);  
		         } catch (Exception e) {  
		             e.printStackTrace();  
		         }
			}
		}
	}

	/**
	 * 
	 * @param driver
	 * @param url
	 * @param user
	 * @param password
	 * @return Map<Key,Value> Key是表名 value是表中字段的封装
	 */
	public static Map<String,List<EntityBean>> getDatas(String driver,String url,String user,String password){
		Map<String,List<EntityBean>> map = new HashMap<String,List<EntityBean>>();
		Map<String,List<String>> tables = getTables(driver, url, user, password);
		if(null!= tables && tables.size()>0){
			Iterator<Map.Entry<String,List<String>>> iter =tables.entrySet().iterator();
			while(iter.hasNext()){
			// 去除表明和字段的下划线、首字母大写 
			//	EntityBean eb = new EntityBean();
				Map.Entry<String,List<String>> entry = iter.next();
				String entityName = ""; // 实体名称
				String keyName = "";
				String tableName = entry.getKey();
				String[] keys = entry.getKey().split("_");
				for(int i=0,len=keys.length;i<len;i++){
					String k = keys[i];
					/***生成实体名字**/
					System.out.println(tableName);
					entityName += k.substring(0, 1).toUpperCase()+k.substring(1,k.length());
				}
					/***生成属性名字**/
					List<String> list = entry.getValue();
					List<EntityBean> beanlist = new ArrayList<EntityBean>();
					// 表字段生成属性,字段格式--字段名:是否自增:数据类型,分隔符-->":"
					for(int m=0;m<list.size();m++){
						String str = list.get(m);
						String string[] = str.split(":");
						String filedName = string[0]; // 字段名称
						String type  = ""; // 数据类型
						//String isAuto=string[1]; // 是否自增
						String dateType=string[2]; // 数据类型
						String propName = ""; // 属性名称(首字母小写)
						String propNameUP = ""; // 属性名称(首字母大写)
						System.out.println("filedName："+filedName);
						String[] fNames =filedName.split("_");
						String p = "";
						for(int i=0,len=fNames.length;i<len;i++){
							String k = fNames[i];
							/***生成实体名字**/
							System.out.println(tableName);
							p += k.substring(0, 1).toUpperCase()+k.substring(1,k.length());
						}
						propNameUP  = p;
						propName  = p.substring(0,1).toLowerCase()+p.substring(1,p.length());
						type = getType(Integer.valueOf(dateType));
						if(m==0)keyName = propName;
						String remark="";
						try {
							remark = string[3];
						} catch (Exception e) {
						}
						beanlist.add(new EntityBean(keyName,"private",type,entityName,propName,propNameUP,tableName,filedName,remark));
					System.out.println(keyName+" "+type+" "+entityName+" "+propName+"   "+propNameUP+" "+tableName+" "+filedName);
					}
					map.put(entityName,beanlist);
				//}
			}
		}
		return map;
	}
	public static String getType(Integer type){
		String typeName = "";
		switch(type){
		case Types.BIGINT:
			typeName = "Long";
			break;
		case Types.SMALLINT:
		case Types.INTEGER:
			typeName = "Integer";
			break;
		case Types.TINYINT:
		case Types.BOOLEAN:
		case Types.BIT:
			typeName = "Boolean";
			break;
		case Types.VARCHAR:
		case Types.LONGVARCHAR:
		case Types.LONGNVARCHAR:
			typeName = "String";
			break;
		case Types.DATE:
		case Types.TIMESTAMP:
		case Types.TIME:
			typeName = "Date";
			break;
		case Types.DOUBLE:
		case Types.DECIMAL:
			typeName = "Double";
			break;
		case Types.FLOAT:
			typeName = "Float";
			break;
		}
		return typeName;
	}
	/**
	 * 获取数据库中数据的表和字段
	 * @param driver
	 * @param url
	 * @param user
	 * @param password
	 * @return 返回一个map，key是表名，value是字段列表，其中字段格式: 字段名:是否自增:数据类型  ex: ename:YES:-5
	 *         字段数据类型是封装成的一个类，值是数字类型，有可能有负值(枚举类型)
	 */
	public static Map<String,List<String>> getTables(String driver,String url,String user,String password){
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
                	list.add(rs.getString(4)+":"+rs.getString("IS_AUTOINCREMENT")+":"+rs.getString("DATA_TYPE")+":"+rs.getString("REMARKS"));
                }
                map.put(tableName, list);
			  } 
			  if(rs != null) {
				  rs.close();
			  }
			  resultSet.close();
			  connection.close();
			  return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
	}

	public static void bizService(Map<String,List<EntityBean>> map,Configuration cfg) throws IOException{
		String savePath = gPath+"biz/";
		if(null!=map &&map.size()>0){
			Iterator<Map.Entry<String,List<EntityBean>>> iter1 =map.entrySet().iterator();
			while(iter1.hasNext()){
				Map.Entry<String,List<EntityBean>> entry1 = iter1.next();
				// 生成entity
				Template temEntity= cfg.getTemplate("BizService.ftl");
				//
				File file=new File(savePath+entry1.getKey()+".java");
				if(file.exists()){
					System.out.println(entry1.getKey()+"  已经存在! ");
					continue;
				}
			    File newsDir = new File(savePath);  
		        if (!newsDir.exists()) {  
		             newsDir.mkdirs();  
		        }
				Map root = new HashMap();
		        root.put("entity_name", entry1.getKey());
		        root.put("entity_name_low", entry1.getKey().substring(0,1).toLowerCase()+entry1.getKey().substring(1,entry1.getKey().length()));
		       // root.put("beans", entry1.getValue());
		        try {  
		             Writer out = new OutputStreamWriter(new FileOutputStream(savePath+entry1.getKey()+"Biz.java"),"UTF-8");
		             temEntity.process(root, out);  
		         } catch (Exception e) {  
		             e.printStackTrace();  
		         }
			}
		}
	}
	public static void apiService(Map<String,List<EntityBean>> map,Configuration cfg) throws IOException{
		String savePath = gPath+"api/";
		if(null!=map &&map.size()>0){
			Iterator<Map.Entry<String,List<EntityBean>>> iter1 =map.entrySet().iterator();
			while(iter1.hasNext()){
				Map.Entry<String,List<EntityBean>> entry1 = iter1.next();
				// 生成entity
				Template temEntity= cfg.getTemplate("ApiService.ftl");
				//
				File file=new File(savePath+entry1.getKey()+".java");
				if(file.exists()){
					System.out.println(entry1.getKey()+"  已经存在! ");
					continue;
				}
				File newsDir = new File(savePath);
				if (!newsDir.exists()) {
					newsDir.mkdirs();
				}
				Map root = new HashMap();
				root.put("entity_name", entry1.getKey());
				root.put("entity_name_low", entry1.getKey().substring(0,1).toLowerCase()+entry1.getKey().substring(1,entry1.getKey().length()));
				// root.put("beans", entry1.getValue());
				try {
					Writer out = new OutputStreamWriter(new FileOutputStream(savePath+entry1.getKey()+"Api.java"),"UTF-8");
					temEntity.process(root, out);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void apiServiceImpl(Map<String,List<EntityBean>> map,Configuration cfg) throws IOException{
		String savePath = gPath+"apiImpl/";
		if(null!=map &&map.size()>0){
			Iterator<Map.Entry<String,List<EntityBean>>> iter1 =map.entrySet().iterator();
			while(iter1.hasNext()){
				Map.Entry<String,List<EntityBean>> entry1 = iter1.next();
				// 生成entity
				Template temEntity= cfg.getTemplate("ApiServiceImpl.ftl");
				//
				File file=new File(savePath+entry1.getKey()+".java");
				if(file.exists()){
					System.out.println(entry1.getKey()+"  已经存在! ");
					continue;
				}
				File newsDir = new File(savePath);
				if (!newsDir.exists()) {
					newsDir.mkdirs();
				}
				Map root = new HashMap();
				root.put("entity_name", entry1.getKey());
				root.put("entity_name_low", entry1.getKey().substring(0,1).toLowerCase()+entry1.getKey().substring(1,entry1.getKey().length()));
				// root.put("beans", entry1.getValue());
				try {
					Writer out = new OutputStreamWriter(new FileOutputStream(savePath+entry1.getKey()+"ImplApi.java"),"UTF-8");
					temEntity.process(root, out);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}


	public static List<File> filelist = new ArrayList<File>();
	
	public static void genHttpEntity(Configuration cfg) throws Exception {
		BufferedReader bufferedReader = null;
		String savePath = gPath+"httpEntity/";
		filelist = getFileList("E:/httpEntityTxt");
		for (File file : filelist) {
			System.out.println("读取文件："+file.getAbsolutePath());
			try {
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), "utf-8");// 考虑到编码格式
				bufferedReader = new BufferedReader(read);
				String field = bufferedReader.readLine();
				ArrayList<EntityBean> beanList = new ArrayList<EntityBean>();
				Map<String,List<EntityBean>> map = new HashMap<String, List<EntityBean>>();
				while (field != null) {
					String[] fields = field.split(",");
					String propName   = fields[0].trim();
					String propNameUP = propName.substring(0,1).toUpperCase()+propName.substring(1,propName.length());
					beanList.add(new EntityBean(null, "private", fields[2].trim(), null, propName, propNameUP, null, null, fields[1].trim()));
					field = bufferedReader.readLine(); 
				}
				map.put(file.getName().replaceAll("[.][^.]+$", ""), beanList);
				
				if(null!=map &&map.size()>0){
					Iterator<Map.Entry<String,List<EntityBean>>> iter1 =map.entrySet().iterator();
					while(iter1.hasNext()){
						Map.Entry<String,List<EntityBean>> entry1 = iter1.next();
						// 生成entity
						Template temEntity = null;
						StringBuffer finalPath = new StringBuffer();
						if(file.getAbsolutePath().toLowerCase().contains("request")){
							temEntity= cfg.getTemplate("Request.ftl");
							finalPath.append(savePath).append("request/");
						}else if (file.getAbsolutePath().toLowerCase().contains("response")) {
							temEntity= cfg.getTemplate("Response.ftl");
							finalPath.append(savePath).append("response/");
						}else if (file.getAbsolutePath().toLowerCase().contains("submit")) {
							temEntity= cfg.getTemplate("Submit.ftl");
							finalPath.append(savePath).append("submit/");
						}else if (file.getAbsolutePath().toLowerCase().contains("return")) {
							temEntity= cfg.getTemplate("Return.ftl");
							finalPath.append(savePath).append("return/");
						}
						//
						File newsDir = new File(finalPath.toString());  
				        if (!newsDir.exists()) {  
				             newsDir.mkdirs();  
				        }
						File entityFile=new File(finalPath.append(entry1.getKey()).append(".java").toString());
						if(entityFile.exists()){
							System.out.println(entry1.getKey()+"  已经存在! ");
							continue;
						}
						Map root = new HashMap();
				        root.put("entity_name", entry1.getKey());
				        root.put("beans", entry1.getValue());
				        System.out.println("entity_name"+entry1.getKey());
				        try {  
				             Writer out = new OutputStreamWriter(new FileOutputStream(entityFile),"UTF-8");  
				             temEntity.process(root, out);  
				         } catch (Exception e) {  
				             e.printStackTrace();  
				         }
					}
				}
				
				
			}
			 catch (Exception e) {
				 e.printStackTrace();
				} finally {
					try {
						if (bufferedReader != null) {
							bufferedReader.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
		}
	}
	
	public static List<File> getFileList(String strPath) {
		File dir = new File(strPath);
		File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				String fileName = files[i].getName();
				if (files[i].isDirectory()) { // 判断是文件还是文件夹
					getFileList(files[i].getAbsolutePath()); // 获取文件绝对路径
				} else if (fileName.endsWith("txt")) { // 判断文件名是否以.txt结尾
					String strFileName = files[i].getAbsolutePath();
					System.out.println("---" + strFileName);
					filelist.add(files[i]);
				} else {
					continue;
				}
			}

		}
		return filelist;
	}
}
