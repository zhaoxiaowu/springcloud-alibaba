package com.zxw.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SentinelDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelDemoApplication.class, args);
    }

    @RestController
    public class DemoController {

        // 对应的 `handleException` 函数需要位于 `ExceptionUtil` 类中，并且必须为 static 函数.
//        @GetMapping(value = "/test")
//        @SentinelResource(value = "test", blockHandler = "handleException", blockHandlerClass = {ExceptionUtil.class})
//        public String test() {
//            return "test";
//        }


        // 原函数s
        @GetMapping(value = "/hello")
        @SentinelResource(value = "hello", blockHandler = "exceptionHandler", fallback = "helloFallback")
        public String hello(String s) {
            return "Hello at";
        }

        // Fallback 函数，函数签名与原函数一致或加一个 Throwable 类型的参数.
        public String helloFallback(String s) {
            return String.format("Halooooo %d");
        }

        // Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
        public String exceptionHandler(String s,BlockException ex) {
            // Do some log here.
            ex.printStackTrace();
            return "Oops, error occurred at ";
        }

        @GetMapping(value = "/white")
        public String white() {
            return "white";
        }
    }
}
