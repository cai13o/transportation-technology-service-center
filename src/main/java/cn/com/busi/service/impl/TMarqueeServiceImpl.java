package cn.com.busi.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.com.busi.domain.TMarquee;
import cn.com.busi.mapper.TMarqueeMapper;
import cn.com.busi.service.TMarqueeService;

import java.util.List;
import java.util.UUID;

@Service
public class TMarqueeServiceImpl implements TMarqueeService{

    @Resource
    private TMarqueeMapper tMarqueeMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return tMarqueeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TMarquee record) {
        return tMarqueeMapper.insert(record);
    }

    @Override
    public int insertSelective(TMarquee record) {
        record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        return tMarqueeMapper.insertSelective(record);
    }

    @Override
    public TMarquee selectByPrimaryKey(String id) {
        return tMarqueeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TMarquee record) {
        return tMarqueeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TMarquee record) {
        return tMarqueeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TMarquee> findByAll(TMarquee tMarquee) {
        return tMarqueeMapper.findByAll(tMarquee);
    }

}
