package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmSysParametersMapper;
import com.jingcheng.marketing.business.model.CrmSysParameters;
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
public class CrmSysParametersBiz {

    @Autowired
    private CrmSysParametersMapper crmSysParametersMapper;

    /**
     * 新增记录
     *
     * @param crmSysParameters
     * @return
     */

    public MsgDto addCrmSysParameters(CrmSysParameters crmSysParameters) {
        crmSysParameters.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmSysParameters> crmSysParametersList = crmSysParametersMapper.selectListByMap(map);
        if (!crmSysParametersList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmSysParametersList.get(0));
         }
        crmSysParametersMapper.insertSelective(crmSysParameters);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmSysParameters);
    }

    /**
    * 根据id更新记录
    *
    * @param crmSysParameters
    * @return
    */
    public MsgDto updateCrmSysParameters(CrmSysParameters crmSysParameters) {
       Map<String, Object> map = new HashMap();

      List<CrmSysParameters> crmSysParametersList = crmSysParametersMapper.selectListByMap(map);
        if (!crmSysParametersList.isEmpty()) {
          for (CrmSysParameters crmSysParameterss : crmSysParametersList) {
             if (!crmSysParameterss.getId().equals(crmSysParameters.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmSysParameterss);
              }
            }
        }
         crmSysParametersMapper.updateByPrimaryKeySelective(crmSysParameters);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmSysParameters);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmSysParameters(String id) {
         crmSysParametersMapper.deleteByPrimaryKey(id);
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
              crmSysParametersMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmSysParameters(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmSysParametersMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmSysParametersMapper.queryPage(params);
          }

 }