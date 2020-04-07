package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Warning extends GameObject {
private Handler handler;
private int timer=100;
	public Warning(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		velX=0;
		velY=0;
		this.handler=handler;
	}

	@Override
	public void tick() {

		timer--;
		if(timer<=0)
		{
			handler.removeObject(this);
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		if(timer%10>=0 &&timer%10<=5)
		{
		g.setColor(Color.red);
		g.drawRect((int)x,(int)y, 16, 16);
		}else {
			g.setColor(Color.white);
		g.drawRect((int)x,(int)y, 16, 16);
	}
	}
	
	public Rectangle getBounds() {
		return new Rectangle ((int)x,(int)y,16,16);
	}

}
