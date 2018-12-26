package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmClazzBakMapper;
import com.jingcheng.marketing.business.model.CrmClazzBak;
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
public class CrmClazzBakBiz {

    @Autowired
    private CrmClazzBakMapper crmClazzBakMapper;

    /**
     * 新增记录
     *
     * @param crmClazzBak
     * @return
     */

    public MsgDto addCrmClazzBak(CrmClazzBak crmClazzBak) {
        crmClazzBak.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmClazzBak> crmClazzBakList = crmClazzBakMapper.selectListByMap(map);
        if (!crmClazzBakList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmClazzBakList.get(0));
         }
        crmClazzBakMapper.insertSelective(crmClazzBak);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmClazzBak);
    }

    /**
    * 根据id更新记录
    *
    * @param crmClazzBak
    * @return
    */
    public MsgDto updateCrmClazzBak(CrmClazzBak crmClazzBak) {
       Map<String, Object> map = new HashMap();

      List<CrmClazzBak> crmClazzBakList = crmClazzBakMapper.selectListByMap(map);
        if (!crmClazzBakList.isEmpty()) {
          for (CrmClazzBak crmClazzBaks : crmClazzBakList) {
             if (!crmClazzBaks.getId().equals(crmClazzBak.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmClazzBaks);
              }
            }
        }
         crmClazzBakMapper.updateByPrimaryKeySelective(crmClazzBak);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmClazzBak);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmClazzBak(String id) {
         crmClazzBakMapper.deleteByPrimaryKey(id);
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
              crmClazzBakMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmClazzBak(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmClazzBakMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmClazzBakMapper.queryPage(params);
          }

 }