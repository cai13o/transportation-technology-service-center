package cn.com.busi.service.impl;

import cn.com.busi.domain.TSubtask;
import cn.com.busi.mapper.TSubtaskMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import cn.com.busi.mapper.TTaskMapper;
import cn.com.busi.domain.TTask;
import cn.com.busi.service.TTaskService;

import java.util.List;
import java.util.UUID;

@Service
public class TTaskServiceImpl implements TTaskService {

    @Resource
    private TTaskMapper tTaskMapper;
    @Resource
    private TSubtaskMapper tSubtaskMapper;


    @Override
    public int deleteByPrimaryKey(String id) {
        return tTaskMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TTask record) {
        return tTaskMapper.insert(record);
    }

    @Override
    public int insertSelective(TTask record) {
        record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        record.setStatus("0");
        record.setProgress(0);
        tTaskMapper.insertSelective(record);
        if (null != record.getSubtaskList()) {
            for (TSubtask tSubtask : record.getSubtaskList()) {
                System.out.println(tSubtask);
                tSubtask.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                tSubtask.setStatus("0");
                tSubtask.setProgress(0);
                tSubtask.setTid(record.getId());
                tSubtaskMapper.insertSelective(tSubtask);
            }
        }
        return 1;
    }

    @Override
    public TTask selectByPrimaryKey(String id) {
        TTask tTask = tTaskMapper.selectByPrimaryKey(id);
        List<TSubtask> subtaskList = tTask.getSubtaskList();
        if (null != subtaskList) {
            if (subtaskList.size() != 0) {
                int count = 0;
                for (TSubtask tSubtask : subtaskList) {
                    System.out.println(tSubtask.getProgress());
                    count += tSubtask.getProgress();
                    System.out.println(count);
                }
                System.out.println(subtaskList.size());
                count = count / subtaskList.size();
                System.out.println(count);
                tTask.setProgress(count);
                tTaskMapper.updateByPrimaryKey(tTask);
            }
        }

        return tTask;
    }

    @Override
    public int updateByPrimaryKeySelective(TTask record) {
        return tTaskMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TTask record) {
        if (null != record.getProgress() && ("100").equals(record.getProgress())) {
            record.setAuditStatus("2");
        }
        return tTaskMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TTask> findByAll(TTask tTask, String startDate, String endDate, String stutas, String assigned,String deptId, String isitoverdue,String startsDate,String staDate) {

        if (null != isitoverdue) {
            if (isitoverdue.equals("0")) {
                isitoverdue = "<";
            } else {
                isitoverdue = ">";
            }
        }
        if (null != tTask.getAuditStatus() && "" != tTask.getAuditStatus()) {
            tTask.setAuditStatus(tTask.getAuditStatus().replace("[", "").replace("]", "").replace("\"", ""));
        }
        if (stutas.equals("0")) {
            stutas = null;
        }
        return tTaskMapper.findByAll(tTask, startDate, endDate, isitoverdue, stutas, assigned,deptId,startsDate,staDate);
    }

    @Override
    public String[] countByType() {
        return tTaskMapper.countByType();
    }

    @Override
    public String[] countByName() {
        return tTaskMapper.countByName();
    }


}


