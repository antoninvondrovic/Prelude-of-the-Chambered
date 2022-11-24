package com.mojang.escape.level;

import com.mojang.escape.level.block.Block;

public class BackroomsLevel extends Level {
	public BackroomsLevel() {
		floorCol = 0xC6C58B;
		ceilCol = 0xE1E2BB;
		wallCol = 0xE4E6A8;
		name = "The Backrooms";
	}

	protected void decorateBlock(int x, int y, Block block, int col) {
		super.decorateBlock(x, y, block, col);
	}

	protected Block getBlock(int x, int y, int col) {
		return super.getBlock(x, y, col);
	}

	public void switchLevel(int id) {
		if (id == 1) game.switchLevel("overworld", 1);
		if (id == 2) game.switchLevel("dungeon", 1);
	}

	public void getLoot(int id) {
		super.getLoot(id);
	}
}