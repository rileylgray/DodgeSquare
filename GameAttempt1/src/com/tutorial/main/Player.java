package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Player extends GameObject {
	Random r = new Random();
	Handler handler;
private BufferedImage playerImage;

	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		Sprite ss=new Sprite(Game.sprite_image);
		playerImage=ss.grabImage(1,1,32,32);
	}

    

	@Override
	public void tick() {
		x += velX;
		y += velY;

		x = Game.clamp(x, 0, Game.WIDTH - 40);
		y = Game.clamp(y, 0, Game.HEIGHT - 65);
		collision();
	}

	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ID.BasicEnemy||tempObject.getId() == ID.FastEnemy
					||tempObject.getId() == ID.SmartEnemy) {
				if (getBounds().intersects(tempObject.getBounds())) {
					HUD.HEALTH -= 2;
				}
			}else if (tempObject.getId() == ID.Boss) {
				if (getBounds().intersects(tempObject.getBounds())) {
					HUD.HEALTH -= 10;
				}
			}
		}
	}

	@Override
	public void render(Graphics g) {

		//g.setColor(Color.white);
		//g.fillRect((int)x, (int)y, 32, 32);
		g.drawImage(playerImage, (int)x, (int)
				y, null);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}

}
