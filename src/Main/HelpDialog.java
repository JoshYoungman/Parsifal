package Main;

import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Josh Youngman
 *
 */

public class HelpDialog extends JDialog {
	
	/**
	 * Displays a dialog explaining how to use the application.
	 */
	
	public HelpDialog() {
		this.setSize(new Dimension(700, 650));
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblApplication = new JLabel("What is the Application:"); // Creates an instance of the label
		getContentPane().add(lblApplication);
		
		JTextArea applicationTxtArea = new JTextArea(); // Creates an instance of the text area
		applicationTxtArea.setLineWrap(true); // Wraps the text held in the JTextArea
		applicationTxtArea.setWrapStyleWord(true); // Prevents words from being split when the text wraps
		applicationTxtArea.setText("This software is used to create trips for Parsifal College and add students to "
				+ "these trips."); // Text included the in JTextArea
		getContentPane().add(applicationTxtArea);
		
		JLabel lblCreatingATrip = new JLabel("Creating a Trip:"); // Creates an instance of the label
		getContentPane().add(lblCreatingATrip);
		
		JTextArea tripTxtArea = new JTextArea(); // Creates an instance of the text area
		tripTxtArea.setText("To create a trip, left click on the 'Add Trip' button. A dialog will be displayed"
				+ " where you area able to add information about the said trip. Once the information has been added,"
				+ " click the 'Add Trip' button on the dialog.");
		tripTxtArea.setLineWrap(true); // Wraps the text held in the JTextArea
		tripTxtArea.setWrapStyleWord(true); // Prevents words from being split when the text wraps
		getContentPane().add(tripTxtArea);
		
		JLabel lblAddingAStudent = new JLabel("Adding a Student:"); // Creates an instance of the label
		getContentPane().add(lblAddingAStudent);
		
		JTextArea studentTxtArea = new JTextArea(); // Creates an instance of the text area
		studentTxtArea.setText("To add a student, left click on an already inputted trip and left click the 'Add Student' button."
				+ " A dialog will be displayed where you are able to add information about the said student. Once the information"
				+ " has been added, click the 'Add Student' button on the dialog.");
		studentTxtArea.setLineWrap(true); // Wraps the text held in the JTextArea
		studentTxtArea.setWrapStyleWord(true); // Prevents words from being split when the text wraps
		getContentPane().add(studentTxtArea);
		
		JLabel lblViewLinkedStudents = new JLabel("View Linked Students:"); // Creates an instance of the label
		getContentPane().add(lblViewLinkedStudents);
		
		JTextArea linkedTxtArea = new JTextArea(); // Creates an instance of the text area
		linkedTxtArea.setText("To view linked students, left click on a trip in the trip table that has had student linked to it"
				+ " (if a trip with no students is selected, an empty table will be displayed). Once a trip is selected,"
				+ " left click on the 'View Students' button. A dialog will be displayed with a table displaying all of the"
				+ " students linked to the selected trip.");
		linkedTxtArea.setLineWrap(true); // Wraps the text held in the JTextArea
		linkedTxtArea.setWrapStyleWord(true); // Prevents words from being split when the text wraps
		getContentPane().add(linkedTxtArea);
		
		JLabel lblRemoveTripstudent = new JLabel("Remove Trip/Student:"); // Creates an instance of the label
		getContentPane().add(lblRemoveTripstudent);
		
		JTextArea removeTxtArea = new JTextArea(); // Creates an instance of the text area
		removeTxtArea.setText("To remove a trip or student, left click on a trip/student so the row becomes highlighted."
				+ " Left click on the respective remove button.");
		removeTxtArea.setLineWrap(true); // Wraps the text held in the JTextArea
		removeTxtArea.setWrapStyleWord(true); // Prevents words from being split when the text wraps
		getContentPane().add(removeTxtArea);
		
		JButton btnClose = new JButton("Close"); // Creates an instance of the close button
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		getContentPane().add(btnClose);
	}
}
