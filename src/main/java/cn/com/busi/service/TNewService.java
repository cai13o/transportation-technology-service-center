package cn.com.busi.service;

import cn.com.busi.domain.TNew;

import java.util.List;
import java.util.Map;

public interface TNewService {


    int deleteByPrimaryKey(String id);

    int insert(TNew record);

    int insertSelective(TNew record);

    TNew selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TNew record);

    int updateByPrimaryKey(TNew record);

    List<TNew> findByAll(TNew tNew, String issue, String startDate, String endDate, String order, String by,String stutas,String depts);

    Map findByType(TNew tNew, String issue, String startDate, String endDate, String order, String by,String stutas,String depts);
}




