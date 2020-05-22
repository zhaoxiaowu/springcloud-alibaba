package com.zxw.nacoscustomer;

import com.zxw.nacoscustomer.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosCustomerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosCustomerFeignApplication.class, args);
    }

    @RestController
    public class NacosController{

        @Autowired
        private EchoService echoService;

        @GetMapping("/testfeign")
        public String echoAppName(){
            return echoService.echo("hello feign");
        }

    }
}
