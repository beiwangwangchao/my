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
public class CrmRole extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String name; // 角色名称
	private Integer isInvalid; // 是否有效 0有效 1无效
	private Integer isPublic; // 是否全局可用 0 不可 1可以
	private Integer isDeleted; // 是否删除 0 正常 1删除
	private Integer isAdministrator; // 是否管理员角色，0否 1是
	private Integer isApp; // 是否移动终端角色 0 否 1是
}