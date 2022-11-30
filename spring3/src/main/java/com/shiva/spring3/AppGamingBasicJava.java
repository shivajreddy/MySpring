package com.shiva.spring3;

import com.shiva.spring3.game.ContraGame;
import com.shiva.spring3.game.GameRunner;
import com.shiva.spring3.game.MarioGame;


public class AppGamingBasicJava {

	public static void main(String[] args) {
		
		var marioGame = new MarioGame();
		var contraGame = new ContraGame();

		// var gameRunner = new GameRunner(marioGame);
		var gameRunner = new GameRunner(contraGame);

		gameRunner.run();
		
	}

}
