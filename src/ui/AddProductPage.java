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

import dao.ProductDAO;
import pojo.Product;

public class AddProductPage extends JFrame implements ActionListener{
	private JPanel panel;
	
	private JLabel productCode;
	private JTextField prodCode;
	
	private JLabel productName;
	private JTextField prodName;
	
	private JLabel productQuantity;
	private JTextField prodQty;
	
	private JLabel productPrice;
	private JTextField prodPrice;
	
	 private JButton save;
	 private JButton back;

	public AddProductPage(){
		setTitle("Add product page");
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
			
	    productCode=new JLabel("Product code");
	    prodCode=new JTextField(20);
	    
	    productName=new JLabel("Product Name");
	    prodName=new JTextField(20);
	    
	    productQuantity=new JLabel("Product Quantity");
	    prodQty=new JTextField(20);
	    
	    productPrice=new JLabel("Product Price");
	    prodPrice=new JTextField(20);
	    
	    save=new JButton("Save");
	    back=new JButton("Back");
	    
		panel.add(productCode);
		panel.add(prodCode);
		
		panel.add(productName);
		panel.add(prodName);
		
		panel.add(productQuantity);
		panel.add(prodQty);
		
		panel.add(productPrice);
		panel.add(prodPrice);
		
		panel.add(save);
				
		setLayout(new GridBagLayout());
	    GridBagConstraints gc=new GridBagConstraints();
	    
	    /* Set weights */
	    gc.weightx=0.5;
	    gc.weighty=0.5;
	    
	    gc.gridx=0;
	    gc.gridy=0;
	    gc.gridheight=1;
	    add(productCode,gc);
	    
	    gc.gridx=1;
	    gc.gridy=0;
	    add(prodCode,gc);
	    
	    gc.gridx=0;
	    gc.gridy=2;
	    add(productName,gc);
	    
	    gc.gridx=1;
	    gc.gridy=2;
	    add(prodName,gc);
	    
	    gc.gridx=0;
	    gc.gridy=3;
	    add(productQuantity,gc);
	    
	    gc.gridx=1;
	    gc.gridy=3;
	    add(prodQty,gc);
	    
	    gc.gridx=0;
	    gc.gridy=4;
	    add(productPrice,gc);
	    
	    gc.gridx=1;
	    gc.gridy=4;
	    add(prodPrice,gc);
	    
	    gc.gridx=1;
	    gc.gridy=5;
	    add(save,gc);
	    
	    gc.gridx=0;
	    gc.gridy=5;
	    add(back,gc);
	    	    
	    save.addActionListener(this);
	    back.addActionListener(this);	    
	}
			
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
	  if(event.getSource()==save) {
		Product product=new Product();
		
		if(prodCode.getText().equals("") || prodName.getText().equals("") || prodQty.getText().equals("") || prodPrice.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please fill all the fields!");
        }else{
           /* Set product details */
        	product.setProductCode(prodCode.getText());
        	product.setProductName(prodName.getText());
        	product.setQuantity(Integer.parseInt(prodQty.getText()));
        	product.setPrice(Integer.parseInt(prodPrice.getText()));
        	  
            new ProductDAO().addProduct(product);
            JOptionPane.showMessageDialog(null,"Product added succesfully!");      
        }
	  }
	  
	  if(event.getSource()==back) {
		  	this.dispose();
			ProductsPage hp=new ProductsPage();
	  }
		
	}
	
	
	
	
}
