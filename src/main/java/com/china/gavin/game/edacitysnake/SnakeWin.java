package com.china.gavin.game.edacitysnake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class SnakeWin extends JPanel implements ActionListener, KeyListener,
		Runnable {

	private static final long serialVersionUID = 1L;

	JButton newGame, stopGame;
	int fenShu = 0, Speed = 0;
	boolean start = false;
	Random r = new Random();
	int rx = 0, ry = 0;
	int temp = 0;
	int tempEat1 = 0;
	int tempEat2 = 0;
	List<SnakeAct> list = new ArrayList<SnakeAct>();

	public SnakeWin() {
		newGame = new JButton("New Game");
		stopGame = new JButton("Stop Game");
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		newGame.addActionListener(this);
		stopGame.addActionListener(this);
		this.addKeyListener(this);
		this.add(newGame);
		this.add(stopGame);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(10, 40, 400, 300);
		g.drawString("Score:" + fenShu, 150, 20);
		g.drawString("Speed:" + Speed, 230, 20);
		g.setColor(new Color(0, 255, 0));
		if (start) {
			g.fillRect(10 + rx * 10, 40 + ry * 10, 10, 10);
			g.setColor(new Color(255, 0, 0));
			for (int i = 0; i < list.size(); i++) {
				g.fillRect(10 + list.get(i).getX() * 10, 40 + list.get(i)
						.getY() * 10, 10, 10);
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newGame) {
			newGame.setEnabled(false);
			stopGame.setEnabled(true);
			start = true;
			rx = r.nextInt(40);
			ry = r.nextInt(30);
			SnakeAct tempAct = new SnakeAct();
			tempAct.setX(20);
			tempAct.setX(15);
			list.add(tempAct);
			this.requestFocus();
			Thread nThread = new Thread(this);
			nThread.start();
			repaint();
		}
		if (e.getSource() == stopGame) {
			stopGame.setEnabled(false);
			newGame.setEnabled(true);
			System.exit(0);
		}
	}

	public boolean minYes(int x, int y) {
		if (!maxYes(x, y)) {
			return false;
		} else {

		}
		return true;
	}

	public boolean maxYes(int x, int y) {
		if (x < 0 || x >= 40 || y < 0 || y >= 30) {
			return false;
		} else {

		}
		return true;
	}

	public void eat() {
		if (rx == list.get(0).getX() && ry == list.get(0).getY()) {
			rx = r.nextInt(40);
			ry = r.nextInt(30);
			SnakeAct tempAct = new SnakeAct();
			tempAct.setX(list.get(list.size() - 1).getX());
			tempAct.setY(list.get(list.size() - 1).getY());
			list.add(tempAct);
			fenShu = fenShu + 100 * Speed;
			tempEat1 += 1;
			if ((tempEat1 - tempEat2) >= 10) {
				tempEat2 = tempEat1;
				if (Speed <= 9) {
					Speed += 1;
				}
			}
		}
	}

	public void otherMove() {
		SnakeAct tempAct = new SnakeAct();
		for (int i = 0; i < list.size(); i++) {
			if (i == 1) {
				list.get(i).setX(list.get(0).getX());
				list.get(i).setY(list.get(0).getY());
			} else if (i > 1) {
				tempAct = list.get(i - 1);
				list.set(i - 1, list.get(i));
				list.set(i, tempAct);
			}
		}
	}

	public void move(int x, int y) {
		if (minYes(list.get(0).getX() + x, list.get(0).getY() + y)) {
			otherMove();
			list.get(0).setX(list.get(0).getX() + x);
			list.get(0).setY(list.get(0).getY() + y);
			eat();
			repaint();
		} else {

		}
	}

	public void keyPressed(KeyEvent e) {
		if (start) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				move(0, -1);
				temp = 1;
				break;
			case KeyEvent.VK_DOWN:
				move(0, 1);
				temp = 2;
				break;
			case KeyEvent.VK_LEFT:
				move(-1, 0);
				temp = 3;
				break;
			case KeyEvent.VK_RIGHT:
				move(1, 0);
				temp = 4;
				break;
			default:
				break;
			}
		}

	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}

	public void run() {
		while (start) {
			switch (temp) {
			case 1:
				move(0, -1);
				break;
			case 2:
				move(0, 1);
				break;
			case 3:
				move(-1, 0);
				break;
			case 4:
				move(1, 0);
				break;
			default:
				move(1, 0);
				break;
			}
			fenShu += 10 * Speed;
			repaint();
			try {
				Thread.sleep(500 - 5 * Speed);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
}
