package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmBusinessCardProductMapper;
import com.jingcheng.marketing.business.model.CrmBusinessCardProduct;
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
public class CrmBusinessCardProductBiz {

    @Autowired
    private CrmBusinessCardProductMapper crmBusinessCardProductMapper;

    /**
     * 新增记录
     *
     * @param crmBusinessCardProduct
     * @return
     */

    public MsgDto addCrmBusinessCardProduct(CrmBusinessCardProduct crmBusinessCardProduct) {
        crmBusinessCardProduct.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmBusinessCardProduct> crmBusinessCardProductList = crmBusinessCardProductMapper.selectListByMap(map);
        if (!crmBusinessCardProductList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmBusinessCardProductList.get(0));
         }
        crmBusinessCardProductMapper.insertSelective(crmBusinessCardProduct);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmBusinessCardProduct);
    }

    /**
    * 根据id更新记录
    *
    * @param crmBusinessCardProduct
    * @return
    */
    public MsgDto updateCrmBusinessCardProduct(CrmBusinessCardProduct crmBusinessCardProduct) {
       Map<String, Object> map = new HashMap();

      List<CrmBusinessCardProduct> crmBusinessCardProductList = crmBusinessCardProductMapper.selectListByMap(map);
        if (!crmBusinessCardProductList.isEmpty()) {
          for (CrmBusinessCardProduct crmBusinessCardProducts : crmBusinessCardProductList) {
             if (!crmBusinessCardProducts.getId().equals(crmBusinessCardProduct.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmBusinessCardProducts);
              }
            }
        }
         crmBusinessCardProductMapper.updateByPrimaryKeySelective(crmBusinessCardProduct);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmBusinessCardProduct);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmBusinessCardProduct(String id) {
         crmBusinessCardProductMapper.deleteByPrimaryKey(id);
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
              crmBusinessCardProductMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmBusinessCardProduct(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmBusinessCardProductMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmBusinessCardProductMapper.queryPage(params);
          }

 }