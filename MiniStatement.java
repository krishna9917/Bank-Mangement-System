package BankServices;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class MiniStatement extends JFrame implements ActionListener 
{  
	DefaultTableModel model = new DefaultTableModel();
	 	JTable table = new JTable(model);
	JLabel heading,statement;
	JButton back;
	
	MiniStatement()
	{
	        model.addColumn("Date");
	        model.addColumn("Withdrawal");
	        model.addColumn("Deposite");
	        model.addColumn("Balance");
	        
	        
    	//back Button
		back=new JButton("<<Back");
		back.setFont(new Font("Verdana",Font.BOLD,20));
		back.setBackground(Color.black);
		back.setForeground(Color.WHITE);
		back.setBounds(1100,600,170,40);
		add(back);
		back.addActionListener(this);
		
		
						
		try
		{
	          connection con=new connection();
	            String statementshow="Select Date,Withdrawal,Deposite,Balance from statement where Ac_No="+Front_page.inputdata+" and Id="+Front_page.Id;
	            ResultSet Rs=con.Database.executeQuery(statementshow);
	            while(Rs.next())
	            {
	                model.addRow(new Object[]{Rs.getString(1),Rs.getString(2),Rs.getString(3),Rs.getString(4)});
		        }
	            JScrollPane table1 = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	            add(table1);
	            
		}
		catch(Exception x)
		{
			System.out.println("Error:"+x);
		}
		
	 //frame title and size maintain with visiblility
   	setVisible(true);
   	setSize(1920,1280);
   	setTitle("Mini Statement");
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
	   }
}
