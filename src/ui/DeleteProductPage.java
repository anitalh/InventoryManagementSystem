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

public class DeleteProductPage extends JFrame implements ActionListener{
	private JPanel panel;
	
	private JLabel prodId;
	private JTextField productId;
	
	private JButton delete;
	
	private ProductDAO prodDAO;
	public DeleteProductPage() {
		setTitle("Delete products page");
		setPanel();
		setSize(500,500);
		/* Set frame to center of the screen */
    	setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setPanel() {
		panel = new JPanel();
	
		prodId=new JLabel("Enter Product ID");
		productId=new JTextField(20);
		
	    delete=new JButton("Delete");
	    
	    setLayout(new GridBagLayout());
	    GridBagConstraints gc=new GridBagConstraints();
	    
	    panel.add(prodId);
	    panel.add(productId);
	    panel.add(delete);
	    
	    /* Set weights */
	    gc.weightx=0.5;
	    gc.weighty=0.5;
	    
	    gc.gridx=0;
	    gc.gridy=0;
	    gc.gridheight=1;
	    add(prodId,gc);
	    
	    gc.gridx=1;
	    gc.gridy=0;
	    add(productId,gc);
	    
	    gc.gridx=1;
	    gc.gridy=1;
	    add(delete,gc);
	    
	    delete.addActionListener(this);
	    
	    
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteProductPage dp=new DeleteProductPage();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Product product=new Product();
		prodDAO=new ProductDAO();
		if(productId.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter product id!");
        }else{
        	product.setProductId(Integer.parseInt(productId.getText()));
        	List<Integer> ids=prodDAO.getProductIds();
        	/* Check if entered id is valid */
        	if(ids.contains(Integer.parseInt(productId.getText()))){
        		prodDAO.deleteProduct(product);
        		JOptionPane.showMessageDialog(null,"Product deleted succesfully!");
            
        }
        	else
        	{
        		JOptionPane.showMessageDialog(null,"Product does not exist!");
        		
        	}
        }
		
		
	}

}
