package BankServices;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class AccountInformation extends JFrame implements ActionListener {
  JLabel heading;
  JButton fastcash,ministatement,cardpinchange,balanceenquiry,back;
  
    AccountInformation()
    {
    	//heading of the page
    	heading=new JLabel("Please Select Your Transaction");
    	setLayout(null);
    	heading.setBounds(250,50,1000,50);
        heading.setFont(new Font("Osward",Font.BOLD,50));
    	add(heading);
    	
    	
    	//fastcash button
    	fastcash=new JButton("Fast Cash");
    	fastcash.setFont(new Font("Verdana",Font.BOLD,20));
		fastcash.setBackground(Color.black);
		fastcash.setForeground(Color.WHITE);
		fastcash.setBounds(250,200,300,50);
		add(fastcash);
	   
		
		
		//Balance  button
		ministatement=new JButton("Statement & Balance");
    	ministatement.setFont(new Font("Verdana",Font.BOLD,20));
		ministatement.setBackground(Color.black);
		ministatement.setForeground(Color.WHITE);
		ministatement.setBounds(700,200,300,50);
		add(ministatement);
		
		
		//cardpinchange button
		cardpinchange=new JButton("Change ATM Details");
    	cardpinchange.setFont(new Font("Verdana",Font.BOLD,20));
		cardpinchange.setBackground(Color.black);
		cardpinchange.setForeground(Color.WHITE);
		cardpinchange.setBounds(250,300,300,50);
		add(cardpinchange);
		
		
		//balanceenquirychange button
		balanceenquiry=new JButton("Account Information");
		balanceenquiry.setFont(new Font("Verdana",Font.BOLD,20));
		balanceenquiry.setBackground(Color.black);
		balanceenquiry.setForeground(Color.WHITE);
		balanceenquiry.setBounds(700,300,300,50);
		add(balanceenquiry);
		
		
		 
		//back Button
		back=new JButton("<<Back");
		back.setFont(new Font("Verdana",Font.BOLD,20));
		back.setBackground(Color.black);
		back.setForeground(Color.WHITE);
		back.setBounds(500,500,300,50);
		add(back);
		
		
		//registration of Buttons
		fastcash.addActionListener(this);
		ministatement.addActionListener(this);
		cardpinchange.addActionListener(this);
		balanceenquiry.addActionListener(this);
		back.addActionListener(this);
		
		
		
    	
    	//frame title and size maintain with visiblility
    	setVisible(true);
    	setSize(1920,1080);
    	setTitle("Account INFORMATION");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	//change the color of the page
    	getContentPane().setBackground(Color.WHITE);
    }
    public void actionPerformed(ActionEvent event)
    {
    	if(event.getSource()==fastcash)
    	{
    		new FastCash().setVisible(true);
    		setVisible(false);
    	}
    	else if(event.getSource()==cardpinchange)
    	{
    		new CardPinChange().setVisible(true);
    		setVisible(false);
    	}
    	if(event.getSource()==ministatement)
    	{
    		try
    		{
    		connection conn=new connection();
			String query="Select Balance from accountinfo where Ac_No="+Front_page.inputdata+" and Id="+Front_page.Id;
			ResultSet rs=conn.Database.executeQuery(query);
			if(rs.next())
			{
				String Balance=rs.getString("Balance");
				JOptionPane.showMessageDialog(null,"Account Balance: Rs "+Balance);
				new MiniStatement().setVisible(true);
	    		setVisible(false);
			}
    		}
    		catch(Exception x)
    		{
    			System.out.println("Error:"+x);
    		}
    		
    	}
    	if(event.getSource()==balanceenquiry)
    	{
    		new AllDetails().setVisible(true);
    		setVisible(false);
    	}
    	if(event.getSource()==back)
    	{
    		new Front_page().setVisible(true);
    		setVisible(false);
    	}
    }
}
