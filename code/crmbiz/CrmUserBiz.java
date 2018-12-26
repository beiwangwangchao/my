package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmUserMapper;
import com.jingcheng.marketing.business.model.CrmUser;
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
public class CrmUserBiz {

    @Autowired
    private CrmUserMapper crmUserMapper;

    /**
     * 新增记录
     *
     * @param crmUser
     * @return
     */

    public MsgDto addCrmUser(CrmUser crmUser) {
        crmUser.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmUser> crmUserList = crmUserMapper.selectListByMap(map);
        if (!crmUserList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmUserList.get(0));
         }
        crmUserMapper.insertSelective(crmUser);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmUser);
    }

    /**
    * 根据id更新记录
    *
    * @param crmUser
    * @return
    */
    public MsgDto updateCrmUser(CrmUser crmUser) {
       Map<String, Object> map = new HashMap();

      List<CrmUser> crmUserList = crmUserMapper.selectListByMap(map);
        if (!crmUserList.isEmpty()) {
          for (CrmUser crmUsers : crmUserList) {
             if (!crmUsers.getId().equals(crmUser.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmUsers);
              }
            }
        }
         crmUserMapper.updateByPrimaryKeySelective(crmUser);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmUser);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmUser(String id) {
         crmUserMapper.deleteByPrimaryKey(id);
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
              crmUserMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmUser(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmUserMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmUserMapper.queryPage(params);
          }

 }