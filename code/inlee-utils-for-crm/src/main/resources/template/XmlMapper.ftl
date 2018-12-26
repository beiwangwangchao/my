<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.jingcheng.marketing.business.mapper.${entity_name}Mapper">

    <select id="queryPage" parameterType="java.util.Map" resultType="java.util.Map">
        select
        *
        from ${entity_table_name}
        <where>
            1 = 1
            <#list beans as bean>
             <if test="obj.${bean.propName} != null<#if bean.type=="String"> and obj.${bean.propName} != ''</#if>">
                 and ${bean.filedName} = ${r'#{'}obj.${bean.propName}}
             </if>
            </#list>
        </where>
    </select>
</mapper>