package cn.com.busi.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.com.busi.mapper.TScheduleMapper;
import cn.com.busi.domain.TSchedule;
import cn.com.busi.service.TScheduleService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TScheduleServiceImpl implements TScheduleService {

    @Resource
    private TScheduleMapper tScheduleMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return tScheduleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TSchedule record) {
        return tScheduleMapper.insert(record);
    }

    @Override
    public int insertSelective(TSchedule record) {
        record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        return tScheduleMapper.insertSelective(record);
    }

    @Override
    public TSchedule selectByPrimaryKey(String id) {
        return tScheduleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TSchedule record) {
        return tScheduleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TSchedule record) {
        return tScheduleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TSchedule> findByAll(TSchedule tSchedule, String by, String start, String end) {
        if (null != by && "" != by) {
            if ("0".equals(by)) {
                by = "DESC";
            } else {
                by = "ASC";
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date timeStart = null;
        Date timeEnd = null;

        try {
            if (null != start && "" != start) {
                timeStart = (sdf.parse(start));
            }
            if (null != end && "" != end) {
                timeEnd = (sdf.parse(end));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tScheduleMapper.findByAll(tSchedule, by,timeStart,timeEnd);
    }

}




