package com.example.eurekaconsumer.controller;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wmx
 * @version 1.0
 * @date 2021/5/8 15:47
 * @Description
 */
@RestController
@RequestMapping("consumer")
public class TestController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("consumerHello")
    public String sayHello(){
        //使用Eureka服务组名，会自动拼成实际的url
        return restTemplate.getForEntity("http://api-provider/provider/providerHello",String.class).getBody();
    }
    @GetMapping("getById")
    public String getById(String id){
        String url="http://api-provider/provider/getById?id={1}";
        return restTemplate.getForEntity(url,String.class,id).getBody();
    }

    @PostMapping("/postMap")
    public Map<String, Object>  postMap(@RequestParam String id,@RequestParam String name) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        String url="http://api-provider/provider/postMap";
        return restTemplate.postForObject(url,map,HashMap.class);
    }
    @PostMapping("/postParam")
    public void   postMap1(@RequestParam String id, @RequestParam String name, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        String url="http://api-provider/provider/postParam";
        URI uri = restTemplate.postForLocation(url, map, HashMap.class);
        httpServletResponse.sendRedirect(String.valueOf(uri));
    }

}
