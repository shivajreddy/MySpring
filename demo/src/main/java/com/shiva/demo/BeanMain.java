package com.shiva.demo;

import com.shiva.demo.game.ContraGame;
import com.shiva.demo.game.GameRunner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanMain {
    public static void main(String[] args) {
        System.out.println("java bean");

        // ContraGame contra = new ContraGame();
        // GameRunner runner = new GameRunner(contra);
        // runner.run();

        // # 1.Launch "Spring Context"
        // # 2. Configure the things that we want spring to manage - @Configuration class
        // #3. Create a bean
        // # 4. Retrieving Beans managed by Spring

        // # 1.Launch "Spring Context"
        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        // # 4. Retrieving Beans managed by Spring
        System.out.println(context.getBean("name"));

    }
}
