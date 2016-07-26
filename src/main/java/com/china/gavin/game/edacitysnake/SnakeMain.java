package com.china.gavin.game.edacitysnake;

import javax.swing.*;

public class SnakeMain extends JFrame {
	private static final long serialVersionUID = 1L;
	public SnakeMain()
      {
    	  SnakeWin win=new SnakeWin();
    	  this.add(win);
    	  setTitle("Edacity Snake");
    	  setSize(435,390);
    	  setLocation(200,200);
    	  setVisible(true);
      }
      public static void main(String[] args) 
      {
		 new SnakeMain();
	  } 
}
