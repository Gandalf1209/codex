package com.gandalf1209.codex;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import com.gandalf1209.codex.scene.Scene;
import com.gandalf1209.codex.scene.SceneObject;
import com.gandalf1209.yge2.engine.Application;
import com.gandalf1209.yge2.engine.Game;
import com.gandalf1209.yge2.graphics.Display;
import com.gandalf1209.yge2.graphics.GraphicsX;
import com.gandalf1209.yge2.input.Keys;

public class MainGame implements Game {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static int LEVEL = 1;
	
	public static MainGame main;
	
	private Display d;
	
	public static void main(String[] args) {
		Application.start();
		main = new MainGame();
		main.init();
	}
	
	public void init() {
		d = new Display("Codex - " + Application.VERSION, WIDTH, HEIGHT, this);
		
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
				if (key == Keys.Q || key == Keys.SHIFT) {
					Player.attack();
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
		
		Texture.init();
		
		LevelHandler.load(LEVEL);
		
		d.getWindow().setResizable(false);
		d.getWindow().setVisible(true);
		
		d.start(30);
	}
	
	@Override
	public void render(GraphicsX g) {
		g.setBGColor(g.hex("#72DB92"));
		
		for (int i = 0; i < Scene.list.size(); i++) {
			SceneObject so = Scene.list.get(i);
			BufferedImage img = Texture.getTexture(so.getName());
			g.addImage(img, so.getX(), so.getY(), so.getW(), so.getH());
		}
		
		g.addImage(Texture.getTexture("Player"), Player.x, Player.y, 50, 50);
		
		g.setColor(g.hex("#C2384B"));
		for (int i = 0; i < Enemy.list.size(); i++) {
			Enemy e = Enemy.list.get(i);
			g.fillOval(e.getX(), e.getY(), 50, 50);
		}
	}

	@Override
	public void update() {
		Player.movement();
		for (int i = 0; i < Enemy.list.size(); i++) {
			Enemy e = Enemy.list.get(i);
			e.movement();
		}
	}
	
}