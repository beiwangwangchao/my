package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmProductBiz;
import com.jingcheng.marketing.business.model.CrmProduct;
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
@RequestMapping("/crmProduct")
public class CrmProductController extends BaseController {
@Autowired
CrmProductBiz crmProductBiz;

    /***
     * @function1
     * 新增记录
     * @param crmProduct
     */
    @RequestMapping("/add")
    public MsgDto addCrmProduct(@RequestBody CrmProduct crmProduct) {
        return crmProductBiz.addCrmProduct(crmProduct);
    }

    /****
     * @function2
     * 更新记录
     * @param crmProduct
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmProduct(@RequestBody CrmProduct crmProduct) {
        if (null == crmProduct.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmProductBiz.updateCrmProduct(crmProduct);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmProduct(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmProductBiz.delCrmProduct(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmProduct(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmProductBiz.getCrmProduct(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmProductBiz.queryByPage(paramsMap);
    }
 }
