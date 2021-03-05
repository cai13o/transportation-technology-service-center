package cn.com.busi.mapper;

import cn.com.busi.domain.TPersonnelStatus;

public interface TPersonnelStatusMapper {
    int deleteByPrimaryKey(String id);

    int insert(TPersonnelStatus record);

    int insertSelective(TPersonnelStatus record);

    TPersonnelStatus selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TPersonnelStatus record);

    int updateByPrimaryKey(TPersonnelStatus record);
}