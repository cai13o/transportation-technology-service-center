package cn.com.busi.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class TResourceCenter implements Serializable {
    private String id;

    private String name;

    private String url;

    private String size;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date opdate;

    private String auditStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date auditdate;

    private String operator;

    private Integer count;

    private String dept;

    /**
     * 审核意见
     */
    private String auditOpinion;

    /**
     * 审核人
     */
    private String auditor;

    private String disc;

    private static final long serialVersionUID = 1L;
}