package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmRoleMenuMapper;
import com.jingcheng.marketing.business.model.CrmRoleMenu;
import com.util.comm.Cons;
import com.util.mybatisplus.Page;
import com.util.comm.ParamsMap;
import com.util.dto.MsgDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class CrmRoleMenuBiz {

    @Autowired
    private CrmRoleMenuMapper crmRoleMenuMapper;

    /**
     * 新增记录
     *
     * @param crmRoleMenu
     * @return
     */

    public MsgDto addCrmRoleMenu(CrmRoleMenu crmRoleMenu) {
        crmRoleMenu.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmRoleMenu> crmRoleMenuList = crmRoleMenuMapper.selectListByMap(map);
        if (!crmRoleMenuList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmRoleMenuList.get(0));
         }
        crmRoleMenuMapper.insertSelective(crmRoleMenu);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmRoleMenu);
    }

    /**
    * 根据id更新记录
    *
    * @param crmRoleMenu
    * @return
    */
    public MsgDto updateCrmRoleMenu(CrmRoleMenu crmRoleMenu) {
       Map<String, Object> map = new HashMap();

      List<CrmRoleMenu> crmRoleMenuList = crmRoleMenuMapper.selectListByMap(map);
        if (!crmRoleMenuList.isEmpty()) {
          for (CrmRoleMenu crmRoleMenus : crmRoleMenuList) {
             if (!crmRoleMenus.getId().equals(crmRoleMenu.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmRoleMenus);
              }
            }
        }
         crmRoleMenuMapper.updateByPrimaryKeySelective(crmRoleMenu);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmRoleMenu);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmRoleMenu(String id) {
         crmRoleMenuMapper.deleteByPrimaryKey(id);
        return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 删除多条记录
        *
        * @param ids
        * @return
        */
        public MsgDto delete(String ids) {
           String[] arr = ids.split(",");
            for (String id : arr) {
              crmRoleMenuMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmRoleMenu(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmRoleMenuMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmRoleMenuMapper.queryPage(params);
          }

 }