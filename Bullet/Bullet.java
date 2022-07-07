package Bullet;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

abstract public class Bullet {
	BufferedImage img;
	int x, y;
	double angle;
	int W, H;
	int speed;
	
	public Bullet(int tx, int ty, double tangle) {
		System.out.println("弾生成");
		x = tx;
		y = ty;
		angle = tangle;
	}
	
	public void sizeinit() {
        W = img.getWidth() / 100;
        H = img.getHeight() / 100;
	}
	
	abstract public void move();
	
	public void draw(Graphics g) {
		move();

		g.drawImage(img, x, y, null);
	}
}
