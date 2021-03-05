package cn.com.busi.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class TWorkInfo implements Serializable {
    private String id;

    private String jobno;

    private String institution;

    private String dept;

    private String superior;

    private String post;

    private String function;

    private String workplace;

    private String account;

    private String password;

    private String rank;

    private String opflag;

    private Date opdate;

    private static final long serialVersionUID = 1L;
}