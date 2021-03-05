package cn.com.busi.mapper;

import cn.com.busi.domain.TResourceCenter;import org.apache.ibatis.annotations.Param;import java.util.Date;import java.util.List;

public interface TResourceCenterMapper {
    int deleteByPrimaryKey(String id);

    int insert(TResourceCenter record);

    int insertSelective(TResourceCenter record);

    TResourceCenter selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TResourceCenter record);

    int updateByPrimaryKey(TResourceCenter record);

    List<TResourceCenter> findByAll(@Param("tResourceCenter") TResourceCenter tResourceCenter, @Param("timeStart") Date timeStart, @Param("timeEnd") Date timeEnd, @Param("stutas") String stutas, @Param("depts") String depts,@Param("uname") String uname);
}