package com.miaodi.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by Useradmin on 2016/8/5.
 */
@SpringBootApplication
public class ApiServer extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApiServer.class);
    }
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApiServer.class, args);
    }
}
