{
<#list beans as bean>
	 	"${bean.propName}":""<#if bean_has_next>,</#if>
</#list>
}