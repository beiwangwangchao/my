package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmSalesWorkflowHistoryBiz;
import com.jingcheng.marketing.business.model.CrmSalesWorkflowHistory;
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
@RequestMapping("/crmSalesWorkflowHistory")
public class CrmSalesWorkflowHistoryController extends BaseController {
@Autowired
CrmSalesWorkflowHistoryBiz crmSalesWorkflowHistoryBiz;

    /***
     * @function1
     * 新增记录
     * @param crmSalesWorkflowHistory
     */
    @RequestMapping("/add")
    public MsgDto addCrmSalesWorkflowHistory(@RequestBody CrmSalesWorkflowHistory crmSalesWorkflowHistory) {
        return crmSalesWorkflowHistoryBiz.addCrmSalesWorkflowHistory(crmSalesWorkflowHistory);
    }

    /****
     * @function2
     * 更新记录
     * @param crmSalesWorkflowHistory
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmSalesWorkflowHistory(@RequestBody CrmSalesWorkflowHistory crmSalesWorkflowHistory) {
        if (null == crmSalesWorkflowHistory.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmSalesWorkflowHistoryBiz.updateCrmSalesWorkflowHistory(crmSalesWorkflowHistory);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmSalesWorkflowHistory(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmSalesWorkflowHistoryBiz.delCrmSalesWorkflowHistory(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmSalesWorkflowHistory(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmSalesWorkflowHistoryBiz.getCrmSalesWorkflowHistory(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmSalesWorkflowHistoryBiz.queryByPage(paramsMap);
    }
 }
