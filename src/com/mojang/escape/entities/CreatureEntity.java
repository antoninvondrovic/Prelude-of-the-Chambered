package com.mojang.escape.entities;

import com.mojang.escape.Art;

public class CreatureEntity extends EnemyEntity {
	private int shootDelay;

	public CreatureEntity(double x, double z) {
		super(x, z, 5 * 8, Art.getCol(0x82A821));
		this.x = x;
		this.z = z;
		health = 3;
		r = 0.4;
		spinSpeed = 0.1;
	}

	@Override
	protected void hurt(double xd, double zd) {
		super.hurt(xd, zd);
		shootDelay = 25;
	}

	public void tick() {
		super.tick();
		if (shootDelay > 0) shootDelay--;
		else if (random.nextInt(40) == 0) {
			shootDelay = 40;
			level.addEntity(new Bullet(this, x, z, Math.atan2(level.player.x - x, level.player.z - z), 0.3, 1, defaultColor));
		}
	}
}
