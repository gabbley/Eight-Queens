import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private JButton btnSolutions;
	private JLabel lblSolutions;
	ChessSquarePanel[][] spaces = new ChessSquarePanel[ROWS][COLS]; 
	ArrayList<Queen> queens = new ArrayList<Queen>();
	static ArrayList<ArrayList<Queen>> sol = new ArrayList<ArrayList<Queen>>();

	/**
	 * <h1>ChessBoard</h1>Description here
	 * 
	 * @author Gabby Baniqued
	 */
	ChessBoard() {
		buildFrame();
		queens = new ArrayList<Queen>();
		btnSolutions = new JButton("Next Solution");
		lblSolutions = new JLabel("Solution #");
		
		panelOne = buildHeaderPanel();
		panelTwo = buildGridPanels();
		panelThree = buildFooterPanel();

		window.add(panelOne);
		window.add(panelTwo);
		window.add(panelThree);
		panelThree.add(btnSolutions);
		panelThree.add(lblSolutions);
		btnSolutions.addActionListener(new Action());
	

		window.setVisible(true);
	}

	
	class Action implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int i = 0; //does this reset it every click
			ChessBoard c = new ChessBoard();
			ArrayList<Queen> queens = sol.get(i);
			for (Queen q : queens)
				c.updatePanel(q.getRow(), q.getCol());
			lblSolutions.setText("Solution " + i);
			i++;
		}
	}

	private void buildFrame() {
		window = new JFrame("Eight Queens Algorithm");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(new Dimension(WIDTH, HEIGHT));
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
				spaces[r][c] = m; 
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
		return p;
	}
	
	private void updatePanel(int r, int c) {
		ChessSquarePanel p = spaces[r][c];
		p.setQueen(true);
	}

	public static void main(String[] args) {
		ChessSquarePanel p = new ChessSquarePanel();
		sol = p.getSolutions();
		ChessBoard c = new ChessBoard();
		
	}
}
