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
		
		
		
		this.setBounds(100, 100, 1000, 540);
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
		springLayout.putConstraint(SpringLayout.NORTH, btnAddTrip, 0, SpringLayout.NORTH, scrollPane);
		btnAddTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TripDialog tripDialog = new TripDialog(tripJTable);
				tripDialog.setVisible(true);
			}
		});
		this.getContentPane().add(btnAddTrip);
		
		tripJTable = new JTable();
		tripJTable.setModel(new TripTableModel());
		scrollPane.setViewportView(tripJTable);
		
		JButton btnAddStudent = new JButton("Add Student");
		springLayout.putConstraint(SpringLayout.SOUTH, btnAddStudent, -201, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnAddTrip, 0, SpringLayout.EAST, btnAddStudent);
		springLayout.putConstraint(SpringLayout.EAST, btnAddStudent, -10, SpringLayout.EAST, getContentPane());
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedRow = tripJTable.getSelectedRow();
				Object tripIDVal = tripJTable.getModel().getValueAt(selectedRow, 0);
				StudentDialog studentDialog = new StudentDialog(studentJTable, tripIDVal);
				studentDialog.setVisible(true);
			}
		});
		this.getContentPane().add(btnAddStudent);
		
		JButton btnClose = new JButton("Close");
		springLayout.putConstraint(SpringLayout.EAST, btnClose, -10, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnClose, -10, SpringLayout.SOUTH, getContentPane());
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
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
		springLayout.putConstraint(SpringLayout.NORTH, btnRemoveTrip, 6, SpringLayout.SOUTH, btnAddTrip);
		springLayout.putConstraint(SpringLayout.EAST, btnRemoveTrip, 0, SpringLayout.EAST, btnAddTrip);
		btnRemoveTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel defModel = (DefaultTableModel)tripJTable.getModel();
				int selectedRow = tripJTable.getSelectedRow();
				if(selectedRow != -1) {
					defModel.removeRow(selectedRow);
				}
			}
		});
		getContentPane().add(btnRemoveTrip);
		
		JButton btnRemoveStudent = new JButton("Remove Student");
		springLayout.putConstraint(SpringLayout.NORTH, btnRemoveStudent, 6, SpringLayout.SOUTH, btnAddStudent);
		springLayout.putConstraint(SpringLayout.EAST, btnRemoveStudent, 0, SpringLayout.EAST, btnAddTrip);
		btnRemoveStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel defModel = (DefaultTableModel)studentJTable.getModel();
				int selectedRow = studentJTable.getSelectedRow();
				if(selectedRow != -1) {
					defModel.removeRow(selectedRow);
				}
			}
		});
		getContentPane().add(btnRemoveStudent);
	}
}
