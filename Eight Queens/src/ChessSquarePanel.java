import java.awt.Color;

/**
 * <h1>ChessSquarePanel</h1>Description here
 * 
 * @author Gabby Baniqued
 */
public class ChessSquarePanel {
	

	public ChessSquarePanel(Color c, boolean flag) {

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

}
