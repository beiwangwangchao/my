package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmSysParametersBiz;
import com.jingcheng.marketing.business.model.CrmSysParameters;
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
@RequestMapping("/crmSysParameters")
public class CrmSysParametersController extends BaseController {
@Autowired
CrmSysParametersBiz crmSysParametersBiz;

    /***
     * @function1
     * 新增记录
     * @param crmSysParameters
     */
    @RequestMapping("/add")
    public MsgDto addCrmSysParameters(@RequestBody CrmSysParameters crmSysParameters) {
        return crmSysParametersBiz.addCrmSysParameters(crmSysParameters);
    }

    /****
     * @function2
     * 更新记录
     * @param crmSysParameters
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmSysParameters(@RequestBody CrmSysParameters crmSysParameters) {
        if (null == crmSysParameters.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmSysParametersBiz.updateCrmSysParameters(crmSysParameters);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmSysParameters(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmSysParametersBiz.delCrmSysParameters(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmSysParameters(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmSysParametersBiz.getCrmSysParameters(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmSysParametersBiz.queryByPage(paramsMap);
    }
 }
