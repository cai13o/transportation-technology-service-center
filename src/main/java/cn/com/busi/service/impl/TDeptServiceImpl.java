package cn.com.busi.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.com.busi.domain.TDept;
import cn.com.busi.mapper.TDeptMapper;
import cn.com.busi.service.TDeptService;

import java.util.List;

@Service
public class TDeptServiceImpl implements TDeptService{

    @Resource
    private TDeptMapper tDeptMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return tDeptMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TDept record) {
        return tDeptMapper.insert(record);
    }

    @Override
    public int insertSelective(TDept record) {
        return tDeptMapper.insertSelective(record);
    }

    @Override
    public TDept selectByPrimaryKey(String id) {
        return tDeptMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TDept> findByAll(TDept tDept) {
        return tDeptMapper.findByAll(tDept);
    }

    @Override
    public int updateByPrimaryKeySelective(TDept record) {
        return tDeptMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TDept record) {
        return tDeptMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TDept> selectAllDeptAndJobs() {
        return tDeptMapper.selectAllDeptAndJobs();
    }

    @Override
    public List<TDept> countByType() {
        return tDeptMapper.countByType();
    }

    @Override
    public List<TDept> countByName() {
        return tDeptMapper.countByName();
    }

}
