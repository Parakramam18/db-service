package com.raj.stock.dbservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableEurekaClient
@EnableJpaRepositories(basePackages = "com.raj.stock.dbservice.resource")
@SpringBootApplication
public class DbServiceApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(DbServiceApplication.class, args);
    }

}
