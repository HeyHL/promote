package io.hel.config;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.function.Predicate;

/**
 * helei
 * 2021/11/15 11:34
 * description:
 */
@SuppressWarnings("all")
@EnableOpenApi   // 开启Swagger自定义接口文档
@Configuration   // 相当于Spring配置中的<beans>
public class SwaggerConfig {

    @Value("${spring.profiles.active}")
    private String activeProfiles = "dev";
    @Value("${spring.application.name}")
    private String applicationName = "swagger-mall-demo";

    @Bean   // 相当于Spring 配置中的<bean>
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(getPathSelectors())
                .build();
    }

    // API基础信息定义（就是更新Swagger默认页面上的信息）
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .description("文档描述：更多问题，请联系开发者")
                .contact(new Contact("helei(name)", "(url)", "@qq.com(email)"))
                .version("1.0")
                .build();
    }

    private Predicate<String> getPathSelectors() {
        return this.activeProfiles.toLowerCase().contains("prod") ? PathSelectors.none() : PathSelectors.any();
    }
}