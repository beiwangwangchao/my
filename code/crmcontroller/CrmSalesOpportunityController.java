package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmSalesOpportunityBiz;
import com.jingcheng.marketing.business.model.CrmSalesOpportunity;
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
@RequestMapping("/crmSalesOpportunity")
public class CrmSalesOpportunityController extends BaseController {
@Autowired
CrmSalesOpportunityBiz crmSalesOpportunityBiz;

    /***
     * @function1
     * 新增记录
     * @param crmSalesOpportunity
     */
    @RequestMapping("/add")
    public MsgDto addCrmSalesOpportunity(@RequestBody CrmSalesOpportunity crmSalesOpportunity) {
        return crmSalesOpportunityBiz.addCrmSalesOpportunity(crmSalesOpportunity);
    }

    /****
     * @function2
     * 更新记录
     * @param crmSalesOpportunity
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmSalesOpportunity(@RequestBody CrmSalesOpportunity crmSalesOpportunity) {
        if (null == crmSalesOpportunity.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmSalesOpportunityBiz.updateCrmSalesOpportunity(crmSalesOpportunity);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmSalesOpportunity(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmSalesOpportunityBiz.delCrmSalesOpportunity(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmSalesOpportunity(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmSalesOpportunityBiz.getCrmSalesOpportunity(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmSalesOpportunityBiz.queryByPage(paramsMap);
    }
 }
