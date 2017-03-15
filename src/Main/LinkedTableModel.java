package Main;

import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author Josh Youngman
 *
 */

public class LinkedTableModel extends DefaultTableModel {
	
	static String[] columnNames = {
			"First Name",
			"Last Name",
			"Mobile Number",
			"Has Authority",
			"Has Paid?"}; // Column names held in the trip table
	
	/**
	 * Stores all values to be used in the linked table held in the linkedTableGUI class.
	 */
	
	public LinkedTableModel() {
		for (int i = 0; i < columnNames.length; ++i) {
			this.addColumn(columnNames[i]);
		} // Adds the column names to the TripTableModel
	}
	
	 @Override
	 public boolean isCellEditable(int row, int column) {
	    return false;
	 } // Prevents cells in the trip table from being edited
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}  // Returns the amount of columns in the table

	@Override
	public int getRowCount() {
		return super.getRowCount();
	} // Returns the amount of rows in the table

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return super.getValueAt(rowIndex, columnIndex);
	} // Returns the values of all cells held in the table
	
	@Override
	public String getColumnName(final int index) {
		return columnNames[index];
	} // Returns the column names
	
}
