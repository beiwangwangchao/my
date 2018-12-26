package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmReplyContentMapper;
import com.jingcheng.marketing.business.model.CrmReplyContent;
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
public class CrmReplyContentBiz {

    @Autowired
    private CrmReplyContentMapper crmReplyContentMapper;

    /**
     * 新增记录
     *
     * @param crmReplyContent
     * @return
     */

    public MsgDto addCrmReplyContent(CrmReplyContent crmReplyContent) {
        crmReplyContent.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmReplyContent> crmReplyContentList = crmReplyContentMapper.selectListByMap(map);
        if (!crmReplyContentList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmReplyContentList.get(0));
         }
        crmReplyContentMapper.insertSelective(crmReplyContent);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmReplyContent);
    }

    /**
    * 根据id更新记录
    *
    * @param crmReplyContent
    * @return
    */
    public MsgDto updateCrmReplyContent(CrmReplyContent crmReplyContent) {
       Map<String, Object> map = new HashMap();

      List<CrmReplyContent> crmReplyContentList = crmReplyContentMapper.selectListByMap(map);
        if (!crmReplyContentList.isEmpty()) {
          for (CrmReplyContent crmReplyContents : crmReplyContentList) {
             if (!crmReplyContents.getId().equals(crmReplyContent.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmReplyContents);
              }
            }
        }
         crmReplyContentMapper.updateByPrimaryKeySelective(crmReplyContent);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmReplyContent);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmReplyContent(String id) {
         crmReplyContentMapper.deleteByPrimaryKey(id);
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
              crmReplyContentMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmReplyContent(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmReplyContentMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmReplyContentMapper.queryPage(params);
          }

 }