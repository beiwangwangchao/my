package com.jingcheng.marketing.business.biz;

import com.jingcheng.marketing.business.mapper.CrmTransferRecordMapper;
import com.jingcheng.marketing.business.model.CrmTransferRecord;
import com.util.comm.Cons;
import com.util.mybatisplus.Page;
import com.util.comm.ParamsMap;
import com.util.dto.MsgDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class CrmTransferRecordBiz {

    @Autowired
    private CrmTransferRecordMapper crmTransferRecordMapper;

    /**
     * 新增记录
     *
     * @param crmTransferRecord
     * @return
     */

    public MsgDto addCrmTransferRecord(CrmTransferRecord crmTransferRecord) {
        crmTransferRecord.setId(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap();

        List<CrmTransferRecord> crmTransferRecordList = crmTransferRecordMapper.selectListByMap(map);
        if (!crmTransferRecordList.isEmpty()) {
           return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmTransferRecordList.get(0));
         }
        crmTransferRecordMapper.insertSelective(crmTransferRecord);
      return new MsgDto(Cons.SysCode.SUCCESS, "新增成功", true, crmTransferRecord);
    }

    /**
    * 根据id更新记录
    *
    * @param crmTransferRecord
    * @return
    */
    public MsgDto updateCrmTransferRecord(CrmTransferRecord crmTransferRecord) {
       Map<String, Object> map = new HashMap();

      List<CrmTransferRecord> crmTransferRecordList = crmTransferRecordMapper.selectListByMap(map);
        if (!crmTransferRecordList.isEmpty()) {
          for (CrmTransferRecord crmTransferRecords : crmTransferRecordList) {
             if (!crmTransferRecords.getId().equals(crmTransferRecord.getId())) {
                return new MsgDto(Cons.SysCode.EXIET, "该数据已存在！", false, crmTransferRecords);
              }
            }
        }
         crmTransferRecordMapper.updateByPrimaryKeySelective(crmTransferRecord);
        return new MsgDto(Cons.SysCode.SUCCESS, "更新成功", true, crmTransferRecord);
        }

        /**
        * 删除单条记录
        *
        * @param id
        * @return
        */
        public MsgDto delCrmTransferRecord(String id) {
         crmTransferRecordMapper.deleteByPrimaryKey(id);
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
              crmTransferRecordMapper.deleteByPrimaryKey(id);
            }
          return new MsgDto(Cons.SysCode.SUCCESS, "删除成功", true);
        }

        /**
        * 查询单条记录
        *
        * @param id
        * @return
        */
        public MsgDto getCrmTransferRecord(String id) {
        return new MsgDto(Cons.SysCode.SUCCESS, "查询成功", true, crmTransferRecordMapper.selectById(id));
        }

        /**
        * 查询分页数据
        *
        * @param params
        * @return
        */
        public Page<Object> queryByPage(ParamsMap params) {
            return crmTransferRecordMapper.queryPage(params);
          }

 }