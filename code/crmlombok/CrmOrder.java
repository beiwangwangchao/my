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
public class CrmOrder extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String orderDetailsNo; // 订单详情编号
	private String orderNo; // 订单编号
	private String orgId; // 所属广场
	private String orgName; // 
	private String organizationId; // 所属机构
	private String organizationName; // 
	private String subId; // 科目id
	private String subName; // 科目名称
	private String classId; // 课程
	private String clazzName; // 课程名称
	private String classScheduleName; // 班级名称
	private String classScheduleId; // 班级
	private String userId; // 用户
	private String teacherId; // 老师
	private String teacherName; // 老师名称
	private Integer clazzType; // 课程类型 0 普通课 1活动课
	private String studentId; // 学生
	private String studentName; // 学生名称
	private String classroomId; // 教室id
	private String classroomName; // 教室名称
	private String consultantId; // 销售顾问id
	private Integer goodPrice; // 应付金额
	private String clubcardId; // 会员卡
	private Integer clubcardMoney; // 会员卡金额
	private Integer clubcardDiscountsMoney; // 会员卡优惠金额
	private String couponsId; // 优惠券id
	private Integer couponsMoney; // 优惠券金额
	private Integer couponsDiscountsMoney; // 优惠券优惠金额
	private Integer sumMoney; // 应付总金额
	private Integer discountsMoney; // 优惠总金额
	private Integer orderStatus; // 订单状态(0
	private String payTime; // 订单支付时间
	private Integer source; // 订单来源(0
	private Integer way; // 订单创建方式 0
}