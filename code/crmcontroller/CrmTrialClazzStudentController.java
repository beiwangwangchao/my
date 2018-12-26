package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmTrialClazzStudentBiz;
import com.jingcheng.marketing.business.model.CrmTrialClazzStudent;
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
@RequestMapping("/crmTrialClazzStudent")
public class CrmTrialClazzStudentController extends BaseController {
@Autowired
CrmTrialClazzStudentBiz crmTrialClazzStudentBiz;

    /***
     * @function1
     * 新增记录
     * @param crmTrialClazzStudent
     */
    @RequestMapping("/add")
    public MsgDto addCrmTrialClazzStudent(@RequestBody CrmTrialClazzStudent crmTrialClazzStudent) {
        return crmTrialClazzStudentBiz.addCrmTrialClazzStudent(crmTrialClazzStudent);
    }

    /****
     * @function2
     * 更新记录
     * @param crmTrialClazzStudent
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmTrialClazzStudent(@RequestBody CrmTrialClazzStudent crmTrialClazzStudent) {
        if (null == crmTrialClazzStudent.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmTrialClazzStudentBiz.updateCrmTrialClazzStudent(crmTrialClazzStudent);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmTrialClazzStudent(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmTrialClazzStudentBiz.delCrmTrialClazzStudent(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmTrialClazzStudent(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmTrialClazzStudentBiz.getCrmTrialClazzStudent(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmTrialClazzStudentBiz.queryByPage(paramsMap);
    }
 }
