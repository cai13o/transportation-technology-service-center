package cn.com.busi.mapper;

import cn.com.busi.domain.TSubtask;

public interface TSubtaskMapper {
    int deleteByPrimaryKey(String id);

    int insert(TSubtask record);

    int insertSelective(TSubtask record);

    TSubtask selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TSubtask record);

    int updateByPrimaryKey(TSubtask record);

    int updateByTid(TSubtask record);
}