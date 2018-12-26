package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmOrganizationBiz;
import com.jingcheng.marketing.business.model.CrmOrganization;
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
@RequestMapping("/crmOrganization")
public class CrmOrganizationController extends BaseController {
@Autowired
CrmOrganizationBiz crmOrganizationBiz;

    /***
     * @function1
     * 新增记录
     * @param crmOrganization
     */
    @RequestMapping("/add")
    public MsgDto addCrmOrganization(@RequestBody CrmOrganization crmOrganization) {
        return crmOrganizationBiz.addCrmOrganization(crmOrganization);
    }

    /****
     * @function2
     * 更新记录
     * @param crmOrganization
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmOrganization(@RequestBody CrmOrganization crmOrganization) {
        if (null == crmOrganization.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmOrganizationBiz.updateCrmOrganization(crmOrganization);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmOrganization(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmOrganizationBiz.delCrmOrganization(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmOrganization(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmOrganizationBiz.getCrmOrganization(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmOrganizationBiz.queryByPage(paramsMap);
    }
 }
