package com.kind1ess.config;

import com.kind1ess.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {

    @Bean
    public HelloService helloService(){
        return new HelloService();
    }
}
