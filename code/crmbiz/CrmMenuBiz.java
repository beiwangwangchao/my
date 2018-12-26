package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmMenuMapper;
import com.jingcheng.marketing.business.model.CrmMenu;
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
public class CrmMenuBiz {

    @Autowired
    private CrmMenuMapper crmMenuMapper;

    /**
     * 新增记录
     *
     * @param crmMenu
     * @return
     */

    public MsgDto addCrmMenu(CrmMenu crmMenu) {
        crmMenu.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmMenu> crmMenuList = crmMenuMapper.selectListByMap(map);
        if (!crmMenuList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmMenuList.get(0));
         }
        crmMenuMapper.insertSelective(crmMenu);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmMenu);
    }

    /**
    * 根据id更新记录
    *
    * @param crmMenu
    * @return
    */
    public MsgDto updateCrmMenu(CrmMenu crmMenu) {
       Map<String, Object> map = new HashMap();

      List<CrmMenu> crmMenuList = crmMenuMapper.selectListByMap(map);
        if (!crmMenuList.isEmpty()) {
          for (CrmMenu crmMenus : crmMenuList) {
             if (!crmMenus.getId().equals(crmMenu.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmMenus);
              }
            }
        }
         crmMenuMapper.updateByPrimaryKeySelective(crmMenu);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmMenu);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmMenu(String id) {
         crmMenuMapper.deleteByPrimaryKey(id);
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
              crmMenuMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmMenu(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmMenuMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmMenuMapper.queryPage(params);
          }

 }