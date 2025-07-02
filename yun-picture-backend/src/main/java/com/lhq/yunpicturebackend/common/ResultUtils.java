package com.lhq.yunpicturebackend.common;

import com.lhq.yunpicturebackend.exception.ErrorCode;

/**
 * @author lhq
 * @version 1.0
 * @date 2025/6/18 下午12:09
 * 通用返回工具类
 */
public class ResultUtils {
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0, data, "ok");
    }
    
    public static BaseResponse error(ErrorCode errorCode) {
        return new BaseResponse<>(errorCode);
    }
    
    public static BaseResponse error(ErrorCode errorCode, String message) {
        return new BaseResponse<>(errorCode.getCode(), message);
    }
    
    public static BaseResponse error(int code, String message) {
        return new BaseResponse<>(code,null ,message);
    }
}
