package com.lhq.yunpicturebackend.common;

import com.lhq.yunpicturebackend.exception.ErrorCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lhq
 * @version 1.0
 * @date 2025/6/18 下午12:05
 * 通用响应类
 */
@Data
public class BaseReSponse<T> implements Serializable {
    
    private int code;

    private String message;
    
    private T data;
    
    private final static long serialVersionUID = 1L;
    
    public BaseReSponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    
    public BaseReSponse(int code, T data) {
        this(code, "", data);
    }
    
    public BaseReSponse(ErrorCode errorCode) {
        this(errorCode.getCode(), errorCode.getMessage(), null);
    }
}
