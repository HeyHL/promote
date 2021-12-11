package io.hel.startup;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * helei
 * 2021/11/10 10:42
 * description:
 */
@SuppressWarnings("all")
@SpringBootApplication(scanBasePackages = {"io.hel"})
@MapperScan(basePackages = {"io.hel.mapper"})
@Slf4j
public class ServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("spring application name->{}", System.getProperty("spring.application.name"));
    }
}
