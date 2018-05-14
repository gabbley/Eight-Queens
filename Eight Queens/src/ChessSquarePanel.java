import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.nio.channels.AlreadyBoundException;

import javax.swing.JPanel;

/**
 * <h1>ChessSquarePanel</h1>Description here
 * 
 * @author Gabby Baniqued
 */
public class ChessSquarePanel extends JPanel {

	// These fields are used whenever PaintComponent is executed to update the
	// panel
	private static final int ROWS = 8;
	private static final int COLS = 8;
	private final static int FONTSIZE = 20;
	private Color backColor;
	private boolean queen;

	public ChessSquarePanel() {
		backColor = Color.WHITE;
		queen = false;
	}

	public ChessSquarePanel(Color c, boolean q) {
		backColor = c;
		queen = q;
	}

	// recursive, adds queens until there are 8
	public boolean addQueens(Queen[][] queens) {
		int r = 0;
		int c = 0;
		
			while (!hasEight(queens)){
				if (isLegal(r, c, queens))
					
			}
	}

	public boolean isLegal(int r, int c, Queen[][] queens) {

		return true;
		
		
	}
	
	public void checkHorizontal(int r, int c, Queen[][] queens){
		/*
		 * if the check is false, r++
		 * */
	}
	
	public void checkVertical(int r, int c, Queen[][] queens){
	
		/*if the check is false, c++*/
	}
	
	public boolean checkDiagonal(int r, int c, Queen[][] queens){
		/*if the check is false
		 * 
		 * */
	}

	
	//returns true if there are 8 LEGALLY PLACED queens
	public boolean hasEight(Queen[][] queens) {
		int n = 0;
		for (int i = 0; i < queens.length; i++) {
			for (int j = 0; j < queens[i].length; j++) {
				if (queens[i][j].isPiece())
					n++;
			}
		}
		return (n == 8);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setFont(new Font("TimesRoman", Font.PLAIN, FONTSIZE));
		this.setBackground(backColor);
		g.setColor(Color.BLACK);

		int x = (this.getWidth() / 2) - FONTSIZE / 4;
		int y = (this.getHeight() / 2) + FONTSIZE / 4;
		if (isQueen())
			g.drawString("Q", x, y);
	}

	public void setBackColor(Color c) {
		backColor = c;
		repaint(); // forces paintComponent to execute
	}

	public Color getBackColor() {
		return backColor;
	}

	public boolean isQueen() {
		return queen;
	}

	public void setQueen(boolean q) {
		queen = q;
		repaint();
	}

	public boolean getQueen() {
		return queen;
	}

}
