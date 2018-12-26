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
public class CrmStudent extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String stuNo; // 学生学号
	private String customerId; // 客户id(家庭id)
	private String type; // 类型：son-儿子,daughter-女儿
	private String name; // 学生姓名
	private String birthday; // 出生日期
	private String sex; // 性别,male-男,female-女
	private String grade; // 年级，下拉框填写
	private String schoolId; // 学校的ID
	private String interest; // 兴趣爱好，下拉框选择
	private Integer isDeleted; // 是否删除 0 正常 1删除
	private String onsysStudentId; // 昂思系统ID
	private String school; // 学校信息
}