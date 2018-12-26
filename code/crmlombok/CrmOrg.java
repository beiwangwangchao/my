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
public class CrmOrg extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String code; // 组织编码
	private String name; // 组织名称
	private String type; // 取值数据字典，三种类型，总部，自营广场，外部广场
	private String description; // 描述
	private String parentOrgId; // 保留字段  父级组织id
	private String personInCharge; // 负责人
	private String personInChargePhone; // 负责人电话
	private Integer isDeleted; // 是否删除 0正常 1删除
	private Integer onsysId; // 对映昂思的广场ID
}