package com.lhq.yunpicturebackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lhq.yunpicturebackend.mapper")
public class YunPictureBackendApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(YunPictureBackendApplication.class, args);
    }
    
}
