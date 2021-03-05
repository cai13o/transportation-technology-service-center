package cn.com.busi.mapper;

import cn.com.busi.domain.TWorkInfo;

public interface TWorkInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(TWorkInfo record);

    int insertSelective(TWorkInfo record);

    TWorkInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TWorkInfo record);

    int updateByPrimaryKey(TWorkInfo record);
}