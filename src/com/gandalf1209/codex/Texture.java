package com.gandalf1209.codex;

import java.awt.image.BufferedImage;

import com.gandalf1209.yge2.graphics.GraphicsLoader;

public class Texture {

	private static GraphicsLoader gl = new GraphicsLoader();
	
	public static void init() {
		gl.setDefaultLoadingDirectory("/textures/");
	}
	
	public static BufferedImage getTexture(String name) {
		BufferedImage img = null;
		img = gl.loadGraphic(name + ".png");
		if (img == null)
			img = gl.loadGraphic("Missing.png");
		return img;
	}
	
}