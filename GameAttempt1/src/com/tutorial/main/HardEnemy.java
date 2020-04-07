package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class HardEnemy extends GameObject {
	private Handler handler;
	private Random r = new Random();

	public HardEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		velX = 5;
		velY = 5;
		this.handler = handler;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;

		if (y <= 0 || y >= Game.HEIGHT - 32)
			{
			if (y <= 0)velY = -(r.nextInt(8)+3)*-1;
			else velY = (r.nextInt(8)+3)*-1;
			}
		if (x <= 0 || x >= Game.WIDTH - 16)
			{
			if (x <= 0)velX = -(r.nextInt(8)+1)*-1;
			else velX = (r.nextInt(8)+1)*-1;
			}
		handler.addObject(new Trail(x, y, ID.Trail, Color.pink, 16, 16, 0.03F, handler));
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.pink);
		g.fillRect((int) x, (int) y, 16, 16);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 16, 16);
	}

}