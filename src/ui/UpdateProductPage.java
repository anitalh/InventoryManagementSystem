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

import dao.ProductDAO;
import pojo.Product;

public class UpdateProductPage extends JFrame implements ActionListener{
	private JPanel panel;
	
	private JLabel productId;
	private JTextField prodId;
	
	private JLabel productCode;
	private JTextField prodCode;
	
	private JLabel productName;
	private JTextField prodName;
	
	private JLabel productQuantity;
	private JTextField prodQty;
	
	private JLabel productPrice;
	private JTextField prodPrice;
	
	private ProductDAO prodDAO;
	
	private JButton update;
	
	public UpdateProductPage() {
		setTitle("Update products page");
		setPanel();
		setSize(500,500);
		/* Set frame to center of the screen */
    	setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setPanel() {
		panel = new JPanel();
		
		productId=new JLabel("Enter product id to be updated");
		prodId=new JTextField(20);
	    
		
		productCode=new JLabel("Product code");
	    prodCode=new JTextField(20);
	    
	    productName=new JLabel("Product Name");
	    prodName=new JTextField(20);
	    
	    productQuantity=new JLabel("Product Quantity");
	    prodQty=new JTextField(20);
	    
	    productPrice=new JLabel("Product Price");
	    prodPrice=new JTextField(20);
	    
	    update=new JButton("Update");
	    
	    panel.add(productId);
		panel.add(prodId);
	    
		panel.add(productCode);
		panel.add(prodCode);
		
		panel.add(productName);
		panel.add(prodName);
		
		panel.add(productQuantity);
		panel.add(prodQty);
		
		panel.add(productPrice);
		panel.add(prodPrice);
		
		panel.add(update);
		
		setLayout(new GridBagLayout());
	    GridBagConstraints gc=new GridBagConstraints();
	    
	    /* Set weights */
	    gc.weightx=0.5;
	    gc.weighty=0.5;
	    
	    gc.gridx=0;
	    gc.gridy=0;
	    gc.gridheight=1;
	    add(productId,gc);
	    
	    gc.gridx=1;
	    gc.gridy=0;
	    add(prodId,gc);
	    
	    gc.gridx=0;
	    gc.gridy=2;
	    gc.gridheight=1;
	    add(productCode,gc);
	    
	    gc.gridx=1;
	    gc.gridy=2;
	    add(prodCode,gc);
	    
	    gc.gridx=0;
	    gc.gridy=3;
	    add(productName,gc);
	    
	    gc.gridx=1;
	    gc.gridy=3;
	    add(prodName,gc);
	    
	    gc.gridx=0;
	    gc.gridy=4;
	    add(productQuantity,gc);
	    
	    gc.gridx=1;
	    gc.gridy=4;
	    add(prodQty,gc);
	    
	    gc.gridx=0;
	    gc.gridy=5;
	    add(productPrice,gc);
	    
	    gc.gridx=1;
	    gc.gridy=5;
	    add(prodPrice,gc);
	    
	    gc.gridx=1;
	    gc.gridy=6;
	    add(update,gc);
	    
	    update.addActionListener(this);
	   
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Product product=new Product();
		prodDAO=new ProductDAO();
    	if(productId.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter product id!");
        }else{
        	product.setProductId(Integer.parseInt(prodId.getText()));
        	List<Integer> ids=prodDAO.getProductIds();
        	/* Check if product id exists otherwise throw error */
        	if(ids!=null && ids.size()>0 && ids.contains(Integer.parseInt(prodId.getText()))){
        		product.setProductId(Integer.parseInt(prodId.getText()));
        		product.setProductCode(prodCode.getText());
        		product.setProductName(prodName.getText());
        		product.setQuantity(Integer.parseInt(prodQty.getText()));
        		product.setPrice(Integer.parseInt(prodPrice.getText()));
        		prodDAO.updateProduct(product);
        		JOptionPane.showMessageDialog(null,"Product updated succesfully!");
        	}
        	else
        	{
        		JOptionPane.showMessageDialog(null,"Product does not exist!");
        	}
        	
        }
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UpdateProductPage up=new UpdateProductPage();
	}

	

}
