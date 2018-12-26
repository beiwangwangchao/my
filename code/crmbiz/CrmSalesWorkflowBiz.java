package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmSalesWorkflowMapper;
import com.jingcheng.marketing.business.model.CrmSalesWorkflow;
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
public class CrmSalesWorkflowBiz {

    @Autowired
    private CrmSalesWorkflowMapper crmSalesWorkflowMapper;

    /**
     * 新增记录
     *
     * @param crmSalesWorkflow
     * @return
     */

    public MsgDto addCrmSalesWorkflow(CrmSalesWorkflow crmSalesWorkflow) {
        crmSalesWorkflow.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmSalesWorkflow> crmSalesWorkflowList = crmSalesWorkflowMapper.selectListByMap(map);
        if (!crmSalesWorkflowList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmSalesWorkflowList.get(0));
         }
        crmSalesWorkflowMapper.insertSelective(crmSalesWorkflow);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmSalesWorkflow);
    }

    /**
    * 根据id更新记录
    *
    * @param crmSalesWorkflow
    * @return
    */
    public MsgDto updateCrmSalesWorkflow(CrmSalesWorkflow crmSalesWorkflow) {
       Map<String, Object> map = new HashMap();

      List<CrmSalesWorkflow> crmSalesWorkflowList = crmSalesWorkflowMapper.selectListByMap(map);
        if (!crmSalesWorkflowList.isEmpty()) {
          for (CrmSalesWorkflow crmSalesWorkflows : crmSalesWorkflowList) {
             if (!crmSalesWorkflows.getId().equals(crmSalesWorkflow.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmSalesWorkflows);
              }
            }
        }
         crmSalesWorkflowMapper.updateByPrimaryKeySelective(crmSalesWorkflow);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmSalesWorkflow);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmSalesWorkflow(String id) {
         crmSalesWorkflowMapper.deleteByPrimaryKey(id);
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
              crmSalesWorkflowMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmSalesWorkflow(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmSalesWorkflowMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmSalesWorkflowMapper.queryPage(params);
          }

 }