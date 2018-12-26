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
public class CrmBusinessCardInformation extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String name; // 名字
	private String phone; // 电话
	private String email; // 邮箱
	private String weixin; // 微信号
	private String position; // 职位
	private String picture; // 头像
	private String introduction; // 自我介绍
	private String userId; // 用户id
	private String company; // 公司、企业名称
}