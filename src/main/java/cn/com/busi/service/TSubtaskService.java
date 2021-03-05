package cn.com.busi.service;

import cn.com.busi.domain.TSubtask;

public interface TSubtaskService {


    int deleteByPrimaryKey(String id);

    int insert(TSubtask record);

    int insertSelective(TSubtask record);

    TSubtask selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TSubtask record);

    int updateByPrimaryKey(TSubtask record);

    int updateByTid(TSubtask record);
}



