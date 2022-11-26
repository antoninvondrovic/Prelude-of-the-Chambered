package com.mojang.escape.level;

import com.mojang.escape.entities.Item;

public class DustLevel extends Level {
	public DustLevel() {
		ceilTex = -1;
		floorCol = 0x508253;
		floorTex = 8 * 3;
		wallCol = 0xa0a0a0;
		name = "The Island";
	}

	public void switchLevel(int id) {
		if (id == 1) game.switchLevel("bonus", 1);
	}

	public void getLoot(int id) {
		super.getLoot(id);
		if (id == 1) game.getLoot(Item.powerGlove);
	}
}