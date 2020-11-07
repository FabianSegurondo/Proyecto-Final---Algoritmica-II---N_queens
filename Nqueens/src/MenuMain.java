
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
import java.util.List;

import javax.swing.UIManager;
import javax.swing.JTextField;


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
	
	ImageIcon queenCrown= new ImageIcon(new ImageIcon(getClass().getResource("/drawables/chessLogo.png")).getImage());
	/**
	 * Create the frame.
	 */
	//Para guardar los arrays (rows[]) con las soluciones posibles al input ingresado
	ArrayList<int[]> solutionList= new ArrayList<int[]>(); 
	//Array donde guardamos las posiciones de las casillas donde se posibilitan las N reinas
	int[] rows= new int[30];
	//Numero de soluciones encontradas al problema
	int solution=0;
	//Tamaño por lado del tablero, de 4 a 20
	int N=0;
	//Numero de reinas iniciales a solicitar
	int initQueens=0;
	//Vector de columnas de las reinas iniciales
	ArrayList<Integer> queenColumn= new ArrayList<Integer>();
	//Array con la posición de cada reina inicial
	int[] queens=new int[30];
	
	private JTextField solutNumber;
	
	public MenuMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 488);
		setIconImage(queenCrown.getImage());
		setTitle("N Queens Solver");
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
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(99, 314, 641, 92);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblParaSuProblema = new JLabel("Para su problema, existen");
		lblParaSuProblema.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblParaSuProblema.setBounds(10, 27, 182, 40);
		panel_2.add(lblParaSuProblema);
		
		//Campo de texto ineditable que mostrará el número total de soluciones disponibles para el problema
		solutNumber = new JTextField();
		solutNumber.setBounds(189, 35, 35, 28);
		solutNumber.setEditable(false);
		panel_2.add(solutNumber);
		solutNumber.setColumns(10);
		
		JLabel lblSoluciones = new JLabel("soluciones.");
		lblSoluciones.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSoluciones.setBounds(232, 35, 81, 25);
		panel_2.add(lblSoluciones);
		
		//Spinner que de su minimo (0 o 1, dependiendo de si es solucionable la entrada) al número máximo de soluciones
		//permitirá al usuario seleccionar cual resultado quiere ver
		final JSpinner solutionSpinner = new JSpinner();
		
		solutionSpinner.setFont(new Font("Tahoma", Font.BOLD, 13));
		solutionSpinner.setModel(new SpinnerNumberModel(0, 0, 0, 1));
		solutionSpinner.setBounds(513, 3, 52, 39);
		solutionSpinner.setEnabled(false);
		panel_2.add(solutionSpinner);
		
		JLabel lblSeleccionarSolucin = new JLabel("Seleccionar soluci\u00F3n:");
		lblSeleccionarSolucin.setFont(new Font("Fugaz One", Font.PLAIN, 12));
		lblSeleccionarSolucin.setBounds(373, 11, 144, 28);
		panel_2.add(lblSeleccionarSolucin);
		
		//Este botón tomará tanto la posición de la solución como el tamaño del tablero, mandandolos a otro Jframe
		//el cual se encargará de procesar el array y ArrayList de posiciones de las reinas iniciales y el ArrayList de
		//las posiciones disponibles
		final JButton SeeSolveButtton = new JButton("Ver solucion!");
		SeeSolveButtton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nqueenframe showQueens= new Nqueenframe();
				showQueens.setSizeGrid(N);
				showQueens.Nqueens(queenColumn,queens.clone(), solutionList, (Integer) solutionSpinner.getValue()-1);
				
			}
		});
		SeeSolveButtton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SeeSolveButtton.setBackground(UIManager.getColor("Button.focus"));
		SeeSolveButtton.setEnabled(false);
		SeeSolveButtton.setBounds(404, 47, 130, 34);
		panel_2.add(SeeSolveButtton);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(99, 102, 641, 190);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		//Spinner de 1 a N de la columna de la reina 1
		final JSpinner ColSpinner1 = new JSpinner();
		ColSpinner1.setBounds(298, 66, 29, 20);
		ColSpinner1.setEnabled(false);
		panel_1.add(ColSpinner1);
		
		//Spinner de 1 a N de la fila de la reina 1
		final JSpinner RowSpinner1 = new JSpinner();
		RowSpinner1.setBounds(298, 91, 29, 20);
		RowSpinner1.setEnabled(false);
		panel_1.add(RowSpinner1);
		
		//Spinner de 1 a N de la columna de la reina 2
		final JSpinner ColSpinner2 = new JSpinner();
		ColSpinner2.setBounds(430, 66, 29, 20);
		ColSpinner2.setEnabled(false);
		panel_1.add(ColSpinner2);
		
		//Spinner de 1 a N de la fila de la reina 2
		final JSpinner RowSpinner2 = new JSpinner();
		RowSpinner2.setBounds(430, 91, 29, 20);
		RowSpinner2.setEnabled(false);
		panel_1.add(RowSpinner2);
		
		//Spinner de 1 a N de la columna de la reina 3
		final JSpinner ColSpinner3 = new JSpinner();
		ColSpinner3.setBounds(564, 66, 29, 20);
		ColSpinner3.setEnabled(false);
		panel_1.add(ColSpinner3);
		
		//Spinner de 1 a N de la fila de la reina 3
		final JSpinner RowSpinner3 = new JSpinner();
		RowSpinner3.setBounds(564, 91, 29, 20);
		RowSpinner3.setEnabled(false);
		panel_1.add(RowSpinner3);
		
		//Con el ArrayList de Columnas de Reinas y su array de filas lleno, reiniciará el array de Rows para
		//comenzar el backtracking con solve() desde cero, reiniciando el valor de soluciones disponibles.
		//Si existiese al menos una solución, el spinner de selección de solución será habilitado junto al botón
		//de acceso a esta, de lo contrario, una notificación indicará el fallo y deshabilitará los dos componentes antes indicados
		final JButton ButtonActivate = new JButton("\u00A1\u00A1Resolver!!");
		ButtonActivate.setForeground(Color.BLACK);
		ButtonActivate.setFont(new Font("Tahoma", Font.BOLD, 13));
		ButtonActivate.setEnabled(false);
		ButtonActivate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetRow();
				solution=0;
				solve(0,N);
				if (solution>0) {
					solutNumber.setText(Integer.toString(solution));
					solutionSpinner.setModel(new SpinnerNumberModel(1, 1, solution, 1));
					solutionSpinner.setEnabled(true);
					SeeSolveButtton.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "No hay solución disponible para la(s) reina(s) ingresada(s)", "Fallo", JOptionPane.ERROR_MESSAGE);
					solutionSpinner.setModel(new SpinnerNumberModel(0,0,0,1));
					solutNumber.setText(Integer.toString(0));
					SeeSolveButtton.setEnabled(false);
				}
			}
			//Método del backtracking utilizado para hallar soluciones a N reinas en un tablero de n*n espacios.
			//A diferencia del estandar, al llegar a la columna N luego de recorrer el tablero, crea una variable
			//que incrementará si, mediante un for de 0 al tamaño de reinas requeridas, la fila dentro 
			// la columna extraida mediante su posicion en el ArrayList es igual a la de row en su mismo valor
			//Si el compare es igual al número de reinas iniciales, clonará e insertará lo obtenido en el array de 
			//rows al ArrayList de soluciones a la vez que aumenta el N° de estas
			private void solve(int column, int Size) {
				if (column == Size) {
					int compare=0;
					for (int i = 0; i < queenColumn.size(); i++) {
						if (rows[queenColumn.get(i)]==queens[queenColumn.get(i)]) {
							compare++;
						}
					}
					if (queenColumn.size()==compare) {
						solutionList.add(solutionList.size(),rows.clone());
						solution++;
					}
				}
				for (int row = 0; row < Size; row++) {
					if (isValid(row, column)) {
						rows[column] = row;
						solve(column+1,Size);
					}
				}
				
			}
		});
		
		
		ButtonActivate.setBackground(UIManager.getColor("Button.focus"));
		ButtonActivate.setBounds(229, 150, 123, 40);
		panel_1.add(ButtonActivate);
		
		
		//Al ser esta la tercera reina, hay que analizar su posición constantemente con las dos anteriores, 
	    //mediante el método isSolve con el cual se hará el terce análisis de posiciones.
		//De estar posicionada correctamente, ingresará sus posiciones a queenColumn y queens (columna y fila)
		// y activará el botón de resolver inmediatamente, al ser el máximo de reinas iniciales.
		final JButton Verificate3Button = new JButton("Ajustar reina 3");
		Verificate3Button.setBackground(UIManager.getColor("Button.focus"));
		Verificate3Button.setEnabled(false);
		Verificate3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int col3=(Integer) ColSpinner3.getValue();
				int row3=(Integer) RowSpinner3.getValue();
				if (isValid(row3-1,col3-1)) {
					queenColumn.add(queenColumn.size(), col3-1);
					queens[col3-1]=row3-1;
					Verificate3Button.setEnabled(false);
					if (queenColumn.size()==initQueens) {
						ButtonActivate.setEnabled(true);
					}
				}
				
			}
		});
		Verificate3Button.setBounds(483, 122, 115, 23);
		panel_1.add(Verificate3Button);
		
		//Al ser esta la primera reina, hay que analizar su posición constantemente con la primera, 
		//mediante el método isSolve con el cual se hará el segundo análisis de posiciones.
		//De estar posicionada correctamente, ingresará sus posiciones a queenColumn y queens (columna y fila)
		// y de querer sólo 2 reinas, activará el botón de resolver.
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
				if (isValid(row2-1,col2-1)) {
					queenColumn.add(queenColumn.size(), col2-1);
					queens[col2-1]=row2-1;
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
		
		//Al ser esta la primera reina, es cuestión de ajustarla al ArrayList de reinas requeridas y al array de rows
		//con el cual se hará el primer análisis de posiciones.
		//De ser la única reina requerida, activará el botón de resolver.
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
					queens[col1-1]=row1-1;
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
		//Botón de radio 1 (quiero 1 reina en mi consulta). Habilitará la entrada de 1 columna y 1 fila para una sola reina
	   // a la vez que ajustará la disponibilidad de los spinners que los seleccionen
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
					resetQueens();
					ColSpinner1.setEnabled(false);
					RowSpinner1.setEnabled(false);
					Verificate1Button.setEnabled(false);
					Verificate2Button.setEnabled(false);
					Verificate3Button.setEnabled(false);
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
		
		//Botón de radio 2 (quiero 2 reinas en mi consulta). Habilitará la entrada de 2 columnas y 2 filas para reinas
		// a la vez que ajustará la disponibilidad de los spinners que las seleccionen
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
					resetQueens();
					ColSpinner1.setEnabled(false);
					RowSpinner1.setEnabled(false);
					ColSpinner2.setEnabled(false);
					RowSpinner2.setEnabled(false);
					Verificate1Button.setEnabled(false);
					Verificate2Button.setEnabled(false);
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
		
		//Botón de radio 3 (quiero 3 reinas en mi consulta). Habilitará la entrada de 3 columnas y 3 filas para reinas
		// a la vez que ajustará la disponibilidad de los spinners que las seleccionen
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
					resetQueens();
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
		
		//Spinner que sirve para indicar el número de casillas por lado del tablero de ajedrez, y con él el
		//N° de reinas totales en él.
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
		
		//Este botón reiniciará las casillas de reinas a tener, los ArrayList de columnas de reinas y de soluciones
		// mientras deshabilita los botones de entrada y los RadioButtons necesarios para evitar errores
		
		JButton NsizeButton = new JButton("Mandar tama\u00F1o / Reiniciar");
		NsizeButton.setBackground(UIManager.getColor("Button.focus"));
		NsizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButtonQ1.setEnabled(false);
				radioButtonQ2.setEnabled(false);
				radioButtonQ3.setEnabled(false);
				radioButtonQ1.setSelected(false);
				radioButtonQ2.setSelected(false);
				radioButtonQ3.setSelected(false);
				Verificate1Button.setEnabled(false);
				Verificate2Button.setEnabled(false);
				Verificate3Button.setEnabled(false);
				ColSpinner1.setEnabled(false);
				RowSpinner1.setEnabled(false);
				ColSpinner2.setEnabled(false);
				RowSpinner2.setEnabled(false);
				ColSpinner3.setEnabled(false);
				RowSpinner3.setEnabled(false);
				SeeSolveButtton.setEnabled(false);
				ButtonActivate.setEnabled(false);
				solutionSpinner.setEnabled(false);
				N=(Integer) nSpinner.getValue();
				solutionList.clear();
				queenColumn.clear();
				resetQueens();
				resetRow();
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
		NsizeButton.setBounds(413, 25, 204, 23);
		panel_1.add(NsizeButton);
		
		backgroundLabel.setIcon(BGIcon);
		contentPane.add(backgroundLabel);
		
	}
	
	
	//Boolean que verifica si no existe una reina en la posición que se le manda o si no está en el rango de ataque
	//de una ficha aledaña
	public boolean isValid(int row, int column){
		for (int prev = 0; prev < column; prev++) {
			if(rows[prev]==row || Math.abs(rows[prev]-row)==Math.abs(prev-column)){
				return false;
			}
		}
		return true;
	}
	
	//Reinicia los valores del array de Row a su estado inicial
	public void resetRow() {
		for (int i = 0; i < 30; i++) {
			rows[i]=0;
		}
	}
	
	//Reinicia los valores del array de Reinas iniciales a su estado original
	public void resetQueens() {
		for (int i = 0; i < 30; i++) {
			queens[i]=0;
		}
	}
}