package cn.com.busi.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.com.busi.mapper.TIsomericSystemMapper;
import cn.com.busi.domain.TIsomericSystem;
import cn.com.busi.service.TIsomericSystemService;
@Service
public class TIsomericSystemServiceImpl implements TIsomericSystemService{

    @Resource
    private TIsomericSystemMapper tIsomericSystemMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return tIsomericSystemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TIsomericSystem record) {
        return tIsomericSystemMapper.insert(record);
    }

    @Override
    public int insertSelective(TIsomericSystem record) {
        return tIsomericSystemMapper.insertSelective(record);
    }

    @Override
    public TIsomericSystem selectByPrimaryKey(Integer id) {
        return tIsomericSystemMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TIsomericSystem record) {
        return tIsomericSystemMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TIsomericSystem record) {
        return tIsomericSystemMapper.updateByPrimaryKey(record);
    }

}
