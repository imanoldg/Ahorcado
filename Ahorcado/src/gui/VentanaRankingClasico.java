package gui;

import java.awt.BorderLayout;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import DataBase.MetodosBD;
import domain.Usuario;

public class VentanaRankingClasico extends JFrame{

	private MetodosBD metodos = new MetodosBD();
	public Map<Integer, Usuario> mapaUsuarios = metodos.obtenerListaUsuarios();
	
	class TableModel extends AbstractTableModel{


		String[] cabecera = {"", "JUGADOR", "PUNTOS"};
		
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return mapaUsuarios.keySet().size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return cabecera.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {

			switch (columnIndex) {
			case 0 : return null;
			case 1: return mapaUsuarios.get(rowIndex);
			case 2: return mapaUsuarios.get(rowIndex).getPuntuacionClasico();
			default: return null;
			}
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return false;
		}
		
		
	}
	
	
	public VentanaRankingClasico() {
		
		JTable tabla = new JTable(new TableModel());
		
		JScrollPane scrollpane = new JScrollPane(tabla);
		
		
		this.add(scrollpane, BorderLayout.CENTER);
		this.setTitle("Ranking del Modo Clasico");
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}
	
	public static void main(String[] args) {
		new VentanaRankingClasico();
	}
}


