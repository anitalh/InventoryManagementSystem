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

import dao.CustomerDAO;
import dao.UserDAO;
import pojo.Customer;
import pojo.User;


	public class UpdateCustomerPage extends JFrame implements ActionListener{
		private JPanel panel;
		
		private JLabel customerId;
		private JTextField uniqueId;
		
		private JLabel name;
		private JTextField customerName;
		
		private JLabel location;
		private JTextField customerLocation;
		
		private JLabel phone;
		private JTextField phoneNumber;
		
		private JLabel customerCode;
		private JTextField code;
		
		private JLabel email;
		private JTextField emailAddress;
		
		private JButton update;
		private JButton back;
		
		private CustomerDAO custDAO;

		public UpdateCustomerPage(){
			setTitle("Update customer page");
			setPanel();
			setSize(500,500);
			setLocationRelativeTo(null);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		}

			private void setPanel() {			
			/* Setting up panel */
			panel = new JPanel();
				
			customerId=new JLabel("Customer ID");
			uniqueId=new JTextField(20);
		    
			name=new JLabel("Name");
			customerName=new JTextField(20);
		    
			location=new JLabel("Location");
			customerLocation=new JTextField(20);
		    
			phone=new JLabel("Phone Number");
			phoneNumber=new JTextField(20);
			
			email=new JLabel("Email");
			emailAddress=new JTextField(20);
		    
			customerCode=new JLabel("Customer Code");
			code=new JTextField(20);
		    
			update=new JButton("Update");
			back=new JButton("Back");
		    
			panel.add(customerId);
			panel.add(uniqueId);
			
			panel.add(name);
			panel.add(customerName);
			
			panel.add(location);
			panel.add(customerLocation);
			
			panel.add(phone);
			panel.add(phoneNumber);
			
			panel.add(email);
			panel.add(emailAddress);
			
			panel.add(customerCode);
			panel.add(code);
			
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
		    add(customerId,gc);
		    
		    gc.gridx=1;
		    gc.gridy=0;
		    add(uniqueId,gc);
		    
		    gc.gridx=0;
		    gc.gridy=2;
		    add(name,gc);
		    
		    gc.gridx=1;
		    gc.gridy=2;
		    add(customerName,gc);
		    
		    gc.gridx=0;
		    gc.gridy=3;
		    add(location,gc);
		    
		    gc.gridx=1;
		    gc.gridy=3;
		    add(customerLocation,gc);
		    
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
		    add(customerCode,gc);
		    
		    gc.gridx=1;
		    gc.gridy=6;
		    add(code,gc);
		    
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
			UpdateCustomerPage cp =new UpdateCustomerPage();
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			 if(e.getSource()==update) {
				 Customer customer=new Customer();
				 custDAO=new CustomerDAO();
			
				 if(emailAddress.getText().equals("")){
					 JOptionPane.showMessageDialog(null,"Please enter email!");
				 }   
				 else {
					 customer.setEmail(emailAddress.getText());
					 List<String> ids=custDAO.getCustomerIds();
					 if(ids!=null && ids.size()>0 && ids.contains((emailAddress.getText()))){
						 customer.setCustomerId(uniqueId.getText());
						 customer.setName(customerName.getText());
						 customer.setLocation(customerLocation.getText());
						 customer.setPhone(phoneNumber.getText());
						 customer.setCustomerCode(code.getText());
						 customer.setEmail(emailAddress.getText());
						 new CustomerDAO().editCustomerDAO(customer); 
						 JOptionPane.showMessageDialog(null,"Customer Updated succesfully!");
					 }
					 
	           		else{
	           			JOptionPane.showMessageDialog(null,"Customer does not exist!");
	           		}
				 }
			 }
			 
			 if(e.getSource()==back) {
				  this.dispose();
				  CustomersPage cp = new CustomersPage();
			 }
		}
	}