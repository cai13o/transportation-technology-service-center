package cn.com.busi.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class TJobs implements Serializable {
    private String id;

    private String name;

    private String introduction;

    private String stutas;

    private Integer number;

    private String opflag;

    private Date opdate;

    private String dept;

    private TDept tDept;

    private static final long serialVersionUID = 1L;

}