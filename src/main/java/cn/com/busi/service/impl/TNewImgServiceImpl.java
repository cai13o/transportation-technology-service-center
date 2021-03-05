package cn.com.busi.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.com.busi.mapper.TNewImgMapper;
import cn.com.busi.domain.TNewImg;
import cn.com.busi.service.TNewImgService;

@Service
public class TNewImgServiceImpl implements TNewImgService {

    @Resource
    private TNewImgMapper tNewImgMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return tNewImgMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TNewImg record) {
        return tNewImgMapper.insert(record);
    }

    @Override
    public int insertSelective(TNewImg record) {
        return tNewImgMapper.insertSelective(record);
    }

    @Override
    public TNewImg selectByPrimaryKey(String id) {
        return tNewImgMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TNewImg record) {
        return tNewImgMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TNewImg record) {
        return tNewImgMapper.updateByPrimaryKey(record);
    }

}

