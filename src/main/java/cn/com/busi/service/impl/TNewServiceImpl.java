package cn.com.busi.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import cn.com.busi.mapper.TNewMapper;
import cn.com.busi.domain.TNew;
import cn.com.busi.service.TNewService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TNewServiceImpl implements TNewService {

    @Resource
    private TNewMapper tNewMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return tNewMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TNew record) {
        return tNewMapper.insert(record);
    }

    @Override
    public int insertSelective(TNew record) {
        record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        record.setIssuedate(new Date());
        return tNewMapper.insertSelective(record);
    }

    @Override
    public TNew selectByPrimaryKey(String id) {
        return tNewMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TNew record) {
        return tNewMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TNew record) {
        return tNewMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TNew> findByAll(TNew tNew, String issue, String startDate, String endDate, String order, String by,String stutas,String depts) {
        if (null != issue && "" != issue) {
            if (issue.equals("近一周")) {
                issue = " 7 DAY";
            } else if (issue.equals("近一个月")) {
                issue = " 1 MONTH";
            } else if (issue.equals("近三个月")) {
                issue = " 3 MONTH";
            } else if (issue.equals("近半年")) {
                issue = " 6 MONTH";
            } else if (issue.equals("近一年")) {
                issue = " 1 YEAR";
            }
        }
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
        if (null != tNew.getImportance() && "" != tNew.getImportance()) {
            tNew.setImportance(tNew.getImportance().replace("[", "").replace("]", "").replace("\"", ""));
        }
        if (null != tNew.getAuditStatus() && "" != tNew.getAuditStatus()) {
            tNew.setAuditStatus(tNew.getAuditStatus().replace("[", "").replace("]", "").replace("\"", ""));
        }
        String type = null;
        System.out.println("---------------------------------"+type);
        if (tNew.getType().equals("['中心要闻','行业动态']")) {
            tNew.setType(type);
            type = "'中心要闻','行业动态'";
        }
        if (null != order && "" != order) {
            if ("发布时间".equals(order)) {
                order = "issueDate";
            } else if ("0".equals(order)) {
                order = "issueDate";
            } else {
                order = "ctr";
            }
        }
        if (null != by && "" != by) {
            if ("0".equals(by)) {
                by = "DESC";
            } else {
                by = "ASC";
            }
        }
        if (stutas.equals("0")){
            stutas = null;
        }
        return tNewMapper.findByAll(tNew, issue, timeStart, timeEnd, order, by, type,stutas,depts);
    }

    @Override
    public Map findByType(TNew tNew, String issue, String startDate, String endDate, String order, String by,String stutas,String depts) {
        if (null != issue && "" != issue) {
            if (issue.equals("近一周")) {
                issue = " 7 DAY";
            } else if (issue.equals("近一个月")) {
                issue = " 1 MONTH";
            } else if (issue.equals("近三个月")) {
                issue = " 3 MONTH";
            } else if (issue.equals("近半年")) {
                issue = " 6 MONTH";
            } else if (issue.equals("近一年")) {
                issue = " 1 YEAR";
            }
        }
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

        if (null != tNew.getAuditStatus() && "" != tNew.getAuditStatus()) {
            tNew.setAuditStatus(tNew.getAuditStatus().replace("[", "").replace("]", "").replace("\"", ""));
        }
        String type = null;
        if (null != order && "" != order) {
            if ("发布时间".equals(order)) {
                order = "issueDate";
            } else if ("0".equals(order)) {
                order = "issueDate";
            } else {
                order = "ctr";
            }
        }
        if (null != by && "" != by) {
            if ("0".equals(by)) {
                by = "DESC";
            } else {
                by = "ASC";
            }
        }
        if (stutas.equals("0")){
            stutas = null;
        }
        Map map = new HashMap();
        tNew.setType("中心要闻");
        map.put("z",tNewMapper.findByAll(tNew, issue, timeStart, timeEnd, order, by, type,stutas,depts));
        tNew.setType("通知公告");
        map.put("t",tNewMapper.findByAll(tNew, issue, timeStart, timeEnd, order, by, type,stutas,depts));
        tNew.setType("行业动态");
        map.put("h",tNewMapper.findByAll(tNew, issue, timeStart, timeEnd, order, by, type, stutas, depts));
        return map;
    }

}




