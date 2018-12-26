package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmOrganizationMapper;
import com.jingcheng.marketing.business.model.CrmOrganization;
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
public class CrmOrganizationBiz {

    @Autowired
    private CrmOrganizationMapper crmOrganizationMapper;

    /**
     * 新增记录
     *
     * @param crmOrganization
     * @return
     */

    public MsgDto addCrmOrganization(CrmOrganization crmOrganization) {
        crmOrganization.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmOrganization> crmOrganizationList = crmOrganizationMapper.selectListByMap(map);
        if (!crmOrganizationList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmOrganizationList.get(0));
         }
        crmOrganizationMapper.insertSelective(crmOrganization);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmOrganization);
    }

    /**
    * 根据id更新记录
    *
    * @param crmOrganization
    * @return
    */
    public MsgDto updateCrmOrganization(CrmOrganization crmOrganization) {
       Map<String, Object> map = new HashMap();

      List<CrmOrganization> crmOrganizationList = crmOrganizationMapper.selectListByMap(map);
        if (!crmOrganizationList.isEmpty()) {
          for (CrmOrganization crmOrganizations : crmOrganizationList) {
             if (!crmOrganizations.getId().equals(crmOrganization.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmOrganizations);
              }
            }
        }
         crmOrganizationMapper.updateByPrimaryKeySelective(crmOrganization);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmOrganization);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmOrganization(String id) {
         crmOrganizationMapper.deleteByPrimaryKey(id);
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
              crmOrganizationMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmOrganization(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmOrganizationMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmOrganizationMapper.queryPage(params);
          }

 }