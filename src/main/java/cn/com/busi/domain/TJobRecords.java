package cn.com.busi.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class TJobRecords implements Serializable {
    private Integer id;

    private String eid;

    private Date startdate;

    private Date enddate;

    private String function;

    private String dept;

    private String post;

    private String mark;

    private String opflag;

    private Date opdate;

    private static final long serialVersionUID = 1L;
}