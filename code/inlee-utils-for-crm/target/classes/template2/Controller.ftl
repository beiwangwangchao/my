package com.crm.console.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.crm.console.api.${entity_name}Api;
import com.crm.console.model.${entity_name};
import com.util.base.BaseController;
import com.util.comm.Cons;
import com.util.comm.Page;
import com.util.comm.ParamsMap;
import com.util.dto.MsgDto;
import com.util.exception.ParamsException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/${entity_name_low}")
public class ${entity_name}Controller extends BaseController {

    @Reference
    private ${entity_name}Api ${entity_name_low}Api;

    /***
     * @function1
     * 新增记录
     * @param ${entity_name_low}
     */
    @RequestMapping("/add")
    public MsgDto add${entity_name}(@RequestBody ${entity_name} ${entity_name_low}) {
        return ${entity_name_low}Api.add${entity_name}(${entity_name_low});
    }

    /****
     * @function2
     * 更新记录
     * @param ${entity_name_low}
     * @return
     */
    @RequestMapping("/update")
    public MsgDto update${entity_name}(@RequestBody ${entity_name} ${entity_name_low}) {
        if (null == ${entity_name_low}.getId()) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return ${entity_name_low}Api.update${entity_name}(${entity_name_low});
    }

    /****
     * @function3
     * 删除单条记录
     * @param id
     */
    @RequestMapping("/delete")
    public MsgDto delete${entity_name}(@RequestParam("id") String id) {
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return ${entity_name_low}Api.del${entity_name}(id);
    }

    /*******
     * @function4
     * 查询单条记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/getDetail")
    public MsgDto getDetail${entity_name}(@RequestBody ParamsMap paramsMap) {
        Object id = paramsMap.get("id");
        if (null == id) throw new ParamsException(Cons.SysCode.ISNULL, "id为空");
        return ${entity_name_low}Api.get${entity_name}(id.toString());

    }

    /*****
     * @function5
     * 分页查询记录
     * @param paramsMap
     * @return
     */
    @RequestMapping("/query")
    public Page<Object> query(@RequestBody ParamsMap paramsMap) {
    return ${entity_name_low}Api.queryByPage(paramsMap);
    }
 }
