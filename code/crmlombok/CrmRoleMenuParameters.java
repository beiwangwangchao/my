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
public class CrmRoleMenuParameters extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String crmRoleMenuId; // 所属菜单参数ID
	private String parameterId; // 参数id
	private String parameterValue; // 参数值
}