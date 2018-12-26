package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmUserOrganizationBiz;
import com.jingcheng.marketing.business.model.CrmUserOrganization;
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
@RequestMapping("/crmUserOrganization")
public class CrmUserOrganizationController extends BaseController {
@Autowired
CrmUserOrganizationBiz crmUserOrganizationBiz;

    /***
     * @function1
     * 新增记录
     * @param crmUserOrganization
     */
    @RequestMapping("/add")
    public MsgDto addCrmUserOrganization(@RequestBody CrmUserOrganization crmUserOrganization) {
        return crmUserOrganizationBiz.addCrmUserOrganization(crmUserOrganization);
    }

    /****
     * @function2
     * 更新记录
     * @param crmUserOrganization
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmUserOrganization(@RequestBody CrmUserOrganization crmUserOrganization) {
        if (null == crmUserOrganization.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmUserOrganizationBiz.updateCrmUserOrganization(crmUserOrganization);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmUserOrganization(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmUserOrganizationBiz.delCrmUserOrganization(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmUserOrganization(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmUserOrganizationBiz.getCrmUserOrganization(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmUserOrganizationBiz.queryByPage(paramsMap);
    }
 }
