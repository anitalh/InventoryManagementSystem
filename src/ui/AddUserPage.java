package ui;

import java.awt.GridBagConstraints;
import dao.UserDAO;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import pojo.User;


	public class AddUserPage extends JFrame implements ActionListener{
		private JPanel panel;
		
		private JLabel name;
		private JTextField userName;
		
		private JLabel location;
		private JTextField userLocation;
		
		private JLabel phone;
		private JTextField phoneNumber;
		
		private JLabel category;
		private JTextField userCategory;
		
		private JLabel email;
		private JTextField emailAddress;
		
		private JButton save;
		private JButton back;

		public AddUserPage(){
			setTitle("Add User page");
			setPanel();
			setSize(1000,800);
			setLocationRelativeTo(null);
			getContentPane().setBackground(new java.awt.Color(204, 227, 227));
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
		}

		private void setPanel() {		
			/* Setting up panel */
			panel = new JPanel();
		    
			name=new JLabel("Name");
			userName=new JTextField(20);
		    
			location=new JLabel("Location");
			userLocation=new JTextField(20);
		    
			phone=new JLabel("Phone Number");
			phoneNumber=new JTextField(20);
			
			email=new JLabel("Email");
			emailAddress=new JTextField(20);
		    
			category=new JLabel("Category");
			userCategory=new JTextField(20);
		    
		    save=new JButton("Save");
		    back= new JButton("Back");
			
			panel.add(name);
			panel.add(userName);
			
			panel.add(location);
			panel.add(userLocation);
			
			panel.add(phone);
			panel.add(phoneNumber);
			
			panel.add(email);
			panel.add(emailAddress);
			
			panel.add(category);
			panel.add(userCategory);
			
			panel.add(save);
			panel.add(back);
			
			
			setLayout(new GridBagLayout());
		    GridBagConstraints gc=new GridBagConstraints();
		    
		    /* Set weights */
		    gc.weightx=0.5;
		    gc.weighty=0.5;
		    
		    gc.gridx=0;
		    gc.gridy=2;
		    add(name,gc);
		    
		    gc.gridx=1;
		    gc.gridy=2;
		    add(userName,gc);
		    
		    gc.gridx=0;
		    gc.gridy=3;
		    add(location,gc);
		    
		    gc.gridx=1;
		    gc.gridy=3;
		    add(userLocation,gc);
		    
		    gc.gridx=1;
		    gc.gridy=4;
		    add(phoneNumber,gc);
		    
		    gc.gridx=0;
		    gc.gridy=4;
		    add(phone,gc);
		    
		    gc.gridx=1;
		    gc.gridy=5;
		    add(emailAddress,gc);
		    
		    gc.gridx=0;
		    gc.gridy=5;
		    add(email,gc);
		    
		    gc.gridx=0;
		    gc.gridy=6;
		    add(category,gc);
		    
		    gc.gridx=1;
		    gc.gridy=6;
		    add(userCategory,gc);
		    
		    gc.gridx=1;
		    gc.gridy=7;
		    add(save,gc);
		    
		    gc.gridx=0;
		    gc.gridy=7;
		    add(back,gc);
		    
		    save.addActionListener(this);
		    back.addActionListener(this);	    	    
		}
		
		

		@Override
		public void actionPerformed(ActionEvent event) {
			 if(event.getSource()==save) {
			// TODO Auto-generated method stub
				 User user=new User();
			
				 if(userName.getText().equals("") || userLocation.getText().equals("") || phoneNumber.getText().equals("") || userCategory.getText().equals("") || emailAddress.getText().equals("") ){
					 JOptionPane.showMessageDialog(null,"Please fill all the fields!");
				 }   
				 else {
					 user.setName(userName.getText());
					 user.setLocation(userLocation.getText());
					 user.setPhone(phoneNumber.getText());
					 user.setCategory(userCategory.getText());
					 user.setEmail(emailAddress.getText());
				
					 new UserDAO().addUserDAO(user); 
					 JOptionPane.showMessageDialog(null,"User added succesfully!");
				 	}
			 	}
			 
			  if(event.getSource()==back) {
				  	this.dispose();
					UsersPage hp=new UsersPage();
			  }
		}
	}