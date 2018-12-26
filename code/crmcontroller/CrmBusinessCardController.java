package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmBusinessCardBiz;
import com.jingcheng.marketing.business.model.CrmBusinessCard;
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
@RequestMapping("/crmBusinessCard")
public class CrmBusinessCardController extends BaseController {
@Autowired
CrmBusinessCardBiz crmBusinessCardBiz;

    /***
     * @function1
     * 新增记录
     * @param crmBusinessCard
     */
    @RequestMapping("/add")
    public MsgDto addCrmBusinessCard(@RequestBody CrmBusinessCard crmBusinessCard) {
        return crmBusinessCardBiz.addCrmBusinessCard(crmBusinessCard);
    }

    /****
     * @function2
     * 更新记录
     * @param crmBusinessCard
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmBusinessCard(@RequestBody CrmBusinessCard crmBusinessCard) {
        if (null == crmBusinessCard.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmBusinessCardBiz.updateCrmBusinessCard(crmBusinessCard);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmBusinessCard(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmBusinessCardBiz.delCrmBusinessCard(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmBusinessCard(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmBusinessCardBiz.getCrmBusinessCard(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmBusinessCardBiz.queryByPage(paramsMap);
    }
 }
