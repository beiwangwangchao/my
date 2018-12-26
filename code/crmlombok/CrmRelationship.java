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
public class CrmRelationship extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String customerId; // 客户（家庭id）
	private String contactId; // 家长id
	private String relationship; // 类型：father-爸爸，mother-妈妈，grandpa-爷爷，grandma-奶奶
}