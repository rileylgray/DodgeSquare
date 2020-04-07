package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Bullet extends GameObject {
private Handler handler;
Random r=new Random();
	public Bullet(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		velX=(r.nextInt(5 - -5)+-5);
		velY=5;
		this.handler=handler;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x +=velX;
		y += velY;
	
	if (y>= Game.HEIGHT) handler.removeObject(this);
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.fillRect((int)x,(int)y, 16, 16);
	}
	
	public Rectangle getBounds() {
		return new Rectangle ((int)x,(int)y,16,16);
	}

}
