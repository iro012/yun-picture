package com.lhq.yunpicturebackend.exception;

import com.lhq.yunpicturebackend.common.BaseReSponse;
import com.lhq.yunpicturebackend.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author lhq
 * @version 1.0
 * @date 2025/6/18 上午12:01
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    
    @ExceptionHandler(BusinessException.class)
    public BaseReSponse businessExceptionHandler(BusinessException e) {
        log.error("businessException: ", e);
        return ResultUtils.error(e.getCode(), e.getMessage());
    }
    
    @ExceptionHandler(RuntimeException.class)
    public BaseReSponse runtimeExceptionHandler(RuntimeException e) {
        log.error("runtimeException：", e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR, "系统错误");
    }
    
}
