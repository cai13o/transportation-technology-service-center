package cn.com.busi.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class TMarquee implements Serializable {
    private String id;

    private String context;

    private String status;

    private static final long serialVersionUID = 1L;
}