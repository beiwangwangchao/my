package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmBusinessCardInformationBiz;
import com.jingcheng.marketing.business.model.CrmBusinessCardInformation;
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
@RequestMapping("/crmBusinessCardInformation")
public class CrmBusinessCardInformationController extends BaseController {
@Autowired
CrmBusinessCardInformationBiz crmBusinessCardInformationBiz;

    /***
     * @function1
     * 新增记录
     * @param crmBusinessCardInformation
     */
    @RequestMapping("/add")
    public MsgDto addCrmBusinessCardInformation(@RequestBody CrmBusinessCardInformation crmBusinessCardInformation) {
        return crmBusinessCardInformationBiz.addCrmBusinessCardInformation(crmBusinessCardInformation);
    }

    /****
     * @function2
     * 更新记录
     * @param crmBusinessCardInformation
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmBusinessCardInformation(@RequestBody CrmBusinessCardInformation crmBusinessCardInformation) {
        if (null == crmBusinessCardInformation.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmBusinessCardInformationBiz.updateCrmBusinessCardInformation(crmBusinessCardInformation);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmBusinessCardInformation(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmBusinessCardInformationBiz.delCrmBusinessCardInformation(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmBusinessCardInformation(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmBusinessCardInformationBiz.getCrmBusinessCardInformation(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmBusinessCardInformationBiz.queryByPage(paramsMap);
    }
 }
