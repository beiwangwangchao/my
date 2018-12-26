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
public class CrmReplyContent extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String orgId; // 组织id
	private String organizationId; // 机构id
	private String userId; // 用户id
	private String isDefault; // 是否默认回复
	private String type; // 类型，autoReply 自动回复 quickReply 快捷回复
	private String content; // 内容
	private Integer sort; // 排序
}