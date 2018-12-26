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
public class CrmSalesOpportunity extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String customerId; // 客户（学生)id
	private String contactId; // 联系人id(家长)
	private String productId; // 意向课程(Id)
	private Integer salesAmount; // 预计销售金额(以分为单位)
	private String salesDate; // 预计签单日期
	private String status; // 商机：new-新建，tracing-跟进中，conluded-已成交，seaing-进入公海，close-关闭
	private String detailsStatusId; // 明细状态Id
	private String salesLeadId; // 线索id
	private String principalId; // 负责人
	private String organizationId; // 所属机构
	private String transferDate; // 转移日期
	private Integer isStar; // 星标
	private Integer isView; // 查看 标识 0-未查看 1-已查看
	private Integer isDeleted; // 是否删除 0 正常 1删除
	private String opportunityProperty; // leadProperty; // 属性 personal-个人，organization-部门
	private Integer amount; // 实际成交金额
	private String payType; // 支付方式
	private String remark; // 备注说明
}