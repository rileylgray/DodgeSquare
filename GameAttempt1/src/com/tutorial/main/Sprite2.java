package com.tutorial.main;

import java.awt.image.BufferedImage;

public class Sprite2 {
	private BufferedImage sprite;

	public Sprite2(BufferedImage ss) {
		this.sprite = ss;
	}

	public BufferedImage grabImage(int col, int row, int width, int height) {
		BufferedImage img = sprite.getSubimage((row * 64) - 64, (col * 64) - 64, width, height);
	return img;
	}
}