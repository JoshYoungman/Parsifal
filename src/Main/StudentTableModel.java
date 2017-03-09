package Main;

import javax.swing.table.DefaultTableModel;

public class StudentTableModel extends DefaultTableModel {
	static String[] columnNames = {"First Name",
			"Last Name",
			"Mobile Number",
			"Has Authority?",
			"Linked Trip"};
	
	static String[][] rowData = {
			
	};
	
	public StudentTableModel() {
		for (int i = 0; i < columnNames.length; ++i) {
			this.addColumn(columnNames[i]);
		}
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return super.getRowCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return super.getValueAt(rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(final int index) {
		return columnNames[index];
	}
}
