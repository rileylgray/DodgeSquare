package com.tutorial.main;

import static com.tutorial.main.Game.sprite_image;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Boss2 extends GameObject {
private Handler handler;
Random r=new Random();
private int timer=150;
private int timer2=50;
private int timer3=2000;
private BufferedImage bossImage;


	public Boss2(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		velX=0;
		velY=2;
		this.handler=handler;
                BufferedImageLoader loader = new BufferedImageLoader();
                Sprite2 ss=new Sprite2(loader.loadImage("/Pumkin4.png"));
		bossImage=ss.grabImage(1,1,64,64);
	}

	@Override
	public void tick() {
		y += velY;
	if (timer<=0) velY=0;
	else timer--;
	
	if(timer<=0)timer2--;
	if(timer2<=0)
	{
		timer3--;
		if(timer3<=0)
		{
			handler.removeObject(this);
		}
		int spawn=r.nextInt(3);
		if (spawn==0)handler.addObject(new PumpkinBullets((int)x+32,(int)y+32,ID.BasicEnemy,handler));
	}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
                
		g.drawImage(bossImage, (int)x, (int)
				y, null);
	}
	
	public Rectangle getBounds() {
		return new Rectangle ((int)x,(int)y,64,64);
	}

}


