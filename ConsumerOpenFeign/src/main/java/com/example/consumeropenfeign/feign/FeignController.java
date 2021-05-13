package com.example.consumeropenfeign.feign;

import com.example.consumeropenfeign.pojo.ToEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wmx
 * @version 1.0
 * @date 2021/5/10 21:23
 * @Description
 */
@RestController
public class FeignController {
    @Autowired
    private FeignApi feignApi;
    @Autowired
    private OpenFeignApiEureka feignApiEureka;




/*    @GetMapping("/fegin")
    public String fegin(){
        String provider = feignApi.provider();
        return provider;
    }
    @GetMapping("/feginGetById")
    public String feginGetById(String id){
        //  在此处一定要对应好远程调用的参数，不然无法传递
        String provider = feignApi.providerGetById(id);
        return provider;
    }*/

    @GetMapping("/feginEureka")
    public String feginEureka(){
        String provider = feignApiEureka.provider();
        return provider;
    }


    @GetMapping(value = "/getMap")
    public Map<Integer,String> getMap(@RequestParam("id") Integer id, @RequestParam("name") String name){
        return feignApiEureka.getMap(id,name);
    };

    @PostMapping("/postMap")
    public Map<Integer, String> postMap(Integer id,String name){
        HashMap<String, Object> map = new HashMap<>();
        map.put(String.valueOf(id),name);
        System.out.println(map);
        return feignApiEureka.postMap(map);
    };

    @GetMapping("/map4")
    public Map<Integer, String> map4(@RequestParam Map<String, Object> map) {

        System.out.println(map);
        return feignApiEureka.postMap(map);
    }
}
