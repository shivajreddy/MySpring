package com.shiva.demo.app6;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

// @Component
@Named
class DataService {

}

// @Component
@Named
class BusinessService {
    private DataService dataService;

    public DataService getDataService() {
        return dataService;
    }

    // @Autowired
    @Inject
    public void setDataService(DataService dataService) {
        this.dataService = dataService;
        System.out.println("finished wiring dependencies");
    }
}


@Configuration
@ComponentScan
public class App6Main {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(App6Main.class)) {
            System.out.println("app 6 main");

            System.out.println(context.getBean(BusinessService.class).getDataService());
        }

    }
}
