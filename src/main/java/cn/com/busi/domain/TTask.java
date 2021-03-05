package cn.com.busi.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class TTask implements Serializable {
    /**
     * ID
     */
    private String id;

    /**
     * 任务名
     */
    private String name;

    /**
     * 指派人
     */
    private String nominator;

    /**
     * 指派给
     */
    private String assignedTo;

    /**
     * 截止时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
    private Date deadline;

    /**
     * 抄送给
     */
    private String copyTo;

    /**
     * 任务内容
     */
    private String content;

    /**
     * 附件
     */
    private String accessory;

    /**
     * 任务来源
     */
    private String source;

    /**
     * 任务类型
     */
    private String type;

    /**
     * 通知方式
     */
    private String byNotification;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
    private Date createdate;

    /**
     * 实际完成时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date atc;

    /**
     * 任务状态
     */
    private String status;

    /**
     * 满意度
     */
    private String satisfaction;

    /**
     * 评价说明
     */
    private String evaluation;

    /**
     * 任务进度
     */
    private Integer progress;

    /**
     * 科室
     */
    private String dept;

    /**
     * 审核状态
     */
    private String auditStatus;

    /**
     * 审核时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date auditdate;

    /**
     * 审核意见
     */
    private String auditOpinion;

    /**
     * 审核人
     */
    private String auditor;

    private static final long serialVersionUID = 1L;

    private List<TSubtask> SubtaskList;

    private TDept tDept;

    private String disc;

    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
    private Date startdate;
}