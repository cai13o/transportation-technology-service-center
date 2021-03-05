package cn.com.busi.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.com.busi.mapper.TPermissionMapper;
import cn.com.busi.domain.TPermission;
import cn.com.busi.service.TPermissionService;

import java.util.List;

@Service
public class TPermissionServiceImpl implements TPermissionService{

    @Resource
    private TPermissionMapper tPermissionMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return tPermissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TPermission record) {
        return tPermissionMapper.insert(record);
    }

    @Override
    public int insertSelective(TPermission record) {
        return tPermissionMapper.insertSelective(record);
    }

    @Override
    public TPermission selectByPrimaryKey(String id) {
        return tPermissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TPermission record) {
        return tPermissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TPermission record) {
        return tPermissionMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TPermission> selectByAll(TPermission tPermission) {
        return tPermissionMapper.selectByAll(tPermission);
    }

}
