package cn.com.busi.mapper;

import cn.com.busi.domain.TTask;import org.apache.ibatis.annotations.Param;import java.util.List;

public interface TTaskMapper {
    int deleteByPrimaryKey(String id);

    int insert(TTask record);

    int insertSelective(TTask record);

    TTask selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TTask record);

    int updateByPrimaryKey(TTask record);

    List<TTask> findByAll(@Param("tTask") TTask tTask, @Param("timeStart") String timeStart, @Param("timeEnd") String timeEnd, @Param("isitoverdue") String isitoverdue, @Param("stutas") String stutas, @Param("assigned") String assigned, @Param("deptId") String deptId,@Param("startsDate") String startsDate,@Param("staDate")String staDate);

    String[] countByType();

    String[] countByName();
}