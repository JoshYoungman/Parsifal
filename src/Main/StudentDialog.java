package Main;

import javax.swing.JDialog;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Josh Youngman
 *
 */

public class StudentDialog extends JDialog {
	
	String[] authorityArray = {
			"Y",
			"N"
	};
	// Array for both options held in the Authority combo box
	String[] paidArray = {
			"Y",
			"N"
	};
	// Array for both options held in the Paid combo box
	private JTextField firstNameTxtField;
	private JTextField lastNameTxtField;
	private JTextField mobileNumberTxtField;
	private JComboBox hasPaidCombo;
	private Object tripIDVal;
	
	private JTable table;
	
	/**
	 * This Dialog is used to input data into the specified columns in the student table using the selected
	 * row from the trip table to link a student to a trip.
	 * 
	 * @param table
	 * @param tripIDVal - The trip id value held in the trip table.
	 */
	
	public StudentDialog(JTable table, Object tripIDVal) {
		this.table = table;
		this.tripIDVal = tripIDVal; // Passed in from GUI
		
		this.setSize(new Dimension(555, 477)); // Sets the size of the dialog
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblFirstName = new JLabel("First Name:"); // Creates Label
		springLayout.putConstraint(SpringLayout.NORTH, lblFirstName, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblFirstName, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:"); // Creates Label
		springLayout.putConstraint(SpringLayout.WEST, lblLastName, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblLastName);
		
		firstNameTxtField = new JTextField(); // Creates Text field
		springLayout.putConstraint(SpringLayout.NORTH, firstNameTxtField, 0, SpringLayout.NORTH, lblFirstName);
		springLayout.putConstraint(SpringLayout.EAST, firstNameTxtField, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(firstNameTxtField);
		firstNameTxtField.setColumns(10);
		
		lastNameTxtField = new JTextField(); // Creates Text field
		springLayout.putConstraint(SpringLayout.NORTH, lastNameTxtField, 29, SpringLayout.SOUTH, firstNameTxtField);
		springLayout.putConstraint(SpringLayout.NORTH, lblLastName, 0, SpringLayout.NORTH, lastNameTxtField);
		springLayout.putConstraint(SpringLayout.EAST, lastNameTxtField, 0, SpringLayout.EAST, firstNameTxtField);
		getContentPane().add(lastNameTxtField);
		lastNameTxtField.setColumns(10);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number:"); // Creates Label
		springLayout.putConstraint(SpringLayout.WEST, lblMobileNumber, 0, SpringLayout.WEST, lblFirstName);
		getContentPane().add(lblMobileNumber);
		
		mobileNumberTxtField = new JTextField(); // Creates Text field
		springLayout.putConstraint(SpringLayout.NORTH, mobileNumberTxtField, 29, SpringLayout.SOUTH, lastNameTxtField);
		springLayout.putConstraint(SpringLayout.NORTH, lblMobileNumber, 0, SpringLayout.NORTH, mobileNumberTxtField);
		springLayout.putConstraint(SpringLayout.WEST, mobileNumberTxtField, 0, SpringLayout.WEST, firstNameTxtField);
		getContentPane().add(mobileNumberTxtField);
		mobileNumberTxtField.setColumns(10);
		
		JLabel lblHasAuthority = new JLabel("Has Authority?"); // Creates Label
		springLayout.putConstraint(SpringLayout.WEST, lblHasAuthority, 0, SpringLayout.WEST, lblFirstName);
		getContentPane().add(lblHasAuthority);
		
		JComboBox hasAuthorityCombo = new JComboBox(authorityArray); // Creates Combo box
		springLayout.putConstraint(SpringLayout.NORTH, hasAuthorityCombo, 29, SpringLayout.SOUTH, mobileNumberTxtField);
		springLayout.putConstraint(SpringLayout.NORTH, lblHasAuthority, 0, SpringLayout.NORTH, hasAuthorityCombo);
		springLayout.putConstraint(SpringLayout.WEST, hasAuthorityCombo, 0, SpringLayout.WEST, firstNameTxtField);
		getContentPane().add(hasAuthorityCombo);
		
		JButton btnClose = new JButton("Close"); // Creates Close button
		btnClose.setToolTipText("Closes the current dialog"); // Close button tooltip
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose(); // Closes the window
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnClose, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnClose, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(btnClose);
		
		JLabel lblHasPaid = new JLabel("Has Paid?"); // Creates Label
		springLayout.putConstraint(SpringLayout.NORTH, lblHasPaid, 35, SpringLayout.SOUTH, lblHasAuthority);
		springLayout.putConstraint(SpringLayout.WEST, lblHasPaid, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblHasPaid);
		
		JComboBox hasPaidCombo = new JComboBox(paidArray); // Creates Combo box
		springLayout.putConstraint(SpringLayout.NORTH, hasPaidCombo, 0, SpringLayout.NORTH, lblHasPaid);
		springLayout.putConstraint(SpringLayout.WEST, hasPaidCombo, 0, SpringLayout.WEST, firstNameTxtField);
		getContentPane().add(hasPaidCombo);
		
		JButton btnAddStudent = new JButton("Add Student"); // Creates Add Student button
		btnAddStudent.setToolTipText("Adds a student to the student table with the data entered in the text fields and combo boxes.");
		// Add Student tooltip
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel defModel = (DefaultTableModel)table.getModel();
				// Creates an instance of DefaultTableModel
				defModel.addRow(new Object[]{firstNameTxtField.getText(), lastNameTxtField.getText(), mobileNumberTxtField.getText(), 
						hasAuthorityCombo.getSelectedItem(), hasPaidCombo.getSelectedItem(),tripIDVal});
				// Adds all of the data held in the text fields/combo boxes to defModel
				dispose(); // Closes the window
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnAddStudent, 0, SpringLayout.NORTH, btnClose);
		springLayout.putConstraint(SpringLayout.EAST, btnAddStudent, -6, SpringLayout.WEST, btnClose);
		getContentPane().add(btnAddStudent);
	}
}
