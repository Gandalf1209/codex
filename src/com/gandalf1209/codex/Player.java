package com.gandalf1209.codex;

public class Player {

	public static int x = 100;
	public static int y = 100;
	public static int speed = 5;
	
	public static boolean mr;
	public static boolean ml;
	public static boolean md;
	public static boolean mu;
	
	public static void movement() {
		if (mr) {
			x += speed;
		}
		if (ml) {
			x -= speed;
		}
		if (md) {
			y += speed;
		}
		if (mu) {
			y -= speed;
		}
	}
	
	public static void attack() {
		for (int i = 0; i < Enemy.list.size(); i++) {
			Enemy e = Enemy.list.get(i);
			if (e.getX() + 100 > x &&
					e.getX() - 100 < x &&
					e.getY() + 100 > y &&
					e.getY() - 100 < y) {
				e.kill();
			}
		}
	}
	
}