import java.awt.Color;
import java.util.ArrayList;

public class CheckLegal {
	
	// These fields are used whenever PaintComponent is executed to update the
	// panel
	private static final int ROWS = 8;
	private static final int COLS = 8;
	private static final String QUEEN = "Q";
	private final static int FONTSIZE = 20;
	private Color backColor;
	private boolean queen;
	ArrayList<Queen> placedQueens = new ArrayList<Queen>();

	public CheckLegal() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Recursively adds queens to the Chess Board until there are
	 * eight legally placed queens on the board
	 * 
	 * @param queens
	 *            boolean matrix, true denoting spaces with a queen, false otherwise
	 * 
	 * @return boolean true if 8 queens are properly placed
	 */
	public boolean addQueens(int r, int c, ArrayList<Queen> queens) { //need to add 0,0 before calling first
		c = queens.get(queens.size()-1).getCol();

		while (queens.size() < COLS) {	
			for (r = 0; r < ROWS; r++) {
				if (isLegal(r, c, queens)) {
					placedQueens.add(new Queen(r, c));
					c++;
					//this.setQueen(true);
					return addQueens(r, c, queens);
				} 
			}
		}
		return true;
	}

	/**
	 * Determines if the placement of a queen is legal
	 * 
	 * @param r
	 * 		row in which the queen is placed
	 * 
	 * @param c
	 * 		col in which the queen is placed
	 * 
	 * @param queens
	 * 		 boolean matrix, true denoting spaces with a queen, false otherwise
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
	 * 		col in which the queen is placed
	 * 
	 * @param queens
	 * 		 boolean matrix, true denoting spaces with a queen, false otherwise
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
	 * 		row in which the queen is placed
	 * 
	 * @param queens
	 * 		 ArrayList
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
	 * 		row in which the queen is placed
	 * 
	 * @param c
	 * 		col in which the queen is placed
	 * 
	 * @param queens
	 * 		 boolean matrix, true denoting spaces with a queen, false otherwise
	 * 
	 * @return boolean true if the path is clear, false otherwise
	 */
	public boolean checkDiagonal(int r, int c, ArrayList<Queen> q) {
		//slope, creds to patty
		for (int i = 0; i<q.size(); i++){
		if (Math.abs(r-q.get(i).getRow()) == Math.abs(c-q.get(i).getRow()))
				return false;
		}
		
		return true;
	}


}
