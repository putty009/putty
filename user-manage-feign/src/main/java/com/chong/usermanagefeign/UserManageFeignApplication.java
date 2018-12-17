package com.chong.usermanagefeign;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
//@EnableDiscoveryClient
@SpringBootApplication
public class UserManageFeignApplication {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    public static void main(String[] args) {
        SpringApplication.run(UserManageFeignApplication.class, args);
    }

    /**
     * 抽样收集的策略：一直为true
     * */
    /*@Bean
    public AlwaysSampler alwaysSampler() {
        return new AlwaysSampler();
    }*/

    /**
     * 抽样收集的策略：自定义包含“test"tag的Span
     * */
    /*@Bean
    public TagSimpler tagSimpler() {
        return new TagSimpler("test");
    }*/

}
