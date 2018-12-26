package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmProductMapper;
import com.jingcheng.marketing.business.model.CrmProduct;
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
public class CrmProductBiz {

    @Autowired
    private CrmProductMapper crmProductMapper;

    /**
     * 新增记录
     *
     * @param crmProduct
     * @return
     */

    public MsgDto addCrmProduct(CrmProduct crmProduct) {
        crmProduct.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmProduct> crmProductList = crmProductMapper.selectListByMap(map);
        if (!crmProductList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmProductList.get(0));
         }
        crmProductMapper.insertSelective(crmProduct);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmProduct);
    }

    /**
    * 根据id更新记录
    *
    * @param crmProduct
    * @return
    */
    public MsgDto updateCrmProduct(CrmProduct crmProduct) {
       Map<String, Object> map = new HashMap();

      List<CrmProduct> crmProductList = crmProductMapper.selectListByMap(map);
        if (!crmProductList.isEmpty()) {
          for (CrmProduct crmProducts : crmProductList) {
             if (!crmProducts.getId().equals(crmProduct.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmProducts);
              }
            }
        }
         crmProductMapper.updateByPrimaryKeySelective(crmProduct);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmProduct);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmProduct(String id) {
         crmProductMapper.deleteByPrimaryKey(id);
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
              crmProductMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmProduct(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmProductMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmProductMapper.queryPage(params);
          }

 }