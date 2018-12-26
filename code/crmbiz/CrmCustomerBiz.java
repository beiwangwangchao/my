package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmCustomerMapper;
import com.jingcheng.marketing.business.model.CrmCustomer;
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
public class CrmCustomerBiz {

    @Autowired
    private CrmCustomerMapper crmCustomerMapper;

    /**
     * 新增记录
     *
     * @param crmCustomer
     * @return
     */

    public MsgDto addCrmCustomer(CrmCustomer crmCustomer) {
        crmCustomer.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmCustomer> crmCustomerList = crmCustomerMapper.selectListByMap(map);
        if (!crmCustomerList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmCustomerList.get(0));
         }
        crmCustomerMapper.insertSelective(crmCustomer);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmCustomer);
    }

    /**
    * 根据id更新记录
    *
    * @param crmCustomer
    * @return
    */
    public MsgDto updateCrmCustomer(CrmCustomer crmCustomer) {
       Map<String, Object> map = new HashMap();

      List<CrmCustomer> crmCustomerList = crmCustomerMapper.selectListByMap(map);
        if (!crmCustomerList.isEmpty()) {
          for (CrmCustomer crmCustomers : crmCustomerList) {
             if (!crmCustomers.getId().equals(crmCustomer.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmCustomers);
              }
            }
        }
         crmCustomerMapper.updateByPrimaryKeySelective(crmCustomer);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmCustomer);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmCustomer(String id) {
         crmCustomerMapper.deleteByPrimaryKey(id);
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
              crmCustomerMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmCustomer(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmCustomerMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmCustomerMapper.queryPage(params);
          }

 }