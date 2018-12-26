package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmMessageBiz;
import com.jingcheng.marketing.business.model.CrmMessage;
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
@RequestMapping("/crmMessage")
public class CrmMessageController extends BaseController {
@Autowired
CrmMessageBiz crmMessageBiz;

    /***
     * @function1
     * 新增记录
     * @param crmMessage
     */
    @RequestMapping("/add")
    public MsgDto addCrmMessage(@RequestBody CrmMessage crmMessage) {
        return crmMessageBiz.addCrmMessage(crmMessage);
    }

    /****
     * @function2
     * 更新记录
     * @param crmMessage
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmMessage(@RequestBody CrmMessage crmMessage) {
        if (null == crmMessage.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmMessageBiz.updateCrmMessage(crmMessage);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmMessage(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmMessageBiz.delCrmMessage(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmMessage(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmMessageBiz.getCrmMessage(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmMessageBiz.queryByPage(paramsMap);
    }
 }
