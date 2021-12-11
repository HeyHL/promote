package io.hel.config;

import com.github.pagehelper.PageInterceptor;
import io.hel.interceptor.MyPageInterceptor;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * helei
 * 2021/11/9 17:52
 * description:
 */
@SuppressWarnings("all")
@Configuration
public class MybatisConfig {


//    @Bean
//    @Order(Integer.MIN_VALUE)
    public PageInterceptor pageInterceptor() {
        return new PageInterceptor();
    }

    @Bean
    public MyPageInterceptor myPageInterceptor() {
        return new MyPageInterceptor();
    }

}
