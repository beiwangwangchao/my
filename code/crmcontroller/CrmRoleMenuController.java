package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmRoleMenuBiz;
import com.jingcheng.marketing.business.model.CrmRoleMenu;
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
@RequestMapping("/crmRoleMenu")
public class CrmRoleMenuController extends BaseController {
@Autowired
CrmRoleMenuBiz crmRoleMenuBiz;

    /***
     * @function1
     * 新增记录
     * @param crmRoleMenu
     */
    @RequestMapping("/add")
    public MsgDto addCrmRoleMenu(@RequestBody CrmRoleMenu crmRoleMenu) {
        return crmRoleMenuBiz.addCrmRoleMenu(crmRoleMenu);
    }

    /****
     * @function2
     * 更新记录
     * @param crmRoleMenu
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmRoleMenu(@RequestBody CrmRoleMenu crmRoleMenu) {
        if (null == crmRoleMenu.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmRoleMenuBiz.updateCrmRoleMenu(crmRoleMenu);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmRoleMenu(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmRoleMenuBiz.delCrmRoleMenu(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmRoleMenu(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmRoleMenuBiz.getCrmRoleMenu(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmRoleMenuBiz.queryByPage(paramsMap);
    }
 }
