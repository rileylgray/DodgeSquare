package com.tutorial.main;


	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.Rectangle;

	public class FastEnemy  extends GameObject {
	private Handler handler;
		public FastEnemy(float x, float y, ID id, Handler handler) {
			super(x, y, id);
			velX=2;
			velY=12;
			this.handler=handler;
		}

		@Override
		public void tick() {
			// TODO Auto-generated method stub
			x +=velX;
			y += velY;
		
		if(y <=0|| y>=Game.HEIGHT-32) velY*=-1;
		if(x <=0|| x>=Game.WIDTH-16) velX*=-1;
	handler.addObject(new Trail (x,y,ID.Trail, Color.green,16,16,0.03F,handler));
		}

		@Override
		public void render(Graphics g) {
			// TODO Auto-generated method stub
			g.setColor(Color.green);
			g.fillRect((int)x,(int)y, 16, 16);
		}
		
		public Rectangle getBounds() {
			return new Rectangle ((int)x,(int)y,16,16);
		}

	}

