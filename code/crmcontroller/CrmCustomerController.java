package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmCustomerBiz;
import com.jingcheng.marketing.business.model.CrmCustomer;
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
@RequestMapping("/crmCustomer")
public class CrmCustomerController extends BaseController {
@Autowired
CrmCustomerBiz crmCustomerBiz;

    /***
     * @function1
     * 新增记录
     * @param crmCustomer
     */
    @RequestMapping("/add")
    public MsgDto addCrmCustomer(@RequestBody CrmCustomer crmCustomer) {
        return crmCustomerBiz.addCrmCustomer(crmCustomer);
    }

    /****
     * @function2
     * 更新记录
     * @param crmCustomer
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmCustomer(@RequestBody CrmCustomer crmCustomer) {
        if (null == crmCustomer.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmCustomerBiz.updateCrmCustomer(crmCustomer);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmCustomer(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmCustomerBiz.delCrmCustomer(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmCustomer(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmCustomerBiz.getCrmCustomer(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmCustomerBiz.queryByPage(paramsMap);
    }
 }
