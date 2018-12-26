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
public class CrmClazzScheduleStudent extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String classScheduleId; // 班级id
	private String studentId; // 学生id
	private Integer isDeleted; // 是否删除 0正常 1 删除
}