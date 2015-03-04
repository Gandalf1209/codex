package com.gandalf1209.codex;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.gandalf1209.yge2.engine.Application;
import com.gandalf1209.yge2.engine.Game;
import com.gandalf1209.yge2.graphics.Display;
import com.gandalf1209.yge2.graphics.GraphicsX;
import com.gandalf1209.yge2.input.Keys;

public class MainGame implements Game {

	public static MainGame main;
	
	private Display d;
	
	public static void main(String[] args) {
		Application.start();
		main = new MainGame();
		main.init();
	}
	
	public void init() {
		d = new Display("Codex", 800, 600, this);
		
		d.keyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				
				if (key == Keys.W || key == Keys.UP) {
					Player.mu = true;
				}
				if (key == Keys.A || key == Keys.LEFT) {
					Player.ml = true;
				}
				if (key == Keys.S || key == Keys.DOWN) {
					Player.md = true;
				}
				if (key == Keys.D || key == Keys.RIGHT) {
					Player.mr = true;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
				
				if (key == Keys.W || key == Keys.UP) {
					Player.mu = false;
				}
				if (key == Keys.A || key == Keys.LEFT) {
					Player.ml = false;
				}
				if (key == Keys.S || key == Keys.DOWN) {
					Player.md = false;
				}
				if (key == Keys.D || key == Keys.RIGHT) {
					Player.mr = false;
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				
			}
		});
		
		d.getWindow().setResizable(false);
		d.getWindow().setVisible(true);
		
		d.initTime(40);
	}
	
	@Override
	public void render(GraphicsX g) {
		g.setBGColor(g.hex("#72DB92"));
		g.setColor(g.hex("#13456E"));
		g.fillRect(Player.x, Player.y, 50, 50);
	}

	@Override
	public void update() {
		Player.movement();
	}
	
}