package Main;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LinkedTableGUI extends JFrame {
	
	private JTable linkedTable;
	
	/**
	 * This is a window used to display the students linked to the trip selected, before clicking the
	 * 'View Students' button
	 * 
	 * @param tripIDVal - The trip id value held in the trip table.
	 * @param tableModel - DefaultTableModel
	 */
	
	public LinkedTableGUI(Object tripIDVal, DefaultTableModel tableModel) {
		setTitle("Students Linked to Trip");// Sets the title of the window
		this.setSize(new Dimension(611, 540)); // Sets the dimentions of the window
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JScrollPane scrollPane = new JScrollPane(); // Creates an instance of the scroll pane
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -10, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(scrollPane);
		
		linkedTable = new JTable(); // Creates an instance of the linkedTable
		linkedTable.setModel(tableModel); // Sets the model of the linkedTable
		scrollPane.setViewportView(linkedTable); // Sets the linkedTable to a scroll pane
		
		JButton btnClose = new JButton("Close"); // Creates an instance of the close button
		btnClose.setToolTipText("Closes the current dialog"); // Close button dialog
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose(); // Closes the window
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnClose, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnClose, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(btnClose);
	}
}
