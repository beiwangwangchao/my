package com.crm.console.api;

import com.crm.console.model.${entity_name};
import com.util.base.BaseException;
import com.util.comm.Page;
import com.util.comm.ParamsMap;
import com.util.dto.MsgDto;


public interface ${entity_name}Api {
    public MsgDto add${entity_name}(${entity_name} ${entity_name_low}) throws BaseException;

    public MsgDto update${entity_name}(${entity_name} ${entity_name_low}) throws BaseException;

    public MsgDto get${entity_name}(String id) throws BaseException;

    public MsgDto del${entity_name}(String id) throws BaseException;

    /****
     * 支持数据批量删除
     * @param ids
     * @throws BaseException
     */
    public MsgDto delete(String ids) throws BaseException;

    public Page<Object> queryByPage(ParamsMap params) throws BaseException;
 }