package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmBusinessCardVisitCountMapper;
import com.jingcheng.marketing.business.model.CrmBusinessCardVisitCount;
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
public class CrmBusinessCardVisitCountBiz {

    @Autowired
    private CrmBusinessCardVisitCountMapper crmBusinessCardVisitCountMapper;

    /**
     * 新增记录
     *
     * @param crmBusinessCardVisitCount
     * @return
     */

    public MsgDto addCrmBusinessCardVisitCount(CrmBusinessCardVisitCount crmBusinessCardVisitCount) {
        crmBusinessCardVisitCount.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmBusinessCardVisitCount> crmBusinessCardVisitCountList = crmBusinessCardVisitCountMapper.selectListByMap(map);
        if (!crmBusinessCardVisitCountList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmBusinessCardVisitCountList.get(0));
         }
        crmBusinessCardVisitCountMapper.insertSelective(crmBusinessCardVisitCount);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmBusinessCardVisitCount);
    }

    /**
    * 根据id更新记录
    *
    * @param crmBusinessCardVisitCount
    * @return
    */
    public MsgDto updateCrmBusinessCardVisitCount(CrmBusinessCardVisitCount crmBusinessCardVisitCount) {
       Map<String, Object> map = new HashMap();

      List<CrmBusinessCardVisitCount> crmBusinessCardVisitCountList = crmBusinessCardVisitCountMapper.selectListByMap(map);
        if (!crmBusinessCardVisitCountList.isEmpty()) {
          for (CrmBusinessCardVisitCount crmBusinessCardVisitCounts : crmBusinessCardVisitCountList) {
             if (!crmBusinessCardVisitCounts.getId().equals(crmBusinessCardVisitCount.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmBusinessCardVisitCounts);
              }
            }
        }
         crmBusinessCardVisitCountMapper.updateByPrimaryKeySelective(crmBusinessCardVisitCount);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmBusinessCardVisitCount);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmBusinessCardVisitCount(String id) {
         crmBusinessCardVisitCountMapper.deleteByPrimaryKey(id);
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
              crmBusinessCardVisitCountMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmBusinessCardVisitCount(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmBusinessCardVisitCountMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmBusinessCardVisitCountMapper.queryPage(params);
          }

 }