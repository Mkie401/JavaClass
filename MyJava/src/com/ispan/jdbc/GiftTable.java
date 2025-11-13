package com.ispan.jdbc;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ispan.apis.GiftDB;

public class GiftTable extends JTable{
	private GiftDB db;
	public GiftTable() {
		try {
			db = new GiftDB();
			db.queryDB();
		} catch (Exception e) {
			System.out.println(e);
		}
		setModel(new MyModal());
	}
	
	public void delRow() {
		int delNum = getSelectedRow();
		if (delNum >= 0)db.delData(delNum);
		repaint();
	}
	
	public void addRow() {
		// todo
	}
	
	private class MyModal extends DefaultTableModel {

		@Override
		public int getRowCount() {
			try {
				return db.getRows();
			} catch (Exception e) {
				System.out.println(e);
				return 0;
			}
		}

		@Override
		public int getColumnCount() {
			
			return db.getCols();
		}

		@Override
		public Object getValueAt(int row, int column) {
			
			return db.getData(row, column);
		}

		@Override
		public String getColumnName(int column) {
			
			return db.getColName(column);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			
			return column > 0;
		}

		@Override
		public void setValueAt(Object aValue, int row, int column) {
			
			try {
				db.setData(aValue, row, column);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "ERROR");
			}
		}
		
		
		
	}
}
