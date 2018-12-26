package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmTeacherMapper;
import com.jingcheng.marketing.business.model.CrmTeacher;
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
public class CrmTeacherBiz {

    @Autowired
    private CrmTeacherMapper crmTeacherMapper;

    /**
     * 新增记录
     *
     * @param crmTeacher
     * @return
     */

    public MsgDto addCrmTeacher(CrmTeacher crmTeacher) {
        crmTeacher.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmTeacher> crmTeacherList = crmTeacherMapper.selectListByMap(map);
        if (!crmTeacherList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmTeacherList.get(0));
         }
        crmTeacherMapper.insertSelective(crmTeacher);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmTeacher);
    }

    /**
    * 根据id更新记录
    *
    * @param crmTeacher
    * @return
    */
    public MsgDto updateCrmTeacher(CrmTeacher crmTeacher) {
       Map<String, Object> map = new HashMap();

      List<CrmTeacher> crmTeacherList = crmTeacherMapper.selectListByMap(map);
        if (!crmTeacherList.isEmpty()) {
          for (CrmTeacher crmTeachers : crmTeacherList) {
             if (!crmTeachers.getId().equals(crmTeacher.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmTeachers);
              }
            }
        }
         crmTeacherMapper.updateByPrimaryKeySelective(crmTeacher);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmTeacher);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmTeacher(String id) {
         crmTeacherMapper.deleteByPrimaryKey(id);
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
              crmTeacherMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmTeacher(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmTeacherMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmTeacherMapper.queryPage(params);
          }

 }