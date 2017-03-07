package Main;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7082040179903724243L;
	
	private JTable tripJTable;
	private JTable studentJTable;
	
	
	/**
	 * Create the application.
	 */
	public GUI(final String title) {
		super(title);
		
		
		
		this.setBounds(100, 100, 960, 540);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		this.getContentPane().setLayout(springLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.NORTH, this.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, this.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 442, SpringLayout.NORTH, this.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 360, SpringLayout.WEST, this.getContentPane());
		this.getContentPane().add(scrollPane);
		
		JButton btnAddTrip = new JButton("Add Trip");
		springLayout.putConstraint(SpringLayout.NORTH, btnAddTrip, 10, SpringLayout.NORTH, getContentPane());
		btnAddTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TripDialog tripDialog = new TripDialog(tripJTable);
				tripDialog.setVisible(true);
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, btnAddTrip, -10, SpringLayout.EAST, this.getContentPane());
		this.getContentPane().add(btnAddTrip);
		
		tripJTable = new JTable();
		tripJTable.setModel(new TripTableModel());
		scrollPane.setViewportView(tripJTable);
		
		JButton btnAddStudent = new JButton("Add Student");
		springLayout.putConstraint(SpringLayout.EAST, btnAddStudent, -10, SpringLayout.EAST, getContentPane());
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentDialog studentDialog = new StudentDialog(studentJTable);
				studentDialog.setVisible(true);
			}
		});
		this.getContentPane().add(btnAddStudent);
		
		JButton btnClose = new JButton("Close");
		springLayout.putConstraint(SpringLayout.SOUTH, btnAddStudent, -149, SpringLayout.NORTH, btnClose);
		springLayout.putConstraint(SpringLayout.SOUTH, btnClose, -10, SpringLayout.SOUTH, getContentPane());
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, btnClose, 0, SpringLayout.EAST, btnAddTrip);
		getContentPane().add(btnClose);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane_1, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scrollPane_1, 6, SpringLayout.EAST, scrollPane);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane_1, 442, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane_1, 356, SpringLayout.EAST, scrollPane);
		getContentPane().add(scrollPane_1);
		
		studentJTable = new JTable();
		studentJTable.setModel(new StudentTableModel());
		scrollPane_1.setViewportView(studentJTable);
		
		JButton btnRemoveTrip = new JButton("Remove Trip");
		btnRemoveTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel defModel = (DefaultTableModel)tripJTable.getModel();
				int selectedRow = tripJTable.getSelectedRow();
				if(selectedRow != -1) {
					defModel.removeRow(selectedRow);
				}
				//tripJTable.removeRowSelectionInterval(selectedRow, selectedRow);
				//table.remov
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnRemoveTrip, 6, SpringLayout.SOUTH, btnAddTrip);
		springLayout.putConstraint(SpringLayout.EAST, btnRemoveTrip, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(btnRemoveTrip);
	}
}
