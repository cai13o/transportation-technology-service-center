package cn.com.busi.mapper;

import cn.com.busi.domain.TStandardizingSystem;import org.apache.ibatis.annotations.Param;import java.util.Date;import java.util.List;

public interface TStandardizingSystemMapper {
    int deleteByPrimaryKey(String id);

    int insert(TStandardizingSystem record);

    int insertSelective(TStandardizingSystem record);

    TStandardizingSystem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TStandardizingSystem record);

    int updateByPrimaryKey(TStandardizingSystem record);

    List<TStandardizingSystem> findByAll(@Param("tStandardizingSystem") TStandardizingSystem tStandardizingSystem, @Param("timeStart") Date timeStart, @Param("timeEnd") Date timeEnd, @Param("order") String order, @Param("by") String by);
}