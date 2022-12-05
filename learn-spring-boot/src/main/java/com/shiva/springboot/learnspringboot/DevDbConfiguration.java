package com.shiva.springboot.learnspringboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "dev-db")
@Component
public class DevDbConfiguration {
    private String DbName;
    private String DbUsername;

    public String getDbName() {
        return DbName;
    }

    public void setDbName(String dbName) {
        DbName = dbName;
    }

    public String getDbUsername() {
        return DbUsername;
    }

    public void setDbUsername(String dbUsername) {
        DbUsername = dbUsername;
    }
}
