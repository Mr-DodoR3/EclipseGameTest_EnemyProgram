package Game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import Bullet.Bullet;
import Bullet.NomalBullet;
import Enemy.Cat;
import Enemy.Enemy;

public class MainCanvas extends Canvas implements Runnable, MouseMotionListener {
	private Graphics ct;
	
	int x = 10;
	int playerX, playerY;
    private Thread thread;
    
    List<Enemy> enemy = new ArrayList<Enemy>();
    List<Bullet> bullet = new ArrayList<Bullet>();
    
	public MainCanvas() {    	
    	System.out.println("OK");
    	
        setBackground(Color.white);
        addMouseMotionListener(this);
        
        thread = new Thread(this);
        thread.start();
        
        enemy.add(new Cat(500, 300));
	}
	
	public void init() {

	}
	
	public void update(Graphics g) {
		paint(g);
	}

    public void paint(Graphics g) {
    	MainFlame.buf = createImage(960, 640);
		ct = MainFlame.buf.getGraphics();
		
		int[] player_pos = { playerX, playerY };
		for (Enemy e : enemy) {
			e.draw(ct, player_pos);
			if (e.attack()) bullet.add(new NomalBullet(e.getPos()[0], e.getPos()[1], e.getAngle()));
		}
		for (Bullet b : bullet) {
			b.draw(ct);
		}

		ct.fillOval(playerX, playerY, 10, 10);
		g.drawImage(MainFlame.buf, 0, 0, this);
    }

	@Override
	public void run() {
        while (true) {
        	repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		playerX = e.getX() - 5;
		playerY = e.getY() - 5;
		//repaint();
		
	}
}
