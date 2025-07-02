package com.lhq.yunpicturebackend.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lhq
 * @version 1.0
 * @date 2025/6/18 下午12:26
 * 删除请求通用类
 */
@Data
public class DeleteRequest implements Serializable {
    
    /**
     * id
     */
    private long id;
    
    private final long serialVersionUID = 1L;
}
