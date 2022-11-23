package ui;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.ProductDAO;

public class ViewProductsPage extends JFrame implements ActionListener{

	private JPanel panel;
	
	private JTable jTable;
	
	private String prodId="";
	private String prodCode="";
	private String prodName="";
	private String prodQty="";
	private String prodPrice="";
	
	private ProductDAO prodDAO;
	
	public ViewProductsPage() {
		setTitle("View products page");
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
		String[] columnNames= {"Product Id","Product Code","Name","Quantity","Price"};
		DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        jTable=new JTable();
        jTable.setModel(model);
        try {
        	prodDAO=new ProductDAO();
        	ResultSet rs=prodDAO.getAllProducts();
        	int i=0;
        	/* Add list of records to the table */
        	while(rs.next()) {
        		prodId=rs.getString(1);
        		prodCode=rs.getString(2);
        		prodName=rs.getString(3);
        		prodQty=rs.getString(4);
        		prodPrice=rs.getString(5);
        		model.addRow(new Object[]{prodId, prodCode, prodName, prodQty, prodPrice});
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
                BorderFactory.createEtchedBorder(), "Products view", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        
       panel.add(scrollPane);
       add(panel);
        
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ViewProductsPage viewProducts=new ViewProductsPage();

	}

}
