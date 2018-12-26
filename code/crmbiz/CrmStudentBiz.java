package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmStudentMapper;
import com.jingcheng.marketing.business.model.CrmStudent;
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
public class CrmStudentBiz {

    @Autowired
    private CrmStudentMapper crmStudentMapper;

    /**
     * 新增记录
     *
     * @param crmStudent
     * @return
     */

    public MsgDto addCrmStudent(CrmStudent crmStudent) {
        crmStudent.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmStudent> crmStudentList = crmStudentMapper.selectListByMap(map);
        if (!crmStudentList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmStudentList.get(0));
         }
        crmStudentMapper.insertSelective(crmStudent);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmStudent);
    }

    /**
    * 根据id更新记录
    *
    * @param crmStudent
    * @return
    */
    public MsgDto updateCrmStudent(CrmStudent crmStudent) {
       Map<String, Object> map = new HashMap();

      List<CrmStudent> crmStudentList = crmStudentMapper.selectListByMap(map);
        if (!crmStudentList.isEmpty()) {
          for (CrmStudent crmStudents : crmStudentList) {
             if (!crmStudents.getId().equals(crmStudent.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmStudents);
              }
            }
        }
         crmStudentMapper.updateByPrimaryKeySelective(crmStudent);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmStudent);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmStudent(String id) {
         crmStudentMapper.deleteByPrimaryKey(id);
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
              crmStudentMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmStudent(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmStudentMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmStudentMapper.queryPage(params);
          }

 }