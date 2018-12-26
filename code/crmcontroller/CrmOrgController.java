package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmOrgBiz;
import com.jingcheng.marketing.business.model.CrmOrg;
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
@RequestMapping("/crmOrg")
public class CrmOrgController extends BaseController {
@Autowired
CrmOrgBiz crmOrgBiz;

    /***
     * @function1
     * 新增记录
     * @param crmOrg
     */
    @RequestMapping("/add")
    public MsgDto addCrmOrg(@RequestBody CrmOrg crmOrg) {
        return crmOrgBiz.addCrmOrg(crmOrg);
    }

    /****
     * @function2
     * 更新记录
     * @param crmOrg
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmOrg(@RequestBody CrmOrg crmOrg) {
        if (null == crmOrg.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmOrgBiz.updateCrmOrg(crmOrg);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmOrg(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmOrgBiz.delCrmOrg(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmOrg(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmOrgBiz.getCrmOrg(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmOrgBiz.queryByPage(paramsMap);
    }
 }
