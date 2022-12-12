package ui;

import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CustomersPage extends JFrame implements ActionListener {
	private JButton addCustomer;
	private JButton updateCustomer;
	private JButton viewCustomer;
	private JButton back;
	
	public CustomersPage() {
		setTitle("Customer page");
		setPanel();
		setSize(1000,800);
		/* Set frame to center of the screen */
    	setLocationRelativeTo(null);
    	getContentPane().setBackground(new java.awt.Color(204, 227, 227));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setPanel() {
		new JPanel();
		
		addCustomer=new JButton("Add Customer");
		updateCustomer=new JButton("Update Customer");
		viewCustomer=new JButton("View Customer");
		
		back=new JButton("Back");
		
		setLayout(new GridBagLayout());
	    GridBagConstraints gc=new GridBagConstraints();
	    
	    /* Set weights */
	    gc.weightx=0.5;
	    gc.weighty=0.5;
	    
	    gc.gridx=0;
	    gc.gridy=0;
	    gc.gridheight=1;
	    add(addCustomer,gc);
	    
	    gc.gridx=0;
	    gc.gridy=1;
	    add(updateCustomer,gc);
	    
	    gc.gridx=0;
	    gc.gridy=2;
	    add(viewCustomer,gc);
	    
	    gc.gridx=0;
	    gc.gridy=3;
	    add(back,gc);
	    
	    addCustomer.addActionListener(this);
	    updateCustomer.addActionListener(this);
	    viewCustomer.addActionListener(this);
	    back.addActionListener(this);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {		
		/* Display appropriate screens based on buttons clicked */
		if(e.getSource()==addCustomer) {
			this.dispose();
			AddCustomerPage addProd=new AddCustomerPage();
		}
		else if(e.getSource()==updateCustomer) {
			this.dispose();
			UpdateCustomerPage deleteProd=new UpdateCustomerPage();
		}
		else if(e.getSource()==viewCustomer){
			this.dispose();
			ViewCustomerPage viewCustomer=new ViewCustomerPage();
		}
		else {
			this.dispose();
			HomePage customer=new HomePage();
		}
	}
}
