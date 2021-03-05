package cn.com.busi.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.com.busi.domain.TResourceCenter;
import cn.com.busi.mapper.TResourceCenterMapper;
import cn.com.busi.service.TResourceCenterService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TResourceCenterServiceImpl implements TResourceCenterService {

    @Resource
    private TResourceCenterMapper tResourceCenterMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return tResourceCenterMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TResourceCenter record) {
        return tResourceCenterMapper.insert(record);
    }

    @Override
    public int insertSelective(TResourceCenter record) {
        record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        record.setOpdate(new Date());
        record.setCount(0);
        return tResourceCenterMapper.insertSelective(record);
    }

    @Override
    public TResourceCenter selectByPrimaryKey(String id) {
        return tResourceCenterMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TResourceCenter record) {
        return tResourceCenterMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TResourceCenter record) {
        return tResourceCenterMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TResourceCenter> findByAll(TResourceCenter record, String startDate, String endDate, String stutas, String depts,String uname) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date timeStart = null;
        Date timeEnd = null;
        try {
            if (null != startDate && "" != startDate) {
                timeStart = (sdf.parse(startDate));
            }
            if (null != endDate && "" != endDate) {
                timeEnd = (sdf.parse(endDate));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (stutas.equals("0")) {
            stutas = null;
        }
        return tResourceCenterMapper.findByAll(record, timeStart, timeEnd, stutas, depts,uname);
    }
}

