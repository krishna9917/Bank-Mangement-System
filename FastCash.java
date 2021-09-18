package BankServices;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class FastCash extends JFrame implements ActionListener
{
	JLabel heading;
	JButton hundred,fivehundred,thousands,twothousands,fivethousands,tenthousands,back;
  FastCash()
  {
	  //set Heading
		 heading=new JLabel("Select Your Amount to Withdraw");
		 heading.setFont(new Font("Osward",Font.BOLD,50));
		 setLayout(null);
		 heading.setBounds(120,50,1000,60);
		 add(heading);
		 
	
     //set amount buttons 
		    hundred=new JButton("Rs 100");
	    	hundred.setFont(new Font("Verdana",Font.BOLD,20));
	    	hundred.setBackground(Color.black);
	    	hundred.setForeground(Color.WHITE);
	    	hundred.setBounds(130,200,300,50);
			add(hundred);
			hundred.addActionListener(this);
			
			
			    fivehundred=new JButton("Rs 500");
		    	fivehundred.setFont(new Font("Verdana",Font.BOLD,20));
		    	fivehundred.setBackground(Color.black);
		    	fivehundred.setForeground(Color.WHITE);
		    	fivehundred.setBounds(600,200,300,50);
				add(fivehundred);
				fivehundred.addActionListener(this);
				
				    thousands=new JButton("Rs 1000");
			    	thousands.setFont(new Font("Verdana",Font.BOLD,20));
			    	thousands.setBackground(Color.black);
			    	thousands.setForeground(Color.WHITE);
			    	thousands.setBounds(130,300,300,50);
					add(thousands);
					thousands.addActionListener(this);
					
					    twothousands=new JButton("Rs 2000");
				    	twothousands.setFont(new Font("Verdana",Font.BOLD,20));
				    	twothousands.setBackground(Color.black);
				    	twothousands.setForeground(Color.WHITE);
				    	twothousands.setBounds(600,300,300,50);
						add(twothousands);
						twothousands.addActionListener(this);
		 
						    fivethousands=new JButton("Rs 5000");
					    	fivethousands.setFont(new Font("Verdana",Font.BOLD,20));
					    	fivethousands.setBackground(Color.black);
					    	fivethousands.setForeground(Color.WHITE);
					    	fivethousands.setBounds(130,400,300,50);
							add(fivethousands);
						    fivethousands.addActionListener(this);
							
							tenthousands=new JButton("Rs 10000");
					    	tenthousands.setFont(new Font("Verdana",Font.BOLD,20));
					    	tenthousands.setBackground(Color.black);
					    	tenthousands.setForeground(Color.WHITE);
					    	tenthousands.setBounds(600,400,300,50);
							add(tenthousands);
							tenthousands.addActionListener(this);
							
			
			//back Button
			back=new JButton("<<Back");
		    back.setFont(new Font("Verdana",Font.BOLD,20));
			back.setBackground(Color.black);
			back.setForeground(Color.WHITE);
			back.setBounds(360,550,300,50);
			add(back);
			back.addActionListener(this);
						
		 
		 //frame title and size maintain with visiblility
		   	setVisible(true);
		   	setBounds(130,0,1020,680);
		   	setTitle("Fast Cash Withdrawal");
		   	setResizable(false);
		   	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   	
		   	//change the color of the page
		   	getContentPane().setBackground(Color.WHITE);
  }
      public void actionPerformed(ActionEvent ae)
      {
    	  if(ae.getSource()==back)
    	  {
    		  new AccountInformation().setVisible(true);
    	  }
    		try {
    			//connection to Database
    		   connection con=new connection();
    		   String withdrawquery="Select Balance from accountinfo where Ac_No="+Front_page.inputdata+" and Id="+Front_page.Id;
    		   ResultSet rs=con.Database.executeQuery(withdrawquery);
    		   if(ae.getSource()==hundred)
    		   {
    		       if(rs.next())
    			   {
    		    	   int Amount=100;
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
    		   if(ae.getSource()==fivehundred)
    		   {
    		       if(rs.next())
    			   {
    		    	   int Amount=500;
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
    		   if(ae.getSource()==thousands)
    		   {
    		       if(rs.next())
    			   {
    		    	   int Amount=1000;
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
    		   if(ae.getSource()==twothousands)
    		   {
    		       if(rs.next())
    			   {
    		    	   int Amount=2000;
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
    		   if(ae.getSource()==fivethousands)
    		   {
    		       if(rs.next())
    			   {
    		    	   int Amount=5000;
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
    		   if(ae.getSource()==tenthousands)
    		   {
    		       if(rs.next())
    			   {
    		    	   int Amount=10000;
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
