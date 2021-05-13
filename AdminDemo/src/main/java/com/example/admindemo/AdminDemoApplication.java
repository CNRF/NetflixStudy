package com.example.admindemo;

import com.example.admindemo.config.DingDingNotifier;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableAdminServer
@SpringBootApplication
public class AdminDemoApplication {


    @Bean
    public DingDingNotifier dingDingNotifier(InstanceRepository repository) {
        return new DingDingNotifier(repository);
    }
    public static void main(String[] args) {
        SpringApplication.run(AdminDemoApplication.class, args);
    }

}
