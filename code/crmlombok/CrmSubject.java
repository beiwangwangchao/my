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
public class CrmSubject extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private Long orgId; // 所属广场
	private Long organizationId; // 所属机构
	private String name; // 科目名称
	private Long parentId; // 上级科目
	private Integer sort; // 排序
	private String remark; // 备注
	private Boolean isEnble; // 是否启用(0
	private Integer num; // 统计科目下的课程数
	private Boolean isDeleted; // 是否删除(0
}