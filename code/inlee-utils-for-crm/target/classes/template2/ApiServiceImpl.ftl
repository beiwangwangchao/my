package com.crm.console.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.crm.console.biz.${entity_name}Biz;
import com.crm.console.model.${entity_name};
import com.util.comm.Page;
import com.util.comm.ParamsMap;
import com.util.dto.MsgDto;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class ${entity_name}ImplApi implements ${entity_name}Api {

    @Autowired
    private ${entity_name}Biz ${entity_name_low}Biz;

    @Override
    public MsgDto add${entity_name}(${entity_name} ${entity_name_low}) {
        return ${entity_name_low}Biz.add${entity_name}(${entity_name_low});
    }

    @Override
    public MsgDto update${entity_name}(${entity_name} ${entity_name_low}) {
        return ${entity_name_low}Biz.update${entity_name}(${entity_name_low});
    }

    @Override
    public MsgDto get${entity_name}(String id) {
        return ${entity_name_low}Biz.get${entity_name}(id);
    }

    @Override
    public MsgDto del${entity_name}(String id) {
        return ${entity_name_low}Biz.del${entity_name}(id);
    }

    @Override
    public MsgDto delete(String ids) {
        return ${entity_name_low}Biz.delete(ids);
    }

    @Override
    public Page<Object> queryByPage(ParamsMap params) {
    return ${entity_name_low}Biz.queryByPage(params);
    }

}