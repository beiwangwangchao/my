package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmDataDictionaryMapper;
import com.jingcheng.marketing.business.model.CrmDataDictionary;
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
public class CrmDataDictionaryBiz {

    @Autowired
    private CrmDataDictionaryMapper crmDataDictionaryMapper;

    /**
     * 新增记录
     *
     * @param crmDataDictionary
     * @return
     */

    public MsgDto addCrmDataDictionary(CrmDataDictionary crmDataDictionary) {
        crmDataDictionary.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmDataDictionary> crmDataDictionaryList = crmDataDictionaryMapper.selectListByMap(map);
        if (!crmDataDictionaryList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmDataDictionaryList.get(0));
         }
        crmDataDictionaryMapper.insertSelective(crmDataDictionary);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmDataDictionary);
    }

    /**
    * 根据id更新记录
    *
    * @param crmDataDictionary
    * @return
    */
    public MsgDto updateCrmDataDictionary(CrmDataDictionary crmDataDictionary) {
       Map<String, Object> map = new HashMap();

      List<CrmDataDictionary> crmDataDictionaryList = crmDataDictionaryMapper.selectListByMap(map);
        if (!crmDataDictionaryList.isEmpty()) {
          for (CrmDataDictionary crmDataDictionarys : crmDataDictionaryList) {
             if (!crmDataDictionarys.getId().equals(crmDataDictionary.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmDataDictionarys);
              }
            }
        }
         crmDataDictionaryMapper.updateByPrimaryKeySelective(crmDataDictionary);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmDataDictionary);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmDataDictionary(String id) {
         crmDataDictionaryMapper.deleteByPrimaryKey(id);
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
              crmDataDictionaryMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmDataDictionary(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmDataDictionaryMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmDataDictionaryMapper.queryPage(params);
          }

 }