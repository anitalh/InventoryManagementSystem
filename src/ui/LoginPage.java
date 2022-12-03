package ui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.UserDAO;
import pojo.User;

public class LoginPage extends JFrame implements ActionListener{
	
	private JPanel panel;
	
	private JLabel userName;
	private JTextField name;
	
    private JLabel password;
	private JPasswordField jpass;
	
	private JButton login;
	
	
	private JLabel heading;
	
	public static String loggedInUser;
	
	public LoginPage() {
		setTitle("Login page");
		setPanel();
		setSize(800,500);
		/* Set frame to center of the screen */
    	setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setPanel() {
		panel = new JPanel();
		heading = new JLabel("Inventory management system",JLabel.RIGHT);
		heading.setFont(new Font("Times New Roman", Font.BOLD, 24));
		ImageIcon inventoryIcon = createImageIcon("inventory.png",
                "Inventory image");
		heading.setIcon(inventoryIcon);
		/* Set text to left of icon */
		heading.setHorizontalTextPosition(JLabel.LEFT);
		
	
		userName=new JLabel("Username");
		name=new JTextField(20);
	    
		ImageIcon userIcon = createImageIcon("userIcon.png",
                "User image");
		userName.setIcon(userIcon);
		
		
		password=new JLabel("Password");
		jpass=new JPasswordField(20);
		/* Set characters to * when password is being typed */
		jpass.setEchoChar('*');
		
		ImageIcon passwordIcon = createImageIcon("password.png",
                "Password image");
		password.setIcon(passwordIcon);
		
		login=new JButton("Login");
		
		//panel.add(heading);
		
		setLayout(new GridBagLayout());
	    GridBagConstraints gc=new GridBagConstraints();
	    
	    /* Set weights */
	    gc.weightx=0.5;
	    gc.weighty=0.5;
	    
	    GridBagConstraints c = new GridBagConstraints();
	    gc.gridx=0;
	    gc.gridy=0;
	    /* Set label to center of screen */
	    c.gridwidth=3;
	    add(heading,c);
	   
	    
	    
	    gc.gridx=0;
	    gc.gridy=1;
	    gc.gridheight=1;
	    add(userName,gc);
	    
	    gc.gridx=1;
	    gc.gridy=1;
	    add(name,gc);
	    
	    gc.gridx=0;
	    gc.gridy=2;
	    gc.gridheight=1;
	    add(password,gc);
	    
	    gc.gridx=1;
	    gc.gridy=2;
	    add(jpass,gc);
	    
	    gc.gridx=1;
	    gc.gridy=3;
	    add(login,gc);
	    
	    login.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		User user=new User();
		UserDAO userDAO=new UserDAO();
		
		if(name.getText().equals("")) {
			 JOptionPane.showMessageDialog(null,"Please enter username!");
		}
		
		else if(String.valueOf(jpass.getPassword()).equals("")) {
			JOptionPane.showMessageDialog(null,"Please enter password!");
		}
		
		else
		{
			//Check if username exists and password is correct
			List<String> users=userDAO.getUserNames();
			if(users.contains(name.getText()) && String.valueOf(jpass.getPassword()).equals("pass123")) {
				loggedInUser=name.getText();
				this.dispose();
				HomePage hp=new HomePage();
			}
			else {
				JOptionPane.showMessageDialog(null,"Username or password is incorrect!");
			}
			
			
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
	
	public static void main(String[] args) {
		LoginPage page=new LoginPage();
		
	}

}
