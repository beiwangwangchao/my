package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmSalesWorkflowHistoryMapper;
import com.jingcheng.marketing.business.model.CrmSalesWorkflowHistory;
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
public class CrmSalesWorkflowHistoryBiz {

    @Autowired
    private CrmSalesWorkflowHistoryMapper crmSalesWorkflowHistoryMapper;

    /**
     * 新增记录
     *
     * @param crmSalesWorkflowHistory
     * @return
     */

    public MsgDto addCrmSalesWorkflowHistory(CrmSalesWorkflowHistory crmSalesWorkflowHistory) {
        crmSalesWorkflowHistory.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmSalesWorkflowHistory> crmSalesWorkflowHistoryList = crmSalesWorkflowHistoryMapper.selectListByMap(map);
        if (!crmSalesWorkflowHistoryList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmSalesWorkflowHistoryList.get(0));
         }
        crmSalesWorkflowHistoryMapper.insertSelective(crmSalesWorkflowHistory);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmSalesWorkflowHistory);
    }

    /**
    * 根据id更新记录
    *
    * @param crmSalesWorkflowHistory
    * @return
    */
    public MsgDto updateCrmSalesWorkflowHistory(CrmSalesWorkflowHistory crmSalesWorkflowHistory) {
       Map<String, Object> map = new HashMap();

      List<CrmSalesWorkflowHistory> crmSalesWorkflowHistoryList = crmSalesWorkflowHistoryMapper.selectListByMap(map);
        if (!crmSalesWorkflowHistoryList.isEmpty()) {
          for (CrmSalesWorkflowHistory crmSalesWorkflowHistorys : crmSalesWorkflowHistoryList) {
             if (!crmSalesWorkflowHistorys.getId().equals(crmSalesWorkflowHistory.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmSalesWorkflowHistorys);
              }
            }
        }
         crmSalesWorkflowHistoryMapper.updateByPrimaryKeySelective(crmSalesWorkflowHistory);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmSalesWorkflowHistory);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmSalesWorkflowHistory(String id) {
         crmSalesWorkflowHistoryMapper.deleteByPrimaryKey(id);
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
              crmSalesWorkflowHistoryMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmSalesWorkflowHistory(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmSalesWorkflowHistoryMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmSalesWorkflowHistoryMapper.queryPage(params);
          }

 }