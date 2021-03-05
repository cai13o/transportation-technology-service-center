package cn.com.busi.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.com.busi.domain.TFamilyInfo;
import cn.com.busi.mapper.TFamilyInfoMapper;
import cn.com.busi.service.TFamilyInfoService;
@Service
public class TFamilyInfoServiceImpl implements TFamilyInfoService{

    @Resource
    private TFamilyInfoMapper tFamilyInfoMapper;

    @Override
    public int insert(TFamilyInfo record) {
        return tFamilyInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(TFamilyInfo record) {
        return tFamilyInfoMapper.insertSelective(record);
    }

}
