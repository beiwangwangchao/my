package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmSchoolMapper;
import com.jingcheng.marketing.business.model.CrmSchool;
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
public class CrmSchoolBiz {

    @Autowired
    private CrmSchoolMapper crmSchoolMapper;

    /**
     * 新增记录
     *
     * @param crmSchool
     * @return
     */

    public MsgDto addCrmSchool(CrmSchool crmSchool) {
        crmSchool.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmSchool> crmSchoolList = crmSchoolMapper.selectListByMap(map);
        if (!crmSchoolList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmSchoolList.get(0));
         }
        crmSchoolMapper.insertSelective(crmSchool);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmSchool);
    }

    /**
    * 根据id更新记录
    *
    * @param crmSchool
    * @return
    */
    public MsgDto updateCrmSchool(CrmSchool crmSchool) {
       Map<String, Object> map = new HashMap();

      List<CrmSchool> crmSchoolList = crmSchoolMapper.selectListByMap(map);
        if (!crmSchoolList.isEmpty()) {
          for (CrmSchool crmSchools : crmSchoolList) {
             if (!crmSchools.getId().equals(crmSchool.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmSchools);
              }
            }
        }
         crmSchoolMapper.updateByPrimaryKeySelective(crmSchool);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmSchool);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmSchool(String id) {
         crmSchoolMapper.deleteByPrimaryKey(id);
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
              crmSchoolMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmSchool(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmSchoolMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmSchoolMapper.queryPage(params);
          }

 }