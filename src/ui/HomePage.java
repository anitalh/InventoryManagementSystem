package ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dao.UserDAO;

public class HomePage extends JFrame implements ActionListener{
	
	private JButton products;
	
	private JButton customers;
	
	private JButton users;
	
	private UserDAO userDAO;
	
	public HomePage() {
		setTitle("Home page");
		setPanel();
		setSize(700,500);
		/* Set frame to center of the screen */
    	setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setPanel() {
	    new JFrame();
		new JPanel();
		new JPanel();
		
		products=new JButton("Products section");
		customers=new JButton("Customers section");
		users=new JButton("Users section");
		
		/* Adding image to products button */
		ImageIcon productIcon = createImageIcon("product.png",
                "Product image");
		products.setIcon(productIcon);
		products.setPreferredSize(new Dimension(100, 300));
		/* Adding image to customers button */
		ImageIcon customerIcon = createImageIcon("userIcon.png",
                "Customer image");
		customers.setIcon(customerIcon);
		customers.setPreferredSize(new Dimension(100, 400));
		
		ImageIcon userIcon = createImageIcon("userIcon.png",
                "Customer image");
		users.setIcon(userIcon);
		users.setPreferredSize(new Dimension(100, 300));
		
		JLabel label=new JLabel("Welcome to inventory management system!");
		label.setFont(new Font("Times New Roman", Font.BOLD, 24));
	
		
		setLayout(new GridBagLayout());
	    GridBagConstraints gc=new GridBagConstraints();
	    
	    /* Set weights */
	    gc.weightx=0.5;
	    gc.weighty=0.5;
	    
	    gc.gridx=0;
	    gc.gridy=0;
	    add(label,gc);
	    
	    gc.gridx=0;
	    gc.gridy=1;
	    gc.gridheight=1;
	    add(products,gc);
	    
	    gc.gridx=0;
	    gc.gridy=2;
	    add(customers,gc);
	    
	   String loggedInUser=LoginPage.loggedInUser;
	   userDAO=new UserDAO();
	   if(userDAO.getRole(loggedInUser).equals("admin")) {
	    gc.gridx=0;
	    gc.gridy=3;
	    add(users,gc);
	   }
	    
	    products.addActionListener(this);
	    customers.addActionListener(this);
	    users.addActionListener(this);
	    
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HomePage hp=new HomePage();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==products) {
			this.dispose();
			ProductsPage prodPage=new ProductsPage();
		}
		else  if(e.getSource()==users){
			this.dispose();
			UsersPage userPage= new UsersPage();
		}
		else  if(e.getSource()==customers){
			this.dispose();
			CustomersPage custPage=new CustomersPage();
			//call users home page
		}
		else {
			this.dispose();
			//call customers home page
		}
		
	}
	
	/* Method to create image icon */
	private ImageIcon createImageIcon(String path,
            String description) {
			java.net.URL imgURL = getClass().getResource(path);
			if (imgURL != null) {
				return new ImageIcon(imgURL, description);
			} else {
				System.err.println("Couldn't find file: " + path);
				return null;
			}
	}

}
