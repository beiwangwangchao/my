package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmBusinessCardInformationMapper;
import com.jingcheng.marketing.business.model.CrmBusinessCardInformation;
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
public class CrmBusinessCardInformationBiz {

    @Autowired
    private CrmBusinessCardInformationMapper crmBusinessCardInformationMapper;

    /**
     * 新增记录
     *
     * @param crmBusinessCardInformation
     * @return
     */

    public MsgDto addCrmBusinessCardInformation(CrmBusinessCardInformation crmBusinessCardInformation) {
        crmBusinessCardInformation.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmBusinessCardInformation> crmBusinessCardInformationList = crmBusinessCardInformationMapper.selectListByMap(map);
        if (!crmBusinessCardInformationList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmBusinessCardInformationList.get(0));
         }
        crmBusinessCardInformationMapper.insertSelective(crmBusinessCardInformation);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmBusinessCardInformation);
    }

    /**
    * 根据id更新记录
    *
    * @param crmBusinessCardInformation
    * @return
    */
    public MsgDto updateCrmBusinessCardInformation(CrmBusinessCardInformation crmBusinessCardInformation) {
       Map<String, Object> map = new HashMap();

      List<CrmBusinessCardInformation> crmBusinessCardInformationList = crmBusinessCardInformationMapper.selectListByMap(map);
        if (!crmBusinessCardInformationList.isEmpty()) {
          for (CrmBusinessCardInformation crmBusinessCardInformations : crmBusinessCardInformationList) {
             if (!crmBusinessCardInformations.getId().equals(crmBusinessCardInformation.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmBusinessCardInformations);
              }
            }
        }
         crmBusinessCardInformationMapper.updateByPrimaryKeySelective(crmBusinessCardInformation);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmBusinessCardInformation);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmBusinessCardInformation(String id) {
         crmBusinessCardInformationMapper.deleteByPrimaryKey(id);
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
              crmBusinessCardInformationMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmBusinessCardInformation(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmBusinessCardInformationMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmBusinessCardInformationMapper.queryPage(params);
          }

 }