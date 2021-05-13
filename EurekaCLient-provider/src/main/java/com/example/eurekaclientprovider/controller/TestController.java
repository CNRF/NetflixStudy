package com.example.eurekaclientprovider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wmx
 * @version 1.0
 * @date 2021/5/8 15:13
 * @Description
 */
@RestController
@RequestMapping(value = "/provider")
public class TestController {
    @Value("${server.port}")
    private int serverPort = 0;

    @RequestMapping(value = "/providerHello")
    public String sayHello() {
        //url通过服务名去配置，会自动组成域名/ip
        return String.valueOf(serverPort);
    }

    @RequestMapping(value = "/getById")
    public String getById(String id) {
        return String.valueOf(id);
    }

    @RequestMapping(value = "/getMap")
    public Map<Integer, String> getMap(Integer id, String name) {
        return Collections.singletonMap(id, name);
    }

    @PostMapping("/postMap")
    public Map<Integer, String> postMap(@RequestBody Map<String, Object> map) {
        // TODO Auto-generated method stub
        System.out.println(map);
        return Collections.singletonMap(Integer.parseInt(map.get("id").toString()), map.get("name").toString());
    }

    @PostMapping("/postParam")
    public URI postParam(@RequestBody HashMap map, HttpServletResponse response) throws Exception {

        URI uri = new URI("https://www.baidu.com/s?wd=" + map.get("name"));
        response.addHeader("Location", uri.toString());
        return uri;
    }
}