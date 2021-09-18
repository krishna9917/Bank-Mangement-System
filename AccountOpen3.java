package BankServices;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
public class AccountOpen3 extends JFrame implements ActionListener
{
   JLabel form_no,heading,actype,acno,acno1,cardno,cardno1,cardno2,cardno3,pin,pin1,pin2,pin3,services;
   JRadioButton rsaving,rcurrent,rfd,rrd;
   JTextField tform_no;
   JCheckBox atm,mobilebanking,internetbanking,emailinfo,chequebook,estatement,agreement;
   JButton submit,cancel;
	AccountOpen3()
	{
		
		   //Label , textfield ,checkbox and RadioButton add on Frame at custom Position
		    setLayout(null);
		    form_no=new JLabel("Form no:");
		    form_no.setFont(new Font("Raleway",Font.BOLD,20));
		    form_no.setBounds(1100,10,100,20);
		    add(form_no);
		    tform_no=new JTextField();
		    tform_no.setFont(new Font("Arrial",Font.ITALIC,15));
		    tform_no.setBounds(1200,13,60,20);
		    add(tform_no);
		
		
		    
		    heading=new JLabel("Page 3:Account Details");
		    heading.setFont(new Font("verdana",Font.BOLD,30));
		    heading.setBounds(400,20,500,50);
		    add(heading);
		    
		    
		    
		    actype=new JLabel("Account Type:");
		    actype.setFont(new Font("Raleway",Font.BOLD,25));
		    actype.setBounds(200,100,500,50);
		    add(actype);
		    rsaving=new JRadioButton("Saving Account");
		    rsaving.addActionListener(new ActionListener()
		    {
		    public void actionPerformed(ActionEvent e)
		    {
		    	if(rsaving.isSelected())
		    	{  
		    		rfd.setSelected(false);
		    		rcurrent.setSelected(false);
		    		rrd.setSelected(false);
		    	}
		    }
		    });
		    rsaving.setBounds(200,140,200,30);
		    rsaving.setFont(new Font("Verdana",Font.ITALIC,15));
		    rsaving.setBackground(Color.WHITE);
		    add(rsaving);
		   
		    rfd=new JRadioButton("Fixed Deposit Account");
		    rfd.addActionListener(new ActionListener()
		    {
		    public void actionPerformed(ActionEvent e)
		    {
		    	if(rfd.isSelected())
		    	{  
		    		rsaving.setSelected(false);
		    		rcurrent.setSelected(false);
		    		rrd.setSelected(false);
		    	}
		    }
		    });
		    rfd.setBounds(500,140,500,30);
		    rfd.setFont(new Font("Verdana",Font.ITALIC,15));
		    rfd.setBackground(Color.WHITE);
		    add(rfd);
		    rcurrent=new JRadioButton("Current Account");
		    rcurrent.addActionListener(new ActionListener()
		    {
		    public void actionPerformed(ActionEvent e)
		    {
		    	if(rcurrent.isSelected())
		    	{  
		    		rsaving.setSelected(false);
		    		rrd.setSelected(false);
		    		rfd.setSelected(false);
		    	}
		    }
		    });
		    rcurrent.setBounds(200,170,200,30);
		    rcurrent.setFont(new Font("Verdana",Font.ITALIC,15));
		    rcurrent.setBackground(Color.WHITE);
		    add(rcurrent);
		    rrd=new JRadioButton("Recurring Deposit Account");
		    rrd.addActionListener(new ActionListener()
		    {
		    public void actionPerformed(ActionEvent e)
		    {
		    	if(rrd.isSelected())
		    	{  
		    		rsaving.setSelected(false);
		    		rcurrent.setSelected(false);
		    		rfd.setSelected(false);
		    	}
		    }
		    });
		    rrd.setBounds(500,170,300,30);
		    rrd.setFont(new Font("Verdana",Font.ITALIC,15));
		    rrd.setBackground(Color.WHITE);
		    add(rrd);
		    
		
		    
		    
		    acno=new JLabel("Account Number:");
		    acno.setFont(new Font("Raleway",Font.BOLD,25));
		    acno.setBounds(200,230,500,50);
		    add(acno);
		    acno1=new JLabel("854922000*****");
		    acno1.setFont(new Font("Verdana",Font.ITALIC,25));
		    acno1.setBounds(500,230,500,50);
		    add(acno1);
		    
		    
		    
		    cardno=new JLabel("Card Number:");
		    cardno.setFont(new Font("Raleway",Font.BOLD,25));
		    cardno.setBounds(200,280,500,50);
		    add(cardno);
		    cardno1=new JLabel("XXXX-XXXX-XXXX-XXXX");
		    cardno1.setFont(new Font("Verdana",Font.ITALIC,25));
		    cardno1.setBounds(500,280,500,50);
		    add(cardno1);
		    cardno2=new JLabel("(Your 16-digits Card Number)");
		    cardno2.setBounds(200,310,500,50);
		    cardno2.setFont(new Font("Verdana",Font.ITALIC,10));
		    add(cardno2);
		    cardno3=new JLabel(" It would appear on ATM Card, Cheque Book and Statements");
		    cardno3.setBounds(500,310,500,50);
		    cardno3.setFont(new Font("Verdana",Font.ITALIC,10));
		    add(cardno3);
		    
		    
		    
		    pin=new JLabel("PIN:");
		    pin.setFont(new Font("Raleway",Font.BOLD,25));
		    pin.setBounds(200,345,500,50);
		    add(pin);
		    pin1=new JLabel("XXXX");
		    pin1.setFont(new Font("Verdana",Font.ITALIC,25));
		    pin1.setBounds(500,345,500,50);
		    add(pin1);
		    
		    
		    services=new JLabel("Services Required:");
		    services.setFont(new Font("Raleway",Font.BOLD,25));
		    services.setBounds(200,400,500,50);
		    add(services);
		    
		    
		    atm=new JCheckBox("ATM CARD");
		    atm.setBounds(200,445,200,20);
		    atm.setBackground(Color.WHITE);
		    add(atm);
		    mobilebanking=new JCheckBox("Mobile Banking");
		    mobilebanking.setBounds(200,475,200,20);
		    mobilebanking.setBackground(Color.WHITE);
		    add(mobilebanking);
		    chequebook=new JCheckBox("Cheque Book");
		    chequebook.setBounds(200,505,200,20);
		    chequebook.setBackground(Color.WHITE);
		    add(chequebook);
		    
		    
		    
		    
		    internetbanking=new JCheckBox("Internet Banking");
		    internetbanking.setBounds(520,445,200,20);
		    internetbanking.setBackground(Color.WHITE);
		    add(internetbanking);
		    emailinfo=new JCheckBox("EMAIL Alerts");
		    emailinfo.setBounds(520,475,200,20);
		    emailinfo.setBackground(Color.WHITE);
		    add(emailinfo);
		    estatement=new JCheckBox("E-Statement");
		    estatement.setBounds(520,505,200,20);
		    estatement.setBackground(Color.WHITE);
		    add(estatement);
		    
		    
		    
		    agreement=new JCheckBox("I hereby declares that the above entered details correct to the best of my knowledge."); 
		    agreement.setBounds(200,570,1000,20);
		    agreement.setBackground(Color.WHITE);
		    add(agreement);
		    
		    
		    submit=new JButton("Submit");
		    submit.setBounds(550,600,120,30);
		    submit.setBackground(Color.black);
		    submit.setForeground(Color.white);
		    add(submit);
		    cancel=new JButton("Cancel");
		    cancel.setBounds(680,600,120,30);
		    cancel.setBackground(Color.black);
		    cancel.setForeground(Color.white);
		    add(cancel);
		    
		    //registration of Buttons
		    submit.addActionListener(this);
		    cancel.addActionListener(this);
		    
		    //Frame size and frame title maintain
		    setSize(1920,1080);
			setTitle("Account opening form");
			setVisible(true);
			getContentPane().setBackground(Color.white);
	    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==submit)
		{
	     
		
		
	//generate 5 digit random number for Account number
	   Random r1=new Random();
	   int Accountno=r1.nextInt(99999-10000)+10000; 
	   
	//generate 16 digit number and make always positive random number for ATM Card
	   long AtmCardno=(r1.nextLong()%9000000000000000L)+1000000000000000L;
	   AtmCardno=Math.abs(AtmCardno);
	   
	//generate 4 digit number for Pin 
	    int Pin=r1.nextInt(9999-1000)+1000;
	 
	 
	 String Services="";
	 if(atm.isSelected())
	 {
		 Services=Services+"  ATM card  ";
	 }
	 if(mobilebanking.isSelected())
	 {
		 Services=Services+"  Mobile Banking  ";
	 }
	 if(internetbanking.isSelected())
	 {
		 Services=Services+"  Internet Banking  ";
	 }
	 if(emailinfo.isSelected())
	 {
		 Services=Services+"  Email Alerts  ";
	 }   
	 if(chequebook.isSelected())
	 {
		 Services=Services+"  Cheque Book  ";
	 }
	 if(estatement.isSelected())
	 {
		 Services=Services+"  E-statement  ";
	 }
	
	 
	 Boolean Agreement=false;
	 if(agreement.isSelected())
	 {
		 Agreement=true;
	 }
	 
	 
	 try 
	 {
		 String Accounttype=null;
			if(rsaving.isSelected())
			{
				Accounttype="Saving";
			}
			else if(rcurrent.isSelected())
			{
				Accounttype="Current";
			}
			else if(rfd.isSelected())
			{
				Accounttype="Fixed Deposit";
			}
			else if(rrd.isSelected())
			{
				Accounttype="Recurring Deposit";
			}
		 if(Accounttype==null || tform_no.getText().equals("") || Agreement==false)
		 {
			 JOptionPane.showMessageDialog(null, "Fill all the Required Field"); 
		 }
		else if(!(tform_no.getText().equals(AccountOpen2.Randomnumber)))
 	    {
 		  JOptionPane.showMessageDialog(null,"Invalid Form_no"); 
 	    }
		 else
		 {
			connection con =new connection();
			String query="insert into AccountOpen values('"+AccountOpen.first4+"','"+Accounttype+"','854922000"+Accountno+"','"+AtmCardno+"','"+Pin+"','"+Services+"')";
			String querylogin="insert into accountinfo values('854922000"+Accountno+"','"+AtmCardno+"','"+Pin+"','"+0.00+"','"+AccountOpen.first4+"','"+AccountOpen.PName+"')";
			con.Database.executeUpdate(AccountOpen.query1);
			con.Database.executeUpdate(AccountOpen2.query2);
     		con.Database.executeUpdate(query);
    		con.Database.executeUpdate(querylogin);
			JOptionPane.showMessageDialog(null,"Account Number:854922000"+Accountno+"\n ATM Card Number:"+AtmCardno+"\n ATM PIN:"+Pin);
		 }
	 }
	 catch(Exception ex)
	 {
		 System.out.println("Error:"+ ex);
	 } 
    }
    if(ae.getSource()==cancel)
	{
		new Front_page().setVisible(true);
		setVisible(false);
	}
  
	}
	
}
