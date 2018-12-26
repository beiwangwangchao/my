package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmAddressBiz;
import com.jingcheng.marketing.business.model.CrmAddress;
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
@RequestMapping("/crmAddress")
public class CrmAddressController extends BaseController {
@Autowired
CrmAddressBiz crmAddressBiz;

    /***
     * @function1
     * 新增记录
     * @param crmAddress
     */
    @RequestMapping("/add")
    public MsgDto addCrmAddress(@RequestBody CrmAddress crmAddress) {
        return crmAddressBiz.addCrmAddress(crmAddress);
    }

    /****
     * @function2
     * 更新记录
     * @param crmAddress
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmAddress(@RequestBody CrmAddress crmAddress) {
        if (null == crmAddress.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmAddressBiz.updateCrmAddress(crmAddress);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmAddress(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmAddressBiz.delCrmAddress(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmAddress(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmAddressBiz.getCrmAddress(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmAddressBiz.queryByPage(paramsMap);
    }
 }
