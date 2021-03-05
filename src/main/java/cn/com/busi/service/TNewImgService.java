package cn.com.busi.service;

import cn.com.busi.domain.TNewImg;

public interface TNewImgService {


    int deleteByPrimaryKey(String id);

    int insert(TNewImg record);

    int insertSelective(TNewImg record);

    TNewImg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TNewImg record);

    int updateByPrimaryKey(TNewImg record);

}

