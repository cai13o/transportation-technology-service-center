package cn.com.busi.mapper;

import cn.com.busi.domain.TContactInfo;

public interface TContactInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(TContactInfo record);

    int insertSelective(TContactInfo record);

    TContactInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TContactInfo record);

    int updateByPrimaryKey(TContactInfo record);
}