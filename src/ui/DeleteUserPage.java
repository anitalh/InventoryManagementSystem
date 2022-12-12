package ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.UserDAO;
import pojo.User;


	public class DeleteUserPage extends JFrame implements ActionListener{
		private JPanel panel;
		
		private JLabel userId;
		private JTextField uId;
		
		private JButton delete;
		private JButton back;
		 
		private UserDAO userDAO;

		public DeleteUserPage(){
			setTitle("Delete User page");
			setPanel();
			setSize(1000,800);
			/* Set frame to center of the screen */
	    	setLocationRelativeTo(null);
	    	getContentPane().setBackground(new java.awt.Color(204, 227, 227));
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
		}

		private void setPanel() {			
			/* Setting up panel */
			panel = new JPanel();
			
			userId=new JLabel("User Id");
			uId=new JTextField(20);
		    
		    delete=new JButton("Delete");
		    back = new JButton("Back");
			
			panel.add(userId);
			panel.add(uId);
			
			panel.add(delete);
			panel.add(back);
						
			setLayout(new GridBagLayout());
		    GridBagConstraints gc=new GridBagConstraints();
		    
		    /* Set weights */
		    gc.weightx=0.5;
		    gc.weighty=0.5;
		    
		    gc.gridx=0;
		    gc.gridy=0;
		    add(userId,gc);
		    
		    gc.gridx=1;
		    gc.gridy=0;
		    add(uId,gc);
		    
		    gc.gridx=1;
		    gc.gridy=1;
		    add(delete,gc);
		    
		    gc.gridx=0;
		    gc.gridy=1;
		    add(back,gc);
		    
		    delete.addActionListener(this);
		    back.addActionListener(this);		    
		}
		
	

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==delete) {
				User user=new User();
				userDAO = new UserDAO();
			
			
				if(uId.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Please enter user id!");
				}
				else{
					user.setUserId(Integer.parseInt(uId.getText()));
					List<Integer> ids=userDAO.getUserIds();
	        	/* Check if entered id is valid */
					if(ids.contains(Integer.parseInt(uId.getText()))){
						userDAO.deleteUserDAO(user);
						JOptionPane.showMessageDialog(null,"User deleted succesfully!");            
					}
					else{
	        		JOptionPane.showMessageDialog(null,"User does not exist!");        		
					}
				}
			}
			 if(e.getSource()==back) {
				  	this.dispose();
					UsersPage cp = new UsersPage();
			 }
		}			
	}