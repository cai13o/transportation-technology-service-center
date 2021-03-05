package cn.com.busi.service;

import cn.com.busi.domain.TSchedule;

import java.util.List;

public interface TScheduleService {


    int deleteByPrimaryKey(String id);

    int insert(TSchedule record);

    int insertSelective(TSchedule record);

    TSchedule selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TSchedule record);

    int updateByPrimaryKey(TSchedule record);

    List<TSchedule> findByAll(TSchedule tSchedule, String by, String timeStart, String timeEnd);
}




