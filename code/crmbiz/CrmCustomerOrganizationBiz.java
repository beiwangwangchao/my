package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmCustomerOrganizationMapper;
import com.jingcheng.marketing.business.model.CrmCustomerOrganization;
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
public class CrmCustomerOrganizationBiz {

    @Autowired
    private CrmCustomerOrganizationMapper crmCustomerOrganizationMapper;

    /**
     * 新增记录
     *
     * @param crmCustomerOrganization
     * @return
     */

    public MsgDto addCrmCustomerOrganization(CrmCustomerOrganization crmCustomerOrganization) {
        crmCustomerOrganization.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmCustomerOrganization> crmCustomerOrganizationList = crmCustomerOrganizationMapper.selectListByMap(map);
        if (!crmCustomerOrganizationList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmCustomerOrganizationList.get(0));
         }
        crmCustomerOrganizationMapper.insertSelective(crmCustomerOrganization);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmCustomerOrganization);
    }

    /**
    * 根据id更新记录
    *
    * @param crmCustomerOrganization
    * @return
    */
    public MsgDto updateCrmCustomerOrganization(CrmCustomerOrganization crmCustomerOrganization) {
       Map<String, Object> map = new HashMap();

      List<CrmCustomerOrganization> crmCustomerOrganizationList = crmCustomerOrganizationMapper.selectListByMap(map);
        if (!crmCustomerOrganizationList.isEmpty()) {
          for (CrmCustomerOrganization crmCustomerOrganizations : crmCustomerOrganizationList) {
             if (!crmCustomerOrganizations.getId().equals(crmCustomerOrganization.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmCustomerOrganizations);
              }
            }
        }
         crmCustomerOrganizationMapper.updateByPrimaryKeySelective(crmCustomerOrganization);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmCustomerOrganization);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmCustomerOrganization(String id) {
         crmCustomerOrganizationMapper.deleteByPrimaryKey(id);
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
              crmCustomerOrganizationMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmCustomerOrganization(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmCustomerOrganizationMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmCustomerOrganizationMapper.queryPage(params);
          }

 }