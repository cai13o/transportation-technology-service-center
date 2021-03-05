package cn.com.busi.service.impl;

import cn.com.busi.mapper.TEmpMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.com.busi.domain.TJobs;
import cn.com.busi.mapper.TJobsMapper;
import cn.com.busi.service.TJobsService;

import java.util.List;

@Service
public class TJobsServiceImpl implements TJobsService {

    @Resource
    private TJobsMapper tJobsMapper;

    @Resource
    private TEmpMapper tEmpMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        tEmpMapper.updateByJobs(id);
        return tJobsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TJobs record) {
        return tJobsMapper.insert(record);
    }

    @Override
    public int insertSelective(TJobs record) {
        return tJobsMapper.insertSelective(record);
    }

    @Override
    public TJobs selectByPrimaryKey(String id) {
        return tJobsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TJobs> findByAll(TJobs tJobs) {
        return tJobsMapper.findByAll(tJobs);
    }

    @Override
    public int updateByPrimaryKeySelective(TJobs record) {
        return tJobsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TJobs record) {
        return tJobsMapper.updateByPrimaryKey(record);
    }

}

