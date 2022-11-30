package com.shiva.spring3;

import com.shiva.spring3.game.ContraGame;
import com.shiva.spring3.game.GameRunner;
import com.shiva.spring3.game.MarioGame;
import com.shiva.spring3.game.PacmanGame;


public class AppGamingBasicJava {

	public static void main(String[] args) {
		
		var marioGame = new MarioGame();
		var contraGame = new ContraGame();
		var pacmanGame = new PacmanGame();

		var gameRunner = new GameRunner(marioGame);
		var gameRunner2 = new GameRunner(contraGame);
		var gameRunner3 = new GameRunner(pacmanGame);

		// gameRunner.run();
		// gameRunner2.run();
		gameRunner3.run();
		
	}

}
