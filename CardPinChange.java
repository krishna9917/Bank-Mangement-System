package BankServices;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
public class CardPinChange extends JFrame implements ActionListener
{
	JLabel heading,Card,Pin;
	JButton ExistingATM,submit,back;
	JTextField Cardfield,Pinfield;
	
   CardPinChange()
   {
	 //set heading on frame
	 heading=new JLabel("Change ATM card number and ATM PIN");
	 heading.setFont(new Font("Osward",Font.BOLD,50));
	 setLayout(null);
	 heading.setBounds(160,50,1000,60);
	 add(heading);
	 
	 
	 //set card Label and card input field
	   Card=new JLabel("Enter Card Number:");
	   Card.setFont(new Font("Raleway",Font.BOLD,30));
       Card.setBounds(350,200,500,100);
       add(Card);   
       Cardfield=new JTextField();
       Cardfield.setFont(new Font("verdana",Font.ITALIC,15));
       Cardfield.setBounds(650,240,250,30);
       add(Cardfield);
       
      //set pin label and pin input field
       Pin=new JLabel("Enter PIN Number:");
	   Pin.setFont(new Font("Raleway",Font.BOLD,30));
       Pin.setBounds(350,300,500,100);
       add(Pin);   
       Pinfield=new JTextField();
       Pinfield.setFont(new Font("verdana",Font.ITALIC,15));
       Pinfield.setBounds(650,340,100,30);
       add(Pinfield);
       
       
       // Button to check card number
       ExistingATM=new JButton("Press to check ATM CARD no.");
       ExistingATM.setFont(new Font("Verdana",Font.BOLD,20));
       ExistingATM.setBounds(100,500,400,50);
       ExistingATM.setBackground(Color.black);
       ExistingATM.setForeground(Color.WHITE);
       add(ExistingATM); 
       ExistingATM.addActionListener(this);
       
       
       //submit Button 
       submit=new JButton("Submit");
       submit.setFont(new Font("Verdana",Font.BOLD,20));
       submit.setBounds(600,500,200,50);
       submit.setBackground(Color.black);
       submit.setForeground(Color.WHITE);
       add(submit);
       submit.addActionListener(this);
       
       //back Button
       back=new JButton("<<Back");
       back.setFont(new Font("Verdana",Font.BOLD,20));
       back.setBounds(900,500,200,50);
       back.setBackground(Color.black);
       back.setForeground(Color.WHITE);
       add(back); 
       back.addActionListener(this);
	   
		//frame title and size maintain with visiblility
   	setVisible(true);
   	setSize(1920,1080);
   	setTitle("Account INFORMATION");
   	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	
   	//change the color of the page
   	getContentPane().setBackground(Color.WHITE);
   }
   public void actionPerformed(ActionEvent ae)
   {
	   if(ae.getSource()==back)
	   {
		   new AccountInformation().setVisible(true);
		   setVisible(false);
	   }
		try
		{
	   		
			connection conn=new connection();
			String query="Select ATM_card,ATM_PIN from accountinfo where Ac_No="+Front_page.inputdata+" and Id="+Front_page.Id;
			ResultSet rs=conn.Database.executeQuery(query);
			
	   if(ae.getSource()==ExistingATM)
	   {
		   if(rs.next())
		   {
			   String ATM=rs.getString("ATM_card");
			   String Pin=rs.getString("ATM_PIN");
			   JOptionPane.showMessageDialog(null,"ATM Card Number:"+ATM+"\n ATM PIN:"+Pin);   
		   }   
	   }
	   else if(ae.getSource()==submit)
	   {    
		   if(Cardfield.getText().equals("") || Pinfield.getText().equals("")) 
			  {
				  JOptionPane.showMessageDialog(null,"Enter your Card and Pin Details");
			  }
		   //count the input digits 
		   Long card=Long.parseLong(Cardfield.getText());
		   long cardno=card;
		   int pin=Integer.parseInt(Pinfield.getText());
		   int pinno=pin;
		   int cardcount=0,pincount=0;
		   while(card>0)
		   {
			   card=card/10;
			   cardcount++;  
		   }
		   while(pin>0)
		   {
			   pin=pin/10;
			   pincount++;  
		   }
		  if(cardcount!=16 || pincount!=4 )
		  {
			  JOptionPane.showMessageDialog(null,"Enter Correct Card and Pin Details\n(Card no-16digits and Pin no-4digits)");  
		  }
		  else
		  {
			  String updatecarddetails="Update accountinfo set ATM_card="+cardno+", ATM_PIN="+pinno+" where Ac_No="+Front_page.inputdata+" and Id="+Front_page.Id;
	     	  String updatecarddetails1="Update accountopen set ATM_card="+cardno+", ATM_Pin="+pinno+" where Ac_No="+Front_page.inputdata+" and Id="+Front_page.Id;
		      conn.Database.executeUpdate(updatecarddetails);
		      conn.Database.executeUpdate(updatecarddetails1);
		      JOptionPane.showMessageDialog(null,"Your ATM Card Details Successfully Update");  
		  }
	   }
	}
	 catch(Exception x)
		{
		 System.out.println(x);
		}
   }
}
