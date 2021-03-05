package cn.com.busi.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class TSubtask implements Serializable {
    /**
     * ID
     */
    private String id;

    /**
     * 任务名
     */
    private String name;

    /**
     * 负责人
     */
    private String principal;

    /**
     * 抄送人
     */
    private String setrecipient;

    /**
     * 截止时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
    private Date deadline;

    /**
     * 权重
     */
    private Double weight;

    /**
     * 占比
     */
    private String proportion;

    /**
     * 父任务ID
     */
    private String tid;

    /**
     * 任务状态
     */
    private String status;

    /**
     * 任务进度
     */
    private Integer progress;

    private String context;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
    private Date startdate;

    private static final long serialVersionUID = 1L;
}