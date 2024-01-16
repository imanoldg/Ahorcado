package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import DataBase.MetodosBD;
import domain.Usuario;
import io.ComparadorRankingClasico;

public class VentanaRankingClasico extends JFrame {

	private static MetodosBD metodos = new MetodosBD();
	public static List<Usuario> listaUsuarios = metodos.obtenerListaUsuarios();

	public VentanaRankingClasico() {
		
		Collections.sort(listaUsuarios, new ComparadorRankingClasico());
		
		JTable tabla = new JTable(new TableModel());
		tabla.setDefaultRenderer(Object.class, new Renderer());
		tabla.setRowHeight(70);

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
		System.out.println(listaUsuarios);
	}

	class TableModel extends AbstractTableModel {

		
		String[] cabecera = { "", "JUGADOR", "PUNTOS" };

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return listaUsuarios.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return cabecera.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {

			switch (columnIndex) {
			case 0:
				return null;
			case 1:
				return listaUsuarios.get(rowIndex).getNombre();
			case 2:
				return listaUsuarios.get(rowIndex).getPuntuacionClasico();
			default:
				return null;
			}
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return false;
		}

	}

	class Renderer extends JLabel implements TableCellRenderer {

		public Renderer() {
			setOpaque(true);
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {

			setBackground(new Color(245, 245, 220));

			switch (row) {
			case 0:
				switch (column) {
				case 0:
					setIcon(new ImageIcon("resources/images/Medalla_1.png"));
					setText("");
					setHorizontalAlignment(CENTER);
					break;
				default:
					if (column != 0) {
						setText(value.toString());
					} else {
						setText("");
					}

					setIcon(null);
				}
				setBackground(new Color(255, 215, 0));
				break;

			case 1:
				switch (column) {
				case 0:
					setIcon(new ImageIcon("resources/images/Medalla_2.png"));
					setText("");
					setHorizontalAlignment(CENTER);
					break;
				default:
					if (column != 0) {
						setText(value.toString());
					} else {
						setText("");
					}
					setIcon(null);
				}

				setBackground(new Color(192, 192, 192));
				break;

			case 2:
				switch (column) {
				case 0:
					setIcon(new ImageIcon("resources/images/Medalla_3.png"));
					setText("");
					setHorizontalAlignment(CENTER);
					break;
				default:
					if (column != 0) {
						setText(value.toString());
					} else {
						setText("");
					}
					setIcon(null);
				}
				setBackground(new Color(210, 105, 30));
				break;

			default:
				if (column != 0) {
					setText(value.toString());
				} else {
					setText("");
				}
			}

			return this;
		}
		

	}

}
