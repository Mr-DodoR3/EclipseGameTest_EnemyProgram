package Enemy;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

abstract public class Enemy {
	BufferedImage img;
	int x, y;
	int W, H;
	double targetAngle;
	int reload;
	int reload_between;
	char dir = 'l';
	
	public Enemy(int tx, int ty) {
		System.out.println("敵生成");
		x = tx;
		y = ty;
		reload = 0;
	}
	
	public void sizeinit() {
        W = img.getWidth();
        H = img.getHeight();
	}
	
	abstract public void move(int[] player_pos);
	
	abstract public boolean attack();
	public int[] getPos() {
		int[] data = { this.x+W/2, this.y+H/2 };
		return data;
	};
	public double getAngle() { return this.targetAngle; }
	
	public void draw(Graphics g, int[] player_pos) {
		move(player_pos);
		//g.drawImage(img, x, y, null);
		g.drawImage(img, x, y, W+x, H+y, (dir == 'r' ? 0 : W), 0, (dir == 'r' ? W : 0), H, null);
	}
}

//参考https://uguisu.skr.jp/html/java4.html