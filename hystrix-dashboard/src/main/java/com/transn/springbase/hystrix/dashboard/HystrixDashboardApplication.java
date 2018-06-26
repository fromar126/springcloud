package com.transn.springbase.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 在需要监控的服务上增加依赖，并开启@EnableCircuitBreaker注解
 * 然后访问监控面板，输入对应服务的监控地址
 *
 * @Author bryan.wu
 * @Date 2018/4/28
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class, args);
    }
}
