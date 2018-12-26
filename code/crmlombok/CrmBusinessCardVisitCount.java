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
public class CrmBusinessCardVisitCount extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String crmBusinessCardId; // 名片id
	private Integer visitNumber; // 访问量
}