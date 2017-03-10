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
	
	public LinkedTableGUI(Object tripIDVal, DefaultTableModel tableModel) {
		setTitle("Students Linked to Trip");
		this.setSize(new Dimension(611, 540));
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -10, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(scrollPane);
		
		linkedTable = new JTable();
		linkedTable.setModel(tableModel);
		scrollPane.setViewportView(linkedTable);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnClose, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnClose, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(btnClose);
	}
}
