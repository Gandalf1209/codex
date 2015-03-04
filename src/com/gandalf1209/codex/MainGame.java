package com.gandalf1209.codex;

import com.gandalf1209.yge2.engine.Application;
import com.gandalf1209.yge2.engine.Game;
import com.gandalf1209.yge2.graphics.Display;
import com.gandalf1209.yge2.graphics.GraphicsX;

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
		
		d.getWindow().setResizable(false);
		d.getWindow().setVisible(true);
		
		d.initTime(40);
	}
	
	@Override
	public void render(GraphicsX g) {
		
	}

	@Override
	public void update() {
		
	}
	
}