package com.tutorial.main;

import static java.lang.System.out;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Game extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1550691097823471818L;

	public static final int WIDTH = 1000, HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	private boolean running = false;
	private Random r;
	private Handler handler;
	private HUD hud;
	private Spawn spawn;
	private Shop shop;
	private Menu menu;
	public int scores[] = new int[4];
	public static boolean pause = false;
	public int dif = 0;// 0 is normal 1 is hard

	public enum STATE {
		Menu, Game, Help, End, Select, Shop
	};

	public static STATE gameState = STATE.Menu;
	public static BufferedImage sprite_image;

	public Game() {
		readFile();
		handler = new Handler();
		hud = new HUD();
		shop = new Shop(handler, hud);
		this.addKeyListener(new KeyInput(handler, this));
		menu = new Menu(this, handler, hud);
		new Window(WIDTH, HEIGHT, "Game", this);
		this.addMouseListener(menu);
		this.addMouseListener(shop);
		BufferedImageLoader loader = new BufferedImageLoader();
		sprite_image = loader.loadImage("/pixil-frame-0.png");
		spawn = new Spawn(handler, hud, this);
		r = new Random();
		if (gameState == STATE.Game) {
			handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));
			handler.addObject(
					new BasicEnemy((Game.WIDTH - 100), (Game.HEIGHT - 100), ID.BasicEnemy, handler));
		} else {
			for (int i = 0; i < 15; i++) {
				handler.addObject(
						new MenuEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.MenuEnemy, handler));

			}
		}
	


	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {// game loop don't know how it works but very important
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;//how many times tick() method runs a second 
		double ns = 1000000000 / amountOfTicks;// 1sec/60
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();//current time
			delta += (now - lastTime) / ns;//Difference in time between now and previous tick
			lastTime = now;//changing from previous tick to current tick 
			while (delta >= 1) {
				tick();
				render();
				delta--;
			}
			if (running)
				
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	private void tick() {
		if (gameState == STATE.Game) {
			if (!pause) {
				hud.tick();
				spawn.tick();
				handler.tick();

				if (hud.HEALTH <= 0) {
					hud.HEALTH = 100;
					gameState = STATE.End;
					handler.clearEnemys();

				}
			}
		} else if (gameState == STATE.Menu || gameState == STATE.End || gameState == STATE.Select) {
			menu.tick();
			handler.tick();

		}
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		if (pause) {
			g.setColor(Color.white);
			g.drawString("Paused", 100, 100);
		}
		if (gameState == STATE.Game) {
			hud.render(g);
			handler.render(g);

		} else if (gameState == STATE.Shop) {
			shop.render(g);
		} else if (gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End

				|| gameState == STATE.Select) {
			menu.render(g);
			handler.render(g);

		}

		g.dispose();
		bs.show();
	}

	public static float clamp(float var, float min, float max) {
		if (var >= max) {
			return var = max;
		} else if (var <= min) {
			return var = min;
		} else
			return var;
	}

	public static void main(String args[]) {
		new Game();
	}

	public void writeFile() {
		try {
			FileWriter fw = new FileWriter("HighScores.txt");
			PrintWriter pw = new PrintWriter(fw);
			for (int i = 0; i < scores.length; i++) {
				pw.println(scores[i]);
			}
			pw.close();
		} catch (IOException e) {
			out.println("Error");
		}

	}

	public void readFile() {
		int count = 0;
		try {
			FileReader fr = new FileReader("HighScores.txt");
			BufferedReader br = new BufferedReader(fr);

			String str;
			while ((str = br.readLine()) != null) {
				scores[count] = Integer.parseInt(str);
				if (count == 3)
					break;
				count++;
			}
			br.close();

		} catch (IOException e) {
			out.println("Not Found");
		}
	}
}
