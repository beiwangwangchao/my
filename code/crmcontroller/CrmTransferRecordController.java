package com.jingcheng.marketing.business.controller;

import com.jingcheng.marketing.business.biz.CrmTransferRecordBiz;
import com.jingcheng.marketing.business.model.CrmTransferRecord;
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
@RequestMapping("/crmTransferRecord")
public class CrmTransferRecordController extends BaseController {
@Autowired
CrmTransferRecordBiz crmTransferRecordBiz;

    /***
     * @function1
     * 新增记录
     * @param crmTransferRecord
     */
    @RequestMapping("/add")
    public MsgDto addCrmTransferRecord(@RequestBody CrmTransferRecord crmTransferRecord) {
        return crmTransferRecordBiz.addCrmTransferRecord(crmTransferRecord);
    }

    /****
     * @function2
     * 更新记录
     * @param crmTransferRecord
     * @return
     */
    @RequestMapping("/update")
    public MsgDto updateCrmTransferRecord(@RequestBody CrmTransferRecord crmTransferRecord) {
        if (null == crmTransferRecord.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmTransferRecordBiz.updateCrmTransferRecord(crmTransferRecord);
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto deleteCrmTransferRecord(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmTransferRecordBiz.delCrmTransferRecord(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetailCrmTransferRecord(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return crmTransferRecordBiz.getCrmTransferRecord(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return crmTransferRecordBiz.queryByPage(paramsMap);
    }
 }
