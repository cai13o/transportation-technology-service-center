package cn.com.busi.service.impl;

import cn.com.busi.domain.TContactInfo;
import cn.com.busi.domain.TPersonnelStatus;
import cn.com.busi.domain.TWorkInfo;
import cn.com.busi.mapper.TContactInfoMapper;
import cn.com.busi.mapper.TPersonnelStatusMapper;
import cn.com.busi.mapper.TWorkInfoMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.com.busi.domain.TEmp;
import cn.com.busi.mapper.TEmpMapper;
import cn.com.busi.service.TEmpService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class TEmpServiceImpl implements TEmpService {

    @Resource
    private TEmpMapper tEmpMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return tEmpMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TEmp record) {
        return tEmpMapper.insert(record);
    }

    @Override
    public TEmp selectByPrimaryKey(String id) {
        return tEmpMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TEmp record) {
        return tEmpMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TEmp record) {
        return tEmpMapper.updateByPrimaryKey(record);
    }

    @Override
    public int insertSelective(TEmp record) {
        record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        return tEmpMapper.insertSelective(record);
    }

    @Override
    public List<TEmp> findByAll(TEmp tEmp) {
        return tEmpMapper.findByAll(tEmp);
    }

    @Override
    public TEmp selectByUsernameAndPassword(String username, String password) {
        return tEmpMapper.selectByUsernameAndPassword(username, password);
    }

}




