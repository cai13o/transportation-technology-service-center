package cn.com.busi.mapper;

import cn.com.busi.domain.TItemInfo;

public interface TItemInfoMapper {
    int deleteByPrimaryKey(String sort);

    int insert(TItemInfo record);

    int insertSelective(TItemInfo record);

    TItemInfo selectByPrimaryKey(String sort);

    int updateByPrimaryKeySelective(TItemInfo record);

    int updateByPrimaryKey(TItemInfo record);
}