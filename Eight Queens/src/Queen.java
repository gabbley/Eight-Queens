
public class Queen {
	
	private int row;
	private boolean piece;
	

	public Queen() {
		row = 0;
		piece = true;
	}
	
	public Queen(int r, boolean p){
		row = r;
		piece = p;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public boolean isPiece() {
		return piece;
	}

	public void setPiece(boolean piece) {
		this.piece = piece;
	}
	

}
