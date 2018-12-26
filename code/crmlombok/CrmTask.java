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
public class CrmTask extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String taskName; // 任务名
	private String taskGroup; // 任务组
	private String taskCode; // 任务标识
	private String taskClass; // 任务类
	private String taskParameters; // 任务参数
	private String taskStatus; // 任务状态
	private String taskTime; // 任务调度时间
	private Integer isDeleted; // 是否删除 0 正常 1删除
}