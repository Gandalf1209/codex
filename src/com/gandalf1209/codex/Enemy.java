package com.gandalf1209.codex;

import java.util.ArrayList;
import java.util.List;

import com.gandalf1209.yge2.engine.Mathf;

public class Enemy {

	private int x;
	private int y;
	private int speed;
	private int it;
	
	public static List<Enemy> list = new ArrayList<Enemy>();
	
	public Enemy(int x, int y, int speed) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.it = list.size();
		list.add(this);
	}
	
	public static void spawn() {
		new Enemy(Mathf.random(0, MainGame.WIDTH), Mathf.random(0, MainGame.HEIGHT), Mathf.random(2, 4));
	}
	
	public void movement() {
		if (x < Player.x) {
			x += speed;
		}
		if (x > Player.x) {
			x -= speed;
		}
		if (y < Player.y) {
			y += speed;
		}
		if (y > Player.y) {
			y -= speed;
		}
	}
	
	public void kill() {
		list.remove(it);
		for (int i = it; i < list.size(); i++) {
			Enemy.list.get(i).it--;
		}
		x = 0;
		y = 0;
		speed = 0;
		it = 0;
		System.gc();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getIt() {
		return it;
	}

	public void setIt(int it) {
		this.it = it;
	}
	
}