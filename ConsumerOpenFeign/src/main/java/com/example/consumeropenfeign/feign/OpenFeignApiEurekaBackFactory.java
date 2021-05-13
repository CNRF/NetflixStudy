package com.example.consumeropenfeign.feign;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author wmx
 * @version 1.0
 * @date 2021/5/12 14:31
 * @Description
 */
@Component
public class OpenFeignApiEurekaBackFactory implements FallbackFactory<OpenFeignApiEureka> {
    @Override
    public OpenFeignApiEureka create(Throwable throwable) {
        return new OpenFeignApiEureka() {
            //当远程服务调用出现错误时，hystrix会调用此处方法返回给前端请求（类似于try catch的异常处理机制）
            @Override
            public String provider() {
                return "服务熔断了";
            }

            @Override
            public String providerGetById(String id) {
                return null;
            }

            @Override
            public Map<Integer, String> getMap(Integer id, String name) {
                return null;
            }

            @Override
            public Map<Integer, String> postMap(Map<String, Object> map) {
                return null;
            }
        };
    }
}
