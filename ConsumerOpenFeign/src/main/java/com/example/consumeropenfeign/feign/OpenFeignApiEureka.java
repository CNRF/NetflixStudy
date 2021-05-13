package com.example.consumeropenfeign.feign;

import com.example.openfeignapi.feign.FeignApiProvider;
import org.springframework.cloud.openfeign.FeignClient;


/*
*
* feign配合eureka使用，在eureka中获取provider地址
*   feign默认只有get请求，想要支持需要添加其他依赖
* openfeign集成了http请求
* */
@FeignClient( value="api-provider/provider" ,fallbackFactory = OpenFeignApiEurekaBackFactory.class)
public interface OpenFeignApiEureka extends FeignApiProvider {
}
