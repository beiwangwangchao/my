package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmDataDictionaryBiz;
import com.jingcheng.marketing.business.model.CrmDataDictionary;
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
@RequestMapping("/crmDataDictionary")
public class CrmDataDictionaryController extends BaseController {
@Autowired
CrmDataDictionaryBiz crmDataDictionaryBiz;

    /***
     * @function1
     * 新增记录
     * @param crmDataDictionary
     */
    @RequestMapping("/add")
    public MsgDto addCrmDataDictionary(@RequestBody CrmDataDictionary crmDataDictionary) {
        return crmDataDictionaryBiz.addCrmDataDictionary(crmDataDictionary);
    }

    /****
     * @function2
     * 更新记录
     * @param crmDataDictionary
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmDataDictionary(@RequestBody CrmDataDictionary crmDataDictionary) {
        if (null == crmDataDictionary.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmDataDictionaryBiz.updateCrmDataDictionary(crmDataDictionary);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmDataDictionary(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmDataDictionaryBiz.delCrmDataDictionary(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmDataDictionary(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmDataDictionaryBiz.getCrmDataDictionary(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmDataDictionaryBiz.queryByPage(paramsMap);
    }
 }
