package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmOrderMapper;
import com.jingcheng.marketing.business.model.CrmOrder;
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
public class CrmOrderBiz {

    @Autowired
    private CrmOrderMapper crmOrderMapper;

    /**
     * 新增记录
     *
     * @param crmOrder
     * @return
     */

    public MsgDto addCrmOrder(CrmOrder crmOrder) {
        crmOrder.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmOrder> crmOrderList = crmOrderMapper.selectListByMap(map);
        if (!crmOrderList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmOrderList.get(0));
         }
        crmOrderMapper.insertSelective(crmOrder);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmOrder);
    }

    /**
    * 根据id更新记录
    *
    * @param crmOrder
    * @return
    */
    public MsgDto updateCrmOrder(CrmOrder crmOrder) {
       Map<String, Object> map = new HashMap();

      List<CrmOrder> crmOrderList = crmOrderMapper.selectListByMap(map);
        if (!crmOrderList.isEmpty()) {
          for (CrmOrder crmOrders : crmOrderList) {
             if (!crmOrders.getId().equals(crmOrder.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmOrders);
              }
            }
        }
         crmOrderMapper.updateByPrimaryKeySelective(crmOrder);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmOrder);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmOrder(String id) {
         crmOrderMapper.deleteByPrimaryKey(id);
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
              crmOrderMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmOrder(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmOrderMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmOrderMapper.queryPage(params);
          }

 }