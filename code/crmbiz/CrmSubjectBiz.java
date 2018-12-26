package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmSubjectMapper;
import com.jingcheng.marketing.business.model.CrmSubject;
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
public class CrmSubjectBiz {

    @Autowired
    private CrmSubjectMapper crmSubjectMapper;

    /**
     * 新增记录
     *
     * @param crmSubject
     * @return
     */

    public MsgDto addCrmSubject(CrmSubject crmSubject) {
        crmSubject.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmSubject> crmSubjectList = crmSubjectMapper.selectListByMap(map);
        if (!crmSubjectList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmSubjectList.get(0));
         }
        crmSubjectMapper.insertSelective(crmSubject);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmSubject);
    }

    /**
    * 根据id更新记录
    *
    * @param crmSubject
    * @return
    */
    public MsgDto updateCrmSubject(CrmSubject crmSubject) {
       Map<String, Object> map = new HashMap();

      List<CrmSubject> crmSubjectList = crmSubjectMapper.selectListByMap(map);
        if (!crmSubjectList.isEmpty()) {
          for (CrmSubject crmSubjects : crmSubjectList) {
             if (!crmSubjects.getId().equals(crmSubject.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmSubjects);
              }
            }
        }
         crmSubjectMapper.updateByPrimaryKeySelective(crmSubject);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmSubject);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmSubject(String id) {
         crmSubjectMapper.deleteByPrimaryKey(id);
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
              crmSubjectMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmSubject(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmSubjectMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmSubjectMapper.queryPage(params);
          }

 }