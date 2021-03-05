package cn.com.busi.service;

import cn.com.busi.domain.TStandardizingSystem;

import java.util.List;

public interface TStandardizingSystemService {


    int deleteByPrimaryKey(String id);

    int insert(TStandardizingSystem record);

    int insertSelective(TStandardizingSystem record);

    TStandardizingSystem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TStandardizingSystem record);

    int updateByPrimaryKey(TStandardizingSystem record);

    List<TStandardizingSystem> findByAll(TStandardizingSystem tStandardizingSystem, String startDate, String endDate, String order, String by);
}







