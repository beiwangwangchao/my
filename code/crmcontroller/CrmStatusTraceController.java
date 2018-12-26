package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmStatusTraceBiz;
import com.jingcheng.marketing.business.model.CrmStatusTrace;
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
@RequestMapping("/crmStatusTrace")
public class CrmStatusTraceController extends BaseController {
@Autowired
CrmStatusTraceBiz crmStatusTraceBiz;

    /***
     * @function1
     * 新增记录
     * @param crmStatusTrace
     */
    @RequestMapping("/add")
    public MsgDto addCrmStatusTrace(@RequestBody CrmStatusTrace crmStatusTrace) {
        return crmStatusTraceBiz.addCrmStatusTrace(crmStatusTrace);
    }

    /****
     * @function2
     * 更新记录
     * @param crmStatusTrace
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmStatusTrace(@RequestBody CrmStatusTrace crmStatusTrace) {
        if (null == crmStatusTrace.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmStatusTraceBiz.updateCrmStatusTrace(crmStatusTrace);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmStatusTrace(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmStatusTraceBiz.delCrmStatusTrace(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmStatusTrace(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmStatusTraceBiz.getCrmStatusTrace(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmStatusTraceBiz.queryByPage(paramsMap);
    }
 }
