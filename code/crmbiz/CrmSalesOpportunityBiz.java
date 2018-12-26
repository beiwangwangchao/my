package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmSalesOpportunityMapper;
import com.jingcheng.marketing.business.model.CrmSalesOpportunity;
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
public class CrmSalesOpportunityBiz {

    @Autowired
    private CrmSalesOpportunityMapper crmSalesOpportunityMapper;

    /**
     * 新增记录
     *
     * @param crmSalesOpportunity
     * @return
     */

    public MsgDto addCrmSalesOpportunity(CrmSalesOpportunity crmSalesOpportunity) {
        crmSalesOpportunity.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmSalesOpportunity> crmSalesOpportunityList = crmSalesOpportunityMapper.selectListByMap(map);
        if (!crmSalesOpportunityList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmSalesOpportunityList.get(0));
         }
        crmSalesOpportunityMapper.insertSelective(crmSalesOpportunity);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmSalesOpportunity);
    }

    /**
    * 根据id更新记录
    *
    * @param crmSalesOpportunity
    * @return
    */
    public MsgDto updateCrmSalesOpportunity(CrmSalesOpportunity crmSalesOpportunity) {
       Map<String, Object> map = new HashMap();

      List<CrmSalesOpportunity> crmSalesOpportunityList = crmSalesOpportunityMapper.selectListByMap(map);
        if (!crmSalesOpportunityList.isEmpty()) {
          for (CrmSalesOpportunity crmSalesOpportunitys : crmSalesOpportunityList) {
             if (!crmSalesOpportunitys.getId().equals(crmSalesOpportunity.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmSalesOpportunitys);
              }
            }
        }
         crmSalesOpportunityMapper.updateByPrimaryKeySelective(crmSalesOpportunity);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmSalesOpportunity);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmSalesOpportunity(String id) {
         crmSalesOpportunityMapper.deleteByPrimaryKey(id);
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
              crmSalesOpportunityMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmSalesOpportunity(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmSalesOpportunityMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmSalesOpportunityMapper.queryPage(params);
          }

 }