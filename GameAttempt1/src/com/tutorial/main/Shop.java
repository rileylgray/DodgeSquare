package com.tutorial.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.tutorial.main.Game.STATE;

public class Shop extends MouseAdapter {

	Handler handler;
	HUD hud;
	private int B1 = 500;
	private int B2 = 500;
	private int B3 = 100;

	public Shop(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("Arial", 0, 48));
		g.drawString("Shop", Game.WIDTH / 2, 50);

		// box1
		g.setFont(new Font("Arial", 0, 12));
		g.drawRect(100, 100, 100, 80);
		g.drawString("Upgrade Health", 110, 120);
		g.drawString("Cost: " + B1, 110, 140);
		// box2
		g.drawRect(250, 100, 100, 80);
		g.drawString("Upgrade Speed", 260, 120);
		g.drawString("Cost: " + B2, 260, 140);
		// box3
		g.drawRect(400, 100, 100, 80);
		g.drawString("Refil Health", 410, 120);
		g.drawString("Cost: " + B3, 410, 140);

		g.drawString("Score: " + hud.getScore(), 0, 50);
		g.drawString("Press Space to go back", 0, 20);
	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();// x mouse position
		int my = e.getY();// y mouse position
if(Game.gameState==STATE.Shop)
{
		if (mx >= 100 && mx <= 200) {// box 1
			if (my >= 100 && my <= 180) {
				if (hud.getScore() >= B1) {
					hud.setScore(hud.getScore() - B1);
					hud.bounds += 20;
					hud.HEALTH = (200 + (hud.bounds / 2));
					B1+=100;
				}
			}

		}
		if (mx >= 250 && mx <= 350) {// box 2
			if (my >= 100 && my <= 180) {
				if (hud.getScore() >= B2) {
					hud.setScore(hud.getScore() - B2);
					handler.speed+=2;
					B2+=300;
				}
			}

		}
		if (mx >= 400 && mx <= 500) {// box 3
			if (my >= 100 && my <= 180) {
				if (hud.getScore() >= B3) {
					hud.setScore(hud.getScore() - B3);
					
					hud.HEALTH = (100 + (hud.bounds / 2));
				}
			}

		}
}
	}
}