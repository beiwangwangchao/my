package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmBusinessCardVisitCountBiz;
import com.jingcheng.marketing.business.model.CrmBusinessCardVisitCount;
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
@RequestMapping("/crmBusinessCardVisitCount")
public class CrmBusinessCardVisitCountController extends BaseController {
@Autowired
CrmBusinessCardVisitCountBiz crmBusinessCardVisitCountBiz;

    /***
     * @function1
     * 新增记录
     * @param crmBusinessCardVisitCount
     */
    @RequestMapping("/add")
    public MsgDto addCrmBusinessCardVisitCount(@RequestBody CrmBusinessCardVisitCount crmBusinessCardVisitCount) {
        return crmBusinessCardVisitCountBiz.addCrmBusinessCardVisitCount(crmBusinessCardVisitCount);
    }

    /****
     * @function2
     * 更新记录
     * @param crmBusinessCardVisitCount
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmBusinessCardVisitCount(@RequestBody CrmBusinessCardVisitCount crmBusinessCardVisitCount) {
        if (null == crmBusinessCardVisitCount.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmBusinessCardVisitCountBiz.updateCrmBusinessCardVisitCount(crmBusinessCardVisitCount);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmBusinessCardVisitCount(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmBusinessCardVisitCountBiz.delCrmBusinessCardVisitCount(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmBusinessCardVisitCount(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmBusinessCardVisitCountBiz.getCrmBusinessCardVisitCount(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmBusinessCardVisitCountBiz.queryByPage(paramsMap);
    }
 }
