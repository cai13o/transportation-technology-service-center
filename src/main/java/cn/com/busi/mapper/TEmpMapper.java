package cn.com.busi.mapper;

import cn.com.busi.domain.TEmp;import org.apache.ibatis.annotations.Param;import java.util.List;

public interface TEmpMapper {
    int deleteByPrimaryKey(String id);

    int insert(TEmp record);

    int insertSelective(TEmp record);

    TEmp selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TEmp record);

    int updateByPrimaryKey(TEmp record);

    List<TEmp> findByAll(TEmp tEmp);

    TEmp selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    int updateByJobs(@Param("jobs") String jobs);
}