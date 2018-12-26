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
public class CrmTrialClazz extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String orgId; // 所属广场
	private String organizationId; // 所属机构
	private String classroomId; // 上课教室
	private String classId; // 试听课程
	private String type; // 选择类型(数据字典获取) VARIABLE 自定义
	private String teacherId; // 上课老师
	private String classDate; // 上课日期
	private String beginTime; // 上课开始时间
	private String endTime; // 上课结束时间
	private Integer num; // 免费名额
	private Integer status; // 试听状态(0
	private String explains; // 试听说明
	private Integer isPut; // 是否上架（0下架，1上架）
	private Integer isDeleted; // 删除状态
	private Integer week; // 周几上课
	private String perId; // 时段id
	private String finalOpenGradeTime; // 预约截止时间
	private String claim; // 开班要求
}