package BankServices;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class Deposite extends JFrame implements ActionListener
{
   JLabel heading,amountenter;
   JTextField amountfield;
   JButton deposite,back;
   Deposite()
   {
	   //set Heading
		 heading=new JLabel("Deposite Your Amount");
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
	   
	       
	    //set deposite button
	       deposite=new JButton("Deposite Your Amount");
	       deposite.setFont(new Font("Verdana",Font.BOLD,20));
	       deposite.setBounds(140,470,300,50);  
	       deposite.setBackground(Color.black);
	       deposite.setForeground(Color.WHITE);
	       add(deposite); 
	       deposite.addActionListener(this);
	       
	       
	       
	       
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
   	setTitle("Amount Deposite");
   	setResizable(false);
   	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	
   	//change the color of the page
   	getContentPane().setBackground(Color.WHITE);
   }
   public void actionPerformed(ActionEvent ea)
   {
	   if(ea.getSource()==back)
	   {
		   new Front_page().setVisible(true);
	   }
		try {
			//connection to Database
		   connection con=new connection();
		   String withdrawquery="Select Balance from accountinfo where Ac_No="+Front_page.inputdata+" and Id="+Front_page.Id;
		   ResultSet rs=con.Database.executeQuery(withdrawquery);
		   if(ea.getSource()==deposite)
		   {
			   if(amountfield.getText().equals(""))
			   {
				   JOptionPane.showMessageDialog(null,"Please Enter Deposite Amount");
			   }
		     else if(rs.next())
			   {
		    	 Double Amount=Double.parseDouble(amountfield.getText());
				  String Balance=rs.getString("Balance");
				  Double AcBalance=Double.parseDouble(Balance);
				     AcBalance=AcBalance+Amount;  
				     String updatebalance="Update accountinfo set Balance="+AcBalance+" where Id=+"+Front_page.Id;
				     con.Database.executeUpdate(updatebalance);
				     Calendar calendar= Calendar.getInstance();
					  String date=String.valueOf(calendar.get(Calendar.DATE));
					  String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
					  String year=String.valueOf(calendar.get(Calendar.YEAR)); 
					  String todaydate=year+"/"+month+"/"+date;
				     String statement="insert into statement (Id,Ac_No,Date,Deposite,Balance) values('"+Front_page.Id+"','"+Front_page.inputdata+"','"+todaydate+"','"+Amount+"','"+AcBalance+"')";
				     con.Database.executeUpdate(statement);
				     JOptionPane.showMessageDialog(null,"Your Amount is Successfully Credited");
				     new Front_page().setVisible(true);
				     setVisible(false);
			   }
		   }
		}
		catch(Exception x)
		{
			System.out.println("Error:"+x);
		}
   }
}
