package Main;

import javax.swing.table.DefaultTableModel;

public class TripTableModel extends DefaultTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3176216830997803136L;

	static String[] columnNames = {
			"Trip ID",
			"Trip Type",
			"Arranged By",
			"Transport",
			"Venue",
			"Sundry Costs"};
	
	static String[][] rowData = {
			
	};
	
	public TripTableModel() {
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
