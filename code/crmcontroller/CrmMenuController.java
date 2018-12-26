package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmMenuBiz;
import com.jingcheng.marketing.business.model.CrmMenu;
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
@RequestMapping("/crmMenu")
public class CrmMenuController extends BaseController {
@Autowired
CrmMenuBiz crmMenuBiz;

    /***
     * @function1
     * 新增记录
     * @param crmMenu
     */
    @RequestMapping("/add")
    public MsgDto addCrmMenu(@RequestBody CrmMenu crmMenu) {
        return crmMenuBiz.addCrmMenu(crmMenu);
    }

    /****
     * @function2
     * 更新记录
     * @param crmMenu
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmMenu(@RequestBody CrmMenu crmMenu) {
        if (null == crmMenu.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmMenuBiz.updateCrmMenu(crmMenu);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmMenu(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmMenuBiz.delCrmMenu(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmMenu(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmMenuBiz.getCrmMenu(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmMenuBiz.queryByPage(paramsMap);
    }
 }
