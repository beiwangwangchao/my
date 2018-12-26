package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmSalesLeadBiz;
import com.jingcheng.marketing.business.model.CrmSalesLead;
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
@RequestMapping("/crmSalesLead")
public class CrmSalesLeadController extends BaseController {
@Autowired
CrmSalesLeadBiz crmSalesLeadBiz;

    /***
     * @function1
     * 新增记录
     * @param crmSalesLead
     */
    @RequestMapping("/add")
    public MsgDto addCrmSalesLead(@RequestBody CrmSalesLead crmSalesLead) {
        return crmSalesLeadBiz.addCrmSalesLead(crmSalesLead);
    }

    /****
     * @function2
     * 更新记录
     * @param crmSalesLead
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmSalesLead(@RequestBody CrmSalesLead crmSalesLead) {
        if (null == crmSalesLead.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmSalesLeadBiz.updateCrmSalesLead(crmSalesLead);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmSalesLead(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmSalesLeadBiz.delCrmSalesLead(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmSalesLead(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmSalesLeadBiz.getCrmSalesLead(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmSalesLeadBiz.queryByPage(paramsMap);
    }
 }
