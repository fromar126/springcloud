package com.transn.springbase.zuulserver;

import com.transn.springbase.zuulserver.filter.PreFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * 定义一个filter，过滤所有请求
 *
 * @Author bryan.wu
 * @Date 2018/4/28
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulServerApplication {
    public static void main(String[] args) {

        SpringApplication.run(ZuulServerApplication.class, args);
    }

    @Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }
}
