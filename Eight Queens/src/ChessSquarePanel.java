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
	public boolean addQueens(boolean[][] queens) {
		if (hasEight(queens))
			return true;
		else if (!isLegal(0,0,queens)) { //???
			for (int r = 0; r < ROWS; r++) {
				for (int c = 0; c < COLS; c++) {
					queens[r][c] = true;
					return addQueens(queens);
				}
			}
		} else
			return false;

	}

	public boolean isLegal(int r, int c, boolean[][] queens) {
		for (; r < queens.length; r++) {
			for (; c < queens[c].length; c++) {
				// check to the left
				while (r != 0) {
					if (queens[r][c])
						return false;
					r--;
				}

				while (c != 0) {
					if (queens[r][c])
						return false;
					c--;
				}

			}
		}
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
