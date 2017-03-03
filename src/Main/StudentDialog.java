package Main;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentDialog extends JDialog {
	private JTextField firstNameTxtField;
	private JTextField lastNameTxtFiled;
	private JTextField mobileNumberTxtField;

	public StudentDialog(){
		this.setSize(new Dimension(960, 540));
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblFirstName = new JLabel("First Name:");
		springLayout.putConstraint(SpringLayout.NORTH, lblFirstName, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblFirstName, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		springLayout.putConstraint(SpringLayout.NORTH, lblLastName, 26, SpringLayout.SOUTH, lblFirstName);
		springLayout.putConstraint(SpringLayout.WEST, lblLastName, 0, SpringLayout.WEST, lblFirstName);
		getContentPane().add(lblLastName);
		
		firstNameTxtField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, firstNameTxtField, 0, SpringLayout.NORTH, lblFirstName);
		springLayout.putConstraint(SpringLayout.WEST, firstNameTxtField, 6, SpringLayout.EAST, lblFirstName);
		getContentPane().add(firstNameTxtField);
		firstNameTxtField.setColumns(10);
		
		lastNameTxtFiled = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, lastNameTxtFiled, 0, SpringLayout.NORTH, lblLastName);
		springLayout.putConstraint(SpringLayout.EAST, lastNameTxtFiled, 0, SpringLayout.EAST, firstNameTxtField);
		getContentPane().add(lastNameTxtFiled);
		lastNameTxtFiled.setColumns(10);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number:");
		springLayout.putConstraint(SpringLayout.NORTH, lblMobileNumber, 25, SpringLayout.SOUTH, lblLastName);
		springLayout.putConstraint(SpringLayout.WEST, lblMobileNumber, 0, SpringLayout.WEST, lblFirstName);
		getContentPane().add(lblMobileNumber);
		
		mobileNumberTxtField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, mobileNumberTxtField, 0, SpringLayout.NORTH, lblMobileNumber);
		springLayout.putConstraint(SpringLayout.WEST, mobileNumberTxtField, 6, SpringLayout.EAST, lblMobileNumber);
		getContentPane().add(mobileNumberTxtField);
		mobileNumberTxtField.setColumns(10);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		getContentPane().add(btnAddStudent);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnAddStudent, 0, SpringLayout.NORTH, btnClose);
		springLayout.putConstraint(SpringLayout.EAST, btnAddStudent, -6, SpringLayout.WEST, btnClose);
		springLayout.putConstraint(SpringLayout.SOUTH, btnClose, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnClose, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(btnClose);
	}
	
}
