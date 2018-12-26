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
public class CrmSalesWorkflow extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String orgId; // 组织id
	private String organizationId; // 机构id
	private String userId; // 当前待处理人的id
	private String objectId; // 工作流所属对象id
	private String type; // 类型，autoReply 自动回复 quickReply 快捷回复
	private String remark; // 内容
	private String status; // 排序
}