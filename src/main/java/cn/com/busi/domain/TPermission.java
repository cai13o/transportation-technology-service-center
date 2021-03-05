package cn.com.busi.domain;

import java.io.Serializable;
import lombok.Data;

/**
    * 角色
    */
@Data
public class TPermission implements Serializable {
    /**
    * ID
    */
    private String id;

    /**
    * 名称
    */
    private String name;

    /**
    * 描述
    */
    private String desc;

    /**
    * 路由
    */
    private String route;

    private static final long serialVersionUID = 1L;
}