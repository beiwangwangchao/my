package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmSalesWorkflowBiz;
import com.jingcheng.marketing.business.model.CrmSalesWorkflow;
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
@RequestMapping("/crmSalesWorkflow")
public class CrmSalesWorkflowController extends BaseController {
@Autowired
CrmSalesWorkflowBiz crmSalesWorkflowBiz;

    /***
     * @function1
     * 新增记录
     * @param crmSalesWorkflow
     */
    @RequestMapping("/add")
    public MsgDto addCrmSalesWorkflow(@RequestBody CrmSalesWorkflow crmSalesWorkflow) {
        return crmSalesWorkflowBiz.addCrmSalesWorkflow(crmSalesWorkflow);
    }

    /****
     * @function2
     * 更新记录
     * @param crmSalesWorkflow
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmSalesWorkflow(@RequestBody CrmSalesWorkflow crmSalesWorkflow) {
        if (null == crmSalesWorkflow.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmSalesWorkflowBiz.updateCrmSalesWorkflow(crmSalesWorkflow);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmSalesWorkflow(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmSalesWorkflowBiz.delCrmSalesWorkflow(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmSalesWorkflow(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmSalesWorkflowBiz.getCrmSalesWorkflow(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmSalesWorkflowBiz.queryByPage(paramsMap);
    }
 }
