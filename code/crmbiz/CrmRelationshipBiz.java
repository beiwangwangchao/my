package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmRelationshipMapper;
import com.jingcheng.marketing.business.model.CrmRelationship;
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
public class CrmRelationshipBiz {

    @Autowired
    private CrmRelationshipMapper crmRelationshipMapper;

    /**
     * 新增记录
     *
     * @param crmRelationship
     * @return
     */

    public MsgDto addCrmRelationship(CrmRelationship crmRelationship) {
        crmRelationship.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmRelationship> crmRelationshipList = crmRelationshipMapper.selectListByMap(map);
        if (!crmRelationshipList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmRelationshipList.get(0));
         }
        crmRelationshipMapper.insertSelective(crmRelationship);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmRelationship);
    }

    /**
    * 根据id更新记录
    *
    * @param crmRelationship
    * @return
    */
    public MsgDto updateCrmRelationship(CrmRelationship crmRelationship) {
       Map<String, Object> map = new HashMap();

      List<CrmRelationship> crmRelationshipList = crmRelationshipMapper.selectListByMap(map);
        if (!crmRelationshipList.isEmpty()) {
          for (CrmRelationship crmRelationships : crmRelationshipList) {
             if (!crmRelationships.getId().equals(crmRelationship.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmRelationships);
              }
            }
        }
         crmRelationshipMapper.updateByPrimaryKeySelective(crmRelationship);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmRelationship);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmRelationship(String id) {
         crmRelationshipMapper.deleteByPrimaryKey(id);
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
              crmRelationshipMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmRelationship(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmRelationshipMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmRelationshipMapper.queryPage(params);
          }

 }