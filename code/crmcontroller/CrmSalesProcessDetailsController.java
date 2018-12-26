package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmSalesProcessDetailsBiz;
import com.jingcheng.marketing.business.model.CrmSalesProcessDetails;
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
@RequestMapping("/crmSalesProcessDetails")
public class CrmSalesProcessDetailsController extends BaseController {
@Autowired
CrmSalesProcessDetailsBiz crmSalesProcessDetailsBiz;

    /***
     * @function1
     * 新增记录
     * @param crmSalesProcessDetails
     */
    @RequestMapping("/add")
    public MsgDto addCrmSalesProcessDetails(@RequestBody CrmSalesProcessDetails crmSalesProcessDetails) {
        return crmSalesProcessDetailsBiz.addCrmSalesProcessDetails(crmSalesProcessDetails);
    }

    /****
     * @function2
     * 更新记录
     * @param crmSalesProcessDetails
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmSalesProcessDetails(@RequestBody CrmSalesProcessDetails crmSalesProcessDetails) {
        if (null == crmSalesProcessDetails.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmSalesProcessDetailsBiz.updateCrmSalesProcessDetails(crmSalesProcessDetails);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmSalesProcessDetails(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmSalesProcessDetailsBiz.delCrmSalesProcessDetails(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmSalesProcessDetails(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmSalesProcessDetailsBiz.getCrmSalesProcessDetails(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmSalesProcessDetailsBiz.queryByPage(paramsMap);
    }
 }
