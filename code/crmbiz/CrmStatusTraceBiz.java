package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmStatusTraceMapper;
import com.jingcheng.marketing.business.model.CrmStatusTrace;
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
public class CrmStatusTraceBiz {

    @Autowired
    private CrmStatusTraceMapper crmStatusTraceMapper;

    /**
     * 新增记录
     *
     * @param crmStatusTrace
     * @return
     */

    public MsgDto addCrmStatusTrace(CrmStatusTrace crmStatusTrace) {
        crmStatusTrace.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmStatusTrace> crmStatusTraceList = crmStatusTraceMapper.selectListByMap(map);
        if (!crmStatusTraceList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmStatusTraceList.get(0));
         }
        crmStatusTraceMapper.insertSelective(crmStatusTrace);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmStatusTrace);
    }

    /**
    * 根据id更新记录
    *
    * @param crmStatusTrace
    * @return
    */
    public MsgDto updateCrmStatusTrace(CrmStatusTrace crmStatusTrace) {
       Map<String, Object> map = new HashMap();

      List<CrmStatusTrace> crmStatusTraceList = crmStatusTraceMapper.selectListByMap(map);
        if (!crmStatusTraceList.isEmpty()) {
          for (CrmStatusTrace crmStatusTraces : crmStatusTraceList) {
             if (!crmStatusTraces.getId().equals(crmStatusTrace.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmStatusTraces);
              }
            }
        }
         crmStatusTraceMapper.updateByPrimaryKeySelective(crmStatusTrace);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmStatusTrace);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmStatusTrace(String id) {
         crmStatusTraceMapper.deleteByPrimaryKey(id);
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
              crmStatusTraceMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmStatusTrace(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmStatusTraceMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmStatusTraceMapper.queryPage(params);
          }

 }