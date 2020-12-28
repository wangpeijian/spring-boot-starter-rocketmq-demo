package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 此处需要添加扫描包的路径，当前项目扫描路径 + “com.wpj”包
 */
@SpringBootApplication(scanBasePackages = {"com.example.demo", "com.wpj"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}


