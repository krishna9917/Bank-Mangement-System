package BankServices;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class withdrawal extends JFrame implements ActionListener
{   
	JLabel heading,amountenter;
   JTextField amountfield;
   JButton withdraw,back;
	withdrawal()
	{
		//set Heading
		 heading=new JLabel("Withdrawal Your Amount");
		 heading.setFont(new Font("Osward",Font.BOLD,50));
		 setLayout(null);
		 heading.setBounds(120,50,1000,60);
		 add(heading);
		 
		 
		 
		//set label and input field for deposite amount
		   amountenter=new JLabel("Enter Amount:");
		   amountenter.setFont(new Font("Raleway",Font.BOLD,30));
	       amountenter.setBounds(150,250,500,100); 
	       add(amountenter);   
	       amountfield=new JTextField();
	       amountfield.setFont(new Font("verdana",Font.ITALIC,15));
	       amountfield.setBounds(400,290,250,30);   
	       add(amountfield);
	   
	       
	    //set withdraw button
	       withdraw=new JButton("Withdraw Your Amount");
	       withdraw.setFont(new Font("Verdana",Font.BOLD,20));
	       withdraw.setBounds(140,470,300,50);  
	       withdraw.setBackground(Color.black);
	       withdraw.setForeground(Color.WHITE);
	       add( withdraw); 
	       withdraw.addActionListener(this);
	       
	       
	       
	   //set back button
	       back=new JButton("<<Back");
	       back.setFont(new Font("Verdana",Font.BOLD,20));
	       back.setBounds(470,470,200,50);    
	       back.setBackground(Color.black);
	       back.setForeground(Color.WHITE);
	       add(back); 
	       back.addActionListener(this);  
	
	//frame title and size maintain with visiblility
	    	setVisible(true);
	       	setBounds(240,0,800,680);
	       	setTitle("Amount Withdrawal");
	       	setResizable(false);
	       	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//change the color of the page
	getContentPane().setBackground(Color.WHITE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==back)
		{
			new Front_page().setVisible(true);
		}
		try {
			//connection to Database
		   connection con=new connection();
		   String withdrawquery="Select Balance from accountinfo where Ac_No="+Front_page.inputdata+" and Id="+Front_page.Id;
		   ResultSet rs=con.Database.executeQuery(withdrawquery);
		   if(ae.getSource()==withdraw)
		   {
			   if(amountfield.getText().equals(""))
			   {
				   JOptionPane.showMessageDialog(null,"Please Enter Withdraw Amount");
			   }
		     else if(rs.next())
			   {
		    	 Double Amount=Double.parseDouble(amountfield.getText());
				  String Balance=rs.getString("Balance");
				  Double AcBalance=Double.parseDouble(Balance);
				  if(AcBalance<Amount)
				  {
					  JOptionPane.showMessageDialog(null,"Withdraw Amount is Greater than Account Balance "+Balance);
				  }
				  else
				  {
				     AcBalance=AcBalance-Amount;  
				     String updatebalance="Update accountinfo set Balance="+AcBalance+" where Id=+"+Front_page.Id;
				     con.Database.executeUpdate(updatebalance);
				      Calendar calendar= Calendar.getInstance();
					  String date=String.valueOf(calendar.get(Calendar.DATE));
					  String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
					  String year=String.valueOf(calendar.get(Calendar.YEAR)); 
					  String todaydate=year+"/"+month+"/"+date;
				     String statement="insert into statement (Id,Ac_No,Date,Withdrawal,Balance) values('"+Front_page.Id+"','"+Front_page.inputdata+"','"+todaydate+"','"+Amount+"','"+AcBalance+"')";
				     con.Database.executeUpdate(statement);
				     JOptionPane.showMessageDialog(null,"Your Amount is Successfully Debited");
				     new Front_page().setVisible(true);
				     setVisible(false);
				  }
			  }
		   }
		}
		catch(Exception x)
		{
			System.out.println("Error:"+x);
		}
	}

}
