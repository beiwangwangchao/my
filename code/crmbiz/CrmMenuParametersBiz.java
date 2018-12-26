package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmMenuParametersMapper;
import com.jingcheng.marketing.business.model.CrmMenuParameters;
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
public class CrmMenuParametersBiz {

    @Autowired
    private CrmMenuParametersMapper crmMenuParametersMapper;

    /**
     * 新增记录
     *
     * @param crmMenuParameters
     * @return
     */

    public MsgDto addCrmMenuParameters(CrmMenuParameters crmMenuParameters) {
        crmMenuParameters.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmMenuParameters> crmMenuParametersList = crmMenuParametersMapper.selectListByMap(map);
        if (!crmMenuParametersList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmMenuParametersList.get(0));
         }
        crmMenuParametersMapper.insertSelective(crmMenuParameters);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmMenuParameters);
    }

    /**
    * 根据id更新记录
    *
    * @param crmMenuParameters
    * @return
    */
    public MsgDto updateCrmMenuParameters(CrmMenuParameters crmMenuParameters) {
       Map<String, Object> map = new HashMap();

      List<CrmMenuParameters> crmMenuParametersList = crmMenuParametersMapper.selectListByMap(map);
        if (!crmMenuParametersList.isEmpty()) {
          for (CrmMenuParameters crmMenuParameterss : crmMenuParametersList) {
             if (!crmMenuParameterss.getId().equals(crmMenuParameters.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmMenuParameterss);
              }
            }
        }
         crmMenuParametersMapper.updateByPrimaryKeySelective(crmMenuParameters);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmMenuParameters);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmMenuParameters(String id) {
         crmMenuParametersMapper.deleteByPrimaryKey(id);
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
              crmMenuParametersMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmMenuParameters(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmMenuParametersMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmMenuParametersMapper.queryPage(params);
          }

 }