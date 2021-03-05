package cn.com.busi.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class TItemInfo implements Serializable {
    private String sort;

    private String id;

    private String name;

    private String number;

    private String principal;

    private String dept;

    private String status;

    private String keyword;

    private Date planstartdate;

    private Date planenddate;

    private Date startdate;

    private Date enddate;

    private String planday;

    private String day;

    private String goal;

    private String scope;

    private String creator;

    private Date createdate;

    private String schedule;

    private static final long serialVersionUID = 1L;
}