package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmUserRoleMapper;
import com.jingcheng.marketing.business.model.CrmUserRole;
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
public class CrmUserRoleBiz {

    @Autowired
    private CrmUserRoleMapper crmUserRoleMapper;

    /**
     * 新增记录
     *
     * @param crmUserRole
     * @return
     */

    public MsgDto addCrmUserRole(CrmUserRole crmUserRole) {
        crmUserRole.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmUserRole> crmUserRoleList = crmUserRoleMapper.selectListByMap(map);
        if (!crmUserRoleList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmUserRoleList.get(0));
         }
        crmUserRoleMapper.insertSelective(crmUserRole);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmUserRole);
    }

    /**
    * 根据id更新记录
    *
    * @param crmUserRole
    * @return
    */
    public MsgDto updateCrmUserRole(CrmUserRole crmUserRole) {
       Map<String, Object> map = new HashMap();

      List<CrmUserRole> crmUserRoleList = crmUserRoleMapper.selectListByMap(map);
        if (!crmUserRoleList.isEmpty()) {
          for (CrmUserRole crmUserRoles : crmUserRoleList) {
             if (!crmUserRoles.getId().equals(crmUserRole.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmUserRoles);
              }
            }
        }
         crmUserRoleMapper.updateByPrimaryKeySelective(crmUserRole);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmUserRole);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmUserRole(String id) {
         crmUserRoleMapper.deleteByPrimaryKey(id);
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
              crmUserRoleMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmUserRole(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmUserRoleMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmUserRoleMapper.queryPage(params);
          }

 }