package com.crm.console.biz;

import com.crm.console.mapper.${entity_name}Mapper;
import com.crm.console.model.${entity_name};
import com.util.comm.Cons;
import com.util.comm.Page;
import com.util.comm.ParamsMap;
import com.util.core.DateUtils;
import com.util.dto.MsgDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class ${entity_name}Biz {

    @Autowired
    private ${entity_name}Mapper ${entity_name_low}Mapper;

    /**
     * 新增记录
     *
     * @param ${entity_name_low}
     * @return
     */

    public MsgDto add${entity_name}(${entity_name} ${entity_name_low}) {
        ${entity_name_low}.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<${entity_name}> ${entity_name_low}List = ${entity_name_low}Mapper.selectListByMap(map);
        if (!${entity_name_low}List.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, ${entity_name_low}List.get(0));
         }
        ${entity_name_low}Mapper.insertSelective(${entity_name_low});
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, ${entity_name_low});
    }

    /**
    * 根据id更新记录
    *
    * @param ${entity_name_low}
    * @return
    */
    public MsgDto update${entity_name}(${entity_name} ${entity_name_low}) {
       Map<String, Object> map = new HashMap();

      List<${entity_name}> ${entity_name_low}List = ${entity_name_low}Mapper.selectListByMap(map);
        if (!${entity_name_low}List.isEmpty()) {
          for (${entity_name} ${entity_name_low}s : ${entity_name_low}List) {
             if (!${entity_name_low}s.getId().equals(${entity_name_low}.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, ${entity_name_low}s);
              }
            }
        }
         ${entity_name_low}Mapper.updateByPrimaryKeySelective(${entity_name_low});
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, ${entity_name_low});
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto del${entity_name}(String id) {
         ${entity_name_low}Mapper.deleteByPrimaryKey(id);
        return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 删除多条记录
        *
        * @param ids
        * @return
        */
        public MsgDto delete(String ids) {
           String[] arr = ids.split(",");
            for (String id : arr) {
              ${entity_name_low}Mapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto get${entity_name}(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, ${entity_name_low}Mapper.getObjectByStatementName("selectObjectByPrimaryKey", id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return ${entity_name_low}Mapper.queryObjectPageByMap(params);
          }

 }