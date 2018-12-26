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
public class CrmSalesWorkflowHistory extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String remark; // 内容
	private String fromStatus; // 排序
	private String toStatus; // 
	private String fromId; // 
	private String toId; // 
	private String transactionType; // 操作事务类型 --同意 驳回 转他人
	private String workflowId; // 工作流id
}