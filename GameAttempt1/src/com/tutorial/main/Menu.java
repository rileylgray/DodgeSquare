package com.tutorial.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Random;

import com.tutorial.main.Game.STATE;

public class Menu extends MouseAdapter {
	private Game game;
	private Handler handler;
	private Random r = new Random();
	private HUD hud;
	private int count=0;
	private int count2=0;
	String build="";

	public Menu(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;
	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();// x mouse position
		int my = e.getY();// y mouse position
		if (game.gameState == STATE.Menu) {
			// play button
			if (mouseOver(mx, my, 210, 150, 200, 64)) {
				
				game.gameState=STATE.Select;
return;
			}
			// quit button
			if (game.gameState == STATE.Menu && mouseOver(mx, my, 210, 350, 200, 64)) {
				System.exit(0);
			}
			// help button
			if (mouseOver(mx, my, 210, 250, 200, 64)) {
				game.gameState = STATE.Help;
			}
		}
		if (game.gameState == STATE.Help) {
			// back button for help
			if (game.gameState == STATE.Help && mouseOver(mx, my, 210, 350, 200, 64)) {
				game.gameState = STATE.Menu;
				return;
			}
		}

		// try again
		if (game.gameState == STATE.End && mouseOver(mx, my, 210, 350, 200, 64)) {
			Game g;		
			game.writeFile();

			System.exit(1);

			/*count=0;
			count2=0;
			build="";
			game.gameState = STATE.Menu;
			hud.setScore(0);
			hud.setLevel(1);*/
			
		}
		if (game.gameState == STATE.Select) {
			// normal button
			if (mouseOver(mx, my, 210, 150, 200, 64)) {
				Game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));

				handler.clearEnemys();

				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy,
						handler));
				game.dif=0;

			}
			// back button for diffuculty
			if (game.gameState == STATE.Select && mouseOver(mx, my, 210, 350, 200, 64)) {
				game.gameState = STATE.Menu;
				return;
			}
			// hard button
			if (mouseOver(mx, my, 210, 250, 200, 64)) {
				Game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));

				handler.clearEnemys();

				handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy,
						handler));
				game.dif=1;
				
			}
		}
	}

	public void mouseRelased(MouseEvent e) {

	}

	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if (mx > x && mx < x + width)// checks if mouse is inside specified coordinates
			if (my > y && my < y + height) {
				return true;
			} else {
				return false;
			}
		else
			return false;
	}

	public void tick() {

	}

	public void render(Graphics g) {
		if (game.gameState == STATE.Menu)// main menu
		{
			Font fnt = new Font("arial", 1, 50);// changes font

			g.setFont(fnt);
			g.setColor(Color.white);// making buttons
			g.drawString("Menu", 240, 70);

			g.drawRect(210, 150, 200, 64);
			g.drawString("Play", 260, 200);

			g.drawRect(210, 250, 200, 64);
			g.drawString("Help", 260, 300);

			g.drawRect(210, 350, 200, 64);
			g.drawString("Quit", 260, 400);
		} else if (game.gameState == STATE.Help)// help menu
		{
			Font fnt = new Font("arial", 1, 50);// changes font

			g.setFont(fnt);
			g.setColor(Color.white);// making buttons
			g.drawString("Help", 240, 70);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 270, 390);
			Font fnt2 = new Font("arial", 1, 16);// changes font

			g.setFont(fnt2);
			g.drawString("USE WASD KEYS to move and Dodge, P to pause and space for Upgrades", 50, 250);
		} else if (game.gameState == STATE.End)// help menu
		{
			if(count==0)
			{
			
					game.scores[0]=(hud.getScore());					
				      Arrays.sort(game.scores);

						int index=1;

			for(int i=3; i>0;i--)
			{  
				build+= (index)+". "+game.scores[i]+" ";
				index++;
			}
			}
			count=1;

			Font fnt = new Font("arial", 1, 40);// changes font
			g.setFont(fnt);
			g.setColor(Color.white);// making buttons
			g.drawString("Game Over", 240, 70);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Quit", 230, 390);
			g.drawString("You Lost With A Score of: " + hud.getScore(), 50, 300);
			g.drawString("HighScore: "+build , 50, 140);

		}else if (game.gameState == STATE.Select)// main menu
		{
			Font fnt = new Font("arial", 1, 50);// changes font

			g.setFont(fnt);
			g.setColor(Color.white);// making buttons
			g.drawString("Select Diffculty", 240, 70);

			g.drawRect(210, 150, 200, 64);
			g.drawString("Normal", 230, 200);

			g.drawRect(210, 250, 200, 64);
			g.drawString("Hard", 260, 300);

			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 260, 400);
		} 
	}
}
