package com.jingcheng.marketing.model;

import com.util.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ${entity_name} extends BaseEntity{
	private static final long serialVersionUID = 1L;
<#list beans as bean>
	<#if bean.propName=="ctime"||bean.propName=="utime"||bean.propName=="versionNum"||bean.propName =="id"||bean.propName='createdBy'||bean.propName=="lastUpdatedBy">
	<#else>
	${bean.accessAuth} ${bean.type} ${bean.propName}; // ${bean.remarks}
	</#if>
</#list>
}