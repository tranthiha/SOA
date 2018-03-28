package com.vnu.library.ui;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ColorRenderer extends DefaultTableCellRenderer  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6238960766251797272L;

	public Component getTableCellRendererComponent(JTable table, Object color,
			boolean isSelected, boolean hasFocus, int row, int column) {
		JComponent comp = (JComponent) super.getTableCellRendererComponent(
				table, color, isSelected, hasFocus, row, column);
		comp.setBorder(BorderFactory.createEtchedBorder());
		return comp;
	}
}