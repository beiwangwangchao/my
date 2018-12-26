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
public class CrmBusinessCardProduct extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String crmProductId; // 产品（课程）id
	private String crmBusinessCardId; // 名片id
	private Integer sort; // 排序
}