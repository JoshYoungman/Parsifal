package Main;

import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author Josh Youngman
 *
 */

public class TripTableModel extends DefaultTableModel {

	private static final long serialVersionUID = -3176216830997803136L;

	static String[] columnNames = {
			"Trip ID",
			"Trip Type",
			"Arranged By",
			"Transport",
			"Venue",
			"Sundry Costs"}; // Column names held in the trip table
	
	/**
	 * Stores all values to be used in the trip table held in the GUI class.
	 */
	
	public TripTableModel() {
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
	} // Returns the amount of columns in the table

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
