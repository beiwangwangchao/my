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
public class CrmStatusTrace extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String sourceId; // 来源id(取线索表或意向客户表的id)
	private String type; // lead-线索，opportunity-意向客户
	private String status; // 线索：new-新建，tracing-跟进中，converted-已转化，seaing-进入公海，close-关闭 
商机：new-新建，tracing-跟进中，conluded-已转化，seaing-进入公海，close-关闭
	private Integer isDeleted; // 是否删除 0 正常 1删除
}