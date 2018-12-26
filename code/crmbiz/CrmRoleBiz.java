package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmRoleMapper;
import com.jingcheng.marketing.business.model.CrmRole;
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
public class CrmRoleBiz {

    @Autowired
    private CrmRoleMapper crmRoleMapper;

    /**
     * 新增记录
     *
     * @param crmRole
     * @return
     */

    public MsgDto addCrmRole(CrmRole crmRole) {
        crmRole.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmRole> crmRoleList = crmRoleMapper.selectListByMap(map);
        if (!crmRoleList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmRoleList.get(0));
         }
        crmRoleMapper.insertSelective(crmRole);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmRole);
    }

    /**
    * 根据id更新记录
    *
    * @param crmRole
    * @return
    */
    public MsgDto updateCrmRole(CrmRole crmRole) {
       Map<String, Object> map = new HashMap();

      List<CrmRole> crmRoleList = crmRoleMapper.selectListByMap(map);
        if (!crmRoleList.isEmpty()) {
          for (CrmRole crmRoles : crmRoleList) {
             if (!crmRoles.getId().equals(crmRole.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmRoles);
              }
            }
        }
         crmRoleMapper.updateByPrimaryKeySelective(crmRole);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmRole);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmRole(String id) {
         crmRoleMapper.deleteByPrimaryKey(id);
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
              crmRoleMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmRole(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmRoleMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmRoleMapper.queryPage(params);
          }

 }