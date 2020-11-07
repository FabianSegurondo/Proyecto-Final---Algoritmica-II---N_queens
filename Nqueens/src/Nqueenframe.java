import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Nqueenframe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nqueenframe frame = new Nqueenframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	private Container contents;
	
	
	private Color blue=Color.BLUE;
	public void getter(){
		
	}
	int size=0;
	private ImageIcon queen= new ImageIcon(new ImageIcon(getClass().getResource("/drawables/QueenChess.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	ImageIcon queenCrown= new ImageIcon(new ImageIcon(getClass().getResource("/drawables/chessLogo.png")).getImage());
	public Nqueenframe() {
		setSize(500,500);
		setIconImage(queenCrown.getImage());
		setTitle("N Queens Solver: Solucion");
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);	
	}
	
	
	
	public void setSizeGrid(int size) {
		this.size = size;
	}
	

   
	public int getSizeGrid() {
		return size;
	}


//Metodo que creará una grilla de botones sin función, en los cuales se coloreará su fondo en el formato de ajedrez
//a la vez que en ciertas casillas pondrá un icono de pieza de reina si coinciden en posición con la de los arrays
// dentro de solutionList(posicion). Si en este caso especial, la columna j existe en el array de queenColumns y 
// en ella existe la posición deseada de una reina inicial, su fondo será magenta, indicando que es la reina que se
// solocitó al principio
	public void Nqueens(ArrayList<Integer> queenColumn,int[] queensRequired, ArrayList<int[]> solutionList, int pot){
		JButton[][] grid=new JButton[size][size];
		contents = getContentPane();
		contents.setLayout(new GridLayout(size,size));
		for (int i = 0; i < size; i++) { 
			System.out.println("row");
			for (int j = 0; j < size; j++) {
				System.out.println("column");
				System.out.println(i +" "+ j);
				grid[i][j]= new JButton();
				if ((i+j)%2!=0) {
					grid[i][j].setBackground(blue);
				} 
				if (solutionList.get(pot)[j]==i) {
					grid[i][j].setIcon(queen);
					if(queenColumn.contains(j) && queensRequired[j]==i){
						grid[i][j].setBackground(Color.MAGENTA);
					}
				}				
				contents.add(grid[i][j]);
			}
		}
	}
	
	
	

}