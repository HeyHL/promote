package io.hel.startup;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * helei
 * 2021/11/25 13:47
 * description:
 */
@SuppressWarnings("all")
@SpringBootApplication(scanBasePackages = {"io.hel"})
@MapperScan(basePackages = {"io.hel.mapper"})
public class RegionServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RegionServiceApplication.class, args);
    }
}
