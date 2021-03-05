package cn.com.busi.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class TContactInfo implements Serializable {
    private String id;

    private String phone;

    private String mail;

    private String telephone;

    private String contacts;

    private String contactsphone;

    private String opflag;

    private Date opdate;

    private static final long serialVersionUID = 1L;
}