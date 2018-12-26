package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmUserRoleBiz;
import com.jingcheng.marketing.business.model.CrmUserRole;
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
@RequestMapping("/crmUserRole")
public class CrmUserRoleController extends BaseController {
@Autowired
CrmUserRoleBiz crmUserRoleBiz;

    /***
     * @function1
     * 新增记录
     * @param crmUserRole
     */
    @RequestMapping("/add")
    public MsgDto addCrmUserRole(@RequestBody CrmUserRole crmUserRole) {
        return crmUserRoleBiz.addCrmUserRole(crmUserRole);
    }

    /****
     * @function2
     * 更新记录
     * @param crmUserRole
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmUserRole(@RequestBody CrmUserRole crmUserRole) {
        if (null == crmUserRole.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmUserRoleBiz.updateCrmUserRole(crmUserRole);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmUserRole(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmUserRoleBiz.delCrmUserRole(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmUserRole(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmUserRoleBiz.getCrmUserRole(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmUserRoleBiz.queryByPage(paramsMap);
    }
 }
