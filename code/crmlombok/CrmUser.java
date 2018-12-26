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
public class CrmUser extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String code; // 用户编号
	private String name; // 用户名称
	private String phone; // 手机号
	private String password; // 密码
	private String organizationId; // 组织id
	private Integer isInvalid; // 是否失效 0 有效 1 失效
	private Integer isDeleted; // 是否删除 0正常  1删除
}