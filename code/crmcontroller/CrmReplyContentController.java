package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmReplyContentBiz;
import com.jingcheng.marketing.business.model.CrmReplyContent;
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
@RequestMapping("/crmReplyContent")
public class CrmReplyContentController extends BaseController {
@Autowired
CrmReplyContentBiz crmReplyContentBiz;

    /***
     * @function1
     * 新增记录
     * @param crmReplyContent
     */
    @RequestMapping("/add")
    public MsgDto addCrmReplyContent(@RequestBody CrmReplyContent crmReplyContent) {
        return crmReplyContentBiz.addCrmReplyContent(crmReplyContent);
    }

    /****
     * @function2
     * 更新记录
     * @param crmReplyContent
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmReplyContent(@RequestBody CrmReplyContent crmReplyContent) {
        if (null == crmReplyContent.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmReplyContentBiz.updateCrmReplyContent(crmReplyContent);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmReplyContent(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmReplyContentBiz.delCrmReplyContent(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmReplyContent(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmReplyContentBiz.getCrmReplyContent(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmReplyContentBiz.queryByPage(paramsMap);
    }
 }
