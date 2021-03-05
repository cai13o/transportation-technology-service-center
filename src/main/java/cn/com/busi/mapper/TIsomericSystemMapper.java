package cn.com.busi.mapper;

import cn.com.busi.domain.TIsomericSystem;

public interface TIsomericSystemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TIsomericSystem record);

    int insertSelective(TIsomericSystem record);

    TIsomericSystem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TIsomericSystem record);

    int updateByPrimaryKey(TIsomericSystem record);
}