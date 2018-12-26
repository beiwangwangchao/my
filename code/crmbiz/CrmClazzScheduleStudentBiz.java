package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmClazzScheduleStudentMapper;
import com.jingcheng.marketing.business.model.CrmClazzScheduleStudent;
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
public class CrmClazzScheduleStudentBiz {

    @Autowired
    private CrmClazzScheduleStudentMapper crmClazzScheduleStudentMapper;

    /**
     * 新增记录
     *
     * @param crmClazzScheduleStudent
     * @return
     */

    public MsgDto addCrmClazzScheduleStudent(CrmClazzScheduleStudent crmClazzScheduleStudent) {
        crmClazzScheduleStudent.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmClazzScheduleStudent> crmClazzScheduleStudentList = crmClazzScheduleStudentMapper.selectListByMap(map);
        if (!crmClazzScheduleStudentList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmClazzScheduleStudentList.get(0));
         }
        crmClazzScheduleStudentMapper.insertSelective(crmClazzScheduleStudent);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmClazzScheduleStudent);
    }

    /**
    * 根据id更新记录
    *
    * @param crmClazzScheduleStudent
    * @return
    */
    public MsgDto updateCrmClazzScheduleStudent(CrmClazzScheduleStudent crmClazzScheduleStudent) {
       Map<String, Object> map = new HashMap();

      List<CrmClazzScheduleStudent> crmClazzScheduleStudentList = crmClazzScheduleStudentMapper.selectListByMap(map);
        if (!crmClazzScheduleStudentList.isEmpty()) {
          for (CrmClazzScheduleStudent crmClazzScheduleStudents : crmClazzScheduleStudentList) {
             if (!crmClazzScheduleStudents.getId().equals(crmClazzScheduleStudent.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmClazzScheduleStudents);
              }
            }
        }
         crmClazzScheduleStudentMapper.updateByPrimaryKeySelective(crmClazzScheduleStudent);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmClazzScheduleStudent);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmClazzScheduleStudent(String id) {
         crmClazzScheduleStudentMapper.deleteByPrimaryKey(id);
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
              crmClazzScheduleStudentMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmClazzScheduleStudent(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmClazzScheduleStudentMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmClazzScheduleStudentMapper.queryPage(params);
          }

 }