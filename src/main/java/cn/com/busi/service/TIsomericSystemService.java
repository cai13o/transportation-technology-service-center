package cn.com.busi.service;

import cn.com.busi.domain.TIsomericSystem;
public interface TIsomericSystemService{


    int deleteByPrimaryKey(Integer id);

    int insert(TIsomericSystem record);

    int insertSelective(TIsomericSystem record);

    TIsomericSystem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TIsomericSystem record);

    int updateByPrimaryKey(TIsomericSystem record);

}
