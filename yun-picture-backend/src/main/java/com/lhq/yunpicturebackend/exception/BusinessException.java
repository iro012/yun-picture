package com.lhq.yunpicturebackend.exception;

import lombok.Getter;

/**
 * @author lhq
 * @version 1.0
 * @date 2025/6/17 下午11:53
 * 自定义业务异常类
 */
@Getter
public class BusinessException extends RuntimeException{
    
    /**
     * 错误码
     */
    private final int code;
    
    
    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }
    
    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }
    
    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }
}
