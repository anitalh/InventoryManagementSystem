package ui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.CustomerDAO;

public class ViewCustomerPage extends JFrame implements ActionListener{
private JPanel panel;
	
	private JTable jTable;
	
	private String uniqueID="";
	private String customerName="";
	private String code="";
	private String emailAddress="";
	
	private CustomerDAO custDAO;
	
	private JButton back;
	
	public ViewCustomerPage() {
		setTitle("View Customer page");
		setPanel();
		setSize(500,800);
		/* Set frame to center of the screen */
    	setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setPanel() {
		panel = new JPanel();
		back=new JButton("Back");
		
	    
		String[] columnNames= {"Customer Id","Customer Name","Customer Code","Email"};
		DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        jTable=new JTable();
        jTable.setModel(model);
        try {
        	custDAO=new CustomerDAO();
        	ResultSet rs=custDAO.getCustomerDAO();
        	int i=0;
        	/* Add list of records to the table */
        	while(rs.next()) {
        		uniqueID=rs.getString(1);
        		customerName=rs.getString(2);
        		code=rs.getString(3);
        		emailAddress=rs.getString(6);
        		model.addRow(new Object[]{uniqueID, customerName, code, emailAddress});
        		i++;
        	}
        	 if (i < 1) {
                 JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
             }
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        
        /* To display column headers use JScrollPane */
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(jTable);
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Customers view", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
 
        jTable.setBackground(new java.awt.Color(204, 227, 227));
	    panel.add(new JScrollPane(jTable), BorderLayout.CENTER);
	  
	    panel.add(back, BorderLayout.SOUTH);
	    add(panel);
       
       back.addActionListener(this);
        
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
			  	this.dispose();
			  	CustomersPage hp=new CustomersPage();
	}
	
	
}
