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
public class CrmTeacher extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String orgId; // 所属广场
	private String organizationId; // 所属机构
	private String name; // 教师姓名
	private String imageUrl; // 照片
	private String phone; // 联系电话
	private String schoolAge; // 教龄
	private String intro; // 教师简介
	private Integer sort; // 排序
	private Integer isDeleted; // 是否删除(0
}