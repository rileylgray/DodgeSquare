package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Boss extends GameObject {
private Handler handler;
Random r=new Random();
private int timer=70;
private int timer2=50;
private int timer3=2000;
private BufferedImage bossImage;


	public Boss(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		velX=0;
		velY=2;
		this.handler=handler;
                 BufferedImageLoader loader = new BufferedImageLoader();
                Sprite2 ss=new Sprite2(loader.loadImage("/Meanie.png"));
		bossImage=ss.grabImage(1,1,96,96);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x +=velX;
		y += velY;
	if (timer<=0) velY=0;
	else timer--;
	
	if(timer<=0)timer2--;
	if(timer2<=0)
	{
		timer3--;
		if(timer3<=0)
		{
			System.out.println ("Hellooooooooooooooooooooooooooooooooooo");
			handler.removeObject(this);
		}
		if(velX==0) velX=3;
		if(velX>0)
			velX+=0.01f;
		if(velX<0)
			velX-=0.01f;
		velX= Game.clamp(velX, -10, 10);
		int spawn=r.nextInt(7);
		if (spawn==0)handler.addObject(new Bullet((int)x+48,(int)y+52,ID.BasicEnemy,handler));
	}
	if(x <=0|| x>=Game.WIDTH-96) velX*=-1;
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(bossImage, (int)x, (int)
				y, null);
	}
	
	public Rectangle getBounds() {
		return new Rectangle ((int)x,(int)y,96,96);
	}

}

