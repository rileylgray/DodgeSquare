package com.tutorial.main;


	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;


	public class Boss3  extends GameObject {
	private Handler handler;
	private GameObject player;
        private BufferedImage bossImage;
        private int timer3=2000;


		public Boss3(float x, float y, ID id, Handler handler) {
			super(x, y, id);
			this.handler=handler;
                          BufferedImageLoader loader = new BufferedImageLoader();
                Sprite2 ss=new Sprite2(loader.loadImage("/ghost.png"));
		bossImage=ss.grabImage(1,1,64,64);
for(int i=0;i<handler.object.size();i++) {
	if(handler.object.get(i).getId()==ID.Player) player= handler.object.get(i);
}
			velX=5;
			velY=5;
		}

		@Override
		public void tick() {
			// TODO Auto-generated method stub
                        timer3--;
                        if(timer3==1300)
                        {
                        	handler.removeObject(this);
                        }
			x +=velX;
			y += velY;
		float diffX=x-player.getX()-8;
		float diffY=y-player.getY()-8;
		float distance= (float)Math.sqrt((x-player.getX())*(x-player.getX())+(y-player.getY())*(y-player.getY()));
		velX=(float) ((-4.0/distance)*diffX);
		velY=(float) ((-4.0/distance)*diffY);

		
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


