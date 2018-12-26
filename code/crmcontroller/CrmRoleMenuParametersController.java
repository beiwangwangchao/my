package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmRoleMenuParametersBiz;
import com.jingcheng.marketing.business.model.CrmRoleMenuParameters;
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
@RequestMapping("/crmRoleMenuParameters")
public class CrmRoleMenuParametersController extends BaseController {
@Autowired
CrmRoleMenuParametersBiz crmRoleMenuParametersBiz;

    /***
     * @function1
     * 新增记录
     * @param crmRoleMenuParameters
     */
    @RequestMapping("/add")
    public MsgDto addCrmRoleMenuParameters(@RequestBody CrmRoleMenuParameters crmRoleMenuParameters) {
        return crmRoleMenuParametersBiz.addCrmRoleMenuParameters(crmRoleMenuParameters);
    }

    /****
     * @function2
     * 更新记录
     * @param crmRoleMenuParameters
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmRoleMenuParameters(@RequestBody CrmRoleMenuParameters crmRoleMenuParameters) {
        if (null == crmRoleMenuParameters.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmRoleMenuParametersBiz.updateCrmRoleMenuParameters(crmRoleMenuParameters);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmRoleMenuParameters(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmRoleMenuParametersBiz.delCrmRoleMenuParameters(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmRoleMenuParameters(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmRoleMenuParametersBiz.getCrmRoleMenuParameters(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmRoleMenuParametersBiz.queryByPage(paramsMap);
    }
 }
