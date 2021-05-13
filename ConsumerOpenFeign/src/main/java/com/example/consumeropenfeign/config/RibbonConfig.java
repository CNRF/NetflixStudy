package com.example.consumeropenfeign.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wmx
 * @version 1.0
 * @date 2021/5/11 15:24
 * @Description
 */
@Configuration
public class RibbonConfig {
    /*
    *
    *设置ribbon的全局策略
    * */
    @Bean
    public IRule ribbonRUlle(){
        return new RetryRule();
    }
}
