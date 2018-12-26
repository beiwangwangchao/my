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
public class CrmMenu extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String name; // 菜单名称
	private String code; // 菜单编号
	private String parentId; // 上级ID
	private Integer sort; // 排序
	private String logo; // 图标LOGO地址
	private Integer isFreeze; // 是否冻结 冻结后不可分配此菜单,已分配的还可以查看此菜单
	private Integer isHide; // 是否隐藏 0 显示 1 隐藏
	private Integer isDeleted; // 是否删除 0 正常 1 删除
	private Integer isApp; // 是否是移动应用的菜单
}