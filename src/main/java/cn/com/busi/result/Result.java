package cn.com.busi.result;

import cn.com.busi.domain.TStandardizingSystem;
import cn.com.busi.enums.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.expression.spel.ast.OperatorBetween;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@ApiModel(value = "统一返回数据格式")
public class Result<T> {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private String code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private T data ;

    private Result(){}


    public static Result error(){
        Result r = new Result();
        r.setCode(ResultCodeEnum.UNKNOW_REASON.getCode());
        r.setSuccess(ResultCodeEnum.UNKNOW_REASON.getStatus());
        r.setMessage(ResultCodeEnum.UNKNOW_REASON.getMessage());
        return r;
    }

    public static Result ok(ResultCodeEnum codeEnum,Object data){
        Result r = new Result();
        r.setCode(codeEnum.getCode());
        r.setSuccess(codeEnum.getStatus());
        r.setMessage(codeEnum.getMessage());
        r.setData(data);
        return r;
    }

    public static Result ok(ResultCodeEnum codeEnum){
        Result r = new Result();
        r.setCode(codeEnum.getCode());
        r.setSuccess(codeEnum.getStatus());
        r.setMessage(codeEnum.getMessage());
        return r;
    }

    public static Result error(ResultCodeEnum codeEnum){
        Result r = new Result();
        r.setCode(codeEnum.getCode());
        r.setSuccess(codeEnum.getStatus());
        r.setMessage(codeEnum.getMessage());
        return r;
    }

    public Result data(T data){
        this.setData(data);
        return this;
    }

    public Result message(String message){
        this.setMessage(message);
        return this;
    }

    public Result code(String code){
        this.setCode(code);
        return this;
    }

    public Result success(Boolean success){
        this.setSuccess(success);
        return this;
    }

}
