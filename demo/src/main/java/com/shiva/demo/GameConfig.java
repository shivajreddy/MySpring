package com.shiva.demo;

import com.shiva.demo.game.ContraGame;
import com.shiva.demo.game.GamingConsole;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {

    @Bean(name = "gaming_console")
    public GamingConsole gamingConsole() {
        return new ContraGame();
    }

}
