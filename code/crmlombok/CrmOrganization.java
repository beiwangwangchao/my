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
public class CrmOrganization extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String code; // 机构编码
	private String name; // 机构名称
	private String type; // 取值 数据字典 有两种类型  管理机构，经营机构
	private String description; // 描述
	private String parentOrgId; // 保留字段  父级组织id
	private String personInCharge; // 负责人
	private String personInChargePhone; // 负责人电话
	private Integer isDeleted; // 是否删除 0正常 1删除
	private Integer onsysId; // 昻思机构id
}