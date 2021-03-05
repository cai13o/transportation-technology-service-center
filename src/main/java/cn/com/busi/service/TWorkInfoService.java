package cn.com.busi.service;

import cn.com.busi.domain.TWorkInfo;

public interface TWorkInfoService {


    int deleteByPrimaryKey(String eid);

    int insert(TWorkInfo record);

    int insertSelective(TWorkInfo record);

    TWorkInfo selectByPrimaryKey(String eid);

    int updateByPrimaryKeySelective(TWorkInfo record);

    int updateByPrimaryKey(TWorkInfo record);

}

