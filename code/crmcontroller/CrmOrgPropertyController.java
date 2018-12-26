package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmOrgPropertyBiz;
import com.jingcheng.marketing.business.model.CrmOrgProperty;
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
@RequestMapping("/crmOrgProperty")
public class CrmOrgPropertyController extends BaseController {
@Autowired
CrmOrgPropertyBiz crmOrgPropertyBiz;

    /***
     * @function1
     * 新增记录
     * @param crmOrgProperty
     */
    @RequestMapping("/add")
    public MsgDto addCrmOrgProperty(@RequestBody CrmOrgProperty crmOrgProperty) {
        return crmOrgPropertyBiz.addCrmOrgProperty(crmOrgProperty);
    }

    /****
     * @function2
     * 更新记录
     * @param crmOrgProperty
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmOrgProperty(@RequestBody CrmOrgProperty crmOrgProperty) {
        if (null == crmOrgProperty.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmOrgPropertyBiz.updateCrmOrgProperty(crmOrgProperty);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmOrgProperty(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmOrgPropertyBiz.delCrmOrgProperty(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmOrgProperty(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmOrgPropertyBiz.getCrmOrgProperty(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmOrgPropertyBiz.queryByPage(paramsMap);
    }
 }
