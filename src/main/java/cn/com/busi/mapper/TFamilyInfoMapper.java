package cn.com.busi.mapper;

import cn.com.busi.domain.TFamilyInfo;

public interface TFamilyInfoMapper {
    int insert(TFamilyInfo record);

    int insertSelective(TFamilyInfo record);
}