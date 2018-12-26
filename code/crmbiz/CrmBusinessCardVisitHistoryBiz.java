package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmBusinessCardVisitHistoryMapper;
import com.jingcheng.marketing.business.model.CrmBusinessCardVisitHistory;
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
public class CrmBusinessCardVisitHistoryBiz {

    @Autowired
    private CrmBusinessCardVisitHistoryMapper crmBusinessCardVisitHistoryMapper;

    /**
     * 新增记录
     *
     * @param crmBusinessCardVisitHistory
     * @return
     */

    public MsgDto addCrmBusinessCardVisitHistory(CrmBusinessCardVisitHistory crmBusinessCardVisitHistory) {
        crmBusinessCardVisitHistory.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmBusinessCardVisitHistory> crmBusinessCardVisitHistoryList = crmBusinessCardVisitHistoryMapper.selectListByMap(map);
        if (!crmBusinessCardVisitHistoryList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmBusinessCardVisitHistoryList.get(0));
         }
        crmBusinessCardVisitHistoryMapper.insertSelective(crmBusinessCardVisitHistory);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmBusinessCardVisitHistory);
    }

    /**
    * 根据id更新记录
    *
    * @param crmBusinessCardVisitHistory
    * @return
    */
    public MsgDto updateCrmBusinessCardVisitHistory(CrmBusinessCardVisitHistory crmBusinessCardVisitHistory) {
       Map<String, Object> map = new HashMap();

      List<CrmBusinessCardVisitHistory> crmBusinessCardVisitHistoryList = crmBusinessCardVisitHistoryMapper.selectListByMap(map);
        if (!crmBusinessCardVisitHistoryList.isEmpty()) {
          for (CrmBusinessCardVisitHistory crmBusinessCardVisitHistorys : crmBusinessCardVisitHistoryList) {
             if (!crmBusinessCardVisitHistorys.getId().equals(crmBusinessCardVisitHistory.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmBusinessCardVisitHistorys);
              }
            }
        }
         crmBusinessCardVisitHistoryMapper.updateByPrimaryKeySelective(crmBusinessCardVisitHistory);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmBusinessCardVisitHistory);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmBusinessCardVisitHistory(String id) {
         crmBusinessCardVisitHistoryMapper.deleteByPrimaryKey(id);
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
              crmBusinessCardVisitHistoryMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmBusinessCardVisitHistory(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmBusinessCardVisitHistoryMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmBusinessCardVisitHistoryMapper.queryPage(params);
          }

 }