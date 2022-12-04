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


	public class UpdateUserPage extends JFrame implements ActionListener{
		private JPanel panel;
		
		private JLabel userId;
		private JTextField uId;
		
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
		
		private JButton update;
		private JButton back;
		
		private UserDAO userDAO;

		public UpdateUserPage()	{
			setTitle("Update User page");
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
				
			userId=new JLabel("User ID");
			uId=new JTextField(20);
		    
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
		    
			update=new JButton("Update");
			back=new JButton("Back");
		    
			panel.add(userId);
			panel.add(uId);
			
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
			
			panel.add(update);
			panel.add(back);		
			
			setLayout(new GridBagLayout());
		    GridBagConstraints gc=new GridBagConstraints();
		    
		    /* Set weights */
		    gc.weightx=0.5;
		    gc.weighty=0.5;
		    
		    gc.gridx=0;
		    gc.gridy=0;
		    gc.gridheight=1;
		    add(userId,gc);
		    
		    gc.gridx=1;
		    gc.gridy=0;
		    add(uId,gc);
		    
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
		    add(update,gc);
		    
		    gc.gridx=0;
		    gc.gridy=7;
		    add(back,gc);
		    
		    update.addActionListener(this);
		    back.addActionListener(this);	    
		}
		
		public static void main(String[] args) {
			UpdateUserPage up=new UpdateUserPage();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==update) {
				User user=new User();
				userDAO=new UserDAO();
			
				if(emailAddress.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Please enter email!");
				}   
				else {
					user.setEmail(emailAddress.getText());
					List<String> ids=userDAO.getUserIds();
					if(ids!=null && ids.size()>0 && ids.contains((emailAddress.getText()))){
						user.setUserId(uId.getText());
						user.setName(userName.getText());
						user.setLocation(userLocation.getText());
						user.setPhone(phoneNumber.getText());
						user.setCategory(userCategory.getText());
						user.setEmail(emailAddress.getText());
						new UserDAO().editUserDAO(user); 
						JOptionPane.showMessageDialog(null,"User Updated succesfully!");
					}
					else
					{
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