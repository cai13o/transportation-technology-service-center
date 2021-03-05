package cn.com.busi.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.com.busi.mapper.TJobRecordsMapper;
import cn.com.busi.domain.TJobRecords;
import cn.com.busi.service.TJobRecordsService;
@Service
public class TJobRecordsServiceImpl implements TJobRecordsService{

    @Resource
    private TJobRecordsMapper tJobRecordsMapper;

    @Override
    public int insert(TJobRecords record) {
        return tJobRecordsMapper.insert(record);
    }

    @Override
    public int insertSelective(TJobRecords record) {
        return tJobRecordsMapper.insertSelective(record);
    }

}
