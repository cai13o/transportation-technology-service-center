package cn.com.busi.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.com.busi.mapper.TSubtaskMapper;
import cn.com.busi.domain.TSubtask;
import cn.com.busi.service.TSubtaskService;

@Service
public class TSubtaskServiceImpl implements TSubtaskService {

    @Resource
    private TSubtaskMapper tSubtaskMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return tSubtaskMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TSubtask record) {
        return tSubtaskMapper.insert(record);
    }

    @Override
    public int insertSelective(TSubtask record) {
        return tSubtaskMapper.insertSelective(record);
    }

    @Override
    public TSubtask selectByPrimaryKey(String id) {
        return tSubtaskMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TSubtask record) {
        if (null != record.getProgress() && ("100").equals(record.getProgress())) {
            record.setStatus("2");
        }
        return tSubtaskMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TSubtask record) {
        return tSubtaskMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByTid(TSubtask record) {
        return tSubtaskMapper.updateByTid(record);
    }

}



