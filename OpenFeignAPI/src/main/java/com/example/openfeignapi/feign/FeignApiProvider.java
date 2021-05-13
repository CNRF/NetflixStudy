package com.example.openfeignapi.feign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author wmx
 * @version 1.0
 * @date 2021/5/12 11:17
 * @Description
 */
public interface FeignApiProvider {
    @GetMapping("/providerHello")
    public String provider();


    @GetMapping("/getById")
    //此处GetMapping是指定发送到远程服务的请求方式为get，指明url的请求方式
    public String providerGetById(String id);

    @GetMapping(value = "/getMap")
    public Map<Integer,String> getMap(@RequestParam("id") Integer id, @RequestParam("name") String name);

    @PostMapping("/postMap")
        //post请求需要在api和服务接收方都需要添加@RequestBody/@RequestParam注解，否则参数无法传递
    Map<Integer, String> postMap(@RequestBody Map<String, Object> map);
}
