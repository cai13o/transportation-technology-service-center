package cn.com.busi.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import cn.com.busi.domain.TPermission;

public interface TPermissionMapper {
    int deleteByPrimaryKey(String id);

    int insert(TPermission record);

    int insertSelective(TPermission record);

    TPermission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TPermission record);

    int updateByPrimaryKey(TPermission record);

    List<TPermission> selectByAll(TPermission tPermission);

}