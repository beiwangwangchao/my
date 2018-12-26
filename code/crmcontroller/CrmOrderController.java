package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmOrderBiz;
import com.jingcheng.marketing.business.model.CrmOrder;
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
@RequestMapping("/crmOrder")
public class CrmOrderController extends BaseController {
@Autowired
CrmOrderBiz crmOrderBiz;

    /***
     * @function1
     * 新增记录
     * @param crmOrder
     */
    @RequestMapping("/add")
    public MsgDto addCrmOrder(@RequestBody CrmOrder crmOrder) {
        return crmOrderBiz.addCrmOrder(crmOrder);
    }

    /****
     * @function2
     * 更新记录
     * @param crmOrder
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmOrder(@RequestBody CrmOrder crmOrder) {
        if (null == crmOrder.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmOrderBiz.updateCrmOrder(crmOrder);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmOrder(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmOrderBiz.delCrmOrder(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmOrder(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmOrderBiz.getCrmOrder(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmOrderBiz.queryByPage(paramsMap);
    }
 }
