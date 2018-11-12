package com.tracking_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@EnableAutoConfiguration
@EnableJpaAuditing
@SpringBootApplication
public class Application {

    public static void main(String args[]){
        SpringApplication.run(Application.class,args);
    }
}
