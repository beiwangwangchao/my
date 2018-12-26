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
public class CrmDataDictionary extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String parentId; // 上级
	private String belongsSys; // 所属系统
	private String code; // 编码
	private String type; // 类型
	private String value; // 值
	private String comment; // 备注
	private Integer isEnabled; // 是否启用
	private Integer sort; // 排序
	private String orgId; // 标签所属组织id
	private String userId; // 标签所属用户id,当id不为空时，表示标签或字典为私有
}