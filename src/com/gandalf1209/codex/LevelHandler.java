package com.gandalf1209.codex;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.gandalf1209.codex.scene.Tree;
import com.gandalf1209.yge2.util.CrashHandler;

public class LevelHandler {
	
	private static int enemiesToSpawn;

	public static void load(int level) {
		InputStream in = LevelHandler.class.getResourceAsStream("/levels/" + level + ".level");
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		try {
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split("=");
				if (data[0].equalsIgnoreCase("enemy")) {
					enemiesToSpawn = Integer.parseInt(data[1]);
				}
				if (line.startsWith("[Scene]")) {
					String[] soData = line.split(" ");
					String name = soData[1];
					int x = Integer.parseInt(soData[2]);
					int y = Integer.parseInt(soData[3]);
					int w = Integer.parseInt(soData[4]);
					int h = Integer.parseInt(soData[5]);
					if (name.equals("Tree")) {
						new Tree(x, y, w, h);
					}
				}
			}
			executeLevel();
		} catch (Exception e) {
			CrashHandler.logCrash(e, LevelHandler.class.getClass());
			CrashHandler.printCrash(e, LevelHandler.class.getClass());
		}
	}
	
	public static void executeLevel() {
		for (int i = 0; i < enemiesToSpawn; i++) {
			Enemy.spawn();
		}
	}
	
}