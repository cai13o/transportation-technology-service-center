package cn.com.busi.service;

import cn.com.busi.domain.TItemInfo;
public interface TItemInfoService{


    int deleteByPrimaryKey(String sort);

    int insert(TItemInfo record);

    int insertSelective(TItemInfo record);

    TItemInfo selectByPrimaryKey(String sort);

    int updateByPrimaryKeySelective(TItemInfo record);

    int updateByPrimaryKey(TItemInfo record);

}
