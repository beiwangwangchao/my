package com.crm.model;

import com.util.base.BaseEntity;



public class ${entity_name} extends BaseEntity{
	private static final long serialVersionUID = 1L;
<#list beans as bean>
	${bean.accessAuth} ${bean.type} ${bean.propName}; // ${bean.remarks}
</#list>
	public ${entity_name}(){}
	
	private ${entity_name}(${entity_name}Builder builder){
	 <#list beans as bean>
	 	this.${bean.propName} = builder.${bean.propName};
	 </#list>
	 }
	
 <#list beans as bean>
  	  /**
	   * ${bean.remarks}
	   * @return ${bean.propName}
	   */
	  public ${bean.type} get${bean.propNameUP}(){
	   return ${bean.propName};
	  }
	  /**
	   * ${bean.remarks}
	   * @param ${bean.propName} 
	   */
	  public void set${bean.propNameUP}(${bean.type} ${bean.propName}){
	    this.${bean.propName} = ${bean.propName};
	  }
</#list>

	/**
	 *
	 *
	 */
	 public static class ${entity_name}Builder{
  	<#list beans as bean>
		${bean.accessAuth} ${bean.type} ${bean.propName}; // ${bean.remarks}
	</#list>
	<#list beans as bean>
		 /**
	   * ${bean.remarks}
	   * @return ${entity_name}Builder
	   */
		public ${entity_name}Builder add${bean.propNameUP}(${bean.type} ${bean.propName}) {
			this.${bean.propName} = ${bean.propName};
			return this;
		}
	</#list>
	
		public ${entity_name} build(){
			return new ${entity_name}(this);
		}
	 }
	 
}