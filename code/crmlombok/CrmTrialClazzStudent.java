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
public class CrmTrialClazzStudent extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String studentId; // 学生id
	private String trialClassId; // 课程Id
	private String sourceId; // 商机id
	private String feedback; // 试听反馈
	private Integer isAchieved; // 是否成交转换
	private String status; // 试听状态
	private Integer isDeleted; // 是否删除 0 正常 1删除
}