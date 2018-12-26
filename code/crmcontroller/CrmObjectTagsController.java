package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmObjectTagsBiz;
import com.jingcheng.marketing.business.model.CrmObjectTags;
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
@RequestMapping("/crmObjectTags")
public class CrmObjectTagsController extends BaseController {
@Autowired
CrmObjectTagsBiz crmObjectTagsBiz;

    /***
     * @function1
     * 新增记录
     * @param crmObjectTags
     */
    @RequestMapping("/add")
    public MsgDto addCrmObjectTags(@RequestBody CrmObjectTags crmObjectTags) {
        return crmObjectTagsBiz.addCrmObjectTags(crmObjectTags);
    }

    /****
     * @function2
     * 更新记录
     * @param crmObjectTags
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmObjectTags(@RequestBody CrmObjectTags crmObjectTags) {
        if (null == crmObjectTags.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmObjectTagsBiz.updateCrmObjectTags(crmObjectTags);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmObjectTags(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmObjectTagsBiz.delCrmObjectTags(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmObjectTags(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmObjectTagsBiz.getCrmObjectTags(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmObjectTagsBiz.queryByPage(paramsMap);
    }
 }
