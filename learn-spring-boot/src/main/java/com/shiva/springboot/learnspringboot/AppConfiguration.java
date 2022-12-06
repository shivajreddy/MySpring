package com.shiva.springboot.learnspringboot;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "app")
@Component
public class AppConfiguration {

    private int port;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        System.out.println("hi");
        this.port = port;
    }
}

