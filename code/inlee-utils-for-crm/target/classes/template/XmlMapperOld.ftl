<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.inlee.yczx.mapper.biz.${entity_name}Mapper">
	<resultMap type="${entity_name}" id="${entity_name_low}ResultMap">
	<#list beans as bean>
  	  <#if bean.propName == bean.keyName>
  	   <id column="${bean.filedName}" property="${bean.propName}" />
      <#else>
  	   <result column="${bean.filedName}" property="${bean.propName}" />
      </#if>
    </#list>
	</resultMap>
	
	<insert id="insert" parameterType="${entity_name}" useGeneratedKeys="true" keyProperty="${entity_key}">
	  INSERT INTO ${entity_table_name}(<#list beans as bean><#if bean.propName != bean.keyName>${bean.filedName}<#if bean_has_next>,</#if></#if></#list>)
	  VALUES (<#list beans as bean><#if bean.propName != bean.keyName>${r'#{'}${bean.propName}}<#if bean_has_next>,</#if></#if></#list>)
	</insert>

	<delete id="delByIds">
	  DELETE FROM ${entity_table_name} WHERE ${entity_key_field_name} IN
		<foreach collection="array" item="${entity_key}" open="(" separator="," close=")">
			 ${r'#{'}${entity_key}}
		</foreach>
	</delete>
	
	<update id="update" parameterType="${entity_name}">
		UPDATE ${entity_table_name} SET
		<#list beans as bean>${bean.filedName}=${r'#{'}${bean.propName}}<#if bean_has_next>,</#if></#list>
		WHERE ${entity_key_field_name}=${r'#{'}${entity_key}}
	</update>
	
	<select id="selectById" parameterType="long" resultMap="${entity_name_low}ResultMap">
	    SELECT * FROM ${entity_table_name} WHERE ${entity_key_field_name}=${r'#{'}${entity_key}}
	</select>
	
	<select id="selectByProperty" parameterType="${entity_name}" resultMap="${entity_name_low}ResultMap">
	  SELECT * FROM ${entity_table_name} WHERE 1=1
	  <#list beans as bean>
	    <if test="${bean.propName} != null and ${bean.propName} != '' ">
	      AND ${bean.filedName} = ${r'#{'}${bean.propName}}
	    </if>
	  </#list>
	</select>
	
	<select id="selectByPage" parameterType="${entity_name}" resultMap="${entity_name_low}ResultMap">
	    SELECT * FROM ${entity_table_name} 
	</select>
</mapper>