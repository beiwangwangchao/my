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
public class CrmRoleMenu extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String crmRoleId; // 角色名称
	private String crmMenuId; // 是否删除 0 正常 1删除
}