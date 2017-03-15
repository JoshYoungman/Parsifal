package Main;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Josh Youngman
 *
 */
public class GUI extends JFrame {
 
	private static final long serialVersionUID = -7082040179903724243L;
	
	private JTable tripJTable;
	private JTable studentJTable; // Declare both JTables used in the GUI
	
	/**
	 * This window displays both the trip and student tables including buttons to display windows/dialogs for adding
	 * students/trips, removing students/trips, viewing the help dialog, and viewing the linked table.
	 *  
	 * @param title - Sets the title of the GUI window
	 */
	
	public GUI(final String title) {
		super(title);
			
		this.setBounds(100, 100, 1000, 540); // Sets the size of the JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Application is exited when closed
		SpringLayout springLayout = new SpringLayout(); // Creates Spring Layout
		this.getContentPane().setLayout(springLayout);
		
		JScrollPane scrollPane = new JScrollPane(); // Creates scrollPane
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.NORTH, this.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, this.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 442, SpringLayout.NORTH, this.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 360, SpringLayout.WEST, this.getContentPane());
		this.getContentPane().add(scrollPane);
		
		JButton btnAddTrip = new JButton("Add Trip"); // Creates Add Trip button
		btnAddTrip.setToolTipText("Opens a dialog to input data fields for a trip addition."); // Tooltip for Add Trip button
		springLayout.putConstraint(SpringLayout.NORTH, btnAddTrip, 0, SpringLayout.NORTH, scrollPane);
		springLayout.putConstraint(SpringLayout.EAST, btnAddTrip, -10, SpringLayout.EAST, getContentPane());
		btnAddTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TripDialog tripDialog = new TripDialog(tripJTable); // Creates an instance of the class
				tripDialog.setVisible(true); // Displays the trip dialog
			}
		});
		this.getContentPane().add(btnAddTrip);
		
		tripJTable = new JTable(); // Creates the trip table
		tripJTable.setModel(new TripTableModel()); // Sets the model of the trip table to TripTableModel
		scrollPane.setViewportView(tripJTable); // Adds the trip table to the scroll pane
		
		JButton btnAddStudent = new JButton("Add Student"); // Creates Add Student button
		btnAddStudent.setToolTipText("Opens a dialog to input data fields for a student addition. "
				+ "Requires a trip to be selected."); // Add Student button tooltip
		springLayout.putConstraint(SpringLayout.EAST, btnAddStudent, 0, SpringLayout.EAST, btnAddTrip);
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int selectedRow = tripJTable.getSelectedRow(); // Row number of selected row
					Object tripIDVal = tripJTable.getModel().getValueAt(selectedRow, 0); // Value held in the first column of the selected row
					StudentDialog studentDialog = new StudentDialog(studentJTable, tripIDVal); 
					// Creates an instance of the student dialog passing over the student table and value held in the first column of the selected row
					studentDialog.setVisible(true); // Displays the student dialog
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please select a Trip "
							+ "before adding a Student."); // Dialog text displayed if there is an exception
				}
			}
		});
		this.getContentPane().add(btnAddStudent);
		
		JButton btnClose = new JButton("Close"); // Creates the Close button
		btnClose.setToolTipText("Closes the program."); // Close button tooltip
		springLayout.putConstraint(SpringLayout.EAST, btnClose, -10, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnClose, -10, SpringLayout.SOUTH, getContentPane());
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // Closes the application
			}
		});
		getContentPane().add(btnClose);
		
		JScrollPane scrollPane_1 = new JScrollPane(); // Creates a scroll pane
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane_1, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scrollPane_1, 6, SpringLayout.EAST, scrollPane);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane_1, 442, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane_1, 356, SpringLayout.EAST, scrollPane);
		getContentPane().add(scrollPane_1);
		
		studentJTable = new JTable(); // Creates student table
		studentJTable.setModel(new StudentTableModel()); // Sets the model of the student table to StudentTableModel
		scrollPane_1.setViewportView(studentJTable); // Student table held in the scroll pane
		
		JButton btnRemoveTrip = new JButton("Remove Trip"); // Creates Remove Trip button
		btnRemoveTrip.setToolTipText("Removes a trip from the trip table. Requires a trip "
				+ "to be selected."); // Remove Trip button tooltip
		springLayout.putConstraint(SpringLayout.NORTH, btnRemoveTrip, 6, SpringLayout.SOUTH, btnAddTrip);
		springLayout.putConstraint(SpringLayout.EAST, btnRemoveTrip, 0, SpringLayout.EAST, btnAddTrip);
		btnRemoveTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DefaultTableModel defModel = (DefaultTableModel)tripJTable.getModel(); 
					// Creates an instance of DefaultTableModel for the trip table
					int selectedRow = tripJTable.getSelectedRow(); // Declare value of selected row in trip table
					if(selectedRow != -1) {
						defModel.removeRow(selectedRow); // Removes selected row
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please select a Trip before "
							+ "removing a Trip."); // Dialog text displayed if there is an exception
				}
			}
		});
		getContentPane().add(btnRemoveTrip);
		
		JButton btnRemoveStudent = new JButton("Remove Student"); // Creates Remove Student button
		btnRemoveStudent.setToolTipText("Removes a student from the student table. "
				+ "Requires a student to be selected."); // Remove Student button tooltip
		springLayout.putConstraint(SpringLayout.NORTH, btnRemoveStudent, 166, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnAddStudent, -6, SpringLayout.NORTH, btnRemoveStudent);
		springLayout.putConstraint(SpringLayout.EAST, btnRemoveStudent, 0, SpringLayout.EAST, btnAddTrip);
		btnRemoveStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DefaultTableModel defModel = (DefaultTableModel)studentJTable.getModel();
					// Creates an instance of DefaultTableModel for the student table
					int selectedRow = studentJTable.getSelectedRow(); // Declare value of selected row in student table
					if(selectedRow != -1) {
						defModel.removeRow(selectedRow); // Removes selected row
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please select a Student "
							+ "before removing a Student."); // Dialog text displayed if there is an exception
				}
			}
		});
		getContentPane().add(btnRemoveStudent);
		
		JButton btnViewStudents = new JButton("View Students"); // Creates View Students button
		btnViewStudents.setToolTipText("Opens a window displaying all of the student "
				+ "linked to the currently selected trip. Requires a trip to be selected."); // View Students tooltip
		springLayout.putConstraint(SpringLayout.NORTH, btnViewStudents, 60, SpringLayout.SOUTH, btnRemoveStudent);
		springLayout.putConstraint(SpringLayout.EAST, btnViewStudents, 0, SpringLayout.EAST, btnAddTrip);
		btnViewStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int selectedRow = tripJTable.getSelectedRow(); // Declare value of selected row in trip table
					Object tripIDVal = tripJTable.getModel().getValueAt(selectedRow, 0); // Value held in the first column of the selected row
					LinkedTableModel linkedTableModel = new LinkedTableModel(); // Creates and instance of LinkedTableModel
					
					for (int i = 0; i < studentJTable.getModel().getRowCount(); ++i){
						Object studentValue = studentJTable.getModel().getValueAt(i, 5);
						if ((int)studentValue == (int)tripIDVal) {
							linkedTableModel.addRow(new Object[]{
									studentJTable.getModel().getValueAt(i, 0),
									studentJTable.getModel().getValueAt(i, 1),
									studentJTable.getModel().getValueAt(i, 2),
									studentJTable.getModel().getValueAt(i, 3),
									studentJTable.getModel().getValueAt(i, 4)});
						}
					} // Loop to add students to a table that match the trip they were added to
					LinkedTableGUI linkedTableGUI = new LinkedTableGUI(tripIDVal, linkedTableModel); // Creates an instance of LinkedTableGUI
					linkedTableGUI.setVisible(true); // Displays LinkedTableGUI
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please select a Trip "
							+ "before viewing Students."); // Dialog text displayed if there is an exception
				}				
			}
		});
		getContentPane().add(btnViewStudents);
		
		JButton btnHelp = new JButton("Help"); // Creates the Help button
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelpDialog helpDialog = new HelpDialog(); // Creates an instance of HelpDialog
				helpDialog.setVisible(true); // Displays the help dialog
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnHelp, -6, SpringLayout.NORTH, btnClose);
		springLayout.putConstraint(SpringLayout.EAST, btnHelp, 0, SpringLayout.EAST, btnAddTrip);
		getContentPane().add(btnHelp);
	}
}
