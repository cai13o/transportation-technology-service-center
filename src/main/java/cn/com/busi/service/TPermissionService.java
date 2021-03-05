package cn.com.busi.service;

import cn.com.busi.domain.TPermission;

import java.util.List;

public interface TPermissionService{


    int deleteByPrimaryKey(String id);

    int insert(TPermission record);

    int insertSelective(TPermission record);

    TPermission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TPermission record);

    int updateByPrimaryKey(TPermission record);

    List<TPermission> selectByAll(TPermission tPermission);
}
