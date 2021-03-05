package cn.com.busi.service;

import cn.com.busi.domain.TDept;

import java.util.List;

public interface TDeptService{


    int deleteByPrimaryKey(String id);

    int insert(TDept record);

    int insertSelective(TDept record);

    TDept selectByPrimaryKey(String id);

    List<TDept> findByAll(TDept tDept);

    int updateByPrimaryKeySelective(TDept record);

    int updateByPrimaryKey(TDept record);

    List<TDept> selectAllDeptAndJobs();

    List<TDept> countByType();

    List<TDept> countByName();
}
