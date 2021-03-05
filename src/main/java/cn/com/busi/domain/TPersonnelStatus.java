package cn.com.busi.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class TPersonnelStatus implements Serializable {
    private String id;

    private String traffState;

    private String category;

    private String jobNature;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date boarddate;

    private String term;

    private Date positiveDate;

    private String trialPeriod;

    private Date trialenddate;

    private String opflag;

    private Date opdate;

    private static final long serialVersionUID = 1L;
}