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
public class CrmCustomer extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String code; // 客户编码
	private String name; // 客户名称
	private String phone; // 手机/电话
	private String type; // 客户类型 latent-潜在，intention-意向，conclude-成交，unvalid-无效。
	private String school; // 学校
	private String grade; // 年级
	private String sex; // 性别
	private String birthday; // 生日
	private String interest; // 
	private String province; // 省
	private String city; // 市
	private String region; // 区
	private String address; // 备注地址详情
	private Integer isBuy; // 是否购买 0：为没有购买，1：已购买
	private Integer isDeleted; // 是否删除 0 正常 1删除
	private String attribA; // 预留字段
	private String attribB; // 预留字段
	private String attribC; // 预留字段
	private Integer attribD; // 预留字段
	private Integer attribE; // 预留字段
	private Integer attribF; // 预留字段
}