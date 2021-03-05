package cn.com.busi.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class TFamilyInfo implements Serializable {
    private Integer id;

    private String eid;

    private String relation;

    private String name;

    private String unit;

    private String profession;

    private String phone;

    private String mark;

    private String opflag;

    private Date opdate;

    private static final long serialVersionUID = 1L;
}