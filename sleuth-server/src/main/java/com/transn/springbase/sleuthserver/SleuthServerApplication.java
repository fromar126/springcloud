package com.transn.springbase.sleuthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * @Author bryan.wu
 * @Date 2018/4/28
 */
@SpringBootApplication
@EnableZipkinServer
public class SleuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SleuthServerApplication.class, args);
    }
}
