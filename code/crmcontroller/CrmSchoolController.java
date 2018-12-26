package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmSchoolBiz;
import com.jingcheng.marketing.business.model.CrmSchool;
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
@RequestMapping("/crmSchool")
public class CrmSchoolController extends BaseController {
@Autowired
CrmSchoolBiz crmSchoolBiz;

    /***
     * @function1
     * 新增记录
     * @param crmSchool
     */
    @RequestMapping("/add")
    public MsgDto addCrmSchool(@RequestBody CrmSchool crmSchool) {
        return crmSchoolBiz.addCrmSchool(crmSchool);
    }

    /****
     * @function2
     * 更新记录
     * @param crmSchool
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmSchool(@RequestBody CrmSchool crmSchool) {
        if (null == crmSchool.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmSchoolBiz.updateCrmSchool(crmSchool);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmSchool(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmSchoolBiz.delCrmSchool(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmSchool(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmSchoolBiz.getCrmSchool(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmSchoolBiz.queryByPage(paramsMap);
    }
 }
