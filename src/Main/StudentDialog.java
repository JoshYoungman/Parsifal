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

public class StudentDialog extends JDialog {
	
	String[] authorityArray = {
			"Y",
			"N"
	};
	
	private JTextField firstNameTxtField;
	private JTextField lastNameTxtField;
	private JTextField mobileNumberTxtField;
	private Object tripIDVal;
	
	private JTable table;
	
	public StudentDialog(JTable table, Object tripIDVal) {
		this.table = table;
		this.tripIDVal = tripIDVal;
		
		this.setSize(new Dimension(555, 423));
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblFirstName = new JLabel("First Name:");
		springLayout.putConstraint(SpringLayout.NORTH, lblFirstName, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblFirstName, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		springLayout.putConstraint(SpringLayout.NORTH, lblLastName, 35, SpringLayout.SOUTH, lblFirstName);
		springLayout.putConstraint(SpringLayout.WEST, lblLastName, 0, SpringLayout.WEST, lblFirstName);
		getContentPane().add(lblLastName);
		
		firstNameTxtField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, firstNameTxtField, 0, SpringLayout.NORTH, lblFirstName);
		springLayout.putConstraint(SpringLayout.EAST, firstNameTxtField, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(firstNameTxtField);
		firstNameTxtField.setColumns(10);
		
		lastNameTxtField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, lastNameTxtField, 0, SpringLayout.NORTH, lblLastName);
		springLayout.putConstraint(SpringLayout.EAST, lastNameTxtField, 0, SpringLayout.EAST, firstNameTxtField);
		getContentPane().add(lastNameTxtField);
		lastNameTxtField.setColumns(10);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number:");
		springLayout.putConstraint(SpringLayout.NORTH, lblMobileNumber, 35, SpringLayout.SOUTH, lblLastName);
		springLayout.putConstraint(SpringLayout.WEST, lblMobileNumber, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblMobileNumber);
		
		mobileNumberTxtField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, mobileNumberTxtField, 0, SpringLayout.NORTH, lblMobileNumber);
		springLayout.putConstraint(SpringLayout.WEST, mobileNumberTxtField, 0, SpringLayout.WEST, firstNameTxtField);
		getContentPane().add(mobileNumberTxtField);
		mobileNumberTxtField.setColumns(10);
		
		JLabel lblHasAuthority = new JLabel("Has Authority?");
		springLayout.putConstraint(SpringLayout.NORTH, lblHasAuthority, 35, SpringLayout.SOUTH, lblMobileNumber);
		springLayout.putConstraint(SpringLayout.WEST, lblHasAuthority, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblHasAuthority);
		
		JComboBox hasAuthorityCombo = new JComboBox(authorityArray);
		springLayout.putConstraint(SpringLayout.NORTH, hasAuthorityCombo, 0, SpringLayout.NORTH, lblHasAuthority);
		springLayout.putConstraint(SpringLayout.WEST, hasAuthorityCombo, 0, SpringLayout.WEST, firstNameTxtField);
		getContentPane().add(hasAuthorityCombo);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnClose, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnClose, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(btnClose);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel defModel = (DefaultTableModel)table.getModel();
				defModel.addRow(new Object[]{firstNameTxtField.getText(), lastNameTxtField.getText(), 
						mobileNumberTxtField.getText(), hasAuthorityCombo.getSelectedItem(),tripIDVal});
				dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnAddStudent, 0, SpringLayout.NORTH, btnClose);
		springLayout.putConstraint(SpringLayout.EAST, btnAddStudent, -6, SpringLayout.WEST, btnClose);
		getContentPane().add(btnAddStudent);
	}
}
