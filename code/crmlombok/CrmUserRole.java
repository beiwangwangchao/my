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
public class CrmUserRole extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String userId; // 用户id
	private String roleId; // 角色id
}