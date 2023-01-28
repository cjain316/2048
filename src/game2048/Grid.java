package game2048;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Grid {
	private int[][] grid;
	private Color[] colors = new Color[12];
	private Font font = new Font(Font.DIALOG_INPUT, Font.BOLD, 24);
	
	public Grid() {
		grid = new int[4][4];
		
		for (int a = 0; a < grid.length;a++) {
			for (int b = 0; b < grid[0].length;b++) {
				grid[a][b] = 0;
			}
		}
		for (int i = 0; i < 4;i++) {
			generateNew();
		}
	}
	
	public int getLength()      {return grid.length;}
	public int getHeight()      {return grid[0].length;}
	public int getValue(int x, int y)      {return grid[x][y];}
	
	public void setValue(int x, int y, int val)   {grid[x][y] = val;}
	
	public void paint(Graphics g) {
		g.setFont(font);
		for (int i = 0; i < 4;i++) {
			for (int a = 0; a < 4; a++) {
				//colors
				if (grid[i][a]==0) {g.setColor(new Color(250,250,250));}
				if (grid[i][a]==2) {g.setColor(new Color(250,165,37));}
				if (grid[i][a]==4) {g.setColor(new Color(255, 209, 84));}
				if (grid[i][a]==8) {g.setColor(new Color(255, 186, 0));}
				if (grid[i][a]==16) {g.setColor(new Color(235, 78, 0));}
				if (grid[i][a]==32) {g.setColor(new Color(255, 96, 82));}
				if (grid[i][a]==64) {g.setColor(new Color(184, 15, 0));}
				if (grid[i][a]==128) {g.setColor(new Color(212, 0, 88));}
				if (grid[i][a]==256) {g.setColor(new Color(250, 32, 159));}
				if (grid[i][a]==512) {g.setColor(new Color(246, 32, 250));}
				if (grid[i][a]==1024) {g.setColor(new Color(131, 23, 255));}
				if (grid[i][a]==2048) {g.setColor(new Color(23, 222, 232));}
				//
				g.fillRect(i*96+172, a*96+160, 72, 72);;
				g.setColor(new Color(255,255,255));
				g.drawString(""+grid[i][a], i*96+200, a*96+200);
			}
		}
	}
	
	public void shiftLeft() {
		int temp;
		for (int i = 0; i < 3;i++) {
			for (int a = 0; a < grid.length;a++) {
				for (int b = 0; b < grid[0].length;b++) {
					if (a!=0) {
						if (grid[a][b] != 0 && grid[a-1][b] == 0) {
							temp = grid[a][b];
							grid[a][b] = 0;
							grid[a-1][b] = temp;
						}
						
						if (grid[a][b] == grid[a-1][b]) {
							grid[a-1][b] = grid[a][b]*2;
							grid[a][b] = 0;
						}
				
					}
				}
			}
		}
	}
	
	public void shiftUp() {
		int temp;
		for (int i = 0; i < 3;i++) {
			for (int a = 0; a < grid.length;a++) {
				for (int b = 0; b < grid[0].length;b++) {
					if (b!=0) {
						if (grid[a][b] != 0 && grid[a][b-1] == 0) {
							temp = grid[a][b];
							grid[a][b] = 0;
							grid[a][b-1] = temp;
						}
						
						if (grid[a][b] == grid[a][b-1]) {
							grid[a][b-1] = grid[a][b]*2;
							grid[a][b] = 0;
						}
				
					}
				}
			}
		}
	}
	
	public void shiftDown() {
		int temp;
		for (int i = 0; i < 3;i++) {
			for (int a = 0; a < grid.length;a++) {
				for (int b = 0; b < grid[0].length;b++) {
					if (b!=3) {
						if (grid[a][b] != 0 && grid[a][b+1] == 0) {
							temp = grid[a][b];
							grid[a][b] = 0;
							grid[a][b+1] = temp;
						}
						
						if (grid[a][b] == grid[a][b+1]) {
							grid[a][b+1] = grid[a][b]*2;
							grid[a][b] = 0;
						}
				
					}
				}
			}
		}
	}
	
	public void shiftRight() {
		int temp;
		for (int i = 0; i < 3;i++) {
			for (int a = 0; a < grid.length;a++) {
				for (int b = 0; b < grid[0].length;b++) {
					if (a!=3) {
						if (grid[a][b] != 0 && grid[a+1][b] == 0) {
							temp = grid[a][b];
							grid[a][b] = 0;
							grid[a+1][b] = temp;
						}
						
						if (grid[a][b] == grid[a+1][b]) {
							grid[a+1][b] = grid[a][b]*2;
							grid[a][b] = 0;
						}
				
					}
				}
			}
		}
	}
	
	
	
	public void generateNew() {
		boolean used = false;
		int a,b;
		while (!used) {
			a = (int)(Math.random()*4);
			b = (int)(Math.random()*4);
			if (grid[a][b] == 0) {
				grid[a][b] = 2;
				used = true;
			}
		}
	}
}
