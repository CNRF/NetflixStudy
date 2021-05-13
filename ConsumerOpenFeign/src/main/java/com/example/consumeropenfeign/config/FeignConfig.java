package com.example.consumeropenfeign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @author wmx
 * @version 1.0
 * @date 2021/5/11 10:07
 * @Description
 */
@Configuration
public class FeignConfig {
    //重写日志等级,此处需要导入@{import feign.Logger;}的日志包
    @Bean
    Logger.Level logLevel(){

        return Logger.Level.BASIC;
    }
}
