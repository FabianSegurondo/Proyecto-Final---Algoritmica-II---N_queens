
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.UIManager;


public class MenuMain extends JFrame {

	private JPanel contentPane;
	private JRadioButton radioButtonQ1;
	private JRadioButton radioButtonQ2;
	private JRadioButton radioButtonQ3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuMain frame = new MenuMain();
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
	
	ArrayList<int[]> solutionList= new ArrayList<int[]>(); 
	int[] rows= new int[30];
	int solution=0;
	int N=0;
	int initQueens=0;
	ArrayList<Integer> queenColumn= new ArrayList<Integer>();
	int[] queens=new int[30];
	
	public MenuMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setBounds(0, 0, 854, 459);
		ImageIcon selectImage= new ImageIcon(MenuMain.class.getResource("/drawables/chessBackground.jpg"));
		Image backgroundChess= selectImage.getImage().getScaledInstance(backgroundLabel.getWidth(), backgroundLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon BGIcon= new ImageIcon(backgroundChess);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(189, 183, 107));
		panel.setBounds(122, 11, 589, 70);
		contentPane.add(panel);
		
		JLabel lblNQueensSolver = new JLabel("N Queens Solver");
		lblNQueensSolver.setForeground(new Color(128, 0, 0));
		lblNQueensSolver.setFont(new Font("Tahoma", Font.BOLD, 49));
		panel.add(lblNQueensSolver);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(99, 102, 641, 190);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		final JSpinner ColSpinner1 = new JSpinner();
		ColSpinner1.setBounds(298, 66, 29, 20);
		ColSpinner1.setEnabled(false);
		panel_1.add(ColSpinner1);
		
		
		final JSpinner RowSpinner1 = new JSpinner();
		RowSpinner1.setBounds(298, 91, 29, 20);
		RowSpinner1.setEnabled(false);
		panel_1.add(RowSpinner1);
		
		final JSpinner ColSpinner2 = new JSpinner();
		ColSpinner2.setBounds(430, 66, 29, 20);
		ColSpinner2.setEnabled(false);
		panel_1.add(ColSpinner2);
		
		final JSpinner RowSpinner2 = new JSpinner();
		RowSpinner2.setBounds(430, 91, 29, 20);
		RowSpinner2.setEnabled(false);
		panel_1.add(RowSpinner2);
		
		final JSpinner ColSpinner3 = new JSpinner();
		ColSpinner3.setBounds(564, 66, 29, 20);
		ColSpinner3.setEnabled(false);
		panel_1.add(ColSpinner3);
		
		final JSpinner RowSpinner3 = new JSpinner();
		RowSpinner3.setBounds(564, 91, 29, 20);
		RowSpinner3.setEnabled(false);
		panel_1.add(RowSpinner3);
		final JButton ButtonActivate = new JButton("\u00A1\u00A1Resolver!!");
		ButtonActivate.setForeground(Color.BLACK);
		ButtonActivate.setFont(new Font("Tahoma", Font.BOLD, 13));
		ButtonActivate.setEnabled(false);
		ButtonActivate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetRow();
				solution=0;
				solve(0,N);
				
			}
			//para hallar las soluciones haz un for que tome el initQueens (cuantas reinas de inicio) como limite
			//y extraer la columna con el queenColumn.get(i) y hacer un if si rows[column]==row, para sumar un valor comparador
			//que si es igual al numero de reinas iniciales, si es una solución y solution++;
			private void solve(int column, int Size) {
				// TODO Auto-generated method stub
				//Esto ya es tuyo. Recuerda utilizar lo que te dije
				
			}
		});
		ButtonActivate.setBackground(UIManager.getColor("Button.focus"));
		ButtonActivate.setBounds(229, 150, 123, 40);
		panel_1.add(ButtonActivate);
		
		
		//Los verificateButton funcionan así: leen el valor de la fila y columna de la reina, para ver si es posible o no
		//A excepción de la reina 1, las demás contarán con una versión alterada de IsValid con enable 0, que les permite
		//procesar de manera legal que se las pueda colocar aún con espacios entre ellas.
		//El queenColumn es para almacenar las columnas del queens[], quien tendrá las filas, y con ello, ver si el problema
		//es solucionable con ellas
		//queenColumn(posición, columna)
		//queens[columna]=fila
		final JButton Verificate3Button = new JButton("Ajustar reina 3");
		Verificate3Button.setBackground(UIManager.getColor("Button.focus"));
		Verificate3Button.setEnabled(false);
		Verificate3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int col3=(Integer) ColSpinner3.getValue();
				int row3=(Integer) RowSpinner3.getValue();
				if (isValid(row3-1,col3-1,0)) {
					queenColumn.add(queenColumn.size(), col3-1);
					Verificate3Button.setEnabled(false);
					if (queenColumn.size()==initQueens) {
						ButtonActivate.setEnabled(true);
					}
				}
				
			}
		});
		Verificate3Button.setBounds(483, 122, 115, 23);
		panel_1.add(Verificate3Button);
		
		final JButton Verificate2Button = new JButton("Ajustar reina 2");
		Verificate2Button.setBackground(UIManager.getColor("Button.focus"));
		Verificate2Button.setEnabled(false);
		Verificate2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int col2=(Integer) ColSpinner2.getValue();
				int row2=(Integer) RowSpinner2.getValue();
				if(col2==N && initQueens==3){
					JOptionPane.showMessageDialog(null, "No es válido, las reinas se colocan de manera progresiva entre columnas, y esta llega al límite del tablero. Intenta con una columna menor a N", "Advertencia", JOptionPane.ERROR_MESSAGE);
				} else {
				if (isValid(row2-1,col2-1,0)) {
					queenColumn.add(queenColumn.size(), col2-1);
					rows[col2-1]=row2-1;
					ColSpinner3.setModel(new SpinnerNumberModel(col2+1, col2+1, N, 1));
					Verificate2Button.setEnabled(false);
					if (queenColumn.size()==initQueens) {
						ButtonActivate.setEnabled(true);
					} else {
						Verificate3Button.setEnabled(true);
					}
				  }
				}
			}
		});
		Verificate2Button.setBounds(344, 122, 115, 23);
		panel_1.add(Verificate2Button);
		
		final JButton Verificate1Button = new JButton("Ajustar reina 1");
		Verificate1Button.setBackground(UIManager.getColor("Button.focus"));
		Verificate1Button.setEnabled(false);
		Verificate1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int col1=(Integer) ColSpinner1.getValue();
				int row1=(Integer) RowSpinner1.getValue();
				if (initQueens>1 && col1==N ) {
					JOptionPane.showMessageDialog(null, "No es válido, las reinas se colocan de manera progresiva entre columnas, y esta llega al límite del tablero. Intenta con una columna menor a N", "Advertencia", JOptionPane.ERROR_MESSAGE);
				} else {
					queenColumn.add(queenColumn.size(), col1-1);
					rows[col1-1]=row1-1;
					ColSpinner2.setModel(new SpinnerNumberModel(col1+1, col1+1, N, 1));
					ColSpinner3.setModel(new SpinnerNumberModel(col1+1, col1+1, N, 1));
					Verificate1Button.setEnabled(false);
					if (queenColumn.size()==initQueens) {
						ButtonActivate.setEnabled(true);
					} else {
						Verificate2Button.setEnabled(true);
					}
				}
			}	
		});
		Verificate1Button.setBounds(211, 122, 123, 23);
		panel_1.add(Verificate1Button);
		
		
		
		
		
		
		radioButtonQ1 = new JRadioButton("1");
		radioButtonQ1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioButtonQ1.isSelected()) {
					radioButtonQ2.setSelected(false);
					radioButtonQ3.setSelected(false);
					ColSpinner1.setEnabled(true);
					RowSpinner1.setEnabled(true);
					Verificate1Button.setEnabled(true);
					initQueens=1;
				} else {
					queenColumn.clear();
					resetRow();
					ColSpinner1.setEnabled(false);
					RowSpinner1.setEnabled(false);
					Verificate1Button.setEnabled(false);
					ButtonActivate.setEnabled(false);
					initQueens=0;
					ColSpinner1.setModel(new SpinnerNumberModel(1, 1, N, 1));
					RowSpinner1.setModel(new SpinnerNumberModel(1, 1, N, 1));
				}
			}
		});
		radioButtonQ1.setBackground(new Color(245, 245, 220));
		radioButtonQ1.setBounds(148, 65, 45, 23);
		radioButtonQ1.setEnabled(false);
		panel_1.add(radioButtonQ1);
		
		
		radioButtonQ2 = new JRadioButton("2");
		radioButtonQ2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioButtonQ2.isSelected()) {
					radioButtonQ1.setSelected(false);
					radioButtonQ3.setSelected(false);
					ColSpinner1.setEnabled(true);
					RowSpinner1.setEnabled(true);
					ColSpinner2.setEnabled(true);
					RowSpinner2.setEnabled(true);
					Verificate1Button.setEnabled(true);
					initQueens=2;
				} else {
					queenColumn.clear();
					resetRow();
					ColSpinner1.setEnabled(false);
					RowSpinner1.setEnabled(false);
					ColSpinner2.setEnabled(false);
					RowSpinner2.setEnabled(false);
					Verificate1Button.setEnabled(false);
					ButtonActivate.setEnabled(false);
					initQueens=0;
					ColSpinner1.setModel(new SpinnerNumberModel(1, 1, N, 1));
					RowSpinner1.setModel(new SpinnerNumberModel(1, 1, N, 1));
					ColSpinner2.setModel(new SpinnerNumberModel(1, 1, N, 1));
					RowSpinner2.setModel(new SpinnerNumberModel(1, 1, N, 1));
				}
			}
		});
		radioButtonQ2.setBackground(new Color(245, 245, 220));
		radioButtonQ2.setBounds(148, 90, 45, 23);
		radioButtonQ2.setEnabled(false);
		panel_1.add(radioButtonQ2);
		
		radioButtonQ3 = new JRadioButton("3");
		radioButtonQ3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioButtonQ3.isSelected()) {
					radioButtonQ1.setSelected(false);
					radioButtonQ2.setSelected(false);
					ColSpinner1.setEnabled(true);
					RowSpinner1.setEnabled(true);
					ColSpinner2.setEnabled(true);
					RowSpinner2.setEnabled(true);
					ColSpinner3.setEnabled(true);
					RowSpinner3.setEnabled(true);
					Verificate1Button.setEnabled(true);
					initQueens=3;
				} else {
					queenColumn.clear();
					resetRow();
					ColSpinner1.setEnabled(false);
					RowSpinner1.setEnabled(false);
					ColSpinner2.setEnabled(false);
					RowSpinner2.setEnabled(false);
					ColSpinner3.setEnabled(false);
					RowSpinner3.setEnabled(false);
					Verificate1Button.setEnabled(false);
					ButtonActivate.setEnabled(false);
					initQueens=0;
					ColSpinner1.setModel(new SpinnerNumberModel(1, 1, N, 1));
					RowSpinner1.setModel(new SpinnerNumberModel(1, 1, N, 1));
					ColSpinner2.setModel(new SpinnerNumberModel(1, 1, N, 1));
					RowSpinner2.setModel(new SpinnerNumberModel(1, 1, N, 1));
					ColSpinner3.setModel(new SpinnerNumberModel(1, 1, N, 1));
					RowSpinner3.setModel(new SpinnerNumberModel(1, 1, N, 1));
				}
			}
		});
		radioButtonQ3.setBackground(new Color(245, 245, 220));
		radioButtonQ3.setBounds(148, 116, 45, 23);
		radioButtonQ3.setEnabled(false);
		panel_1.add(radioButtonQ3);
		
		
		
		JLabel QueenLabel = new JLabel("Nro de Reinas iniciales:");
		QueenLabel.setFont(new Font("Century Gothic", Font.BOLD, 12));
		QueenLabel.setBounds(10, 68, 142, 14);
		panel_1.add(QueenLabel);
		
		
		
		JLabel label_C1 = new JLabel("Columna Reina 1:");
		label_C1.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		label_C1.setBounds(199, 69, 97, 14);
		panel_1.add(label_C1);
		
		JLabel label_C2 = new JLabel("Columna Reina 2:");
		label_C2.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		label_C2.setBounds(328, 69, 97, 14);
		panel_1.add(label_C2);
		
		JLabel labelC3 = new JLabel("Columna Reina 3:");
		labelC3.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		labelC3.setBounds(469, 69, 97, 14);
		panel_1.add(labelC3);
		
		final JSpinner nSpinner = new JSpinner();
		nSpinner.setModel(new SpinnerNumberModel(4, 4, 20, 1));
		nSpinner.setFont(new Font("Tahoma", Font.BOLD, 16));
		nSpinner.setBounds(337, 11, 64, 46);
		panel_1.add(nSpinner);
		
		JLabel lblTamaoDeTablero = new JLabel("Tama\u00F1o de tablero (NxN):");
		lblTamaoDeTablero.setFont(new Font("Fugaz One", Font.PLAIN, 22));
		lblTamaoDeTablero.setBounds(54, 11, 273, 47);
		panel_1.add(lblTamaoDeTablero);
		
		JLabel lblR1 = new JLabel("Fila Reina 1:");
		lblR1.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		lblR1.setBounds(229, 94, 64, 14);
		panel_1.add(lblR1);
		
		JLabel lblR2 = new JLabel("Fila Reina 2:");
		lblR2.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		lblR2.setBounds(359, 94, 64, 14);
		panel_1.add(lblR2);
		
		JLabel lblR3 = new JLabel("Fila Reina 3:");
		lblR3.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		lblR3.setBounds(499, 94, 64, 14);
		panel_1.add(lblR3);
		
		JButton NsizeButton = new JButton("Mandar tama\u00F1o");
		NsizeButton.setBackground(UIManager.getColor("Button.focus"));
		NsizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ButtonActivate.setEnabled(false);
				N=(Integer) nSpinner.getValue();
				ColSpinner1.setModel(new SpinnerNumberModel(1, 1, N, 1));
				RowSpinner1.setModel(new SpinnerNumberModel(1, 1, N, 1));
				ColSpinner2.setModel(new SpinnerNumberModel(1, 1, N, 1));
				RowSpinner2.setModel(new SpinnerNumberModel(1, 1, N, 1));
				ColSpinner3.setModel(new SpinnerNumberModel(1, 1, N, 1));
				RowSpinner3.setModel(new SpinnerNumberModel(1, 1, N, 1));
				if (N<6){
					radioButtonQ1.setEnabled(true);
				} else if (N<8){
					radioButtonQ1.setEnabled(true);
					radioButtonQ2.setEnabled(true);
				} else {
					radioButtonQ1.setEnabled(true);
					radioButtonQ2.setEnabled(true);
					radioButtonQ3.setEnabled(true);
				}
			}
		});
		NsizeButton.setBounds(413, 25, 123, 23);
		panel_1.add(NsizeButton);
		
		
		
		
	
		backgroundLabel.setIcon(BGIcon);
		contentPane.add(backgroundLabel);
		
	}
	
	//enable 0=matriz inicial 1=matriz final
	//El enable permitirá ver si queremos procesar la matriz con la que hacemos las reinas de inicio o no
	//Por lo que para que isValid funcione con la matriz oficial (la del proceso), se debe mandar al isValid con este formato
	//isValid(row,column,1)
	public boolean isValid(int row, int column, int enable){
		
		//Lo que procesará el algoritmo oficial activado con el boton Resolver. Tambien lo hará con enable 0
		for (int prev = 0; prev < column; prev++) {
			if(rows[prev]==row || Math.abs(rows[prev]-row)==Math.abs(prev-column)){
				if(enable==1 || (enable==0 && queenColumn.indexOf(prev)!=-1)){
				return false;
				}
			}
		}
		return true;
	}
	
	public void resetRow() {
		for (int i = 0; i < 30; i++) {
			rows[i]=0;
		}
	}
	
}
