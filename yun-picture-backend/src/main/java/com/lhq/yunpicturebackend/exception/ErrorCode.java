package com.lhq.yunpicturebackend.exception;

import lombok.Getter;

/**
 * @author lhq
 * @version 1.0
 * @date 2025/6/17 下午11:43
 * 全局错误码枚举类
 */
@Getter
public enum ErrorCode {
    SUCCESS(0, "ok"),
    PARAMS_ERROR(40000, "请求参数错误"),
    NOT_LOGIN_ERROR(40100, "账号未登录"),
    NO_AUTH_ERROR(40101, "无权限"),
    NOT_FOUND_ERROR(40400, "请求数据不存在"),
    SYSTEM_ERROR(50000, "系统错误"),
    OPERATION_ERROR(50001, "操作失败");
    
    /**
     * 状态码
     */
    private final int code;
    
    /**
     * 错误信息
     */
    private final String message;
    
    
    
    ErrorCode(int code, String message) {
        this.message = message;
        this.code = code;
    }
}
