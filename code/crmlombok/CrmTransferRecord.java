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
public class CrmTransferRecord extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String fromId; // 来源Id(userId)
	private String toId; // 转至Id(userId)
	private String originalId; // 原始Id(userId)
	private String sourceId; // 资源Id
	private String type; // lead-线索，opportunity-意向客户
	private Integer isDeleted; // 是否删除 0 正常 1删除
}