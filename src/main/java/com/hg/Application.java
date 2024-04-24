package com.hg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName Application
 * @Author dhg
 * @Version 1.0
 * @Date 2024/4/24 10:36
 * @Description:
 */

@SpringBootApplication(scanBasePackages = {"com.hg.*"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
