package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmClazzScheduleMapper;
import com.jingcheng.marketing.business.model.CrmClazzSchedule;
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
public class CrmClazzScheduleBiz {

    @Autowired
    private CrmClazzScheduleMapper crmClazzScheduleMapper;

    /**
     * 新增记录
     *
     * @param crmClazzSchedule
     * @return
     */

    public MsgDto addCrmClazzSchedule(CrmClazzSchedule crmClazzSchedule) {
        crmClazzSchedule.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmClazzSchedule> crmClazzScheduleList = crmClazzScheduleMapper.selectListByMap(map);
        if (!crmClazzScheduleList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmClazzScheduleList.get(0));
         }
        crmClazzScheduleMapper.insertSelective(crmClazzSchedule);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmClazzSchedule);
    }

    /**
    * 根据id更新记录
    *
    * @param crmClazzSchedule
    * @return
    */
    public MsgDto updateCrmClazzSchedule(CrmClazzSchedule crmClazzSchedule) {
       Map<String, Object> map = new HashMap();

      List<CrmClazzSchedule> crmClazzScheduleList = crmClazzScheduleMapper.selectListByMap(map);
        if (!crmClazzScheduleList.isEmpty()) {
          for (CrmClazzSchedule crmClazzSchedules : crmClazzScheduleList) {
             if (!crmClazzSchedules.getId().equals(crmClazzSchedule.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmClazzSchedules);
              }
            }
        }
         crmClazzScheduleMapper.updateByPrimaryKeySelective(crmClazzSchedule);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmClazzSchedule);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmClazzSchedule(String id) {
         crmClazzScheduleMapper.deleteByPrimaryKey(id);
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
              crmClazzScheduleMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmClazzSchedule(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmClazzScheduleMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmClazzScheduleMapper.queryPage(params);
          }

 }