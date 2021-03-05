package cn.com.busi.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class TIsomericSystem implements Serializable {
    private Integer id;

    private String name;

    private String url;

    private String img;

    private static final long serialVersionUID = 1L;
}