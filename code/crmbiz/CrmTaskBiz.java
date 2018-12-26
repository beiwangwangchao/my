package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmTaskMapper;
import com.jingcheng.marketing.business.model.CrmTask;
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
public class CrmTaskBiz {

    @Autowired
    private CrmTaskMapper crmTaskMapper;

    /**
     * 新增记录
     *
     * @param crmTask
     * @return
     */

    public MsgDto addCrmTask(CrmTask crmTask) {
        crmTask.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmTask> crmTaskList = crmTaskMapper.selectListByMap(map);
        if (!crmTaskList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmTaskList.get(0));
         }
        crmTaskMapper.insertSelective(crmTask);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmTask);
    }

    /**
    * 根据id更新记录
    *
    * @param crmTask
    * @return
    */
    public MsgDto updateCrmTask(CrmTask crmTask) {
       Map<String, Object> map = new HashMap();

      List<CrmTask> crmTaskList = crmTaskMapper.selectListByMap(map);
        if (!crmTaskList.isEmpty()) {
          for (CrmTask crmTasks : crmTaskList) {
             if (!crmTasks.getId().equals(crmTask.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmTasks);
              }
            }
        }
         crmTaskMapper.updateByPrimaryKeySelective(crmTask);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmTask);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmTask(String id) {
         crmTaskMapper.deleteByPrimaryKey(id);
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
              crmTaskMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmTask(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmTaskMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmTaskMapper.queryPage(params);
          }

 }