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
public class CrmContact extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String phone; // 手机/电话
	private String name; // 姓名
	private String sex; // 性别(man 男 women女  未知 - unknown)
	private String position; // 职位
	private Integer salary; // 薪资(以分为单位)
	private String remark; // 备注
	private Integer isHousehold; // 是否户主 0 成员 1 户主
	private Integer isDeleted; // 是否删除 0 正常 1删除
	private String attribA; // 预留字段
	private String attribB; // 预留字段
	private String attribC; // 预留字段
	private Integer attribD; // 预留字段
	private Integer attribE; // 预留字段
	private Integer attribF; // 预留字段
}