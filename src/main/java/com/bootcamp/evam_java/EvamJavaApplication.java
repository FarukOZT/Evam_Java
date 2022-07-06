package com.bootcamp.evam_java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.bootcamp.evam_java.*")
@EnableJpaRepositories(basePackages = "com.bootcamp.evam_java.repositories")
@SpringBootApplication
public class EvamJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvamJavaApplication.class, args);
    }

}
