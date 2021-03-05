package cn.com.busi.mapper;

import cn.com.busi.domain.TSchedule;import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TScheduleMapper {
    int deleteByPrimaryKey(String id);

    int insert(TSchedule record);

    int insertSelective(TSchedule record);

    TSchedule selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TSchedule record);

    int updateByPrimaryKey(TSchedule record);

    List<TSchedule> findByAll(@Param("tSchedule") TSchedule tSchedule, @Param("by") String by, @Param("timeStart") Date timeStart, @Param("timeEnd")Date timeEnd);
}