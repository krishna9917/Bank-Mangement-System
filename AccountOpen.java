package BankServices;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class AccountOpen extends JFrame implements ActionListener
{
	JLabel heading,subheading,name,fathername,dob,date,month,year,gender,email,maritalstatus,address,city,pincode,state;
	JTextField tname,tfathername,temail,taddress,tcity,tpincode,tstate;
	JRadioButton male,female,married,unmarried,other;
	JButton next;
	JComboBox cdate,cmonth,cyear;
	static String query1;
	static String PName;
	static Random ran=new Random();
	static int first4=ran.nextInt(9999-1000)+1000; 
	
	AccountOpen()
	{
		setLayout(null);
		
	 //label and button
		heading=new JLabel("APPLICATION FORM NO."+first4);
	    heading.setFont(new Font("Arrial",Font.BOLD,40));
        heading.setBounds(300,20,1000,100);
        add(heading);
        
        
        subheading=new JLabel("Page 1: Personal Details");
        subheading.setFont(new Font("verdana",Font.BOLD,20));
        subheading.setBounds(440,80,500,100);
        add(subheading);
        
        
        name=new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(200,160,100,100);
        add(name);     
        tname=new JTextField();
        tname.setFont(new Font("verdana",Font.ITALIC,15));
        tname.setBounds(400,200,500,30);
        add(tname);
        
        
        fathername=new JLabel("Father's Name:");
        fathername.setFont(new Font("Raleway",Font.BOLD,20));
        fathername.setBounds(200,200,500,100);
        add(fathername);     
        tfathername=new JTextField();
        tfathername.setFont(new Font("verdana",Font.ITALIC,15));
        tfathername.setBounds(400,240,500,30);
        add(tfathername); 
        
        
        
        dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(200,240,500,100);
        add(dob);  
        date=new JLabel("Date");
        date.setBounds(400,245,500,100);
        add(date);
        String date[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};	
        cdate=new JComboBox(date);
        cdate.setBounds(450,280,60,30);
        add(cdate);
        month=new JLabel("Month");
        month.setBounds(540,245,500,100);
        add(month);
        String months[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
        cmonth=new JComboBox(months);
        cmonth.setBounds(600,280,120,30);
        add(cmonth);
        year=new JLabel("Year");
        year.setBounds(740,245,500,100);
        add(year);
        String years[]= {"1950","1951","1952","1953","1954","1955","1956","1957","1958","1959","1960","1961","1962","1963","1964","1965",
        		          "1966","1967","1968","1969","1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980",
        		          "1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996",
        		          "1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011",
        		          "2012","2013","2014","2015","2016","2017","2018","2019","2020","2021" };
        cyear=new JComboBox(years);
        cyear.setBounds(800,280,100,30);
        add(cyear);
        
        
        
        gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(200,280,500,100);
        add(gender); 
        male=new JRadioButton("Male");
        male.addActionListener(new ActionListener()
		{
	     public void actionPerformed(ActionEvent e)
	     {
	    	if( male.isSelected())
	    	{
	    		 female.setSelected(false);
	    		 other.setSelected(false);
	    	}
	     }
		});
        male.setBounds(400,330,100,20);
        add(male);
        male.setBackground(Color.white);
        female=new JRadioButton("Female");
        female.addActionListener(new ActionListener()
		{
	     public void actionPerformed(ActionEvent e)
	     {
	    	if( female.isSelected())
	    	{
	    		 male.setSelected(false);
	    		 other.setSelected(false);
	    	}
	     }
		});
        female.setBounds(600,330,100,20);
        add(female);
        female.setBackground(Color.white);
        other=new JRadioButton("Other");
        other.addActionListener(new ActionListener()
		{
	     public void actionPerformed(ActionEvent e)
	     {
	    	if( other.isSelected())
	    	{
	    		 female.setSelected(false);
	    		 male.setSelected(false);
	    	}
	     }
		});
        other.setBounds(800,330,100,20);
        add(other);
        other.setBackground(Color.white);
        
        
         
        email=new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(200,320,500,100);
        add(email); 
        temail=new JTextField();
        temail.setFont(new Font("verdana",Font.ITALIC,15));
        temail.setBounds(400,360,500,30);
        add(temail);
        
        
        maritalstatus=new JLabel("Marital Status:");
        maritalstatus.setFont(new Font("Raleway",Font.BOLD,20));
        maritalstatus.setBounds(200,360,500,100);
        add(maritalstatus);
        married=new JRadioButton("Married");
        married.addActionListener(new ActionListener()
		{
	     public void actionPerformed(ActionEvent e)
	     {
	    	if(married.isSelected())
	    	{
	    		 unmarried.setSelected(false);
	    	}
	     }
		});
        married.setBounds(400,400,100,20);
        add(married);
        married.setBackground(Color.white);
        unmarried=new JRadioButton("Unmarried");
        unmarried.addActionListener(new ActionListener()
		{
	     public void actionPerformed(ActionEvent e)
	     {
	    	if(unmarried.isSelected())
	    	{
	    		 married.setSelected(false);
	    	}
	     }
		});
        unmarried.setBounds(600,400,100,20);
        add(unmarried);
        unmarried.setBackground(Color.white);
        
        
        
        address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(200,400,500,100);
        add(address); 
        taddress=new JTextField();
        taddress.setFont(new Font("verdana",Font.ITALIC,15));
        taddress.setBounds(400,440,500,30);
        add(taddress);
        
        
        city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(200,440,500,100);
        add(city); 
        tcity=new JTextField();
        tcity.setFont(new Font("verdana",Font.ITALIC,15));
        tcity.setBounds(400,480,200,30);
        add(tcity);
        
        
        pincode=new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(200,480,500,100);
        add(pincode); 
        tpincode=new JTextField();
        tpincode.setFont(new Font("verdana",Font.ITALIC,15));
        tpincode.setBounds(400,520,100,30);
        add(tpincode);
        
        
        state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(200,520,500,100);
        add(state); 
        tstate=new JTextField();
        tstate.setFont(new Font("verdana",Font.ITALIC,15));
        tstate.setBounds(400,560,200,30);
        add(tstate);
        
        
        
        next=new JButton("Next");
        next.setBounds(700,600,200,30);
        next.setBackground(Color.black);
        next.setForeground(Color.WHITE);
        add(next);
        
        
		//Frame with title
		setSize(1920,1080);
		setTitle("Account opening form");
		setVisible(true);
		getContentPane().setBackground(Color.white);
     	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	
     	next.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{  
		//input store in string variable
	      PName=tname.getText();
	
		
		String fname=tfathername.getText();
		
		
		
		String date=(String)cdate.getSelectedItem();
		String month=(String)cmonth.getSelectedItem();
		String year=(String)cyear.getSelectedItem();
		
		
		
		String gender=null;
		if(male.isSelected())
		{
			gender="Male";
		}
		else if(female.isSelected())
		{
			gender="Female";
			
		}
		else if(other.isSelected())
		{
			gender="Other";
		}
		
		
		
		
		String email=temail.getText();
		
		
		String maritalstatus=null;
		if(married.isSelected())
		{
			maritalstatus="Married";
			
		}
		else if(unmarried.isSelected())
		{
			maritalstatus="Unmarried";
		}
		
		
		String address=taddress.getText();
		
		
		String city=tcity.getText();
		
		String pincode=tpincode.getText();
		
		String state=tstate.getText();
		
		
		
	 // Query update in Database
		try {
			if(tname.getText().equals("") || tfathername.getText().equals("") || gender==null || maritalstatus==null || taddress.getText().equals("")  || tcity.getText().equals("")  || tpincode.getText().equals("")  || tstate.getText().equals("") )
			{
				  JOptionPane.showMessageDialog(null,"Fill all the Required Filled");
			}
			else
			{
				query1="Insert into personal_details values('"+PName+"','"+fname+"','"+date+"/"+month+"/"+year+"','"+gender+"','"+email+"','"+maritalstatus+"','"+address+"','"+city+"','"+pincode+"','"+state+"','"+first4+"')";
				//open 2nd open account Frame
				new AccountOpen2().setVisible(true);
				setVisible(false);
			}
		}
		catch(Exception ex)
		{
		  System.out.println("Error:"+ex);
		}	
		
      }
}	

