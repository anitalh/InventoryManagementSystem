package ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UsersPage extends JFrame implements ActionListener{
	private JButton addUser;
	private JButton updateUser;
	private JButton viewUser;
	private JButton deleteUser;
	
	public UsersPage() {
		setTitle("User page");
		setPanel();
		setSize(500,500);
		/* Set frame to center of the screen */
    	setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setPanel() {
		new JPanel();
		
		addUser=new JButton("Add User");
		updateUser=new JButton("Update User");
		viewUser=new JButton("View User");
		deleteUser=new JButton("Delete User");
		
		setLayout(new GridBagLayout());
	    GridBagConstraints gc=new GridBagConstraints();
	    
	    /* Set weights */
	    gc.weightx=0.5;
	    gc.weighty=0.5;
	    
	    gc.gridx=0;
	    gc.gridy=0;
	    gc.gridheight=1;
	    add(addUser,gc);
	    
	    gc.gridx=0;
	    gc.gridy=1;
	    add(updateUser,gc);
	    
	    gc.gridx=0;
	    gc.gridy=2;
	    add(viewUser,gc);
	    
	    gc.gridx=0;
	    gc.gridy=3;
	    add(deleteUser,gc);
	    
	    addUser.addActionListener(this);
	    updateUser.addActionListener(this);
	    viewUser.addActionListener(this);
	    deleteUser.addActionListener(this);    
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsersPage up=new UsersPage();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/* Display appropriate screens based on buttons clicked */
		if(e.getSource()==addUser) {
			this.dispose();
			AddUserPage add=new AddUserPage();
		}
		else if(e.getSource()==updateUser) {
			this.dispose();
			UpdateUserPage update=new UpdateUserPage();
		}
		else if(e.getSource()==deleteUser) {
			this.dispose();
			DeleteUserPage delete=new DeleteUserPage();
		}
		else {
			this.dispose();
			ViewUsersPage viewUsers=new ViewUsersPage();
		}
	}

}
