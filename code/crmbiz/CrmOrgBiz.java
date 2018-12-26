package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmOrgMapper;
import com.jingcheng.marketing.business.model.CrmOrg;
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
public class CrmOrgBiz {

    @Autowired
    private CrmOrgMapper crmOrgMapper;

    /**
     * 新增记录
     *
     * @param crmOrg
     * @return
     */

    public MsgDto addCrmOrg(CrmOrg crmOrg) {
        crmOrg.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmOrg> crmOrgList = crmOrgMapper.selectListByMap(map);
        if (!crmOrgList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmOrgList.get(0));
         }
        crmOrgMapper.insertSelective(crmOrg);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmOrg);
    }

    /**
    * 根据id更新记录
    *
    * @param crmOrg
    * @return
    */
    public MsgDto updateCrmOrg(CrmOrg crmOrg) {
       Map<String, Object> map = new HashMap();

      List<CrmOrg> crmOrgList = crmOrgMapper.selectListByMap(map);
        if (!crmOrgList.isEmpty()) {
          for (CrmOrg crmOrgs : crmOrgList) {
             if (!crmOrgs.getId().equals(crmOrg.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmOrgs);
              }
            }
        }
         crmOrgMapper.updateByPrimaryKeySelective(crmOrg);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmOrg);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmOrg(String id) {
         crmOrgMapper.deleteByPrimaryKey(id);
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
              crmOrgMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmOrg(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmOrgMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmOrgMapper.queryPage(params);
          }

 }