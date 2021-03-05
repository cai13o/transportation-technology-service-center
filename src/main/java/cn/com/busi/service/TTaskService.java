package cn.com.busi.service;

import cn.com.busi.domain.TTask;

import java.util.List;

public interface TTaskService {


    int deleteByPrimaryKey(String id);

    int insert(TTask record);

    int insertSelective(TTask record);

    TTask selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TTask record);

    int updateByPrimaryKey(TTask record);

    List<TTask> findByAll(TTask tTask, String startDate, String endDate, String stutas, String assigned,String deptId, String isitoverdue,String startsDate,String staDate);

    String[] countByType();

    String[] countByName();
}


