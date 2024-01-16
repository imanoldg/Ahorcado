package io;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class RendererRanking extends JLabel implements TableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RendererRanking() {
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
