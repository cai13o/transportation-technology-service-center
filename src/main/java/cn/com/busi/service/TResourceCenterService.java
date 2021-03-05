package cn.com.busi.service;

import cn.com.busi.domain.TResourceCenter;

import java.util.List;

public interface TResourceCenterService {


    int deleteByPrimaryKey(String id);

    int insert(TResourceCenter record);

    int insertSelective(TResourceCenter record);

    TResourceCenter selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TResourceCenter record);

    int updateByPrimaryKey(TResourceCenter record);

    List<TResourceCenter> findByAll(TResourceCenter record, String startDate, String endDate, String stutas, String depts,String uname);

}

