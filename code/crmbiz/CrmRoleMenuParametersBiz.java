package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmRoleMenuParametersMapper;
import com.jingcheng.marketing.business.model.CrmRoleMenuParameters;
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
public class CrmRoleMenuParametersBiz {

    @Autowired
    private CrmRoleMenuParametersMapper crmRoleMenuParametersMapper;

    /**
     * 新增记录
     *
     * @param crmRoleMenuParameters
     * @return
     */

    public MsgDto addCrmRoleMenuParameters(CrmRoleMenuParameters crmRoleMenuParameters) {
        crmRoleMenuParameters.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmRoleMenuParameters> crmRoleMenuParametersList = crmRoleMenuParametersMapper.selectListByMap(map);
        if (!crmRoleMenuParametersList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmRoleMenuParametersList.get(0));
         }
        crmRoleMenuParametersMapper.insertSelective(crmRoleMenuParameters);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmRoleMenuParameters);
    }

    /**
    * 根据id更新记录
    *
    * @param crmRoleMenuParameters
    * @return
    */
    public MsgDto updateCrmRoleMenuParameters(CrmRoleMenuParameters crmRoleMenuParameters) {
       Map<String, Object> map = new HashMap();

      List<CrmRoleMenuParameters> crmRoleMenuParametersList = crmRoleMenuParametersMapper.selectListByMap(map);
        if (!crmRoleMenuParametersList.isEmpty()) {
          for (CrmRoleMenuParameters crmRoleMenuParameterss : crmRoleMenuParametersList) {
             if (!crmRoleMenuParameterss.getId().equals(crmRoleMenuParameters.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmRoleMenuParameterss);
              }
            }
        }
         crmRoleMenuParametersMapper.updateByPrimaryKeySelective(crmRoleMenuParameters);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmRoleMenuParameters);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmRoleMenuParameters(String id) {
         crmRoleMenuParametersMapper.deleteByPrimaryKey(id);
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
              crmRoleMenuParametersMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmRoleMenuParameters(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmRoleMenuParametersMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmRoleMenuParametersMapper.queryPage(params);
          }

 }