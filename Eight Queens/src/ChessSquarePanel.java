import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

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
	private static final String QUEEN = "Q";
	private final static int FONTSIZE = 20;
	private Color backColor;
	private boolean queen;
	ArrayList<ArrayList<Queen>> sol = new ArrayList<ArrayList<Queen>>();

	/**
	 * Default constructor for ChessSquarePanel Sets default backColor as white
	 * Does not hold a validly placed queen (false)
	 */
	public ChessSquarePanel() {
		backColor = Color.WHITE;
		queen = false;
	}

	/**
	 * Constructor for ChessSquarePanel Sets backColor and boolean flag for
	 * queen
	 */
	public ChessSquarePanel(Color c, boolean q) {
		backColor = c;
		queen = q;
	}

	public void addQueens() {
		ArrayList<Queen> queens = new ArrayList<Queen>();
			addQueens(0, 0, queens);
	}

	/**
	 * Recursively adds queens to the Chess Board until there are eight legally
	 * placed queens on the board
	 * 
	 * @param queens
	 *            boolean matrix, true denoting spaces with a queen, false
	 *            otherwise
	 * 
	 * @return boolean true if 8 queens are properly placed
	 */
	public boolean addQueens(int r, int c, ArrayList<Queen> queens) {

		if (queens.size() == COLS) {
			return true;
		}
		for (; r < ROWS; r++) {
			System.out.println("checking: " + r + ", " + c);
			if (isLegal(r, c, queens)) {
				queens.add(new Queen(r, c));
				// this.setQueen(true);
				if (!addQueens(0, c+1, queens)) {
					Queen q = queens.remove(queens.size() - 1);
					r = q.getRow();
					c = q.getCol();
				}
			}

			if (queens.size() == COLS) {
				ArrayList<Queen> solution = (ArrayList<Queen>) queens.clone();
				sol.add(solution);
				Queen q = queens.remove(queens.size() - 1);
				r = q.getRow();
				c = q.getCol();
			}
		}

		return false;

	}

	/*
	 * steps outside of method, need to send in 0, 0 for first placement first
	 * (0,0) parameters
	 */

	/**
	 * Determines if the placement of a queen is legal
	 * 
	 * @param r
	 *            row in which the queen is placed
	 * 
	 * @param c
	 *            col in which the queen is placed
	 * 
	 * @param queens
	 *            boolean matrix, true denoting spaces with a queen, false
	 *            otherwise
	 * 
	 * @return boolean true if the placement is legal, false otherwise
	 */
	public boolean isLegal(int r, int c, ArrayList<Queen> queens) {

		return (checkHorizontal(c, queens) && checkVertical(r, queens) && checkDiagonal(r, c, queens));

	}

	/**
	 * Determines if the horizontal path of a queen is clear
	 * 
	 * 
	 * @param c
	 *            col in which the queen is placed
	 * 
	 * @param queens
	 *            boolean matrix, true denoting spaces with a queen, false
	 *            otherwise
	 * 
	 * @return boolean true if the path is clear, false otherwise
	 */
	public boolean checkHorizontal(int c, ArrayList<Queen> queens) {
		for (int r = 0; r < queens.size(); r++) {
			if (queens.get(r).getCol() == c)
				return false; // not a valid space
		}
		return true;

	}

	/**
	 * Determines if the vertical path of a queen is clear
	 * 
	 * @param r
	 *            row in which the queen is placed
	 * 
	 * @param queens
	 *            ArrayList
	 * 
	 * @return boolean true if the path is clear, false otherwise
	 */
	public boolean checkVertical(int r, ArrayList<Queen> queens) {
		for (int c = 0; c < queens.size(); c++) {
			if (queens.get(c).getRow() == r)
				return false; // not a valid space
		}
		return true;
	}

	/**
	 * Determines if the diagonal path of a queen is clear
	 * 
	 * @param r
	 *            row in which the queen is placed
	 * 
	 * @param c
	 *            col in which the queen is placed
	 * 
	 * @param queens
	 *            boolean matrix, true denoting spaces with a queen, false
	 *            otherwise
	 * 
	 * @return boolean true if the path is clear, false otherwise
	 */
	public boolean checkDiagonal(int r, int c, ArrayList<Queen> q) {
		// slope, creds to patty
		for (int i = 0; i < q.size(); i++) {
			if (Math.abs(r - q.get(i).getRow()) == Math.abs(c - q.get(i).getCol()))
				return false;
		}

		return true;
	}

	/**
	 * Displays a "Q" on the Board (add more to this****)
	 * 
	 * @param g
	 *            Graphics
	 * 
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setFont(new Font("TimesRoman", Font.PLAIN, FONTSIZE));
		this.setBackground(backColor);
		g.setColor(Color.BLACK);

		int x = (this.getWidth() / 2) - FONTSIZE / 4;
		int y = (this.getHeight() / 2) + FONTSIZE / 4;
		if (isQueen())
			g.drawString(QUEEN, x, y);
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
	
	public ArrayList<ArrayList<Queen>> getSolutions(){
		return sol;
	}
	
	public int getSolNum(){
		return sol.size();
	}

	public static void main(String[] args) {
		ChessSquarePanel p = new ChessSquarePanel();
		p.addQueens(); // initial call, sends in 0,0
		for (ArrayList<Queen> q : p.sol) {
			System.out.println(q);
		}
		System.out.println("Number of Solutions: " + p.sol.size());

		
//		 if (p.addQueens(r, c, queens) ) {
//		 System.out.println("Eight Queens Successfully Displayed");
//		 }
//		 else
//		 System.out.println("Failed");
	}

}
