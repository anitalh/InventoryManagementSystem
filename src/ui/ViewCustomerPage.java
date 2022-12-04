package ui;

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
	
	public ViewCustomerPage() {
		setTitle("View Customer page");
		setPanel();
		setSize(500,500);
		/* Set frame to center of the screen */
    	setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setPanel() {
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
	    
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
        		emailAddress=rs.getString(4);
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
 
       panel.add(scrollPane);
       add(panel);
        
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main(String[] args) {
		ViewCustomerPage viewCustomer=new ViewCustomerPage();

	}

}
