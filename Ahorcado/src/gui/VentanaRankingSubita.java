package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import DataBase.MetodosBD;
import domain.Usuario;
import io.ComparadorRankingSubita;
import io.RendererRanking;

public class VentanaRankingSubita extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MetodosBD metodos = new MetodosBD();
	public static List<Usuario> listaUsuarios = metodos.obtenerListaUsuarios();
	private JTable tabla;

	//Metodo recursivo que busca la posicion del jugador del que se ha introducido la puntuacion
	public int busquedaBinaria(List<Usuario> lista, int low, int high,  int target) {
		
		
		int mid = (low + high)/2;
		
		if (target == lista.get(mid).getPuntuacionSubita()) {
			System.out.println(mid + 1);
			return mid + 1;
		} else if (target > lista.get(mid).getPuntuacionSubita()) {
			return busquedaBinaria(lista, low, mid -1, target);
		} else {
			return busquedaBinaria(lista, mid + 1,  high, target);
		}
		
	}
	
	//Se inicializa la ventana
	public VentanaRankingSubita() {
		
		JLabel label = new JLabel("Puntos del Jugador: ");
		JTextField textoPosicion= new JTextField(10);
		JButton boton = new JButton("Buscar");
		
		JPanel panel = new JPanel();
		
		Collections.sort(listaUsuarios, new ComparadorRankingSubita());
		
		tabla = new JTable(new TableModelSubita());
		tabla.setDefaultRenderer(Object.class, new RendererRanking());
		tabla.setRowHeight(70);
		
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				busquedaBinaria(listaUsuarios, 0, listaUsuarios.size(), Integer.parseInt(textoPosicion.getText()));
				
			}
		});
		
		JScrollPane scrollpane = new JScrollPane(tabla);
		
		panel.add(label);
		panel.add(textoPosicion);
		panel.add(boton);
		
		this.add(panel, BorderLayout.SOUTH);
		this.add(scrollpane, BorderLayout.CENTER);
		this.setTitle("Ranking del Modo Subita");
		this.pack();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}


	//Modelo de la tabla para el ranking del Modo Muerte Subita
	class TableModelSubita extends AbstractTableModel {

		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		List<String> cabecera = Arrays.asList("", "JUGADOR", "PUNTOS");

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return listaUsuarios.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return cabecera.size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {

			switch (columnIndex) {
			case 0:
				return null;
			case 1:
				return listaUsuarios.get(rowIndex).getNombre();
			case 2:
				return listaUsuarios.get(rowIndex).getPuntuacionSubita();
			default:
				return null;
			}
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public String getColumnName(int column) {
			return cabecera.get(column);
			
			}
		}
}
