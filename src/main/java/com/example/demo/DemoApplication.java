package com.example.demo;


import com.wpj.spring.boot.rocketmq.starter.annotation.EnableRocketMQ;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 此处需要添加扫描包的路径，当前项目扫描路径 + “com.wpj”包
 */
@SpringBootApplication(scanBasePackages = {"com.example.demo", "com.wpj"})
@EnableRocketMQ
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}


