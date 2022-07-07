package Enemy;

import java.io.File;

import javax.imageio.ImageIO;

import Game.MainFlame;

public class Cat extends Enemy {

	public Cat(int tx, int ty) {
		super(tx, ty);
		try {
			img = ImageIO.read(new File(MainFlame.path + "\\src\\Image\\Cat.png"));
		}
		catch (Exception e) {
			System.out.println("Error");
		}
		reload_between = 50;
		sizeinit();
	}

	@Override
	public void move(int[] player_pos) {
		// TODO 自動生成されたメソッド・スタブ
		dir = (x + W /2 < player_pos[0] ? 'r' : 'l');
		
		targetAngle = Math.atan2(player_pos[1] - this.y, player_pos[0] - this.x);
	}

	@Override
	public boolean attack() {
		reload++;
		System.out.println(reload);
		
		if (reload > reload_between) {
			reload = 0;
			return true;
		}
		else return false;
	}

}
