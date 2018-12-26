package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmMessageMapper;
import com.jingcheng.marketing.business.model.CrmMessage;
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
public class CrmMessageBiz {

    @Autowired
    private CrmMessageMapper crmMessageMapper;

    /**
     * 新增记录
     *
     * @param crmMessage
     * @return
     */

    public MsgDto addCrmMessage(CrmMessage crmMessage) {
        crmMessage.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmMessage> crmMessageList = crmMessageMapper.selectListByMap(map);
        if (!crmMessageList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmMessageList.get(0));
         }
        crmMessageMapper.insertSelective(crmMessage);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmMessage);
    }

    /**
    * 根据id更新记录
    *
    * @param crmMessage
    * @return
    */
    public MsgDto updateCrmMessage(CrmMessage crmMessage) {
       Map<String, Object> map = new HashMap();

      List<CrmMessage> crmMessageList = crmMessageMapper.selectListByMap(map);
        if (!crmMessageList.isEmpty()) {
          for (CrmMessage crmMessages : crmMessageList) {
             if (!crmMessages.getId().equals(crmMessage.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmMessages);
              }
            }
        }
         crmMessageMapper.updateByPrimaryKeySelective(crmMessage);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmMessage);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmMessage(String id) {
         crmMessageMapper.deleteByPrimaryKey(id);
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
              crmMessageMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmMessage(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmMessageMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmMessageMapper.queryPage(params);
          }

 }