package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmNoticeMapper;
import com.jingcheng.marketing.business.model.CrmNotice;
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
public class CrmNoticeBiz {

    @Autowired
    private CrmNoticeMapper crmNoticeMapper;

    /**
     * 新增记录
     *
     * @param crmNotice
     * @return
     */

    public MsgDto addCrmNotice(CrmNotice crmNotice) {
        crmNotice.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmNotice> crmNoticeList = crmNoticeMapper.selectListByMap(map);
        if (!crmNoticeList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmNoticeList.get(0));
         }
        crmNoticeMapper.insertSelective(crmNotice);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmNotice);
    }

    /**
    * 根据id更新记录
    *
    * @param crmNotice
    * @return
    */
    public MsgDto updateCrmNotice(CrmNotice crmNotice) {
       Map<String, Object> map = new HashMap();

      List<CrmNotice> crmNoticeList = crmNoticeMapper.selectListByMap(map);
        if (!crmNoticeList.isEmpty()) {
          for (CrmNotice crmNotices : crmNoticeList) {
             if (!crmNotices.getId().equals(crmNotice.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmNotices);
              }
            }
        }
         crmNoticeMapper.updateByPrimaryKeySelective(crmNotice);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmNotice);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmNotice(String id) {
         crmNoticeMapper.deleteByPrimaryKey(id);
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
              crmNoticeMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmNotice(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmNoticeMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmNoticeMapper.queryPage(params);
          }

 }