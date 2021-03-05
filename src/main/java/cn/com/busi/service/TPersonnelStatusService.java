package cn.com.busi.service;

import cn.com.busi.domain.TPersonnelStatus;

public interface TPersonnelStatusService {


    int deleteByPrimaryKey(String eid);

    int insert(TPersonnelStatus record);

    int insertSelective(TPersonnelStatus record);

    TPersonnelStatus selectByPrimaryKey(String eid);

    int updateByPrimaryKeySelective(TPersonnelStatus record);

    int updateByPrimaryKey(TPersonnelStatus record);

}

