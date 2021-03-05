package cn.com.busi.service;

import cn.com.busi.domain.TContactInfo;

public interface TContactInfoService {


    int deleteByPrimaryKey(String eid);

    int insert(TContactInfo record);

    int insertSelective(TContactInfo record);

    TContactInfo selectByPrimaryKey(String eid);

    int updateByPrimaryKeySelective(TContactInfo record);

    int updateByPrimaryKey(TContactInfo record);

}





