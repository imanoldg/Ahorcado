package gui;

import java.awt.BorderLayout;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import DataBase.MetodosBD;
import domain.Usuario;
import io.ComparadorRankingContrarreloj;
import io.RendererRanking;

public class VentanaRankingContrarreloj extends JFrame{

	private static MetodosBD metodos = new MetodosBD();
	public static List<Usuario> listaUsuarios = metodos.obtenerListaUsuarios();
	protected JTable tabla;
	
	public VentanaRankingContrarreloj() {
		Collections.sort(listaUsuarios, new ComparadorRankingContrarreloj());
		
		tabla = new JTable(new TableModelContrarreloj());
		tabla.setDefaultRenderer(Object.class, new RendererRanking());
		tabla.setRowHeight(70);

		JScrollPane scrollpane = new JScrollPane(tabla);
		
		
		this.add(scrollpane, BorderLayout.CENTER);
		this.setTitle("Ranking del Modo Clasico");
		this.pack();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}
	
	public static void main(String[] args) {
		new VentanaRankingContrarreloj();
	}
	
	class TableModelContrarreloj extends AbstractTableModel{

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
				return listaUsuarios.get(rowIndex).getPuntuacionContrarreloj();
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