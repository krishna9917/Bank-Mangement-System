package BankServices;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class AllDetails extends JFrame implements ActionListener
{
	
   JLabel heading,Ac,Id,Ac_holdername,fathername,Dob,gender,email,maritalstatus,address,pincode,state,religion,category,income,qualification,occupation,Pancard,Adharcard,services,phone;
   JLabel tAc,tId,tAc_holdername,tfathername,tDob,tgender,temail,tmaritalstatus,taddress,tpincode,tstate,treligion,tcategory,tincome,tqualification,toccupation,tPancard,tAdharcard,tservices,tphone;
   JButton back;
   AllDetails()
   {
	
	 //heading of the page
      heading=new JLabel("All Details related to Your Account");
    	setLayout(null);
   	  heading.setBounds(220,50,1000,50);
       heading.setFont(new Font("Osward",Font.BOLD,50));
  	   add(heading);
   	
   	// set information details labels
    Ac=new JLabel("Account Number"+"     :");
    Ac.setFont(new Font("Raleway",Font.BOLD,25));
    Ac.setBounds(100,120,500,100);
    add(Ac);    
    

    Id=new JLabel("Account Id"+"               :");
    Id.setFont(new Font("Raleway",Font.BOLD,25));
    Id.setBounds(100,160,500,100);
    add(Id);   
	   
    
    Ac_holdername=new JLabel("AC Holder Name"+"     :");
    Ac_holdername.setFont(new Font("Raleway",Font.BOLD,25));
    Ac_holdername.setBounds(100,200,500,100);
    add(Ac_holdername);  
   
    
    
    fathername=new JLabel("Father's Name"+"         :");
    fathername.setFont(new Font("Raleway",Font.BOLD,25));
    fathername.setBounds(100,240,500,100);
     add(fathername);  
    
    
    Dob=new JLabel("Date Of Birth"+"           :");
    Dob.setFont(new Font("Raleway",Font.BOLD,25));
    Dob.setBounds(100,280,500,100);
    add(Dob);
    
    gender=new JLabel("Gender"+"                    :");
    gender.setFont(new Font("Raleway",Font.BOLD,25));
    gender.setBounds(100,320,500,100);
    add(gender);
    
    
    email=new JLabel("Email"+"                       :");
    email.setFont(new Font("Raleway",Font.BOLD,25));
    email.setBounds(100,360,500,100);
    add(email);
    
    phone=new JLabel("Contact no."+"             :");
    phone.setFont(new Font("Raleway",Font.BOLD,25));
    phone.setBounds(100,400,500,100);
    add(phone);
    
    maritalstatus=new JLabel("Marital Status"+"         :");
    maritalstatus.setFont(new Font("Raleway",Font.BOLD,25));
    maritalstatus.setBounds(100,440,500,100);
    add(maritalstatus);
    
    
    address=new JLabel("Address "+"                  :");
    address.setFont(new Font("Raleway",Font.BOLD,25));
    address.setBounds(100,480,500,100);
    add(address);
    
    
    services=new JLabel("Account Services"+"    :");
    services.setFont(new Font("Raleway",Font.BOLD,25));
    services.setBounds(100,520,500,100);
      add(services);
    
    pincode=new JLabel("Pincode "+"                  :");
    pincode.setFont(new Font("Raleway",Font.BOLD,25));
    pincode.setBounds(700,120,500,100);
    add(pincode);
	   
    
    

    state=new JLabel("State "+"                       :");
    state.setFont(new Font("Raleway",Font.BOLD,25));
    state.setBounds(700,160,500,100);
    add(state);
    
    
    religion=new JLabel("Religion "+"                  :");
    religion.setFont(new Font("Raleway",Font.BOLD,25));
    religion.setBounds(700,200,500,100);
      add(religion);
      
      
      category=new JLabel("Category "+"                 :");
      category.setFont(new Font("Raleway",Font.BOLD,25));
      category.setBounds(700,240,500,100);
        add(category);
        
        
        income=new JLabel("Income "+"                    :");
        income.setFont(new Font("Raleway",Font.BOLD,25));
        income.setBounds(700,280,500,100);
          add(income);
    
   
          qualification=new JLabel("Qualification "+"           :");
          qualification.setFont(new Font("Raleway",Font.BOLD,25));
          qualification.setBounds(700,320,500,100);
            add(qualification);
            
            occupation=new JLabel("Occupation "+"             :");
            occupation.setFont(new Font("Raleway",Font.BOLD,25));
            occupation.setBounds(700,360,500,100);
              add(occupation); 
              
              Pancard=new JLabel("PanCard"+"                   :");
              Pancard.setFont(new Font("Raleway",Font.BOLD,25));
              Pancard.setBounds(700,400,500,100);
                add(Pancard); 
    
                Adharcard=new JLabel("AadharCard "+"            :");
                Adharcard.setFont(new Font("Raleway",Font.BOLD,25));
                Adharcard.setBounds(700,440,500,100);
                  add(Adharcard); 
                  
                 
                    
                    

           		 //frame title and size maintain with visiblility
           	    setVisible(true);
           	    setVisible(true);
           	  	setSize(1920,1080);
           	  	setTitle("Account Information Details");
           	  	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           	  	//change the color of the page
           	  	getContentPane().setBackground(Color.WHITE);         
                   
                  
                	//back Button
            		back=new JButton("<<Back");
            		back.setFont(new Font("Verdana",Font.BOLD,20));
            		back.setBackground(Color.black);
            		back.setForeground(Color.WHITE);
            		back.setBounds(10,10,200,40);
            		add(back);
            		back.addActionListener(this);
            		
                    
      try
      {
    	  connection conn=new connection();
    	  String showquery1="Select * from personal_details where Id="+Front_page.Id;
    	  ResultSet rs1=conn.Database.executeQuery(showquery1);
    	  if(rs1.next())
     	 {
    		 // details retrive from data base 
    		  
    		    String Id=rs1.getString("Id");
    		    tId=new JLabel(Id);
    		    tId.setFont(new Font("Raleway",Font.ITALIC,20));
    		    tId.setBounds(355,160,500,100);
    		    add(tId);   
    		  
    		  
     		String holdername=rs1.getString("Ac_HolderName");	  
     		 tAc_holdername=new JLabel(holdername);
     	    tAc_holdername.setFont(new Font("Verdana",Font.ITALIC,20));
     	    tAc_holdername.setBounds(355,200,1000,100);
     	    add(tAc_holdername);  
     	    
     	    String fathername=rs1.getString("FatherName");
     	   tfathername=new JLabel(fathername);
     	    tfathername.setFont(new Font("Raleway",Font.ITALIC,20));
     	    tfathername.setBounds(355,240,500,100);
     	     add(tfathername);
     	     
     	     
     	    String dob=rs1.getString("DOB"); 
     	    tDob=new JLabel(dob);
     	    tDob.setFont(new Font("Raleway",Font.ITALIC,20));
     	    tDob.setBounds(355,280,500,100);
     	    add(tDob); 
     	   
     	   String gender=rs1.getString("Gender"); 
     	   tgender=new JLabel(gender);
     	    tgender.setFont(new Font("Raleway",Font.ITALIC,20));
     	    tgender.setBounds(355,320,500,100);
     	    add(tgender);
     	    
     	   String email=rs1.getString("Email");  
     	   temail=new JLabel(email);
     	    temail.setFont(new Font("Raleway",Font.ITALIC,20));
     	    temail.setBounds(355,360,500,100);
     	    add(temail);
     	    
           String marital=rs1.getString("MaritalStatus"); 
     	   tmaritalstatus=new JLabel(marital);
     	    tmaritalstatus.setFont(new Font("Raleway",Font.ITALIC,20));
     	    tmaritalstatus.setBounds(355,440,500,100);
     	    add(tmaritalstatus);
     	   
     	    String address=rs1.getString("Address"); 
     	   taddress=new JLabel(address);
     	    taddress.setFont(new Font("Raleway",Font.ITALIC,20));
     	    taddress.setBounds(355,480,500,100);
     	    add(taddress); 
     	    
     	    
     	    String pincode=rs1.getString("Pincode"); 
     	   tpincode=new JLabel(pincode);
     	    tpincode.setFont(new Font("Raleway",Font.ITALIC,20));
     	    tpincode.setBounds(950,120,500,100);
     	    add(tpincode);
     	    
     	    String state=rs1.getString("State");
     	    tstate=new JLabel(state);
     	    tstate.setFont(new Font("Raleway",Font.ITALIC,20));
     	    tstate.setBounds(950,160,500,100);
     	    add(tstate);
     	    
     	    
     	   
     	 }
    	  String showquery2="Select * from additional_details where Id="+Front_page.Id;
    	  ResultSet rs2=conn.Database.executeQuery(showquery2);
    	  if(rs2.next())
    	  {
    		  String phone=rs2.getString("Contact-No"); 
    		  tphone=new JLabel(phone);
    		    tphone.setFont(new Font("Raleway",Font.ITALIC,20));
    		    tphone.setBounds(355,400,500,100);
    		    add(tphone);
    		  
    		   String religion=rs2.getString("Religion"); 
    		    treligion=new JLabel(religion);
    		    treligion.setFont(new Font("Raleway",Font.ITALIC,20));
    		    treligion.setBounds(950,200,500,100);
    		      add(treligion);
    		      
    		      String category=rs2.getString("Category");
    		      tcategory=new JLabel(category);
    		      tcategory.setFont(new Font("Raleway",Font.ITALIC,20));
    		      tcategory.setBounds(950,240,500,100);
    		        add(tcategory);
    		        
    		        
    		        String income=rs2.getString("Income");
    		        tincome=new JLabel(income);
    		        tincome.setFont(new Font("Raleway",Font.ITALIC,20));
    		        tincome.setBounds(950,280,500,100);
    		          add(tincome);
    		          
    		          
    		          String qualification=rs2.getString("Qualification");
    		          tqualification=new JLabel(qualification);
    		          tqualification.setFont(new Font("Raleway",Font.ITALIC,20));
    		          tqualification.setBounds(950,320,500,100);
    		            add(tqualification);
    		          
    		           String occupation=rs2.getString("Occupation");
    		            toccupation=new JLabel(occupation);
    		            toccupation.setFont(new Font("Raleway",Font.ITALIC,20));
    		            toccupation.setBounds(950,360,500,100);
    		              add(toccupation);  
    		              
    		              String pancard=rs2.getString("PAN_card");
    		              tPancard=new JLabel(pancard);
    		              tPancard.setFont(new Font("Raleway",Font.ITALIC,20));
    		              tPancard.setBounds(950,400,500,100);
    		                add(tPancard);  
    		                
    		                String adharcard=rs2.getString("Aadhar_card");
    		                tAdharcard=new JLabel(adharcard);
    		                tAdharcard.setFont(new Font("Raleway",Font.ITALIC,20));
    		                tAdharcard.setBounds(950,440,500,100);
    		                  add(tAdharcard);  
    		            
    		    
    	  }
    	  String showquery3="Select * from accountopen where Id="+Front_page.Id;
    	  ResultSet rs3=conn.Database.executeQuery(showquery3);
    	  if(rs3.next())
    	  {
    		  String services=rs3.getString("Services");
    		  tservices=new JLabel(services);
              tservices.setFont(new Font("Raleway",Font.ITALIC,20));
              tservices.setBounds(355,520,500,100);
                add(tservices);
                
                String ac=rs3.getString("AC_No");
                tAc=new JLabel(ac);
                tAc.setFont(new Font("Raleway",Font.ITALIC,20));
                tAc.setBounds(355,120,500,100);
                add(tAc);   
    	  }
    	
    	 
      }
      catch(Exception x)
      {
    	  System.out.println("Error:"+x);
      }
                  

   }
   public void actionPerformed(ActionEvent ae)
   {
	   if(ae.getSource()==back)
	   {
   		new AccountInformation().setVisible(true);
   		setVisible(false);
	   }
   }
  
}
