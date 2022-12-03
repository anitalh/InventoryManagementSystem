package ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ProductsPage extends JFrame implements ActionListener{

	private JPanel panel;
	
	private JButton addProduct;
	private JButton deleteProduct;
	private JButton updateProduct;
	private JButton viewProducts;
	
	
	
	
	public ProductsPage() {
		setTitle("Products page");
		setPanel();
		setSize(500,500);
		/* Set frame to center of the screen */
    	setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setPanel() {
		panel = new JPanel();
		
		addProduct=new JButton("Add Product");
		deleteProduct=new JButton("Delete Product");
		updateProduct=new JButton("Update Product");
		viewProducts=new JButton("View Products");
		
		setLayout(new GridBagLayout());
	    GridBagConstraints gc=new GridBagConstraints();
	    
	    /* Set weights */
	    gc.weightx=0.5;
	    gc.weighty=0.5;
	    
	    gc.gridx=0;
	    gc.gridy=0;
	    gc.gridheight=1;
	    add(addProduct,gc);
	    
	    gc.gridx=0;
	    gc.gridy=1;
	    add(deleteProduct,gc);
	    
	    gc.gridx=0;
	    gc.gridy=2;
	    add(updateProduct,gc);
	    
	    gc.gridx=0;
	    gc.gridy=3;
	    add(viewProducts,gc);
	    
	    addProduct.addActionListener(this);
	    deleteProduct.addActionListener(this);
	    updateProduct.addActionListener(this);
	    viewProducts.addActionListener(this);
	    
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductsPage pp=new ProductsPage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		/* Display appropriate screens based on buttons clicked */
		if(e.getSource()==addProduct) {
			this.dispose();
			AddProductPage addProd=new AddProductPage();
		}
		else if(e.getSource()==deleteProduct) {
			this.dispose();
			DeleteProductPage deleteProd=new DeleteProductPage();
		}
		else if(e.getSource()==updateProduct) {
			this.dispose();
			UpdateProductPage updateProd=new UpdateProductPage();
		}
		else {
			this.dispose();
			ViewProductsPage viewProd=new ViewProductsPage();
		}
		
		
	}

}
