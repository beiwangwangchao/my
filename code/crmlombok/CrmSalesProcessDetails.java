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
public class CrmSalesProcessDetails extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String sourceId; // 来源Id
	private String type; // lead-线索，opportunity-意向客户
	private String productId; // 意向课程(课程Id)
	private String contactType; // 跟进方式
	private String status; // 跟进状态
	private String nextFollowTime; // 下次跟进时间
	private String remark; // 备注
	private String picture; // 图片地址
	private Integer isDeleted; // 是否删除
	private String fromId; // 源负责人
	private String toId; // 新负责人
	private String fromStatus; // 源状态
	private String toStatus; // 新状态
	private String transactionType; // 事物类型 follow 跟进，transfer 变更负责人,update 更新数据
	private String salesDate; // 预计销售日期
	private Integer salesAmount; // 预计销售金额 以分为单位
}