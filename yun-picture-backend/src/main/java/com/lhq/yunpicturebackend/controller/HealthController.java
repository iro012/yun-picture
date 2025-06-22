package com.lhq.yunpicturebackend.controller;

import com.lhq.yunpicturebackend.common.BaseReSponse;
import com.lhq.yunpicturebackend.common.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lhq
 * @version 1.0
 * @date 2025/6/17 下午11:21
 */
@RestController
public class HealthController {
    
    @GetMapping("/health")
    public BaseReSponse<String> health() {
        return ResultUtils.success("ok");
    }
}
