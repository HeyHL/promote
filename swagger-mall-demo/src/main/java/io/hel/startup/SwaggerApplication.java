package io.hel.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * helei
 * 2021/11/15 11:47
 * description:
 */
@SuppressWarnings("all")
@SpringBootApplication(scanBasePackages = {"io.hel"})
//@
public class SwaggerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SwaggerApplication.class, args);
    }
}
