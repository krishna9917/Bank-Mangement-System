package BankServices;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class AccountOpen2 extends JFrame implements ActionListener
{
   JLabel form_no,heading,religion,category,income,qualification,occupation,pancard,adharcard,seniorcitizen,existingAc,phone;
   JTextField tform_no,tpancard,tadharcard,tphone;
   JComboBox creligion,ccategory,cincome,cqualification,coccupation;
   JRadioButton yseniorcitizen,nseniorcitizen,yexistingAc,nexistingAc;
   JButton next;
   static String query2;
   static String Randomnumber=String.valueOf(AccountOpen.first4);
   
   AccountOpen2()
   {
	   //Labels,textfield and Button add on custom position on frame
	    setLayout(null);
	    form_no=new JLabel("Form no.");
	    form_no.setFont(new Font("Raleway",Font.BOLD,20));
	    form_no.setBounds(1100,10,100,20);
	    add(form_no);
	    tform_no=new JTextField();
	    tform_no.setFont(new Font("Arrial",Font.ITALIC,15));
	    tform_no.setBounds(1200,13,60,20);
	    add(tform_no);
	    
	    
	    heading=new JLabel("Page 2:Additional Details");
	    heading.setFont(new Font("verdana",Font.BOLD,30));
	    heading.setBounds(400,20,500,50);
	    add(heading);
	    
	    
	    
	    religion=new JLabel("Religion:");
	    religion.setFont(new Font("Raleway",Font.BOLD,25));
	    religion.setBounds(200,160,500,50);
	    add(religion); 
	    String religion[]= {"Hindu","Muslim","Sikh","Chrishtian","Buddh","Jain","Unaffiliated","Others"};
	    creligion=new JComboBox(religion);
	    creligion.setBounds(500,164,400,30);
	    creligion.setFont(new Font("Verdana",Font.ITALIC,15));
	    add(creligion); 
	    
	    
	    
	    category=new JLabel("Category:");
	    category.setFont(new Font("Raleway",Font.BOLD,25));
	    category.setBounds(200,200,500,50);
	    add(category); 
	    String category[]= {"General","Scheduled Caste(SC)","Scheduled Tribe(ST)","Other Backwrad Class(OBC)"};
	    ccategory=new JComboBox(category);
	    ccategory.setBounds(500,205,400,30);
	    ccategory.setFont(new Font("Verdana",Font.ITALIC,15));
	    add(ccategory); 
	    
	    
	    
	    income=new JLabel("Income:");
	    income.setFont(new Font("Raleway",Font.BOLD,25));
	    income.setBounds(200,240,500,50);
	    add(income); 
	    String income[]= {"Less than 10,000","10,000 - 50,000","50,000 - 1,00,000","More than 1,00,000"};
	    cincome=new JComboBox(income);
	    cincome.setBounds(500,245,400,30);
	    cincome.setFont(new Font("Verdana",Font.ITALIC,15));
	    add(cincome); 
	    
	    
	    
	    qualification=new JLabel("Qualification:");
	    qualification.setFont(new Font("Raleway",Font.BOLD,25));
	    qualification.setBounds(200,280,500,50);
	    add(qualification); 
	    String education[]= {"Non-Graduation","Graduation","Post-Graduation","Others"};
	    cqualification=new JComboBox(education);
	    cqualification.setBounds(500,285,400,30);
	    cqualification.setFont(new Font("Verdana",Font.ITALIC,15));
	    add(cqualification); 
	    
	    
	    occupation=new JLabel("Occupation:");
	    occupation.setFont(new Font("Raleway",Font.BOLD,25));
	    occupation.setBounds(200,320,500,50);
	    add(occupation); 
	    String occupation[]= {"Salaried","Self-employed","Business","Retired","Student","Other"};
	    coccupation=new JComboBox(occupation);
	    coccupation.setBounds(500,325,400,30);
	    coccupation.setFont(new Font("Verdana",Font.ITALIC,15));
	    add(coccupation); 
	   
	    
	    
	    pancard=new JLabel("PAN Card:");
	    pancard.setFont(new Font("Raleway",Font.BOLD,25));
	    pancard.setBounds(200,360,500,50);
	    add(pancard); 
	    tpancard=new JTextField();
	    tpancard.setBounds(500,365,400,30);
	    tpancard.setFont(new Font("Verdana",Font.ITALIC,15));
	    add(tpancard); 
	    
	    adharcard=new JLabel("Aadhar Card:");
	    adharcard.setFont(new Font("Raleway",Font.BOLD,25));
	    adharcard.setBounds(200,400,500,50);
	    add(adharcard); 
	    tadharcard=new JTextField();
	    tadharcard.setBounds(500,405,400,30);
	    tadharcard.setFont(new Font("Verdana",Font.ITALIC,15));
	    add(tadharcard); 
	    
	    
	    seniorcitizen=new JLabel("Senior Citizen:");
	    seniorcitizen.setFont(new Font("Raleway",Font.BOLD,25));
	    seniorcitizen.setBounds(200,440,500,50);
	    add(seniorcitizen);
	    yseniorcitizen=new JRadioButton("Yes");
	    yseniorcitizen.addActionListener(new ActionListener()
	    		{
	    	     public void actionPerformed(ActionEvent e)
	    	     {
	    	    	if(yseniorcitizen.isSelected()) 
	    	    	{
	    	    		 nseniorcitizen.setSelected(false);
	    	    	}
	    	     }
	    		});
	    yseniorcitizen.setBounds(500,445,100,30);
	    yseniorcitizen.setBackground(Color.WHITE);
	    yseniorcitizen.setFont(new Font("Verdana",Font.ITALIC,15));
	    add( yseniorcitizen); 
	    nseniorcitizen=new JRadioButton("No");
	    nseniorcitizen.addActionListener(new ActionListener()
		{
	     public void actionPerformed(ActionEvent e)
	     {
	    	if(nseniorcitizen.isSelected()) 
	    	{
	    		 yseniorcitizen.setSelected(false);
	    	}
	     }
		});
	    nseniorcitizen.setBounds(600,445,100,30);
	    nseniorcitizen.setBackground(Color.WHITE);
	    nseniorcitizen.setFont(new Font("Verdana",Font.ITALIC,15));
	    add( nseniorcitizen);
	    
	    
	    existingAc=new JLabel("Existing Account:");
	    existingAc.setFont(new Font("Raleway",Font.BOLD,25));
	    existingAc.setBounds(200,480,500,50);
	    add(existingAc);
	    yexistingAc=new JRadioButton("Yes");
	    yexistingAc.addActionListener(new ActionListener()
		{
	     public void actionPerformed(ActionEvent e)
	     {
	    	if( yexistingAc.isSelected())
	    	{
	    		 nexistingAc.setSelected(false);
	    	}
	     }
		});
	    yexistingAc.setBounds(500,485,100,30);
	    yexistingAc.setBackground(Color.WHITE);
	    yexistingAc.setFont(new Font("Verdana",Font.ITALIC,15));
	    add(yexistingAc); 
	    nexistingAc=new JRadioButton("No");
	    nexistingAc.addActionListener(new ActionListener()
		{
	     public void actionPerformed(ActionEvent e)
	     {
	    	if( nexistingAc.isSelected())
	    	{
	    		 yexistingAc.setSelected(false);
	    	}
	     }
		});
	    nexistingAc.setBounds(600,485,100,30);
	    nexistingAc.setBackground(Color.WHITE);
	    nexistingAc.setFont(new Font("Verdana",Font.ITALIC,15));
	    add( nexistingAc);
	    
	    phone=new JLabel("Contact No:");
        phone.setFont(new Font("Raleway",Font.BOLD,25));
        phone.setBounds(200,490,500,100);
        add(phone);     
        tphone=new JTextField();
        tphone.setFont(new Font("verdana",Font.ITALIC,15));
        tphone.setBounds(500,525,200,30);
        add(tphone); 
	    
	    next=new JButton("Next");
	    next.setBounds(700,600,200,30);
        next.setBackground(Color.black);
        next.setForeground(Color.WHITE);
        add(next);
       
	    
	    
	    
	   //frame size and title maintain
	    setSize(1920,1080);
		setTitle("Account opening form");
		setVisible(true);
		getContentPane().setBackground(Color.white);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	
    	next.addActionListener(this);
   }
    public void actionPerformed(ActionEvent event)
    {  
           
       String Religion=(String)creligion.getSelectedItem();
       String Category=(String)ccategory.getSelectedItem();
       String Income=(String)cincome.getSelectedItem();
       String Qualification=(String)cqualification.getSelectedItem();
       String Occupation=(String)coccupation.getSelectedItem();
       String Pancard=tpancard.getText();
       String Aadharcard=tadharcard.getText();
       long phone=Long.parseLong(tphone.getText());
       
       
       String Senior_citizen=null;
       if(yseniorcitizen.isSelected())
       {
    	   Senior_citizen="Yes";
       }
       else if(nseniorcitizen.isSelected())
       {
    	   Senior_citizen="No";
       }
       
       
       String ExistingAc=null;
       if(yseniorcitizen.isSelected())
       {
    	   ExistingAc="Yes";
       }
       else if(nseniorcitizen.isSelected())
       {
    	   ExistingAc="No";
       }
       
        
      //if form_no is not match and any textfield is not fill then it show pop up
      try
      { 
    	  if(tform_no.getText().equals("") || tpancard.getText().equals("") || tadharcard.getText().equals("") || Senior_citizen.equals("") || ExistingAc.equals("") || tphone.getText().equals(""))
    	  
    		  JOptionPane.showMessageDialog(null,"Fill all the Required Field");

    	    else if(!(tform_no.getText().equals(Randomnumber)))
    	    
    		  JOptionPane.showMessageDialog(null,"Invalid Form_no"); 
    	    
    	  else
    	  { 
    		  query2="insert into additional_details values('"+AccountOpen.first4+"','"+Religion+"','"+Category+"','"+Income+"','"+Qualification+"','"+Occupation+"','"+Pancard+"','"+Aadharcard+"','"+Senior_citizen+"','"+ExistingAc+"','"+phone+"')";
    		// next frame open 
    		 new AccountOpen3().setVisible(true);
    	     setVisible(false);
    	  }  
      }
      catch(Exception ex)
      {
    	 ex.printStackTrace();
      }    
      
    }
   
}

