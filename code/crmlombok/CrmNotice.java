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
public class CrmNotice extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String perantId; // 父类(原始通知)
	private String noticeId; // 通知用户Id
	private String noticeTitle; // 通知标题
	private Integer noticeType; // 通知类型
	private String noticeModal; // 通知模板
	private String noticeBody; // 通知体
	private Integer noticeStatus; // 通知状态
	private String scopeType; // 范围类型 all-所有人，organization-指定机构，role-指定角色
	private String scope; // 范围
	private Integer isStick; // 0 正常，1 置顶
	private Integer isDeleted; // 是否删除 0正常  1删除
}