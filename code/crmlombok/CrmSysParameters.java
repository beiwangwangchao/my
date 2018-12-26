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
public class CrmSysParameters extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String type; // 参数类型
	private String parameterCode; // 参数code
	private String parameterValue; // 参数value
	private String comments; // 备注字段
	private Integer isDeleted; // 是否删除，0正常1删除
	private Integer isInvalid; // 是否失效，0有效，1失效
}