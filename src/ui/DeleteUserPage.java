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
		
		private JLabel email;
		private JTextField emailAddress;
		
		private JButton delete;
		private JButton back;
		 
		private UserDAO userDAO;

		public DeleteUserPage(){
			setTitle("Delete User page");
			setPanel();
			setSize(500,500);
			/* Set frame to center of the screen */
	    	setLocationRelativeTo(null);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
		}

		private void setPanel() {			
			/* Setting up panel */
			panel = new JPanel();
			
			email=new JLabel("Email");
			emailAddress=new JTextField(20);
		    
		    delete=new JButton("Delete");
		    back = new JButton("Back");
			
			panel.add(email);
			panel.add(emailAddress);
			
			panel.add(delete);
			panel.add(back);
						
			setLayout(new GridBagLayout());
		    GridBagConstraints gc=new GridBagConstraints();
		    
		    /* Set weights */
		    gc.weightx=0.5;
		    gc.weighty=0.5;
		    
		    gc.gridx=1;
		    gc.gridy=0;
		    add(emailAddress,gc);
		    
		    gc.gridx=0;
		    gc.gridy=0;
		    add(email,gc);
		    
		    gc.gridx=1;
		    gc.gridy=1;
		    add(delete,gc);
		    
		    gc.gridx=0;
		    gc.gridy=1;
		    add(back,gc);
		    
		    delete.addActionListener(this);
		    back.addActionListener(this);		    
		}
		
		public static void main(String[] args) {
			DeleteUserPage dp=new DeleteUserPage();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==delete) {
				User user=new User();
				userDAO = new UserDAO();
			
			
				if(emailAddress.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Please enter Email id!");
				}
				else{
					user.setEmail(emailAddress.getText());
					List<String> ids=userDAO.getUserIds();
	        	/* Check if entered id is valid */
					if(ids.contains(emailAddress.getText())){
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