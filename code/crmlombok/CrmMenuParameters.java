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
public class CrmMenuParameters extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String crmMenuId; // 所属菜单ID
	private String name; // 菜单名称
	private String code; // 菜单编号
	private String valueType; // 参数值类型，single 单值 ，multi 多值
	private Integer defaultValue; // 0表示 默认不勾选 1表示默认勾选
	private Integer isInvalid; // 是否有效 0有效 1无效
	private Integer isDeleted; // 是否删除 0 正常  1删除
}