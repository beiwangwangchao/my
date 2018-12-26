package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmRelationshipBiz;
import com.jingcheng.marketing.business.model.CrmRelationship;
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
@RequestMapping("/crmRelationship")
public class CrmRelationshipController extends BaseController {
@Autowired
CrmRelationshipBiz crmRelationshipBiz;

    /***
     * @function1
     * 新增记录
     * @param crmRelationship
     */
    @RequestMapping("/add")
    public MsgDto addCrmRelationship(@RequestBody CrmRelationship crmRelationship) {
        return crmRelationshipBiz.addCrmRelationship(crmRelationship);
    }

    /****
     * @function2
     * 更新记录
     * @param crmRelationship
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmRelationship(@RequestBody CrmRelationship crmRelationship) {
        if (null == crmRelationship.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmRelationshipBiz.updateCrmRelationship(crmRelationship);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmRelationship(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmRelationshipBiz.delCrmRelationship(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmRelationship(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmRelationshipBiz.getCrmRelationship(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmRelationshipBiz.queryByPage(paramsMap);
    }
 }
