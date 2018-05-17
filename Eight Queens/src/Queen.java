
/**
 * <h1>ChessSquarePanel</h1>Description here
 * 
 * @author Gabby Baniqued
 */
public class Queen {

	private int row;
	private int col;

	/**
	 * <h1>Queen</h1>Description here
	 * 
	 * @author Gabby Baniqued
	 */
	public Queen() {
		row = 0;
		col = 0;
	}

	public Queen(int r, int c) {
		row = r;
		col = c;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	
	public String toString(){
		return "row: " + row + ", col: " + col;
	}

}
