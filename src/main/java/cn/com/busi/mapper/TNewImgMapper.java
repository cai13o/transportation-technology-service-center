package cn.com.busi.mapper;

import cn.com.busi.domain.TNewImg;

public interface TNewImgMapper {
    int deleteByPrimaryKey(String id);

    int insert(TNewImg record);

    int insertSelective(TNewImg record);

    TNewImg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TNewImg record);

    int updateByPrimaryKey(TNewImg record);
}