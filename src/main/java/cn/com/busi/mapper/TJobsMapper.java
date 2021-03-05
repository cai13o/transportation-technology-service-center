package cn.com.busi.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Date;

import cn.com.busi.domain.TJobs;import java.util.List;

public interface TJobsMapper {
    int deleteByPrimaryKey(String id);

    int insert(TJobs record);

    int insertSelective(TJobs record);

    TJobs selectByPrimaryKey(String id);

    List<TJobs> findByAll(TJobs tJobs);

    int updateByPrimaryKeySelective(TJobs record);

    int updateByPrimaryKey(TJobs record);


}