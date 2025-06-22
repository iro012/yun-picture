package com.lhq.yunpicturebackend.common;

import com.lhq.yunpicturebackend.exception.ErrorCode;

/**
 * @author lhq
 * @version 1.0
 * @date 2025/6/18 下午12:09
 * 通用返回工具类
 */
public class ResultUtils {
    public static <T> BaseReSponse<T> success(T data) {
        return new BaseReSponse<>(0, "ok", data);
    }
    
    public static BaseReSponse error(ErrorCode errorCode) {
        return new BaseReSponse<>(errorCode);
    }
    
    public static BaseReSponse error(ErrorCode errorCode, String message) {
        return new BaseReSponse<>(errorCode.getCode(), message);
    }
    
    public static BaseReSponse error(int code, String message) {
        return new BaseReSponse<>(code, message);
    }
}
