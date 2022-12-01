package com.shiva.mysprin3;

public class MarioGame implements GamingConsole
{
	@Override
	public void up() {
		System.out.println("mario jumps up");
	}
	@Override
	public void down() {
		System.out.println("mario ducks down");
	}
	@Override
	public void left() {
		System.out.println("mario goes left");
	}
	@Override
	public void right() {
		System.out.println("mario ");
	}
}
