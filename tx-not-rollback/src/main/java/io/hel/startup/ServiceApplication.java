package io.hel.startup;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * helei
 * 2021/11/10 11:33
 * description:
 */
@SuppressWarnings("all")
@SpringBootApplication(scanBasePackages = {"io.hel"})
@MapperScan(basePackages = {"io.hel"})
public class ServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }
}
