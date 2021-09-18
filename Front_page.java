package BankServices;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Front_page extends JFrame implements ActionListener
{
	JLabel bank,account;
	JButton withdraw,deposit,openAC,info;
	JTextField accountinput;
	static Long inputdata;
	static String Id;
	Front_page()
	{
	    //Frame Labels and textfield make
		bank=new JLabel("WELCOME TO KRISHNA BANK");
		bank.setFont(new Font("Osward",Font.BOLD,50));
		accountinput=new JTextField("854922000");
		accountinput.setFont(new Font("Raleway",Font.BOLD,15));
		account=new JLabel("Enter Account Number:");
		account.setFont(new Font("Raleway",Font.BOLD,22));
		
		//Frame Buttons make
		withdraw=new JButton("Withdrawal");
		withdraw.setFont(new Font("Verdana",Font.BOLD,15));
		withdraw.setBackground(Color.black);
		withdraw.setForeground(Color.white);
		deposit=new JButton("Deposit");
		deposit.setFont(new Font("Verdana",Font.BOLD,15));
		deposit.setBackground(Color.black);
		deposit.setForeground(Color.white);
		info=new JButton("Account Info.");
		info.setFont(new Font("Verdana",Font.BOLD,15));
		info.setBackground(Color.black);
		info.setForeground(Color.white);
		openAC=new JButton("Open new ACCOUNT");
		openAC.setFont(new Font("Verdana",Font.BOLD,15));
		openAC.setBackground(Color.green);
		openAC.setForeground(Color.white);
		
		//set position of elements and add elements on frame
		setLayout(null);
		bank.setBounds(250,50,1000,50);   
		add(bank);
		account.setBounds(300,240,500,50);
		add(account);
		accountinput.setBounds(570,250,200,30);
		add(accountinput);
		withdraw.setBounds(350,400,150,50);
		add(withdraw);
		deposit.setBounds(550,400,150,50);
		add(deposit);
		info.setBounds(750,400,200,50);
		add(info);
		openAC.setBounds(490,500,270,50);
		add(openAC);
		
		
	  //Frame make and maintain frame
		setSize(1920,1080);
		setVisible(true);
		setTitle("Krishna Bank");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	  //change the color of the Frame
	    getContentPane().setBackground(Color.white);    
		
       //registration of button for Event
	    withdraw.addActionListener(this);
		deposit.addActionListener(this);
		info.addActionListener(this);
		openAC.addActionListener(this);
		
	}
	//Event handle method
	public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getSource()==openAC)
	      {
			new AccountOpen().setVisible(true);
			setVisible(false);
		  }
	   	try
		{
	   		
			connection conn=new connection();
			inputdata=Long.parseLong(accountinput.getText());
			String query="Select Ac_HolderName,Id from accountinfo where Ac_No="+inputdata;
			ResultSet rs=conn.Database.executeQuery(query);
			
			
		// function of Withdrawal button
         if(ae.getSource()==withdraw)
		{
        
		  if(rs.next())
		  { 
			  String ACName=rs.getString("Ac_HolderName");
			   Id=rs.getString("Id");
			  JOptionPane.showMessageDialog(null,"Account Holder Name:"+ACName+"\n Account ID:"+Id);
			   new withdrawal().setVisible(true);
			   setVisible(false);
		  }
		  else
		  {
			  JOptionPane.showMessageDialog(null,"Invalid Account Number");
		  }
		}
		
		
		//function of Deposit Button
		else if(ae.getSource()==deposit)
		{
			if(rs.next())
			  {
			   String ACName=rs.getString("Ac_HolderName");
			     Id=rs.getString("Id");
			    JOptionPane.showMessageDialog(null,"Account Holder Name:"+ACName+"\n Account ID:"+Id);
				new Deposite().setVisible(true);
				setVisible(false);
			  }
			  else
			  {
				  JOptionPane.showMessageDialog(null,"Invalid Account Number");
			  }	
		}
		
		//function of Account info button
		else if(ae.getSource()==info)
		{
			if(rs.next())
			  {
				 String ACName=rs.getString("Ac_HolderName");
				 Id=rs.getString("Id");
				 JOptionPane.showMessageDialog(null,"Account Holder Name:"+ACName+"\n Account ID:"+Id);
				new AccountInformation().setVisible(true);
				setVisible(false);
			  }
			  else
			  {
				  JOptionPane.showMessageDialog(null,"Invalid Account Number");
			  }	
	     }
		   
		}
		catch(Exception e)
		{
			System.out.println("Error:"+e);
		}
	}
}
