import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

public class ChessBoard {
	private static final int ROWS = 8;
	private static final int COLS = 8;
	private static final int HEIGHT = 120 * ROWS;
	private static final int WIDTH = 120 * COLS;
	private static final Color LIGHT_COLOR = Color.WHITE;
	private static final Color DARK_COLOR = Color.GRAY;
	private static final Color FOOTER_COLOR = Color.WHITE;
	private static final Color HEADER_COLOR = Color.WHITE;

	private JFrame window;
	private JPanel panelOne, panelTwo, panelThree;
	ChessSquarePanel[][] spaces = new ChessSquarePanel[ROWS][COLS]; 
	ArrayList<Queen> queens = new ArrayList<Queen>();

	/**
	 * <h1>ChessBoard</h1>Description here
	 * 
	 * @author Gabby Baniqued
	 */
	ChessBoard() {
		buildFrame();
		queens = new ArrayList<Queen>();
		fillArr();
		
		panelOne = buildHeaderPanel();
		panelTwo = buildGridPanels();
		panelThree = buildFooterPanel();

		window.add(panelOne);
		window.add(panelTwo);
		window.add(panelThree);

		// window.pack(); // Adjusts the frame size, so - collapses it ...
		window.setVisible(true);
	}

	private void buildFrame() {
		window = new JFrame("Eight Queens Algorithm");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(new Dimension(WIDTH, HEIGHT));
		// could set min, max, and preferred dimensions, I think
		window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
	}

	private JPanel buildHeaderPanel() {
		JPanel p = new JPanel();
		p.setPreferredSize(new Dimension(WIDTH, 40));
		p.setMinimumSize(new Dimension(WIDTH, 10));
		p.setMaximumSize(new Dimension(WIDTH, 50));
		p.setBackground(HEADER_COLOR);
		p.add(new JLabel("Eight Queens"));
		return p;
	}

	private boolean isEven(int x) {
		return x % 2 == 0;
	}

	private Color setPanelColor(int row, int col) {
		if (isEven(row) && !isEven(col))
			return LIGHT_COLOR;
		else if (!isEven(row) && isEven(col))
			return LIGHT_COLOR;
		else
			return DARK_COLOR;
	}

	private JPanel buildGridPanels() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(ROWS, COLS));
		Color bg;
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				bg = setPanelColor(r, c);
				ChessSquarePanel m = new ChessSquarePanel(bg, false); // fix!
				spaces[r][c] = m; // keep a reference to the panel, so we can
									// change it
				p.add(m);
			}
		}
		return p;
	}

	private JPanel buildFooterPanel() {
		JPanel p = new JPanel();
		p.setMinimumSize(new Dimension(WIDTH, 10));
		p.setMaximumSize(new Dimension(WIDTH, 50));
		p.setPreferredSize(new Dimension(WIDTH, 40));
		p.setBackground(FOOTER_COLOR);
		p.add(new JLabel("Litty!!!"));
		return p;
	}

	private void updatePanel(int r, int c) {
		ChessSquarePanel p = spaces[r][c];
		if (p.addQueens(r, c, queens) ) {
			System.out.println("Eight Queens Successfully Displayed");
			//p.setQueen(true); // displays the Q
		}
		else
			System.out.println("you suck");

	}

	private void fillArr() { 
		for (int r = 0; r < ROWS; r++) {
			//queen.get(r).ge
		}

	}

	public static void main(String[] args) {
		ChessBoard cb = new ChessBoard();
		cb.updatePanel(0, 0);
	}
}
