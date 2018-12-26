package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmOrgPropertyMapper;
import com.jingcheng.marketing.business.model.CrmOrgProperty;
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
public class CrmOrgPropertyBiz {

    @Autowired
    private CrmOrgPropertyMapper crmOrgPropertyMapper;

    /**
     * 新增记录
     *
     * @param crmOrgProperty
     * @return
     */

    public MsgDto addCrmOrgProperty(CrmOrgProperty crmOrgProperty) {
        crmOrgProperty.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmOrgProperty> crmOrgPropertyList = crmOrgPropertyMapper.selectListByMap(map);
        if (!crmOrgPropertyList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmOrgPropertyList.get(0));
         }
        crmOrgPropertyMapper.insertSelective(crmOrgProperty);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmOrgProperty);
    }

    /**
    * 根据id更新记录
    *
    * @param crmOrgProperty
    * @return
    */
    public MsgDto updateCrmOrgProperty(CrmOrgProperty crmOrgProperty) {
       Map<String, Object> map = new HashMap();

      List<CrmOrgProperty> crmOrgPropertyList = crmOrgPropertyMapper.selectListByMap(map);
        if (!crmOrgPropertyList.isEmpty()) {
          for (CrmOrgProperty crmOrgPropertys : crmOrgPropertyList) {
             if (!crmOrgPropertys.getId().equals(crmOrgProperty.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmOrgPropertys);
              }
            }
        }
         crmOrgPropertyMapper.updateByPrimaryKeySelective(crmOrgProperty);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmOrgProperty);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmOrgProperty(String id) {
         crmOrgPropertyMapper.deleteByPrimaryKey(id);
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
              crmOrgPropertyMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmOrgProperty(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmOrgPropertyMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmOrgPropertyMapper.queryPage(params);
          }

 }