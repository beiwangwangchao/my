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
public class CrmMenuParametersValue extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String crmMenuParametersId; // 所属菜单参数ID
	private String value; // 菜单名称
	private Integer isDefault; // 是否默认 0 不默认 1默认值
	private Integer isDeleted; // 是否删除 0 正常  1删除
}