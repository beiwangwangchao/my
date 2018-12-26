package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmUserBiz;
import com.jingcheng.marketing.business.model.CrmUser;
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
@RequestMapping("/crmUser")
public class CrmUserController extends BaseController {
@Autowired
CrmUserBiz crmUserBiz;

    /***
     * @function1
     * 新增记录
     * @param crmUser
     */
    @RequestMapping("/add")
    public MsgDto addCrmUser(@RequestBody CrmUser crmUser) {
        return crmUserBiz.addCrmUser(crmUser);
    }

    /****
     * @function2
     * 更新记录
     * @param crmUser
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmUser(@RequestBody CrmUser crmUser) {
        if (null == crmUser.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmUserBiz.updateCrmUser(crmUser);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmUser(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmUserBiz.delCrmUser(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmUser(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmUserBiz.getCrmUser(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmUserBiz.queryByPage(paramsMap);
    }
 }
