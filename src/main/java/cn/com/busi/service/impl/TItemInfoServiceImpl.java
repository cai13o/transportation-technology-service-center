package cn.com.busi.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.com.busi.domain.TItemInfo;
import cn.com.busi.mapper.TItemInfoMapper;
import cn.com.busi.service.TItemInfoService;
@Service
public class TItemInfoServiceImpl implements TItemInfoService{

    @Resource
    private TItemInfoMapper tItemInfoMapper;

    @Override
    public int deleteByPrimaryKey(String sort) {
        return tItemInfoMapper.deleteByPrimaryKey(sort);
    }

    @Override
    public int insert(TItemInfo record) {
        return tItemInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(TItemInfo record) {
        return tItemInfoMapper.insertSelective(record);
    }

    @Override
    public TItemInfo selectByPrimaryKey(String sort) {
        return tItemInfoMapper.selectByPrimaryKey(sort);
    }

    @Override
    public int updateByPrimaryKeySelective(TItemInfo record) {
        return tItemInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TItemInfo record) {
        return tItemInfoMapper.updateByPrimaryKey(record);
    }

}
