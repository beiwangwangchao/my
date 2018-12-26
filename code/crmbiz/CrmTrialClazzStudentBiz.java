package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmTrialClazzStudentMapper;
import com.jingcheng.marketing.business.model.CrmTrialClazzStudent;
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
public class CrmTrialClazzStudentBiz {

    @Autowired
    private CrmTrialClazzStudentMapper crmTrialClazzStudentMapper;

    /**
     * 新增记录
     *
     * @param crmTrialClazzStudent
     * @return
     */

    public MsgDto addCrmTrialClazzStudent(CrmTrialClazzStudent crmTrialClazzStudent) {
        crmTrialClazzStudent.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmTrialClazzStudent> crmTrialClazzStudentList = crmTrialClazzStudentMapper.selectListByMap(map);
        if (!crmTrialClazzStudentList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmTrialClazzStudentList.get(0));
         }
        crmTrialClazzStudentMapper.insertSelective(crmTrialClazzStudent);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmTrialClazzStudent);
    }

    /**
    * 根据id更新记录
    *
    * @param crmTrialClazzStudent
    * @return
    */
    public MsgDto updateCrmTrialClazzStudent(CrmTrialClazzStudent crmTrialClazzStudent) {
       Map<String, Object> map = new HashMap();

      List<CrmTrialClazzStudent> crmTrialClazzStudentList = crmTrialClazzStudentMapper.selectListByMap(map);
        if (!crmTrialClazzStudentList.isEmpty()) {
          for (CrmTrialClazzStudent crmTrialClazzStudents : crmTrialClazzStudentList) {
             if (!crmTrialClazzStudents.getId().equals(crmTrialClazzStudent.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmTrialClazzStudents);
              }
            }
        }
         crmTrialClazzStudentMapper.updateByPrimaryKeySelective(crmTrialClazzStudent);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmTrialClazzStudent);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmTrialClazzStudent(String id) {
         crmTrialClazzStudentMapper.deleteByPrimaryKey(id);
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
              crmTrialClazzStudentMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmTrialClazzStudent(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmTrialClazzStudentMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmTrialClazzStudentMapper.queryPage(params);
          }

 }