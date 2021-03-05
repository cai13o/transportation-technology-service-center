package cn.com.busi.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.com.busi.domain.TStandardizingSystem;
import cn.com.busi.mapper.TStandardizingSystemMapper;
import cn.com.busi.service.TStandardizingSystemService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TStandardizingSystemServiceImpl implements TStandardizingSystemService {

    @Resource
    private TStandardizingSystemMapper tStandardizingSystemMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return tStandardizingSystemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TStandardizingSystem record) {

        return tStandardizingSystemMapper.insert(record);
    }

    @Override
    public int insertSelective(TStandardizingSystem record) {
        record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        record.setOpdate(new Date());
        return tStandardizingSystemMapper.insertSelective(record);
    }

    @Override
    public TStandardizingSystem selectByPrimaryKey(String id) {
        return tStandardizingSystemMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TStandardizingSystem record) {
        return tStandardizingSystemMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TStandardizingSystem record) {
        return tStandardizingSystemMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TStandardizingSystem> findByAll(TStandardizingSystem tStandardizingSystem, String startDate, String endDate, String order, String by) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date timeStart = null;
        Date timeEnd = null;
        if (null != tStandardizingSystem.getAuditStatus() && "" != tStandardizingSystem.getAuditStatus()) {
            tStandardizingSystem.setAuditStatus(tStandardizingSystem.getAuditStatus().replace("[", "").replace("]", "").replace("\"", ""));
        }
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
        if (null != order && "" != order) {
            if ("生效时间".equals(order)) {
                order = "Effectivedate";
            } else {
                order = "opdate";
            }
        }
        if (null != by && "" != by) {
            if ("0".equals(by)) {
                by = "DESC";
            } else {
                by = "ASC";
            }
        }
        if (null != tStandardizingSystem.getAuditStatus() && "" != tStandardizingSystem.getAuditStatus()) {
            tStandardizingSystem.setAuditStatus(tStandardizingSystem.getAuditStatus().replace("[", "").replace("]", "").replace("\"", ""));
        }
        return tStandardizingSystemMapper.findByAll(tStandardizingSystem, timeStart, timeEnd, order, by);
    }

}







