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
public class CrmBusinessCard extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private Integer isDeleted; // 是否删除
	private Integer isInvalid; // 是否失效
	private String crmPersonalInformationId; // 个人信息id
	private String isDefault; // 是否默认名片(0：false ,1：true)
}