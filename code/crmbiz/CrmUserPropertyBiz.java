package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmUserPropertyMapper;
import com.jingcheng.marketing.business.model.CrmUserProperty;
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
public class CrmUserPropertyBiz {

    @Autowired
    private CrmUserPropertyMapper crmUserPropertyMapper;

    /**
     * 新增记录
     *
     * @param crmUserProperty
     * @return
     */

    public MsgDto addCrmUserProperty(CrmUserProperty crmUserProperty) {
        crmUserProperty.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmUserProperty> crmUserPropertyList = crmUserPropertyMapper.selectListByMap(map);
        if (!crmUserPropertyList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmUserPropertyList.get(0));
         }
        crmUserPropertyMapper.insertSelective(crmUserProperty);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmUserProperty);
    }

    /**
    * 根据id更新记录
    *
    * @param crmUserProperty
    * @return
    */
    public MsgDto updateCrmUserProperty(CrmUserProperty crmUserProperty) {
       Map<String, Object> map = new HashMap();

      List<CrmUserProperty> crmUserPropertyList = crmUserPropertyMapper.selectListByMap(map);
        if (!crmUserPropertyList.isEmpty()) {
          for (CrmUserProperty crmUserPropertys : crmUserPropertyList) {
             if (!crmUserPropertys.getId().equals(crmUserProperty.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmUserPropertys);
              }
            }
        }
         crmUserPropertyMapper.updateByPrimaryKeySelective(crmUserProperty);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmUserProperty);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmUserProperty(String id) {
         crmUserPropertyMapper.deleteByPrimaryKey(id);
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
              crmUserPropertyMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmUserProperty(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmUserPropertyMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmUserPropertyMapper.queryPage(params);
          }

 }