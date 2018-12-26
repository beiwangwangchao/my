package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmContactOrganizationBiz;
import com.jingcheng.marketing.business.model.CrmContactOrganization;
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
@RequestMapping("/crmContactOrganization")
public class CrmContactOrganizationController extends BaseController {
@Autowired
CrmContactOrganizationBiz crmContactOrganizationBiz;

    /***
     * @function1
     * 新增记录
     * @param crmContactOrganization
     */
    @RequestMapping("/add")
    public MsgDto addCrmContactOrganization(@RequestBody CrmContactOrganization crmContactOrganization) {
        return crmContactOrganizationBiz.addCrmContactOrganization(crmContactOrganization);
    }

    /****
     * @function2
     * 更新记录
     * @param crmContactOrganization
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmContactOrganization(@RequestBody CrmContactOrganization crmContactOrganization) {
        if (null == crmContactOrganization.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmContactOrganizationBiz.updateCrmContactOrganization(crmContactOrganization);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmContactOrganization(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmContactOrganizationBiz.delCrmContactOrganization(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmContactOrganization(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmContactOrganizationBiz.getCrmContactOrganization(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmContactOrganizationBiz.queryByPage(paramsMap);
    }
 }
