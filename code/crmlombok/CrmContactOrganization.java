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
public class CrmContactOrganization extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String contactId; // 联系人id
	private String organizationId; // 机构ID(学生所属机构)
}