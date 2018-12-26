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
public class CrmMessage extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String content; // 内容
	private String status; // 状态
	private String fromUserId; // 发送用户Id
	private String toUserId; // 接收用户Id
	private String sendTime; // 发送时间
	private Integer isDeleted; // 是否删除 0 正常 1删除
}