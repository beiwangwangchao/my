package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmContactBiz;
import com.jingcheng.marketing.business.model.CrmContact;
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
@RequestMapping("/crmContact")
public class CrmContactController extends BaseController {
@Autowired
CrmContactBiz crmContactBiz;

    /***
     * @function1
     * 新增记录
     * @param crmContact
     */
    @RequestMapping("/add")
    public MsgDto addCrmContact(@RequestBody CrmContact crmContact) {
        return crmContactBiz.addCrmContact(crmContact);
    }

    /****
     * @function2
     * 更新记录
     * @param crmContact
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmContact(@RequestBody CrmContact crmContact) {
        if (null == crmContact.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmContactBiz.updateCrmContact(crmContact);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmContact(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmContactBiz.delCrmContact(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmContact(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmContactBiz.getCrmContact(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmContactBiz.queryByPage(paramsMap);
    }
 }
