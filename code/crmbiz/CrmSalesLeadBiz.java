package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmSalesLeadMapper;
import com.jingcheng.marketing.business.model.CrmSalesLead;
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
public class CrmSalesLeadBiz {

    @Autowired
    private CrmSalesLeadMapper crmSalesLeadMapper;

    /**
     * 新增记录
     *
     * @param crmSalesLead
     * @return
     */

    public MsgDto addCrmSalesLead(CrmSalesLead crmSalesLead) {
        crmSalesLead.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmSalesLead> crmSalesLeadList = crmSalesLeadMapper.selectListByMap(map);
        if (!crmSalesLeadList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmSalesLeadList.get(0));
         }
        crmSalesLeadMapper.insertSelective(crmSalesLead);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmSalesLead);
    }

    /**
    * 根据id更新记录
    *
    * @param crmSalesLead
    * @return
    */
    public MsgDto updateCrmSalesLead(CrmSalesLead crmSalesLead) {
       Map<String, Object> map = new HashMap();

      List<CrmSalesLead> crmSalesLeadList = crmSalesLeadMapper.selectListByMap(map);
        if (!crmSalesLeadList.isEmpty()) {
          for (CrmSalesLead crmSalesLeads : crmSalesLeadList) {
             if (!crmSalesLeads.getId().equals(crmSalesLead.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmSalesLeads);
              }
            }
        }
         crmSalesLeadMapper.updateByPrimaryKeySelective(crmSalesLead);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmSalesLead);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmSalesLead(String id) {
         crmSalesLeadMapper.deleteByPrimaryKey(id);
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
              crmSalesLeadMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmSalesLead(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmSalesLeadMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmSalesLeadMapper.queryPage(params);
          }

 }