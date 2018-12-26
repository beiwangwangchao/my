package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmSalesProcessDetailsMapper;
import com.jingcheng.marketing.business.model.CrmSalesProcessDetails;
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
public class CrmSalesProcessDetailsBiz {

    @Autowired
    private CrmSalesProcessDetailsMapper crmSalesProcessDetailsMapper;

    /**
     * 新增记录
     *
     * @param crmSalesProcessDetails
     * @return
     */

    public MsgDto addCrmSalesProcessDetails(CrmSalesProcessDetails crmSalesProcessDetails) {
        crmSalesProcessDetails.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmSalesProcessDetails> crmSalesProcessDetailsList = crmSalesProcessDetailsMapper.selectListByMap(map);
        if (!crmSalesProcessDetailsList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmSalesProcessDetailsList.get(0));
         }
        crmSalesProcessDetailsMapper.insertSelective(crmSalesProcessDetails);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmSalesProcessDetails);
    }

    /**
    * 根据id更新记录
    *
    * @param crmSalesProcessDetails
    * @return
    */
    public MsgDto updateCrmSalesProcessDetails(CrmSalesProcessDetails crmSalesProcessDetails) {
       Map<String, Object> map = new HashMap();

      List<CrmSalesProcessDetails> crmSalesProcessDetailsList = crmSalesProcessDetailsMapper.selectListByMap(map);
        if (!crmSalesProcessDetailsList.isEmpty()) {
          for (CrmSalesProcessDetails crmSalesProcessDetailss : crmSalesProcessDetailsList) {
             if (!crmSalesProcessDetailss.getId().equals(crmSalesProcessDetails.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmSalesProcessDetailss);
              }
            }
        }
         crmSalesProcessDetailsMapper.updateByPrimaryKeySelective(crmSalesProcessDetails);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmSalesProcessDetails);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmSalesProcessDetails(String id) {
         crmSalesProcessDetailsMapper.deleteByPrimaryKey(id);
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
              crmSalesProcessDetailsMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmSalesProcessDetails(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmSalesProcessDetailsMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmSalesProcessDetailsMapper.queryPage(params);
          }

 }