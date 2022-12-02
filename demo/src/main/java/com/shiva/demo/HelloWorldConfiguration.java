package com.shiva.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age, Address address) {
};

record Address(String address, String city) {
};

record Sex(String sex, String gender) {
};


// # 2. Configure the things that we want spring to manage - @Configuration class
@Configuration
public class HelloWorldConfiguration {

    // #3. Create a bean

    @Bean
    public String name() {
        return "shiva";
    }

    @Bean
    public int age() {
        return 27;
    }

    @Bean(name = "fav-num")
    public int favNum(){
        return 21;
    }

    @Bean
    public Person person() {
        return new Person(name(), age(), address());
    }

    @Bean(name = "my-sex")
    public Sex sex() {
        return new Sex("male", "male");
    }

    @Bean(name = "person-3")
    public Person person3(String name, int age, Address address_3) {
        return new Person(name, age, address_3);
    }

    @Bean(name = "address-1")
    public Address address() {
        return new Address("4506 monument ave", "Richmond");
    }

    @Bean(name = "address-2")
    public Address address2() {
        return new Address("12208 dalton lane", "Glen Allen");
    }

    @Bean(name = "address_3")
    public Address address3() {
        return new Address("404 Stone-ridge", "Gainesville");
    }
}
