package cn.com.busi.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.com.busi.mapper.TPersonnelStatusMapper;
import cn.com.busi.domain.TPersonnelStatus;
import cn.com.busi.service.TPersonnelStatusService;

@Service
public class TPersonnelStatusServiceImpl implements TPersonnelStatusService {

    @Resource
    private TPersonnelStatusMapper tPersonnelStatusMapper;

    @Override
    public int deleteByPrimaryKey(String eid) {
        return tPersonnelStatusMapper.deleteByPrimaryKey(eid);
    }

    @Override
    public int insert(TPersonnelStatus record) {
        return tPersonnelStatusMapper.insert(record);
    }

    @Override
    public int insertSelective(TPersonnelStatus record) {
        return tPersonnelStatusMapper.insertSelective(record);
    }

    @Override
    public TPersonnelStatus selectByPrimaryKey(String eid) {
        return tPersonnelStatusMapper.selectByPrimaryKey(eid);
    }

    @Override
    public int updateByPrimaryKeySelective(TPersonnelStatus record) {
        return tPersonnelStatusMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TPersonnelStatus record) {
        return tPersonnelStatusMapper.updateByPrimaryKey(record);
    }

}

