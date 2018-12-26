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
public class CrmClazzBak extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String orgId; // 所属广场
	private String organizationId; // 所属机构
	private String subId; // 所属分类
	private String name; // 课程名称
	private String subhead; // 副标题
	private Integer num; // 课时数
	private Integer price; // 课程价格(单位
	private String objApply; // 适用对象(数据字典获取)
	private String gradeType; // 班型(数据字典获取)
	private String frequency; // 上课频率(数据字典获取)
	private Integer frequencyNum; // 上课频率数
	private String openInfo; // 开班信息
	private String intro; // 课程简介
	private String linkUrl; // 课程链接地址
	private String teacherIntro; // 暂时不要
	private Integer rfm; // 购买量
	private Integer isPut; // 是否上架(0
	private Integer isDeleted; // 是否删除(0
}