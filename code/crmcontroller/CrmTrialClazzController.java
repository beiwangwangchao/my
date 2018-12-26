package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmTrialClazzBiz;
import com.jingcheng.marketing.business.model.CrmTrialClazz;
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
@RequestMapping("/crmTrialClazz")
public class CrmTrialClazzController extends BaseController {
@Autowired
CrmTrialClazzBiz crmTrialClazzBiz;

    /***
     * @function1
     * 新增记录
     * @param crmTrialClazz
     */
    @RequestMapping("/add")
    public MsgDto addCrmTrialClazz(@RequestBody CrmTrialClazz crmTrialClazz) {
        return crmTrialClazzBiz.addCrmTrialClazz(crmTrialClazz);
    }

    /****
     * @function2
     * 更新记录
     * @param crmTrialClazz
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmTrialClazz(@RequestBody CrmTrialClazz crmTrialClazz) {
        if (null == crmTrialClazz.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmTrialClazzBiz.updateCrmTrialClazz(crmTrialClazz);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmTrialClazz(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmTrialClazzBiz.delCrmTrialClazz(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmTrialClazz(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmTrialClazzBiz.getCrmTrialClazz(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmTrialClazzBiz.queryByPage(paramsMap);
    }
 }
