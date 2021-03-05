package cn.com.busi.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class TNew implements Serializable {
    private String id;

    private String type;

    private String title;

    private String author;

    private String dept;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
    private Date validity;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date issuedate;

    private String brief;

    private String text;

    private String accessory;

    private String titlepicfile;

    private String auditStatus;

    /**
     * 审核意见
     */
    private String auditOpinion;

    /**
     * 审核人
     */
    private String auditor;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date auditdate;

    private String importance;

    private String newsSource;

    private String disc;

    private String tag;

    private String top;

    private String label;

    private Integer ctr;

    private static final long serialVersionUID = 1L;
}