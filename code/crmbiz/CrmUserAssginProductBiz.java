package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmUserAssginProductMapper;
import com.jingcheng.marketing.business.model.CrmUserAssginProduct;
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
public class CrmUserAssginProductBiz {

    @Autowired
    private CrmUserAssginProductMapper crmUserAssginProductMapper;

    /**
     * 新增记录
     *
     * @param crmUserAssginProduct
     * @return
     */

    public MsgDto addCrmUserAssginProduct(CrmUserAssginProduct crmUserAssginProduct) {
        crmUserAssginProduct.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmUserAssginProduct> crmUserAssginProductList = crmUserAssginProductMapper.selectListByMap(map);
        if (!crmUserAssginProductList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmUserAssginProductList.get(0));
         }
        crmUserAssginProductMapper.insertSelective(crmUserAssginProduct);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmUserAssginProduct);
    }

    /**
    * 根据id更新记录
    *
    * @param crmUserAssginProduct
    * @return
    */
    public MsgDto updateCrmUserAssginProduct(CrmUserAssginProduct crmUserAssginProduct) {
       Map<String, Object> map = new HashMap();

      List<CrmUserAssginProduct> crmUserAssginProductList = crmUserAssginProductMapper.selectListByMap(map);
        if (!crmUserAssginProductList.isEmpty()) {
          for (CrmUserAssginProduct crmUserAssginProducts : crmUserAssginProductList) {
             if (!crmUserAssginProducts.getId().equals(crmUserAssginProduct.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmUserAssginProducts);
              }
            }
        }
         crmUserAssginProductMapper.updateByPrimaryKeySelective(crmUserAssginProduct);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmUserAssginProduct);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmUserAssginProduct(String id) {
         crmUserAssginProductMapper.deleteByPrimaryKey(id);
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
              crmUserAssginProductMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmUserAssginProduct(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmUserAssginProductMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmUserAssginProductMapper.queryPage(params);
          }

 }