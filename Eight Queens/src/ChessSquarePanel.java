import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * <h1>ChessSquarePanel</h1>Description here
 * 
 * @author Gabby Baniqued
 */
public class ChessSquarePanel extends JPanel {

	// These fields are used whenever PaintComponent is executed to update the
	// panel
	private String letter;
	private Color backColor;
	private boolean queen;
	
	public ChessSquarePanel(){
		 backColor = Color.BLUE;
		 queen = false;
	}

	public ChessSquarePanel(Color c, boolean q) {
		  backColor = c;
		  queen = q;
	}

	// recursive, adds queens until there are 8
	public boolean addQueens(boolean[][] queens) {
		if (hasEight(queens))
			return true;
		else{
			try{
				
			}
			catch{
				
			}
		}

	}

	public boolean isLegal() {

	}

	public boolean hasEight(boolean[][] queens) {
		int n = 0;
		for (int i = 0; i < queens.length; i++) {
			for (int j = 0; j < queens[i].length; j++) {
				if (queens[i][j])
					n++;
			}
		}
		return (n == 8);
	}

	private final static int FONTSIZE = 20;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setFont(new Font("TimesRoman", Font.PLAIN, FONTSIZE));
		this.setBackground(backColor);
		g.setColor(Color.RED);

		// removeAll(); // Someone mentioned panels not updating properly, this
		// may help, but does not seem necessary
		// x and y center the String, adjust as necessary
		int x = (this.getWidth() / 2) - FONTSIZE / 4; // - letter.length()/2;
		int y = (this.getHeight() / 2) + FONTSIZE / 4;
		g.drawString(letter, x, y);
	}

	public void setBackColor(Color c) {
		backColor = c;
		repaint(); // forces paintComponent to execute
	}

	public void setLetter(String letter) {
		this.letter = letter;
		repaint(); // forces paintComponent to execute
	}

	public static void main(String[] args) {
		// ChessBoard board = new ChessBoard();
	}

}
