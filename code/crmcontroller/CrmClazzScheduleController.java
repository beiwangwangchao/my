package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmClazzScheduleBiz;
import com.jingcheng.marketing.business.model.CrmClazzSchedule;
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
@RequestMapping("/crmClazzSchedule")
public class CrmClazzScheduleController extends BaseController {
@Autowired
CrmClazzScheduleBiz crmClazzScheduleBiz;

    /***
     * @function1
     * 新增记录
     * @param crmClazzSchedule
     */
    @RequestMapping("/add")
    public MsgDto addCrmClazzSchedule(@RequestBody CrmClazzSchedule crmClazzSchedule) {
        return crmClazzScheduleBiz.addCrmClazzSchedule(crmClazzSchedule);
    }

    /****
     * @function2
     * 更新记录
     * @param crmClazzSchedule
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmClazzSchedule(@RequestBody CrmClazzSchedule crmClazzSchedule) {
        if (null == crmClazzSchedule.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmClazzScheduleBiz.updateCrmClazzSchedule(crmClazzSchedule);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmClazzSchedule(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmClazzScheduleBiz.delCrmClazzSchedule(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmClazzSchedule(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmClazzScheduleBiz.getCrmClazzSchedule(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmClazzScheduleBiz.queryByPage(paramsMap);
    }
 }
