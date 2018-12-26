package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmObjectTagsMapper;
import com.jingcheng.marketing.business.model.CrmObjectTags;
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
public class CrmObjectTagsBiz {

    @Autowired
    private CrmObjectTagsMapper crmObjectTagsMapper;

    /**
     * 新增记录
     *
     * @param crmObjectTags
     * @return
     */

    public MsgDto addCrmObjectTags(CrmObjectTags crmObjectTags) {
        crmObjectTags.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmObjectTags> crmObjectTagsList = crmObjectTagsMapper.selectListByMap(map);
        if (!crmObjectTagsList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmObjectTagsList.get(0));
         }
        crmObjectTagsMapper.insertSelective(crmObjectTags);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmObjectTags);
    }

    /**
    * 根据id更新记录
    *
    * @param crmObjectTags
    * @return
    */
    public MsgDto updateCrmObjectTags(CrmObjectTags crmObjectTags) {
       Map<String, Object> map = new HashMap();

      List<CrmObjectTags> crmObjectTagsList = crmObjectTagsMapper.selectListByMap(map);
        if (!crmObjectTagsList.isEmpty()) {
          for (CrmObjectTags crmObjectTagss : crmObjectTagsList) {
             if (!crmObjectTagss.getId().equals(crmObjectTags.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmObjectTagss);
              }
            }
        }
         crmObjectTagsMapper.updateByPrimaryKeySelective(crmObjectTags);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmObjectTags);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmObjectTags(String id) {
         crmObjectTagsMapper.deleteByPrimaryKey(id);
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
              crmObjectTagsMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmObjectTags(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmObjectTagsMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmObjectTagsMapper.queryPage(params);
          }

 }