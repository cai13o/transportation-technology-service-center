package cn.com.busi.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class TNewImg implements Serializable {
    private String id;

    private String img;

    private String mark;

    private static final long serialVersionUID = 1L;
}