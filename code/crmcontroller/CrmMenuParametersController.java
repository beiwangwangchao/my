package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmMenuParametersBiz;
import com.jingcheng.marketing.business.model.CrmMenuParameters;
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
@RequestMapping("/crmMenuParameters")
public class CrmMenuParametersController extends BaseController {
@Autowired
CrmMenuParametersBiz crmMenuParametersBiz;

    /***
     * @function1
     * 新增记录
     * @param crmMenuParameters
     */
    @RequestMapping("/add")
    public MsgDto addCrmMenuParameters(@RequestBody CrmMenuParameters crmMenuParameters) {
        return crmMenuParametersBiz.addCrmMenuParameters(crmMenuParameters);
    }

    /****
     * @function2
     * 更新记录
     * @param crmMenuParameters
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmMenuParameters(@RequestBody CrmMenuParameters crmMenuParameters) {
        if (null == crmMenuParameters.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmMenuParametersBiz.updateCrmMenuParameters(crmMenuParameters);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmMenuParameters(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmMenuParametersBiz.delCrmMenuParameters(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmMenuParameters(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmMenuParametersBiz.getCrmMenuParameters(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmMenuParametersBiz.queryByPage(paramsMap);
    }
 }
