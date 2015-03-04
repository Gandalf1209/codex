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
	
}