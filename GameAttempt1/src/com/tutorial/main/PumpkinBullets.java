package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class PumpkinBullets extends GameObject {

    private Handler handler;

    public PumpkinBullets(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        Random r=new Random();
       velX= r.nextInt((5 - -5) + 1) + -5;
       
        velY = r.nextInt((5 - -5) + 1) + -5;
        
        if(velX==0&&velY==0)
        {
            velX=10;
        }

        this.handler = handler;
    }

    @Override
    public void tick() {
        // TODO Auto-generated method stub
        x += velX;
        y += velY;

       if (y>= Game.HEIGHT) handler.removeObject(this);
	
    }

    @Override
    public void render(Graphics g) {
        // TODO Auto-generated method stub
        g.setColor(Color.red);
        g.fillRect((int) x, (int) y, 16, 16);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

}
