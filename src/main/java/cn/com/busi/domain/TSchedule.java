package cn.com.busi.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class TSchedule implements Serializable {
    /**
     * ID
     */
    private String id;

    /**
     * 上下文
     */
    private String context;

    /**
     * 日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date time;

    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date startdate;

    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date enddate;

    /**
     * 所有者
     */
    private String owner;

    /**
     * 重复类型
     */
    private String repeatTypes;

    /**
     * 提醒设置
     */
    private String remindSet;

    /**
     * 关联URL
     */
    private String associatedUrl;

    /**
     * 地点
     */
    private String site;

    /**
     * 活动性质
     */
    private String activities;

    /**
     * 可阅读者
     */
    private String reader;

    /**
     * 可编辑者
     */
    private String editors;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 附件
     */
    private String accessory;

    /**
     * 状态
     */
    private String status;

    /**
     * eid
     */
    private String eid;

    private static final long serialVersionUID = 1L;
}