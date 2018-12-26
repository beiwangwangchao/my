package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmMenuParametersValueBiz;
import com.jingcheng.marketing.business.model.CrmMenuParametersValue;
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
@RequestMapping("/crmMenuParametersValue")
public class CrmMenuParametersValueController extends BaseController {
@Autowired
CrmMenuParametersValueBiz crmMenuParametersValueBiz;

    /***
     * @function1
     * 新增记录
     * @param crmMenuParametersValue
     */
    @RequestMapping("/add")
    public MsgDto addCrmMenuParametersValue(@RequestBody CrmMenuParametersValue crmMenuParametersValue) {
        return crmMenuParametersValueBiz.addCrmMenuParametersValue(crmMenuParametersValue);
    }

    /****
     * @function2
     * 更新记录
     * @param crmMenuParametersValue
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmMenuParametersValue(@RequestBody CrmMenuParametersValue crmMenuParametersValue) {
        if (null == crmMenuParametersValue.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmMenuParametersValueBiz.updateCrmMenuParametersValue(crmMenuParametersValue);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmMenuParametersValue(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmMenuParametersValueBiz.delCrmMenuParametersValue(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmMenuParametersValue(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmMenuParametersValueBiz.getCrmMenuParametersValue(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmMenuParametersValueBiz.queryByPage(paramsMap);
    }
 }
