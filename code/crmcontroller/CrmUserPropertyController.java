package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmUserPropertyBiz;
import com.jingcheng.marketing.business.model.CrmUserProperty;
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
@RequestMapping("/crmUserProperty")
public class CrmUserPropertyController extends BaseController {
@Autowired
CrmUserPropertyBiz crmUserPropertyBiz;

    /***
     * @function1
     * 新增记录
     * @param crmUserProperty
     */
    @RequestMapping("/add")
    public MsgDto addCrmUserProperty(@RequestBody CrmUserProperty crmUserProperty) {
        return crmUserPropertyBiz.addCrmUserProperty(crmUserProperty);
    }

    /****
     * @function2
     * 更新记录
     * @param crmUserProperty
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmUserProperty(@RequestBody CrmUserProperty crmUserProperty) {
        if (null == crmUserProperty.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmUserPropertyBiz.updateCrmUserProperty(crmUserProperty);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmUserProperty(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmUserPropertyBiz.delCrmUserProperty(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmUserProperty(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmUserPropertyBiz.getCrmUserProperty(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmUserPropertyBiz.queryByPage(paramsMap);
    }
 }
