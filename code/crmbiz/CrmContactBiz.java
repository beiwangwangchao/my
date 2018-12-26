package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmContactMapper;
import com.jingcheng.marketing.business.model.CrmContact;
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
public class CrmContactBiz {

    @Autowired
    private CrmContactMapper crmContactMapper;

    /**
     * 新增记录
     *
     * @param crmContact
     * @return
     */

    public MsgDto addCrmContact(CrmContact crmContact) {
        crmContact.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmContact> crmContactList = crmContactMapper.selectListByMap(map);
        if (!crmContactList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmContactList.get(0));
         }
        crmContactMapper.insertSelective(crmContact);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmContact);
    }

    /**
    * 根据id更新记录
    *
    * @param crmContact
    * @return
    */
    public MsgDto updateCrmContact(CrmContact crmContact) {
       Map<String, Object> map = new HashMap();

      List<CrmContact> crmContactList = crmContactMapper.selectListByMap(map);
        if (!crmContactList.isEmpty()) {
          for (CrmContact crmContacts : crmContactList) {
             if (!crmContacts.getId().equals(crmContact.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmContacts);
              }
            }
        }
         crmContactMapper.updateByPrimaryKeySelective(crmContact);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmContact);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmContact(String id) {
         crmContactMapper.deleteByPrimaryKey(id);
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
              crmContactMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmContact(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmContactMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmContactMapper.queryPage(params);
          }

 }