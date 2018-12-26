package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmClazzScheduleStudentBiz;
import com.jingcheng.marketing.business.model.CrmClazzScheduleStudent;
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
@RequestMapping("/crmClazzScheduleStudent")
public class CrmClazzScheduleStudentController extends BaseController {
@Autowired
CrmClazzScheduleStudentBiz crmClazzScheduleStudentBiz;

    /***
     * @function1
     * 新增记录
     * @param crmClazzScheduleStudent
     */
    @RequestMapping("/add")
    public MsgDto addCrmClazzScheduleStudent(@RequestBody CrmClazzScheduleStudent crmClazzScheduleStudent) {
        return crmClazzScheduleStudentBiz.addCrmClazzScheduleStudent(crmClazzScheduleStudent);
    }

    /****
     * @function2
     * 更新记录
     * @param crmClazzScheduleStudent
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmClazzScheduleStudent(@RequestBody CrmClazzScheduleStudent crmClazzScheduleStudent) {
        if (null == crmClazzScheduleStudent.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmClazzScheduleStudentBiz.updateCrmClazzScheduleStudent(crmClazzScheduleStudent);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmClazzScheduleStudent(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmClazzScheduleStudentBiz.delCrmClazzScheduleStudent(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmClazzScheduleStudent(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmClazzScheduleStudentBiz.getCrmClazzScheduleStudent(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmClazzScheduleStudentBiz.queryByPage(paramsMap);
    }
 }
