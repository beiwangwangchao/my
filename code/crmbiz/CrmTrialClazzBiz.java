package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmTrialClazzMapper;
import com.jingcheng.marketing.business.model.CrmTrialClazz;
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
public class CrmTrialClazzBiz {

    @Autowired
    private CrmTrialClazzMapper crmTrialClazzMapper;

    /**
     * 新增记录
     *
     * @param crmTrialClazz
     * @return
     */

    public MsgDto addCrmTrialClazz(CrmTrialClazz crmTrialClazz) {
        crmTrialClazz.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmTrialClazz> crmTrialClazzList = crmTrialClazzMapper.selectListByMap(map);
        if (!crmTrialClazzList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmTrialClazzList.get(0));
         }
        crmTrialClazzMapper.insertSelective(crmTrialClazz);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmTrialClazz);
    }

    /**
    * 根据id更新记录
    *
    * @param crmTrialClazz
    * @return
    */
    public MsgDto updateCrmTrialClazz(CrmTrialClazz crmTrialClazz) {
       Map<String, Object> map = new HashMap();

      List<CrmTrialClazz> crmTrialClazzList = crmTrialClazzMapper.selectListByMap(map);
        if (!crmTrialClazzList.isEmpty()) {
          for (CrmTrialClazz crmTrialClazzs : crmTrialClazzList) {
             if (!crmTrialClazzs.getId().equals(crmTrialClazz.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmTrialClazzs);
              }
            }
        }
         crmTrialClazzMapper.updateByPrimaryKeySelective(crmTrialClazz);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmTrialClazz);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmTrialClazz(String id) {
         crmTrialClazzMapper.deleteByPrimaryKey(id);
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
              crmTrialClazzMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmTrialClazz(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmTrialClazzMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmTrialClazzMapper.queryPage(params);
          }

 }