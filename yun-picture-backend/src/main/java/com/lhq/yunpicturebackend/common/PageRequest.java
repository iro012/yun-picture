package com.lhq.yunpicturebackend.common;

import lombok.Data;

/**
 * @author lhq
 * @version 1.0
 * @date 2025/6/18 下午12:19
 * 分页请求通用类
 */
@Data
public class PageRequest {
    /**
     * 当前页号
     */
    private long current = 1;
    
    /**
     * 页面大小
     */
    private long size = 10;
    
    /**
     * 排序字段
     */
    private String sortField;
    
    /**
     * 排序顺序（默认降序）
     */
    private String sortOrder = "descend";
}
