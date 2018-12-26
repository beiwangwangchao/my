package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmAddressMapper;
import com.jingcheng.marketing.business.model.CrmAddress;
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
public class CrmAddressBiz {

    @Autowired
    private CrmAddressMapper crmAddressMapper;

    /**
     * 新增记录
     *
     * @param crmAddress
     * @return
     */

    public MsgDto addCrmAddress(CrmAddress crmAddress) {
        crmAddress.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmAddress> crmAddressList = crmAddressMapper.selectListByMap(map);
        if (!crmAddressList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmAddressList.get(0));
         }
        crmAddressMapper.insertSelective(crmAddress);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmAddress);
    }

    /**
    * 根据id更新记录
    *
    * @param crmAddress
    * @return
    */
    public MsgDto updateCrmAddress(CrmAddress crmAddress) {
       Map<String, Object> map = new HashMap();

      List<CrmAddress> crmAddressList = crmAddressMapper.selectListByMap(map);
        if (!crmAddressList.isEmpty()) {
          for (CrmAddress crmAddresss : crmAddressList) {
             if (!crmAddresss.getId().equals(crmAddress.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmAddresss);
              }
            }
        }
         crmAddressMapper.updateByPrimaryKeySelective(crmAddress);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmAddress);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmAddress(String id) {
         crmAddressMapper.deleteByPrimaryKey(id);
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
              crmAddressMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmAddress(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmAddressMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmAddressMapper.queryPage(params);
          }

 }