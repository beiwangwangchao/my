package com.inlee.util.codegenerate.bean;

/**
 * 代码生成器自动生成
 * @author rono
 */
public class EntityBean {
	private String keyName;  // 主键
	private String accessAuth; //  访问权限 ---private、public
	private String type;  // 数据类型
	private String entityName; // 实体名字
	private String propName;   // 属性名称(首字母小写)
	private String propNameUP;   // 属性名称(首字母大写)
	private String tableName;  // 表名称
	private String filedName;  // 字段名称
	private String remarks;    // 字段描述
	
	public EntityBean() {
	}
	public EntityBean(String keyName, String accessAuth, String type,
			String entityName, String propName, String propNameUP,
			String tableName, String filedName,String remarks) {
		super();
		this.keyName = keyName;
		this.accessAuth = accessAuth;
		this.type = type;
		this.entityName = entityName;
		this.propName = propName;
		this.propNameUP = propNameUP;
		this.tableName = tableName;
		this.filedName = filedName;
		this.remarks   = remarks;
	}

	public String getAccessAuth() {
		return accessAuth;
	}
	public void setAccessAuth(String accessAuth) {
		this.accessAuth = accessAuth;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getPropName() {
		return propName;
	}
	public void setPropName(String propName) {
		this.propName = propName;
	}
	public String getFiledName() {
		return filedName;
	}
	public void setFiledName(String filedName) {
		this.filedName = filedName;
	}
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	public String getPropNameUP() {
		return propNameUP;
	}
	public void setPropNameUP(String propNameUP) {
		this.propNameUP = propNameUP;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
