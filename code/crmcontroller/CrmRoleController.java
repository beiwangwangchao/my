package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmRoleBiz;
import com.jingcheng.marketing.business.model.CrmRole;
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
@RequestMapping("/crmRole")
public class CrmRoleController extends BaseController {
@Autowired
CrmRoleBiz crmRoleBiz;

    /***
     * @function1
     * 新增记录
     * @param crmRole
     */
    @RequestMapping("/add")
    public MsgDto addCrmRole(@RequestBody CrmRole crmRole) {
        return crmRoleBiz.addCrmRole(crmRole);
    }

    /****
     * @function2
     * 更新记录
     * @param crmRole
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmRole(@RequestBody CrmRole crmRole) {
        if (null == crmRole.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmRoleBiz.updateCrmRole(crmRole);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmRole(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmRoleBiz.delCrmRole(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmRole(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmRoleBiz.getCrmRole(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmRoleBiz.queryByPage(paramsMap);
    }
 }
