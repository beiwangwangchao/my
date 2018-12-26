package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmContactOrganizationMapper;
import com.jingcheng.marketing.business.model.CrmContactOrganization;
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
public class CrmContactOrganizationBiz {

    @Autowired
    private CrmContactOrganizationMapper crmContactOrganizationMapper;

    /**
     * 新增记录
     *
     * @param crmContactOrganization
     * @return
     */

    public MsgDto addCrmContactOrganization(CrmContactOrganization crmContactOrganization) {
        crmContactOrganization.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmContactOrganization> crmContactOrganizationList = crmContactOrganizationMapper.selectListByMap(map);
        if (!crmContactOrganizationList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmContactOrganizationList.get(0));
         }
        crmContactOrganizationMapper.insertSelective(crmContactOrganization);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmContactOrganization);
    }

    /**
    * 根据id更新记录
    *
    * @param crmContactOrganization
    * @return
    */
    public MsgDto updateCrmContactOrganization(CrmContactOrganization crmContactOrganization) {
       Map<String, Object> map = new HashMap();

      List<CrmContactOrganization> crmContactOrganizationList = crmContactOrganizationMapper.selectListByMap(map);
        if (!crmContactOrganizationList.isEmpty()) {
          for (CrmContactOrganization crmContactOrganizations : crmContactOrganizationList) {
             if (!crmContactOrganizations.getId().equals(crmContactOrganization.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmContactOrganizations);
              }
            }
        }
         crmContactOrganizationMapper.updateByPrimaryKeySelective(crmContactOrganization);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmContactOrganization);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmContactOrganization(String id) {
         crmContactOrganizationMapper.deleteByPrimaryKey(id);
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
              crmContactOrganizationMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmContactOrganization(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmContactOrganizationMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmContactOrganizationMapper.queryPage(params);
          }

 }