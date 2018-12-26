package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmCustomerOrganizationBiz;
import com.jingcheng.marketing.business.model.CrmCustomerOrganization;
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
@RequestMapping("/crmCustomerOrganization")
public class CrmCustomerOrganizationController extends BaseController {
@Autowired
CrmCustomerOrganizationBiz crmCustomerOrganizationBiz;

    /***
     * @function1
     * 新增记录
     * @param crmCustomerOrganization
     */
    @RequestMapping("/add")
    public MsgDto addCrmCustomerOrganization(@RequestBody CrmCustomerOrganization crmCustomerOrganization) {
        return crmCustomerOrganizationBiz.addCrmCustomerOrganization(crmCustomerOrganization);
    }

    /****
     * @function2
     * 更新记录
     * @param crmCustomerOrganization
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmCustomerOrganization(@RequestBody CrmCustomerOrganization crmCustomerOrganization) {
        if (null == crmCustomerOrganization.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmCustomerOrganizationBiz.updateCrmCustomerOrganization(crmCustomerOrganization);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmCustomerOrganization(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmCustomerOrganizationBiz.delCrmCustomerOrganization(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmCustomerOrganization(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmCustomerOrganizationBiz.getCrmCustomerOrganization(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmCustomerOrganizationBiz.queryByPage(paramsMap);
    }
 }
