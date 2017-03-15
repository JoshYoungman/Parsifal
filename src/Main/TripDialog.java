package Main;

import javax.swing.JDialog;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTable;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Josh Youngman
 *
 */

public class TripDialog extends JDialog {
	
	private static final long serialVersionUID = 2629552485008460364L;
	
	String[] tripTypeArray = {
			"Single Day",
			"Residential"
	}; // Array for both trip type options held in the trip type combo box
	String[] arrangedByArray = {
			"Teacher",
			"External Provider"
	}; // Array for both arranged by options held in the arranged by combo box
	private JTextField transportTxtField;
	private JTextField venueTxtField;
	private JTextField sundryTxtField;
	private static int instanceCounter = 0;
	private int tripCounter = 0;
	
	/**
	 * This Dialog is used to input data into the specified columns in the trip table.
	 * 
	 * @param table
	 */
	
	public TripDialog(JTable table){
		
		this.setSize(new Dimension(960, 540)); // Sets the size of the dialog
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblTripType = new JLabel("Trip Type:"); // Creates an instance of the Label
		springLayout.putConstraint(SpringLayout.NORTH, lblTripType, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblTripType, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblTripType);
		
		JComboBox tripTypeCombo = new JComboBox(this.tripTypeArray); // Creates an instance of the Combo box
		springLayout.putConstraint(SpringLayout.NORTH, tripTypeCombo, 0, SpringLayout.NORTH, lblTripType);
		springLayout.putConstraint(SpringLayout.WEST, tripTypeCombo, 6, SpringLayout.EAST, lblTripType);
		getContentPane().add(tripTypeCombo);
		
		JLabel lblArrangedBy = new JLabel("Arranged By:"); // Creates an instance of the Label
		springLayout.putConstraint(SpringLayout.NORTH, lblArrangedBy, 21, SpringLayout.SOUTH, lblTripType);
		springLayout.putConstraint(SpringLayout.WEST, lblArrangedBy, 0, SpringLayout.WEST, lblTripType);
		getContentPane().add(lblArrangedBy);
		
		JComboBox arrangedByCombo = new JComboBox(this.arrangedByArray); // Creates an instance of the Combo box
		springLayout.putConstraint(SpringLayout.NORTH, arrangedByCombo, 0, SpringLayout.NORTH, lblArrangedBy);
		springLayout.putConstraint(SpringLayout.WEST, arrangedByCombo, 6, SpringLayout.EAST, lblArrangedBy);
		getContentPane().add(arrangedByCombo);
		
		JLabel lblTransport = new JLabel("Transport:"); // Creates an instance of the Label
		springLayout.putConstraint(SpringLayout.NORTH, lblTransport, 20, SpringLayout.SOUTH, lblArrangedBy);
		springLayout.putConstraint(SpringLayout.WEST, lblTransport, 0, SpringLayout.WEST, lblTripType);
		getContentPane().add(lblTransport);
		
		transportTxtField = new JTextField(); // Creates an instance of the Text field
		springLayout.putConstraint(SpringLayout.NORTH, transportTxtField, 18, SpringLayout.SOUTH, arrangedByCombo);
		springLayout.putConstraint(SpringLayout.WEST, transportTxtField, 0, SpringLayout.WEST, tripTypeCombo);
		getContentPane().add(transportTxtField);
		transportTxtField.setColumns(10);
		
		JLabel lblVenue = new JLabel("Venue:"); // Creates an instance of the Label
		springLayout.putConstraint(SpringLayout.NORTH, lblVenue, 24, SpringLayout.SOUTH, lblTransport);
		springLayout.putConstraint(SpringLayout.WEST, lblVenue, 0, SpringLayout.WEST, lblTripType);
		getContentPane().add(lblVenue);
		
		venueTxtField = new JTextField(); // Creates an instance of the Text field
		springLayout.putConstraint(SpringLayout.NORTH, venueTxtField, 0, SpringLayout.NORTH, lblVenue);
		springLayout.putConstraint(SpringLayout.WEST, venueTxtField, 6, SpringLayout.EAST, lblVenue);
		getContentPane().add(venueTxtField);
		venueTxtField.setColumns(10);
		
		JLabel lblSundryCosts = new JLabel("Sundry Costs:"); // Creates an instance of the Label
		springLayout.putConstraint(SpringLayout.NORTH, lblSundryCosts, 15, SpringLayout.SOUTH, venueTxtField);
		springLayout.putConstraint(SpringLayout.WEST, lblSundryCosts, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblSundryCosts);
		
		sundryTxtField = new JTextField(); // Creates an instance of the Text field
		springLayout.putConstraint(SpringLayout.NORTH, sundryTxtField, 0, SpringLayout.NORTH, lblSundryCosts);
		springLayout.putConstraint(SpringLayout.WEST, sundryTxtField, 6, SpringLayout.EAST, lblSundryCosts);
		getContentPane().add(sundryTxtField);
		sundryTxtField.setColumns(10);
		
		JButton btnClose = new JButton("Close"); // Creates an instance of the Close button
		btnClose.setToolTipText("Closes the current dialog"); // Close button tooltip
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // Closes the window
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnClose, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnClose, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(btnClose);
		
		JButton btnAddTrip = new JButton("Add Trip"); // Creates an instance of the Add trip button
		btnAddTrip.setToolTipText("Adds a trip to the trip table with the data entered in the text fields and combo boxes.");
		// Add trip button tooltip
		btnAddTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel defModel = (DefaultTableModel)table.getModel();
				// Creates an instance of DefaultTableModel
				instanceCounter++; // Increments static instanceCounter variable
				tripCounter = instanceCounter; // Sets the tripCounter variable equal to instanceCounter

				defModel.addRow(new Object[]{tripCounter,tripTypeCombo.getSelectedItem(), arrangedByCombo.getSelectedItem(), 
						transportTxtField.getText(), venueTxtField.getText(), sundryTxtField.getText()});
				// Adds all of the data held in the text fields/combo boxes to defModel
				dispose(); // Closes the window
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnAddTrip, 0, SpringLayout.NORTH, btnClose);
		springLayout.putConstraint(SpringLayout.EAST, btnAddTrip, -5, SpringLayout.WEST, btnClose);
		getContentPane().add(btnAddTrip);
		
	}
}