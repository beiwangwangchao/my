package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmBusinessCardProductBiz;
import com.jingcheng.marketing.business.model.CrmBusinessCardProduct;
import com.util.base.BaseController;
import com.util.comm.Cons;
import com.util.mybatisplus.Page;
import com.util.comm.ParamsMap;
import com.util.dto.MsgDto;
import com.util.exception.ParamsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crmBusinessCardProduct")
public class CrmBusinessCardProductController extends BaseController {
@Autowired
CrmBusinessCardProductBiz crmBusinessCardProductBiz;

    /***
     * @function1
     * 新增记录
     * @param crmBusinessCardProduct
     */
    @RequestMapping("/add")
    public MsgDto addCrmBusinessCardProduct(@RequestBody CrmBusinessCardProduct crmBusinessCardProduct) {
        return crmBusinessCardProductBiz.addCrmBusinessCardProduct(crmBusinessCardProduct);
    }

    /****
     * @function2
     * 更新记录
     * @param crmBusinessCardProduct
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmBusinessCardProduct(@RequestBody CrmBusinessCardProduct crmBusinessCardProduct) {
        if (null == crmBusinessCardProduct.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmBusinessCardProductBiz.updateCrmBusinessCardProduct(crmBusinessCardProduct);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmBusinessCardProduct(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmBusinessCardProductBiz.delCrmBusinessCardProduct(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmBusinessCardProduct(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmBusinessCardProductBiz.getCrmBusinessCardProduct(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmBusinessCardProductBiz.queryByPage(paramsMap);
    }
 }
