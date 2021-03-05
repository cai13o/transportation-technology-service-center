package cn.com.busi.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class TEmp implements Serializable {
    private String id;

    private String name;

    private String beforename;

    private String idcard;

    private String sex;

    private Date birthdate;

    private String nation;

    private String political;

    private Date leaguetime;

    private Date partytime;

    private String education;

    private String degree;

    private String marriage;

    private String healthy;

    private String stature;

    private String weight;

    private String presentAddress;

    private String natives;

    private String birthplace;

    private String householdType;

    private String householdAddress;

    private String householdPolice;

    private Date reporttime;

    private Date jobtime;

    private String seniority;

    private String firmSeniority;

    private String accessory;

    private String opflag;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date opdate;

    private String username;

    private String dept;

    private String password;

    private String jobs;

    private String jobno;

    private String state;

    private String operator;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startdate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date enddate;

    private TJobs tJobs;

    private String img;

    private static final long serialVersionUID = 1L;
}