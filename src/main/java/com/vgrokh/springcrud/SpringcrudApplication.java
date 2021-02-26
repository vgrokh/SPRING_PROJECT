package com.vgrokh.springcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class SpringcrudApplication {

    public static void main(String[] args) {
        System.getProperties().put( "server.port", System.getenv().get("PORT"));
        SpringApplication.run(SpringcrudApplication.class, args);
    }

}
