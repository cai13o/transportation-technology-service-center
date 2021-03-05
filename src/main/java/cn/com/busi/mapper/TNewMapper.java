package cn.com.busi.mapper;

import cn.com.busi.domain.TNew;import org.apache.ibatis.annotations.Param;import java.util.Date;import java.util.List;

public interface TNewMapper {
    int deleteByPrimaryKey(String id);

    int insert(TNew record);

    int insertSelective(TNew record);

    TNew selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TNew record);

    int updateByPrimaryKey(TNew record);

    List<TNew> findByAll(@Param("tNew") TNew tNew, @Param("issue") String issue, @Param("timeStart") Date timeStart, @Param("timeEnd") Date timeEnd, @Param("order") String order, @Param("by") String by, @Param("type") String type,@Param("stutas") String stutas,@Param("depts") String depts);
}