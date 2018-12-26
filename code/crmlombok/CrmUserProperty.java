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
public class CrmUserProperty extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String userId; // 用户id
	private String type; // 属性类型
	private String value; // 属性值
}