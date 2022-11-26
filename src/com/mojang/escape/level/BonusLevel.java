package com.mojang.escape.level;

import com.mojang.escape.level.block.Block;

public class BonusLevel extends Level {
	public BonusLevel() {
		name = "The Prison";
	}

	protected void decorateBlock(int x, int y, Block block, int col) {
		super.decorateBlock(x, y, block, col);
	}

	protected Block getBlock(int x, int y, int col) {
		return super.getBlock(x, y, col);
	}

	public void switchLevel(int id) {
		if (id == 1) game.switchLevel("dust", 1);
	}

	public void getLoot(int id) {
		super.getLoot(id);
	}
}