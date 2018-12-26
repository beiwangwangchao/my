package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmUserAssginProductBiz;
import com.jingcheng.marketing.business.model.CrmUserAssginProduct;
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
@RequestMapping("/crmUserAssginProduct")
public class CrmUserAssginProductController extends BaseController {
@Autowired
CrmUserAssginProductBiz crmUserAssginProductBiz;

    /***
     * @function1
     * 新增记录
     * @param crmUserAssginProduct
     */
    @RequestMapping("/add")
    public MsgDto addCrmUserAssginProduct(@RequestBody CrmUserAssginProduct crmUserAssginProduct) {
        return crmUserAssginProductBiz.addCrmUserAssginProduct(crmUserAssginProduct);
    }

    /****
     * @function2
     * 更新记录
     * @param crmUserAssginProduct
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmUserAssginProduct(@RequestBody CrmUserAssginProduct crmUserAssginProduct) {
        if (null == crmUserAssginProduct.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmUserAssginProductBiz.updateCrmUserAssginProduct(crmUserAssginProduct);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmUserAssginProduct(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmUserAssginProductBiz.delCrmUserAssginProduct(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmUserAssginProduct(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmUserAssginProductBiz.getCrmUserAssginProduct(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmUserAssginProductBiz.queryByPage(paramsMap);
    }
 }
