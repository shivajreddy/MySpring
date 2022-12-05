package com.shiva.springboot.learnspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

    private final CurrencyServiceConfiguration config;

    private final DevDbConfiguration config2;

    @Autowired
    public CurrencyController(CurrencyServiceConfiguration config, DevDbConfiguration config2) {
        this.config = config;
        this.config2 = config2;
    }

    @RequestMapping("/currency")
    public String currencyController() {
        return config.getUrl() + " : " + config.getKey() + " : " + config.getUsername();
    }


    @RequestMapping("/devdb")
    public String devDb() {
        return config2.getDbName() + " : " + config2.getDbUsername();
    }

}
