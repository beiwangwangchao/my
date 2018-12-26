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
public class CrmClazzSchedule extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String orgId; // 所在广场
	private String organizationId; // 所属机构
	private String code; // 班级编号
	private String name; // 班级名称
	private String classId; // 所选课程
	private String teacherId; // 授课老师
	private String type; // 班型
	private Integer num; // 计划名额
	private String frequency; // 上课频率
	private Integer isOpen; // 是否开课 0 开课 1 未开课
	private String startDate; // 开课时间
	private String giveDate; // 上课时间
	private String endDate; // 结束时间
	private String classroomId; // 上课教室
	private String stopTime; // 针对自定义停招的停招时间
	private Integer isDeleted; // 是否删除(0
	private Integer isInvalid; // 是否失效(0
	private String status; // 招生状态，数据字典读取
	private Integer hasNum; // 实招名额
}