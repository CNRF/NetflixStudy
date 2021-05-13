package com.example.consumeropenfeign.feign;


//import com.example.openfeignapi.feign.FeignApiProvider;
import org.springframework.cloud.openfeign.FeignClient;


/*
*
* feign单独使用，没有使用Eureka
* */
@FeignClient(name = "xxx",url= "http://localhost:9110/provider")
public interface FeignApi  {

}
