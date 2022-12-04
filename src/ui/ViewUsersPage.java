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
import dao.UserDAO;

public class ViewUsersPage extends JFrame implements ActionListener{
private JPanel panel;
	
	private JTable jTable;
	
	private String userId="";
	private String name="";
	private String email="";
	private UserDAO userDAO;
	
	public ViewUsersPage() {
		setTitle("View Users page");
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
		String[] columnNames= {"User Id", "User Name","Email"};
		DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        jTable=new JTable();
        jTable.setModel(model);
        try {
        	userDAO=new UserDAO();
        	ResultSet rs=userDAO.getUserDAO();
        	int i=0;
        	/* Add list of records to the table */
        	while(rs.next()) {
        		userId=rs.getString(1);
        		name=rs.getString(2);
        		email=rs.getString(3);
        		model.addRow(new Object[]{userId, name, email});
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
                BorderFactory.createEtchedBorder(), "Users view", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        
       panel.add(scrollPane);
       add(panel);
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main(String[] args) {
		ViewUsersPage viewUsers=new ViewUsersPage();

	}
	
	
}
