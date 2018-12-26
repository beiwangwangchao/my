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
public class CrmSalesLead extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String customerId; // 客户(家庭)id
	private String contactId; // 学生Id
	private String number; // 线索号
	private String sourceFrom; // 线索来源
	private String status; // 线索：new-新建，tracing-跟进中，converted-已转化，seaing-进入公海，close-关闭 
	private String detailsStatusId; // 明细状态Id
	private String principalId; // 负责人
	private String organizationId; // 所属机构
	private String transferDate; // 转移日期
	private Integer isStar; // 星标
	private String leadProperty; // 属性
	private Integer isView; // 查看 标识 0-未查看 1-已查看
	private Integer isSea; // 是否进入公海 1 进入 0没有进入
	private Integer isDeleted; // 是否删除 0 正常 1删除
}