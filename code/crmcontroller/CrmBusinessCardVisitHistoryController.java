package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmBusinessCardVisitHistoryBiz;
import com.jingcheng.marketing.business.model.CrmBusinessCardVisitHistory;
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
@RequestMapping("/crmBusinessCardVisitHistory")
public class CrmBusinessCardVisitHistoryController extends BaseController {
@Autowired
CrmBusinessCardVisitHistoryBiz crmBusinessCardVisitHistoryBiz;

    /***
     * @function1
     * 新增记录
     * @param crmBusinessCardVisitHistory
     */
    @RequestMapping("/add")
    public MsgDto addCrmBusinessCardVisitHistory(@RequestBody CrmBusinessCardVisitHistory crmBusinessCardVisitHistory) {
        return crmBusinessCardVisitHistoryBiz.addCrmBusinessCardVisitHistory(crmBusinessCardVisitHistory);
    }

    /****
     * @function2
     * 更新记录
     * @param crmBusinessCardVisitHistory
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmBusinessCardVisitHistory(@RequestBody CrmBusinessCardVisitHistory crmBusinessCardVisitHistory) {
        if (null == crmBusinessCardVisitHistory.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmBusinessCardVisitHistoryBiz.updateCrmBusinessCardVisitHistory(crmBusinessCardVisitHistory);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmBusinessCardVisitHistory(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmBusinessCardVisitHistoryBiz.delCrmBusinessCardVisitHistory(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmBusinessCardVisitHistory(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmBusinessCardVisitHistoryBiz.getCrmBusinessCardVisitHistory(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmBusinessCardVisitHistoryBiz.queryByPage(paramsMap);
    }
 }
