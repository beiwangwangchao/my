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
public class CrmSchool extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String province; // 省
	private String city; // 市
	private String region; // 区
	private String street; // 街道
	private String school; // 学校
	private String grade; // 学校教授的年级
	private String address; // 详细地址
	private String addressCode; // 地址行政编号
	private  lat; // 纬度
	private  lng; // 经度
	private Integer isDeleted; // 是否删除 0 正常 1删除
}