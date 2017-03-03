package Main;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class TripTableModel extends AbstractTableModel {
	static String[] columnNames = {"Trip Type",
			"Arranged By",
			"Transport",
			"Venue",
			"Sundry Costs"};
	
	static String[][] rowData = {
			
	};
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getColumnName(final int index) {
		return columnNames[index];
	}
	
}
