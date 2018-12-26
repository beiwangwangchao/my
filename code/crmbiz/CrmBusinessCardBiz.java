package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmBusinessCardMapper;
import com.jingcheng.marketing.business.model.CrmBusinessCard;
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
public class CrmBusinessCardBiz {

    @Autowired
    private CrmBusinessCardMapper crmBusinessCardMapper;

    /**
     * 新增记录
     *
     * @param crmBusinessCard
     * @return
     */

    public MsgDto addCrmBusinessCard(CrmBusinessCard crmBusinessCard) {
        crmBusinessCard.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmBusinessCard> crmBusinessCardList = crmBusinessCardMapper.selectListByMap(map);
        if (!crmBusinessCardList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmBusinessCardList.get(0));
         }
        crmBusinessCardMapper.insertSelective(crmBusinessCard);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmBusinessCard);
    }

    /**
    * 根据id更新记录
    *
    * @param crmBusinessCard
    * @return
    */
    public MsgDto updateCrmBusinessCard(CrmBusinessCard crmBusinessCard) {
       Map<String, Object> map = new HashMap();

      List<CrmBusinessCard> crmBusinessCardList = crmBusinessCardMapper.selectListByMap(map);
        if (!crmBusinessCardList.isEmpty()) {
          for (CrmBusinessCard crmBusinessCards : crmBusinessCardList) {
             if (!crmBusinessCards.getId().equals(crmBusinessCard.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmBusinessCards);
              }
            }
        }
         crmBusinessCardMapper.updateByPrimaryKeySelective(crmBusinessCard);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmBusinessCard);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmBusinessCard(String id) {
         crmBusinessCardMapper.deleteByPrimaryKey(id);
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
              crmBusinessCardMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmBusinessCard(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmBusinessCardMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmBusinessCardMapper.queryPage(params);
          }

 }