package cn.com.busi.service;

import cn.com.busi.domain.TJobRecords;
public interface TJobRecordsService{


    int insert(TJobRecords record);

    int insertSelective(TJobRecords record);

}
