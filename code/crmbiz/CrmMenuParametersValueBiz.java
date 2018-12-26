package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmMenuParametersValueMapper;
import com.jingcheng.marketing.business.model.CrmMenuParametersValue;
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
public class CrmMenuParametersValueBiz {

    @Autowired
    private CrmMenuParametersValueMapper crmMenuParametersValueMapper;

    /**
     * 新增记录
     *
     * @param crmMenuParametersValue
     * @return
     */

    public MsgDto addCrmMenuParametersValue(CrmMenuParametersValue crmMenuParametersValue) {
        crmMenuParametersValue.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmMenuParametersValue> crmMenuParametersValueList = crmMenuParametersValueMapper.selectListByMap(map);
        if (!crmMenuParametersValueList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmMenuParametersValueList.get(0));
         }
        crmMenuParametersValueMapper.insertSelective(crmMenuParametersValue);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmMenuParametersValue);
    }

    /**
    * 根据id更新记录
    *
    * @param crmMenuParametersValue
    * @return
    */
    public MsgDto updateCrmMenuParametersValue(CrmMenuParametersValue crmMenuParametersValue) {
       Map<String, Object> map = new HashMap();

      List<CrmMenuParametersValue> crmMenuParametersValueList = crmMenuParametersValueMapper.selectListByMap(map);
        if (!crmMenuParametersValueList.isEmpty()) {
          for (CrmMenuParametersValue crmMenuParametersValues : crmMenuParametersValueList) {
             if (!crmMenuParametersValues.getId().equals(crmMenuParametersValue.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmMenuParametersValues);
              }
            }
        }
         crmMenuParametersValueMapper.updateByPrimaryKeySelective(crmMenuParametersValue);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmMenuParametersValue);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmMenuParametersValue(String id) {
         crmMenuParametersValueMapper.deleteByPrimaryKey(id);
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
              crmMenuParametersValueMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmMenuParametersValue(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmMenuParametersValueMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmMenuParametersValueMapper.queryPage(params);
          }

 }