package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmTaskBiz;
import com.jingcheng.marketing.business.model.CrmTask;
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
@RequestMapping("/crmTask")
public class CrmTaskController extends BaseController {
@Autowired
CrmTaskBiz crmTaskBiz;

    /***
     * @function1
     * 新增记录
     * @param crmTask
     */
    @RequestMapping("/add")
    public MsgDto addCrmTask(@RequestBody CrmTask crmTask) {
        return crmTaskBiz.addCrmTask(crmTask);
    }

    /****
     * @function2
     * 更新记录
     * @param crmTask
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmTask(@RequestBody CrmTask crmTask) {
        if (null == crmTask.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmTaskBiz.updateCrmTask(crmTask);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmTask(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmTaskBiz.delCrmTask(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmTask(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmTaskBiz.getCrmTask(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmTaskBiz.queryByPage(paramsMap);
    }
 }
