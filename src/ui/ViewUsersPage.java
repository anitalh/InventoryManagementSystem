package ui;


import java.awt.BorderLayout;
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
import dao.UserDAO;

public class ViewUsersPage extends JFrame implements ActionListener{
private JPanel panel;
	
	private JTable jTable;
	
	private JButton back;
	
	private String userId="";
	private String name="";
	private String email="";
	private UserDAO userDAO;
	
	public ViewUsersPage() {
		setTitle("View Users page");
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
        		email=rs.getString(6);
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
        
        jTable.setBackground(new java.awt.Color(204, 227, 227));
        panel.add(new JScrollPane(jTable), BorderLayout.CENTER);
        
	    panel.add(back, BorderLayout.SOUTH);
        back.addActionListener(this);
        add(panel);
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		UsersPage users=new UsersPage();
	}
	
	
	
	
	
	
}
