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
public class CrmObjectTags extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String belongTo; // 标签所有者id
	private String tags; // 标签code
}