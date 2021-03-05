package cn.com.busi.service;

import cn.com.busi.domain.TJobs;

import java.util.List;

public interface TJobsService {


    int deleteByPrimaryKey(String id);

    int insert(TJobs record);

    int insertSelective(TJobs record);

    TJobs selectByPrimaryKey(String id);

    List<TJobs> findByAll(TJobs tJobs);

    int updateByPrimaryKeySelective(TJobs record);

    int updateByPrimaryKey(TJobs record);


}

