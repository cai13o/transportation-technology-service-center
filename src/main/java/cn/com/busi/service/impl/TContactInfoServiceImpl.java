package cn.com.busi.service.impl;

import cn.com.busi.service.TContactInfoService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.com.busi.mapper.TContactInfoMapper;
import cn.com.busi.domain.TContactInfo;

@Service
public class TContactInfoServiceImpl implements TContactInfoService {

    @Resource
    private TContactInfoMapper tContactInfoMapper;

    @Override
    public int deleteByPrimaryKey(String eid) {
        return tContactInfoMapper.deleteByPrimaryKey(eid);
    }

    @Override
    public int insert(TContactInfo record) {
        return tContactInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(TContactInfo record) {
        return tContactInfoMapper.insertSelective(record);
    }

    @Override
    public TContactInfo selectByPrimaryKey(String eid) {
        return tContactInfoMapper.selectByPrimaryKey(eid);
    }

    @Override
    public int updateByPrimaryKeySelective(TContactInfo record) {
        return tContactInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TContactInfo record) {
        return tContactInfoMapper.updateByPrimaryKey(record);
    }

}





