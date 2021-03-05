package cn.com.busi.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.com.busi.domain.TWorkInfo;
import cn.com.busi.mapper.TWorkInfoMapper;
import cn.com.busi.service.TWorkInfoService;

@Service
public class TWorkInfoServiceImpl implements TWorkInfoService {

    @Resource
    private TWorkInfoMapper tWorkInfoMapper;

    @Override
    public int deleteByPrimaryKey(String eid) {
        return tWorkInfoMapper.deleteByPrimaryKey(eid);
    }

    @Override
    public int insert(TWorkInfo record) {
        return tWorkInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(TWorkInfo record) {
        return tWorkInfoMapper.insertSelective(record);
    }

    @Override
    public TWorkInfo selectByPrimaryKey(String eid) {
        return tWorkInfoMapper.selectByPrimaryKey(eid);
    }

    @Override
    public int updateByPrimaryKeySelective(TWorkInfo record) {
        return tWorkInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TWorkInfo record) {
        return tWorkInfoMapper.updateByPrimaryKey(record);
    }

}

