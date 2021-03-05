package cn.com.busi.mapper;

import cn.com.busi.domain.TJobRecords;

public interface TJobRecordsMapper {
    int insert(TJobRecords record);

    int insertSelective(TJobRecords record);
}