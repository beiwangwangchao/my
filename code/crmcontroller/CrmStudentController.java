package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmStudentBiz;
import com.jingcheng.marketing.business.model.CrmStudent;
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
@RequestMapping("/crmStudent")
public class CrmStudentController extends BaseController {
@Autowired
CrmStudentBiz crmStudentBiz;

    /***
     * @function1
     * 新增记录
     * @param crmStudent
     */
    @RequestMapping("/add")
    public MsgDto addCrmStudent(@RequestBody CrmStudent crmStudent) {
        return crmStudentBiz.addCrmStudent(crmStudent);
    }

    /****
     * @function2
     * 更新记录
     * @param crmStudent
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmStudent(@RequestBody CrmStudent crmStudent) {
        if (null == crmStudent.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmStudentBiz.updateCrmStudent(crmStudent);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmStudent(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmStudentBiz.delCrmStudent(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmStudent(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmStudentBiz.getCrmStudent(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmStudentBiz.queryByPage(paramsMap);
    }
 }
