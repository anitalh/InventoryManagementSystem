package ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		
		private JLabel email;
		private JTextField emailAddress;
		
		 private JButton delete;

		public DeleteUserPage()
		{
			setTitle("Delete User page");
			setPanel();
			setSize(500,500);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}

			private void setPanel() {
			
			/* Setting up panel */
			panel = new JPanel();
			
			userId=new JLabel("User ID");
			uId=new JTextField(20);
			
			email=new JLabel("Email");
			emailAddress=new JTextField(20);
		    
		    delete=new JButton("Delete");
		    
			panel.add(userId);
			panel.add(uId);
			
			panel.add(email);
			panel.add(emailAddress);
			
			panel.add(delete);
						
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
		    
		    gc.gridx=1;
		    gc.gridy=2;
		    add(emailAddress,gc);
		    
		    gc.gridx=0;
		    gc.gridy=2;
		    add(email,gc);
		    
		    gc.gridx=1;
		    gc.gridy=3;
		    add(delete,gc);
		    
		    delete.addActionListener(this);
		   
		    
		    
		}
		
		public static void main(String[] args) {
			DeleteUserPage dp=new DeleteUserPage();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			User user=new User();
			
			if(uId.getText().equals("") || emailAddress.getText().equals("") ){
				JOptionPane.showMessageDialog(null,"Please fill all the fields!");
			}   
			else {
				user.setUserId(uId.getText());
				user.setEmail(emailAddress.getText());
				
				new UserDAO().deleteUserDAO(user); 
				JOptionPane.showMessageDialog(null,"User Deleted succesfully!");
			}
		}			
	}