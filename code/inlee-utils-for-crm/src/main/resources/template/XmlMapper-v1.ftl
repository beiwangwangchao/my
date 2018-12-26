<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.crm.business.model.${entity_name}">
	<resultMap type="com.crm.business.model.${entity_name}" id="BaseResultMap">
	<#list beans as bean>
  	  <#if bean.propName == bean.keyName>
  	   <id column="${bean.filedName}"   property="${bean.propName}" />
      <#else>
  	   <result column="${bean.filedName}"  property="${bean.propName}" />
      </#if>
    </#list>
    </resultMap>

<sql id="Example_Where_Clause">
     <where>
         <foreach collection="oredCriteria" item="criteria" separator="or">
             <if test="criteria.valid">
                 <trim prefix="(" prefixOverrides="and" suffix=")">
                     <foreach collection="criteria.criteria" item="criterion">
                         <choose>
                             <when test="criterion.noValue">
                                 and ${r"${criterion.condition}"}
                             </when>
                             <when test="criterion.singleValue">
                                 and ${r"${criterion.condition}"} ${r"#{criterion.value}"}
                             </when>
                             <when test="criterion.betweenValue">
                                 and ${r"${criterion.condition}"} ${r"#{criterion.value}"} and ${r"#{criterion.secondValue}"}
                             </when>
                             <when test="criterion.listValue">
                                 and ${r"${criterion.condition}"}
                                 <foreach close=")" collection="criterion.value" item="listItem" open="(" separator=",">
                                 ${r"#{listItem}"}
                                 </foreach>
                             </when>
                         </choose>
                     </foreach>
                 </trim>
             </if>
         </foreach>
     </where>
 </sql>

 <sql id="Update_By_Example_Where_Clause">
     <where>
         <foreach collection="example.oredCriteria" item="criteria" separator="or">
             <if test="criteria.valid">
                 <trim prefix="(" prefixOverrides="and" suffix=")">
                     <foreach collection="criteria.criteria" item="criterion">
                         <choose>
                             <when test="criterion.noValue">
                                 and ${r"${criterion.condition}"}
                             </when>
                             <when test="criterion.singleValue">
                                 and ${r"${criterion.condition}"} ${r"#{criterion.value}"}
                             </when>
                             <when test="criterion.betweenValue">
                                 and ${r"${criterion.condition}"} ${r"#{criterion.value}"} and ${r"#{criterion.secondValue}"}
                             </when>
                             <when test="criterion.listValue">
                                 and ${r"${criterion.condition}"}
                                 <foreach close=")" collection="criterion.value" item="listItem" open="(" separator=",">
                                  ${r"#{listItem}"}
                                 </foreach>
                             </when>
                         </choose>
                     </foreach>
                 </trim>
             </if>
         </foreach>
     </where>
 </sql>

    <sql id="Base_Column_List">
		<#list beans as bean>${bean.filedName}<#if bean_has_next>,</#if></#list>
    </sql>
    <sql id="BaseColumnList">
		<#list beans as bean>${bean.filedName} as ${bean.propName}<#if bean_has_next>,</#if></#list>
    </sql>
	<insert id="insert" parameterType="com.crm.console.model.${entity_name}" useGeneratedKeys="true" keyProperty="${entity_key}">
	  INSERT INTO ${entity_table_name}(<#list beans as bean>${bean.filedName}<#if bean_has_next>,</#if></#list>)
	  VALUES (<#list beans as bean><#if  bean.propName=="ctime"||bean.propName=="utime">  CURRENT_TIMESTAMP<#elseif bean.propName=="versionNum">1<#else>${r'#{'}${bean.propName}}</#if><#if bean_has_next>,</#if></#list>)
	</insert>

    <insert id="insertSelective" keyColumn="id" keyProperty="id" parameterType="com.crm.console.model.${entity_name}" useGeneratedKeys="true">
        insert into ${entity_table_name}
        <trim prefix="(" suffix=")" suffixOverrides=",">
            <#list beans as bean>
                <#if bean.propName=="ctime"||bean.propName=="utime"||bean.propName=="versionNum">
                    ${bean.filedName}<#if bean_has_next>,</#if>
                <#else>
                       <if test="${bean.propName} != null">
                           ${bean.filedName}<#if bean_has_next>,</#if>
                       </if>
                </#if>
			</#list>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
             <#list beans as bean>
                <#if bean.propName=="ctime"||bean.propName=="utime">
                    CURRENT_TIMESTAMP<#if bean_has_next>,</#if>
                <#elseif bean.propName=="versionNum">
                1<#if bean_has_next>,</#if>
                <#else>
                    <if test="${bean.propName} != null">
                        ${r'#{'}${bean.propName}}<#if bean_has_next>,</#if>
                    </if>
                </#if>
			 </#list>
        </trim>
    </insert>

    <select id="selectByPrimaryKey" parameterType="java.lang.String" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from ${entity_table_name}
        where ${entity_key_field_name}=${r'#{'}${entity_key}}
    </select>

    <update id="updateByPrimaryKeySelective" parameterType="com.crm.console.model.${entity_name}">
        update ${entity_table_name}
        <set>
            <trim suffixOverrides=",">
        <#list beans as bean>
                <#if bean.propName=="utime">
                    ${bean.filedName} =CURRENT_TIMESTAMP<#if bean_has_next>,</#if>
                <#elseif  bean.propName=="versionNum" >
                    ${bean.filedName} =${bean.filedName}+1<#if bean_has_next>,</#if>
                <#elseif bean.propName!="ctime"&&bean.propName != bean.keyName>
                    <if test="${bean.propName} != null">
                     ${bean.filedName} = ${r'#{'}${bean.propName}}<#if bean_has_next>,</#if>
                     </if>
                </#if>
		</#list>
                </trim>
        </set>
        where ${entity_key_field_name}=${r'#{'}${entity_key}}
    </update>
    <update id="updateByPrimaryKey" parameterType="com.crm.console.model.${entity_name}">
        update ${entity_table_name}
        set
       <#list beans as bean>
           <#if bean.propName=="utime"> ${bean.filedName} =CURRENT_TIMESTAMP<#if bean_has_next>,</#if>
           <#elseif bean.propName=="versionNum">${bean.filedName} =${bean.filedName}+1<#if bean_has_next>,</#if>
           <#elseif bean.propName!="ctime"&&bean.propName != bean.keyName>${bean.filedName} = ${r'#{'}${bean.propName}}<#if bean_has_next>,</#if>
           </#if>
       </#list>
        where ${entity_key_field_name}=${r'#{'}${entity_key}}
    </update>
    <delete id="deleteByPrimaryKey" parameterType="java.lang.String">
        delete from ${entity_table_name}
        where ${entity_key_field_name}=${r'#{'}${entity_key}}
    </delete>
    <delete id="deleteByExample" parameterType="com.util.criteria.SqlCriteria">
        delete from ${entity_table_name}
        <if test="_parameter != null">
            <include refid="Example_Where_Clause" />
        </if>
    </delete>
    <select id="countByExample" parameterType="com.util.criteria.SqlCriteria" resultType="java.lang.Long">
        select count(*) from ${entity_table_name}
        <if test="_parameter != null">
            <include refid="Example_Where_Clause" />
        </if>
    </select>
    <select id="selectByExample" parameterType="com.util.criteria.SqlCriteria" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from ${entity_table_name}
        <if test="_parameter != null">
            <include refid="Example_Where_Clause" />
        </if>
    </select>
    <select id="selectByMap" parameterType="java.util.Map" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from ${entity_table_name}
        <where>
             1 = 1
             <#list beans as bean>
             <if test="${bean.propName} != null<#if bean.type=="String"> and ${bean.propName} != ''</#if>">
                 and ${bean.filedName} = ${r'#{'}${bean.propName}}
             </if>
             </#list>
        </where>
    </select>
    <delete id="deleteByMap" parameterType="java.util.Map">
        delete from ${entity_table_name}
        <where>
             1 = 1
              <#list beans as bean>
             <if test="${bean.propName} != null<#if bean.type=="String"> and ${bean.propName} != ''</#if>">
                 and ${bean.filedName} = ${r'#{'}${bean.propName}}
             </if>
              </#list>
        </where>
    </delete>
    <select id="countAll" resultType="java.lang.Long">
        select count(*) from ${entity_table_name}
    </select>
    <select id="countByMap" parameterType="java.util.Map" resultType="java.lang.Long">
        select count(*) from ${entity_table_name}
        <where>
             1 = 1
            <#list beans as bean>
             <if test="${bean.propName} != null<#if bean.type=="String"> and ${bean.propName} != ''</#if>">
                 and ${bean.filedName} = ${r'#{'}${bean.propName}}
             </if>
            </#list>
        </where>
    </select>
    <select id="selectListAll" parameterType="java.util.Map" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from ${entity_table_name}
    </select>
    <select id="selectListByMap" parameterType="java.util.Map" resultMap="BaseResultMap">
        select
        <include refid="BaseColumnList" />
        from ${entity_table_name}
        <where>
             1 = 1
            <#list beans as bean>
             <if test="${bean.propName} != null<#if bean.type=="String"> and ${bean.propName} != ''</#if>">
                 and ${bean.filedName} = ${r'#{'}${bean.propName}}
             </if>
            </#list>
        </where>
    </select>
    <select id="queryObjectPageByMap" parameterType="java.util.Map" resultType="java.util.Map">
        select
        <include refid="BaseColumnList" />
        from ${entity_table_name}
        <where>
             1 = 1
            <#list beans as bean>
             <if test="${bean.propName} != null<#if bean.type=="String"> and ${bean.propName} != ''</#if>">
                 and ${bean.filedName} = ${r'#{'}${bean.propName}}
             </if>
            </#list>
        </where>
    </select>
    <select id="selectObjectByPrimaryKey" parameterType="java.lang.String" resultType="java.util.Map">
        SELECT
        <include refid="BaseColumnList" />
        FROM
        ${entity_table_name}
        where ${entity_key_field_name}=${r'#{'}${entity_key}}
        limit 1
    </select>
</mapper>