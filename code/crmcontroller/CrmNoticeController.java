package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmNoticeBiz;
import com.jingcheng.marketing.business.model.CrmNotice;
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
@RequestMapping("/crmNotice")
public class CrmNoticeController extends BaseController {
@Autowired
CrmNoticeBiz crmNoticeBiz;

    /***
     * @function1
     * 新增记录
     * @param crmNotice
     */
    @RequestMapping("/add")
    public MsgDto addCrmNotice(@RequestBody CrmNotice crmNotice) {
        return crmNoticeBiz.addCrmNotice(crmNotice);
    }

    /****
     * @function2
     * 更新记录
     * @param crmNotice
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmNotice(@RequestBody CrmNotice crmNotice) {
        if (null == crmNotice.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmNoticeBiz.updateCrmNotice(crmNotice);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmNotice(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmNoticeBiz.delCrmNotice(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmNotice(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmNoticeBiz.getCrmNotice(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmNoticeBiz.queryByPage(paramsMap);
    }
 }
