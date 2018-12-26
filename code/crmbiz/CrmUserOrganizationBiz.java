package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmUserOrganizationMapper;
import com.jingcheng.marketing.business.model.CrmUserOrganization;
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
public class CrmUserOrganizationBiz {

    @Autowired
    private CrmUserOrganizationMapper crmUserOrganizationMapper;

    /**
     * 新增记录
     *
     * @param crmUserOrganization
     * @return
     */

    public MsgDto addCrmUserOrganization(CrmUserOrganization crmUserOrganization) {
        crmUserOrganization.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmUserOrganization> crmUserOrganizationList = crmUserOrganizationMapper.selectListByMap(map);
        if (!crmUserOrganizationList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmUserOrganizationList.get(0));
         }
        crmUserOrganizationMapper.insertSelective(crmUserOrganization);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmUserOrganization);
    }

    /**
    * 根据id更新记录
    *
    * @param crmUserOrganization
    * @return
    */
    public MsgDto updateCrmUserOrganization(CrmUserOrganization crmUserOrganization) {
       Map<String, Object> map = new HashMap();

      List<CrmUserOrganization> crmUserOrganizationList = crmUserOrganizationMapper.selectListByMap(map);
        if (!crmUserOrganizationList.isEmpty()) {
          for (CrmUserOrganization crmUserOrganizations : crmUserOrganizationList) {
             if (!crmUserOrganizations.getId().equals(crmUserOrganization.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmUserOrganizations);
              }
            }
        }
         crmUserOrganizationMapper.updateByPrimaryKeySelective(crmUserOrganization);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmUserOrganization);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmUserOrganization(String id) {
         crmUserOrganizationMapper.deleteByPrimaryKey(id);
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
              crmUserOrganizationMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmUserOrganization(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmUserOrganizationMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmUserOrganizationMapper.queryPage(params);
          }

 }