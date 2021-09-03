import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Lib 
{
	public static void main(String[] args) throws Exception
	{
		new first();
	}
}

class first extends JFrame
{
	first()
	{
	final JLabel label= new JLabel("       Library Management                  "); 
	label.setBounds(100,50,700,50); 	
	
	
	Container c=getContentPane();
	c.setBackground(Color.gray);
	
	JButton b1=new JButton("Admin Login");
	b1.setBounds(200,150,250,40);
	
	JButton b2=new JButton("Librarian Login");
	b2.setBounds(200,200,250,40);
	

	b1.setFont(new Font("chiller",Font.BOLD,40));
	b2.setFont(new Font("chiller",Font.BOLD,40));
	label.setFont(new Font("chiller",Font.BOLD,40));
	
	
	add(label);add(b1);add(b2);

	setSize(600,400);
	setLayout(null);
	setTitle("Site Introduction");
	setVisible(true);
	setLocationRelativeTo(null);
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	b1.addActionListener
	 ( 
			new ActionListener()
			{
			   public void actionPerformed(ActionEvent e)	
				{
				  try
				  {
                     new second();
				  }
				  finally {}
				}
			}
	  
	  );
	
	b2.addActionListener
	 (
			new ActionListener()
			{
			   public void actionPerformed(ActionEvent e)	
				{
				   try 
				   {
                       new third();
				   }
				   finally {}
				}
			}
	  );
	}

}

class second extends JFrame
{
	second()
	{
		final JLabel label = new JLabel("Admin Login Form");
		label.setBounds(200,50,700,50);
		
		Container c = getContentPane();
		c.setBackground(Color.gray);
		
		JLabel l1=new JLabel("Username: ");
		l1.setBounds(100,120,420,30);
		
		JTextField text = new JTextField();
		text.setBounds(300,120,190,30);
		
		JLabel l2=new JLabel("Password: ");
		l2.setBounds(100,200,420,30);
		
		JTextField text2 = new JTextField();
		text2.setBounds(300,200,190,30);
		
		JButton b=new JButton("Login");
		b.setBounds(340,280,100,30);
		
		l1.setFont(new Font("chiller",Font.BOLD,40));
		l2.setFont(new Font("chiller",Font.BOLD,40));
		label.setFont(new Font("chiller",Font.BOLD,40));
		
		add(label);add(l1);add(l2);add(b);add(text);add(text2);

		setSize(600,400);
		setLayout(null);
		setTitle("Site Introduction");
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		b.addActionListener
		(
			new ActionListener()
			{
			 public void actionPerformed(ActionEvent e)
			 {
				 try
				 {
					  Class.forName("com.mysql.cj.jdbc.Driver");
					  Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.11:3325/library?serverTimezone=UTC", "root" , "" );
					  Statement stmt = con.createStatement();
					  
					  String query = "select * from admin_login";
					  ResultSet rs = stmt.executeQuery(query);
					  
					  String u = text.getText();
					  String p = text2.getText();
					  
					  while(rs.next())
					  {
						  if((u.equals(rs.getString(1))) && (p.equals(rs.getString(2))))
						  {
							  JOptionPane.showMessageDialog(null,"Login Successfull");
							  new forth();
						  }
						  else
						  {
							  JOptionPane.showMessageDialog(null,"Login Failed");  
						  }
					  }
				 }
				 catch(Exception k) {
					  JOptionPane.showMessageDialog(null,"try again");
				 }
			 }
			}
		);
		
	}
}

class third extends JFrame
{
	third()
	{
	final JLabel label= new JLabel("       Library Management                  "); 
	label.setBounds(100,50,700,50); 	
	
	
	Container c=getContentPane();
	c.setBackground(Color.gray);
	
	JLabel l1=new JLabel("Username: ");
	l1.setBounds(100,120,420,30);
	
	JTextField text = new JTextField();
	text.setBounds(300,120,190,30);
	
	JLabel l2=new JLabel("Password: ");
	l2.setBounds(100,200,420,30);
	
	JTextField text2 = new JTextField();
	text2.setBounds(300,200,190,30);
	
	JButton b=new JButton("Login");
	b.setBounds(340,280,100,30);
	

	l1.setFont(new Font("chiller",Font.BOLD,40));
	l2.setFont(new Font("chiller",Font.BOLD,40));
	label.setFont(new Font("chiller",Font.BOLD,40));
	
	
	add(label);add(l1);add(l2);add(text);add(text2);add(b);

	setSize(600,400);
	setLayout(null);
	setTitle("Site Introduction");
	setVisible(true);
	setLocationRelativeTo(null);
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	b.addActionListener
	 ( 
			new ActionListener()
			{
			   public void actionPerformed(ActionEvent e)	
				{
				  try
				  {
					  Class.forName("com.mysql.cj.jdbc.Driver");
					  Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.11:3325/library?serverTimezone=UTC", "root" , "" );
					  Statement stmt = con.createStatement();
					  
					  String query = "select * from librarian_login";
					  ResultSet rs = stmt.executeQuery(query);
					  
					  String u = text.getText();
					  String p = text2.getText();
					  
					  
					  while(rs.next())
					  {
						  if((u.equals(rs.getString(1))) && (p.equals(rs.getString(2))))
						  {
							  JOptionPane.showMessageDialog(null,"Login Successfull");
							  new forth();
						  }
						  else
						  {
							  JOptionPane.showMessageDialog(null,"Login Failed");  
						  }
					  }
				 }
				 catch(Exception kk) {
					  JOptionPane.showMessageDialog(null,"try again");
				 }
				}
			}
	  
	  );

}
}

class forth extends JFrame
{
	forth()
	{
	final JLabel label= new JLabel("     Admin Section                  "); 
	label.setBounds(130,40,700,50); 	
	
	Container c=getContentPane();
	c.setBackground(Color.gray);
	
	JButton b1=new JButton("Add Librarian");
	b1.setBounds(150,100,300,40);
	
	JButton b2=new JButton("View Librarian");
	b2.setBounds(150,160,300,40);
	
	JButton b3=new JButton("Delete Librarian");
	b3.setBounds(150,220,300,40);
	
	JButton b4=new JButton("Logout");
	b4.setBounds(150,270,300,40);
	


	b1.setFont(new Font("chiller",Font.BOLD,40));
	b2.setFont(new Font("chiller",Font.BOLD,40));
	b3.setFont(new Font("chiller",Font.BOLD,40));
	b4.setFont(new Font("chiller",Font.BOLD,40));
	label.setFont(new Font("chiller",Font.BOLD,40));
	
    //setting the properties of second JFrame
    JFrame frame2 = new JFrame("Database Results");
    frame2.setLayout(new FlowLayout());
	frame2.setLocationRelativeTo(null);
	setResizable(false);
    frame2.setSize(800, 800);

    //Setting the properties of JTable and DefaultTableModel
    DefaultTableModel defaultTableModel = new DefaultTableModel();
    JTable table = new JTable(defaultTableModel);
    table.setPreferredScrollableViewportSize(new Dimension(600, 600));
    
    table.setFillsViewportHeight(true);
    frame2.add(new JScrollPane(table));
    defaultTableModel.addColumn("Name");
    defaultTableModel.addColumn("Password");
	defaultTableModel.addColumn("Email");
	defaultTableModel.addColumn("Address");
	defaultTableModel.addColumn("City");
	defaultTableModel.addColumn("Contact");
	
	table.getColumnModel().getColumn(0).setPreferredWidth(100);
    table.getColumnModel().getColumn(1).setPreferredWidth(100);
	table.getColumnModel().getColumn(2).setPreferredWidth(100);
    table.getColumnModel().getColumn(3).setPreferredWidth(100);
	table.getColumnModel().getColumn(4).setPreferredWidth(100);
    table.getColumnModel().getColumn(5).setPreferredWidth(100);
	
	add(label);add(b1);add(b2);add(b3);add(b4);

	setSize(600,400);
	setLayout(null);
	setTitle("Site Introduction");
	setVisible(true);
	setLocationRelativeTo(null);
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	b1.addActionListener(
			
			new ActionListener()
			{
			   public void actionPerformed(ActionEvent e)	
				{
				  try
				  {
                       new addlib();
				  }
				  finally {}
				}
			}	
	);
	
	b2.addActionListener(
			
			new ActionListener()
			{
			   public void actionPerformed(ActionEvent e)	
				{
				   try
					  {	
					      Class.forName("com.mysql.cj.jdbc.Driver");
						  Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.11:3325/library?serverTimezone=UTC", "root" , "" );
						  Statement stmt = con.createStatement();
						  
						  String query = "select * from librarian";
						  ResultSet rs = stmt.executeQuery(query);
						  
						  System.out.println("Connected");

						  while(rs.next())
						  {
					       String i = rs.getString("Name");
				           String a = rs.getString("Password");
				           String b = rs.getString("Email");
				           String g = rs.getString("Address");
				           String d = rs.getString("City");
				           String f = rs.getString("Contact");
				           defaultTableModel.addRow(new Object[]{i,a,b,g,d,f});						   
						   frame2.setVisible(true);
						   frame2.validate();
						   
						   System.out.println("Connected query");
						  }
						  
						  System.out.println("Connected query");
						  
						  stmt.close();
						  con.close();

					  }
					  catch(Exception ef)
					  {    
						  System.out.println("not connecting to database");
					  }

				}
			}	
	);
	
	b3.addActionListener(
			
			new ActionListener()
			{
			   public void actionPerformed(ActionEvent e)	
				{
				  try
				  {
                       new dellib();
				  }
				  finally {}
				}
			}		
	);
	
	b4.addActionListener(
			
			new ActionListener()
			{
			   public void actionPerformed(ActionEvent e)	
				{
				  try
				  {
                       new first();
				  }
				  finally {}
				}
			}	
	);
}
}

class fifth extends JFrame
{
	fifth()
	{
		final JLabel label= new JLabel("     Librarian Section                  "); 
		label.setBounds(130,40,700,50); 	
		
		Container c=getContentPane();
		c.setBackground(Color.gray);
		
		JButton b1=new JButton("Add Books");
		b1.setBounds(150,100,300,40);
		
		JButton b2=new JButton("View Books");
		b2.setBounds(150,160,300,40);
		
		JButton b3=new JButton("Issue Books");
		b3.setBounds(150,220,300,40);
		
		JButton b4=new JButton("View Issued Books");
		b4.setBounds(150,280,300,40);
		
		JButton b5=new JButton("Return Books");
		b5.setBounds(150,340,300,40);
		
		JButton b6=new JButton("Logout");
		b6.setBounds(150,400,300,40);
		
		JFrame frame2 = new JFrame("Database Results");
	    frame2.setLayout(new FlowLayout());
		frame2.setLocationRelativeTo(null);
		setResizable(false);
	    frame2.setSize(800, 800);

	    //Setting the properties of JTable and DefaultTableModel
	    DefaultTableModel defaultTableModel = new DefaultTableModel();
	    JTable table = new JTable(defaultTableModel);
	    table.setPreferredScrollableViewportSize(new Dimension(600, 600));
	    
	    table.setFillsViewportHeight(true);
	    frame2.add(new JScrollPane(table));
	    defaultTableModel.addColumn("Call_No");
	    defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Author");
		defaultTableModel.addColumn("Publisher");
		defaultTableModel.addColumn("Quantity");
		
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
	    table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
	    table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		
		JFrame frame3 = new JFrame("Database Results");
	    frame3.setLayout(new FlowLayout());
		frame3.setLocationRelativeTo(null);
		setResizable(false);
	    frame3.setSize(800, 800);

	    //Setting the properties of JTable and DefaultTableModel
	    DefaultTableModel Model = new DefaultTableModel();
	    JTable table1 = new JTable(Model);
	    table1.setPreferredScrollableViewportSize(new Dimension(600, 600));
	    
	    table1.setFillsViewportHeight(true);
	    frame3.add(new JScrollPane(table1));
	    Model.addColumn("Call_No");
	    Model.addColumn("Id");
		Model.addColumn("Name");
		Model.addColumn("Contact");
		Model.addColumn("Issue date");
		
		table1.getColumnModel().getColumn(0).setPreferredWidth(100);
	    table1.getColumnModel().getColumn(1).setPreferredWidth(100);
		table1.getColumnModel().getColumn(2).setPreferredWidth(100);
	    table1.getColumnModel().getColumn(3).setPreferredWidth(100);
		table1.getColumnModel().getColumn(4).setPreferredWidth(100);
		
		
		b1.setFont(new Font("chiller",Font.BOLD,40));
		b2.setFont(new Font("chiller",Font.BOLD,40));
		b3.setFont(new Font("chiller",Font.BOLD,40));
		b4.setFont(new Font("chiller",Font.BOLD,40));
		b5.setFont(new Font("chiller",Font.BOLD,40));
		b6.setFont(new Font("chiller",Font.BOLD,40));
		label.setFont(new Font("chiller",Font.BOLD,40));
		
		
		add(label);add(b1);add(b2);add(b3);add(b4);add(b5);add(b6);

		setSize(600,600);
		setLayout(null);
		setTitle("Site Introduction");
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		b1.addActionListener(
				new ActionListener()
				{
				   public void actionPerformed(ActionEvent e)	
					{
					  try
					  {
	                       new addbook();
					  }
					  finally {}
					}
				}			
		);
		
		b2.addActionListener(
				new ActionListener()
				{
				   public void actionPerformed(ActionEvent e)	
					{
					   try {
					   Class.forName("com.mysql.cj.jdbc.Driver");
						  Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.11:3325/library?serverTimezone=UTC", "root" , "" );
						  Statement stmt = con.createStatement();
						  
						  String query = "select * from books";
						  ResultSet rs = stmt.executeQuery(query);

						  while(rs.next())
						  {
					       String i = rs.getString("Call_No");
				           String a = rs.getString("Name");
				           String b = rs.getString("Author");
				           String g = rs.getString("Publisher");
				           String d = rs.getString("Quantity");
				           defaultTableModel.addRow(new Object[]{i,a,b,g,d});						   
						   frame2.setVisible(true);
						   frame2.validate();
						   
						  }
						  
						  stmt.close();
						  con.close();

					  }
					  catch(Exception ef)
					  {    
						  System.out.println("not connecting to database");
					  }
					}	
				}
		);
		
		b3.addActionListener(
				new ActionListener()
				{
				   public void actionPerformed(ActionEvent e)	
					{
					  try
					  {
	                       new issuebook();
					  }
					  finally {}
					}
				}			
		);
		
		b4.addActionListener(
				new ActionListener()
				{
				   public void actionPerformed(ActionEvent e)	
					{
					   try {
					   Class.forName("com.mysql.cj.jdbc.Driver");
						  Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.11:3325/library?serverTimezone=UTC", "root" , "" );
						  Statement stmt = con.createStatement();
						  
						  String query = "select * from issue_books";
						  ResultSet rs = stmt.executeQuery(query);

						  while(rs.next())
						  {
					       String i = rs.getString("Call_No");
				           String a = rs.getString("Id");
				           String b = rs.getString("Name");
				           String g = rs.getString("Contact");
				           String d = rs.getString("Issue_time");
				           Model.addRow(new Object[]{i,a,b,g,d});						   
						   frame3.setVisible(true);
						   frame3.validate();
						   
						  }
						  
						  stmt.close();
						  con.close();

					  }
					  catch(Exception ef)
					  {    
						  System.out.println("not connecting to database");
					  }
					}
				}		
		);
		
		b5.addActionListener(
				new ActionListener()
				{
				   public void actionPerformed(ActionEvent e)	
					{
					  try
					  {
	                       new returnbook();
					  }
					  finally {}
					}
				}		
		);
		
		b6.addActionListener(
				new ActionListener()
				{
				   public void actionPerformed(ActionEvent e)	
					{
					  try
					  {
	                       new first();
					  }
					  finally {}
					}
				}		
		);
		
	}
}

class addlib extends JFrame 
{
	addlib()
	{	
	final JLabel label= new JLabel("       Add Librarian                  "); 
	label.setBounds(100,50,700,50); 	
	
	
	Container c=getContentPane();
	c.setBackground(Color.gray);
	
	JLabel l1=new JLabel("Name: ");
	l1.setBounds(100,120,420,30);
	
	JTextField text = new JTextField();
	text.setBounds(300,120,250,30);
	
	JLabel l2=new JLabel("Password: ");
	l2.setBounds(100,160,420,30);
	
	JTextField text2 = new JTextField();
	text2.setBounds(300,160,250,30);
	
	JLabel l3=new JLabel("Email: ");
	l3.setBounds(100,200,420,30);
	
	JTextField text3 = new JTextField();
	text3.setBounds(300,200,250,30);
	
	JLabel l4=new JLabel("Address: ");
	l4.setBounds(100,240,420,30);
	
	JTextField text4 = new JTextField();
	text4.setBounds(300,240,250,30);
	
	JLabel l5=new JLabel("City: ");
	l5.setBounds(100,280,420,30);
	
	JTextField text5 = new JTextField();
	text5.setBounds(300,280,250,30);
	
	JLabel l6=new JLabel("Contact No: ");
	l6.setBounds(100,320,420,30);
	
	JTextField text6 = new JTextField();
	text6.setBounds(300,320,250,30);
	
	JButton b=new JButton("Add Librarian");
	b.setBounds(310,390,230,30);
	
	JButton b1=new JButton("Back");
	b1.setBounds(340,450,150,30);

	l1.setFont(new Font("chiller",Font.BOLD,30));
	l2.setFont(new Font("chiller",Font.BOLD,30));
	l3.setFont(new Font("chiller",Font.BOLD,30));
	l4.setFont(new Font("chiller",Font.BOLD,30));
	l5.setFont(new Font("chiller",Font.BOLD,30));
	l6.setFont(new Font("chiller",Font.BOLD,30));
	text.setFont(new Font("chiller",Font.BOLD,30));
	text2.setFont(new Font("chiller",Font.BOLD,30));
	text3.setFont(new Font("chiller",Font.BOLD,30));
	text4.setFont(new Font("chiller",Font.BOLD,30));
	text5.setFont(new Font("chiller",Font.BOLD,30));
	text6.setFont(new Font("chiller",Font.BOLD,30));
	b.setFont(new Font("chiller",Font.BOLD,30));
	b1.setFont(new Font("chiller",Font.BOLD,30));
	label.setFont(new Font("chiller",Font.BOLD,30));
	
	add(b1);add(label);add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(text);add(text2);add(text3);add(text4);add(text5);add(text6);add(b);

	setSize(600,600);
	setLayout(null);
	setTitle("Site Introduction");
	setVisible(true);
	setLocationRelativeTo(null);
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	b.addActionListener
	 ( 
			new ActionListener()
			{
			   public void actionPerformed(ActionEvent e)	
				{
				  try
				  {	
					  Class.forName("com.mysql.cj.jdbc.Driver");
					  
					  Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.11:3325/library?serverTimezone=UTC", "root" , "" );
					  Statement stmt = con.createStatement();
					  
					     String a_name = text.getText();
						 String a_pass = text2.getText();
						 String a_email = text3.getText();
						 String a_add = text4.getText();
						 String a_city = text5.getText();
						 String a_contact = text6.getText();				
					     PreparedStatement p = con.prepareStatement("Insert into librarian (Name,Password,Email,Address,City,Contact) values(?,?,?,?,?,?)");
					     p.setString(1,a_name);
					     p.setString(2,a_pass);
					     p.setString(3,a_email);
					     p.setString(4,a_add);
					     p.setString(5,a_city);
					     p.setString(6,a_contact);
					     
					     p.executeUpdate();
					     JOptionPane.showMessageDialog(null,"Inserted Successfully!");
					  
					     stmt.close();
					     con.close();

				  }
				  catch(Exception ef)
					    {    
					  System.out.println("not connecting to database");
					    }
				
				}
			}
	  
	  );

	}
}

class dellib extends JFrame
{
 dellib()
 {
	    Container c=getContentPane();
		c.setBackground(Color.gray);
		
		JLabel l1=new JLabel("Enter Id: ");
		l1.setBounds(100,120,420,30);
		
		JTextField text = new JTextField();
		text.setBounds(300,120,250,30); 
		
		JButton b = new JButton("Delete");
		b.setBounds(330,200,150,40);
		
		JButton b1 = new JButton("Back");
		b1.setBounds(330,300,150,40);
		
		l1.setFont(new Font("chiller",Font.BOLD,40));
		text.setFont(new Font("chiller",Font.BOLD,40));
		b.setFont(new Font("chiller",Font.BOLD,40));
		b1.setFont(new Font("chiller",Font.BOLD,40));
		
		JFrame frame2 = new JFrame("Database Results");
	    frame2.setLayout(new FlowLayout());
		frame2.setLocationRelativeTo(null);
		setResizable(false);
	    frame2.setSize(800, 800);

	    //Setting the properties of JTable and DefaultTableModel
	    DefaultTableModel defaultTableModel = new DefaultTableModel();
	    JTable table = new JTable(defaultTableModel);
	    table.setPreferredScrollableViewportSize(new Dimension(600, 600));
	    
	    table.setFillsViewportHeight(true);
	    frame2.add(new JScrollPane(table));
	    defaultTableModel.addColumn("Name");
	    defaultTableModel.addColumn("Password");
		defaultTableModel.addColumn("Email");
		defaultTableModel.addColumn("Address");
		defaultTableModel.addColumn("City");
		defaultTableModel.addColumn("Contact");
		
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
	    table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
	    table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
	    table.getColumnModel().getColumn(5).setPreferredWidth(100);
		
		
		add(l1);add(text);add(b);add(b1);
		
		setSize(600,400);
		setLayout(null);
		setTitle("Site Introduction");
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		b.addActionListener
		 ( 
				new ActionListener()
				{
				   public void actionPerformed(ActionEvent e)	
					{
					  try
					  {	
						  Class.forName("com.mysql.cj.jdbc.Driver");
						  
						  Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.11:3325/library?serverTimezone=UTC", "root" , "" ); 
						  String query= "delete FROM librarian where Id = "+text.getText()+"";
						  Statement stmt = con.createStatement();
						  stmt.executeUpdate(query);
						  				
						   JOptionPane.showMessageDialog(null,"Deleted Successfully!");
			
						   String query1 = "select * from librarian";
						   ResultSet rs = stmt.executeQuery(query1);
							  
							  while(rs.next())
							  {
						       String i = rs.getString("Name");
					           String a = rs.getString("Password");
					           String b = rs.getString("Email");
					           String g = rs.getString("Address");
					           String d = rs.getString("City");
					           String f = rs.getString("Contact");
					           defaultTableModel.addRow(new Object[]{i,a,b,g,d,f});						   
							   frame2.setVisible(true);
							   frame2.validate();
							  }
							  stmt.close();
							  con.close();

						  }
						  catch(Exception ef)
						  {    
							  System.out.println("not connecting to database");
						  }

					  }
				}
		  
		  );
 }
}

class addbook extends JFrame
{
	addbook()
	{
	final JLabel label= new JLabel("               Add Books                  "); 
	label.setBounds(100,50,700,50); 	
	
	
	Container c=getContentPane();
	c.setBackground(Color.gray);
	
	JLabel l1=new JLabel("Call No: ");
	l1.setBounds(100,120,420,30);
	
	JTextField text = new JTextField();
	text.setBounds(300,120,250,30);
	
	JLabel l2=new JLabel("Name: ");
	l2.setBounds(100,160,420,30);
	
	JTextField text2 = new JTextField();
	text2.setBounds(300,160,250,30);
	
	JLabel l3=new JLabel("Author: ");
	l3.setBounds(100,200,420,30);
	
	JTextField text3 = new JTextField();
	text3.setBounds(300,200,250,30);
	
	JLabel l4=new JLabel("Publisher: ");
	l4.setBounds(100,240,420,30);
	
	JTextField text4 = new JTextField();
	text4.setBounds(300,240,250,30);
	
	JLabel l5=new JLabel("Quantity: ");
	l5.setBounds(100,280,420,30);
	
	JTextField text5 = new JTextField();
	text5.setBounds(300,280,250,30);
	
	JButton b=new JButton("Add Books");
	b.setBounds(310,340,230,30);
	
	JButton b1=new JButton("Back");
	b1.setBounds(340,400,150,30);

	l1.setFont(new Font("chiller",Font.BOLD,30));
	l2.setFont(new Font("chiller",Font.BOLD,30));
	l3.setFont(new Font("chiller",Font.BOLD,30));
	l4.setFont(new Font("chiller",Font.BOLD,30));
	l5.setFont(new Font("chiller",Font.BOLD,30));
	text.setFont(new Font("chiller",Font.BOLD,30));
	text2.setFont(new Font("chiller",Font.BOLD,30));
	text3.setFont(new Font("chiller",Font.BOLD,30));
	text4.setFont(new Font("chiller",Font.BOLD,30));
	text5.setFont(new Font("chiller",Font.BOLD,30));
	b.setFont(new Font("chiller",Font.BOLD,30));
	b1.setFont(new Font("chiller",Font.BOLD,30));
	label.setFont(new Font("chiller",Font.BOLD,30));
	
	
	add(b1);add(label);add(l1);add(l2);add(l3);add(l4);add(l5);add(text);add(text2);add(text3);add(text4);add(text5);add(b);

	setSize(600,600);
	setLayout(null);
	setTitle("Site Introduction");
	setVisible(true);
	setLocationRelativeTo(null);
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	b.addActionListener
	 ( 
			new ActionListener()
			{
			   public void actionPerformed(ActionEvent e)	
				{
				   try
					  {	
						  Class.forName("com.mysql.cj.jdbc.Driver");
						  
						  Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.11:3325/library?serverTimezone=UTC", "root" , "" );
						  Statement stmt = con.createStatement();
						  
						     String a = text.getText();
							 String b = text2.getText();
							 String c = text3.getText();
							 String d = text4.getText();
							 String f = text5.getText();			
						     PreparedStatement p = con.prepareStatement("Insert into books (Call_No,Name,Author,Publisher,Quantity) values(?,?,?,?,?)");
						     p.setString(1,a);
						     p.setString(2,b);
						     p.setString(3,c);
						     p.setString(4,d);
						     p.setString(5,f);
						     
						     p.executeUpdate();
						     JOptionPane.showMessageDialog(null,"Inserted Successfully!");
						  
						     stmt.close();
						     con.close();

					  }
					  catch(Exception ef)
						    {    
						  System.out.println("not connecting to database");
						    }

				}
			}
	  
	  );

	}
}

class issuebook extends JFrame
{
	issuebook()
	{
	final JLabel label= new JLabel("               Issue Book                  "); 
	label.setBounds(100,50,700,50); 	
	
	
	Container c=getContentPane();
	c.setBackground(Color.gray);
	
	JLabel l1=new JLabel("Book CallNo: ");
	l1.setBounds(100,120,420,30);
	
	JTextField text = new JTextField();
	text.setBounds(300,120,250,30);
	
	JLabel l2=new JLabel("Student Id: ");
	l2.setBounds(100,160,420,30);
	
	JTextField text2 = new JTextField();
	text2.setBounds(300,160,250,30);
	
	JLabel l3=new JLabel("Student Name: ");
	l3.setBounds(100,200,420,30);
	
	JTextField text3 = new JTextField();
	text3.setBounds(300,200,250,30);
	
	JLabel l4=new JLabel("Student Contact: ");
	l4.setBounds(100,240,420,30);
	
	JTextField text4 = new JTextField();
	text4.setBounds(300,240,250,30);
	
	JButton b=new JButton("Add Books");
	b.setBounds(310,300,230,30);
	
	JButton b1=new JButton("Back");
	b1.setBounds(340,350,150,30);

	l1.setFont(new Font("chiller",Font.BOLD,30));
	l2.setFont(new Font("chiller",Font.BOLD,30));
	l3.setFont(new Font("chiller",Font.BOLD,30));
	l4.setFont(new Font("chiller",Font.BOLD,30));
	text.setFont(new Font("chiller",Font.BOLD,30));
	text2.setFont(new Font("chiller",Font.BOLD,30));
	text3.setFont(new Font("chiller",Font.BOLD,30));
	text4.setFont(new Font("chiller",Font.BOLD,30));
	b.setFont(new Font("chiller",Font.BOLD,30));
	b1.setFont(new Font("chiller",Font.BOLD,30));
	label.setFont(new Font("chiller",Font.BOLD,30));
	
	
	add(b1);add(label);add(l1);add(l2);add(l3);add(l4);add(text);add(text2);add(text3);add(text4);add(b);

	setSize(600,500);
	setLayout(null);
	setTitle("Site Introduction");
	setVisible(true);
	setLocationRelativeTo(null);
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	b.addActionListener
	 ( 
			new ActionListener()
			{
			   public void actionPerformed(ActionEvent e)	
				{
				  try
				  {
					  Class.forName("com.mysql.cj.jdbc.Driver");
					  
					  Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.11:3325/library?serverTimezone=UTC", "root" , "" );
					  Statement stmt = con.createStatement();
					  
					     String a = text.getText();
						 String b = text2.getText();
						 String c = text3.getText();
						 String d = text4.getText();
						 
						 PreparedStatement p = con.prepareStatement("Insert into issue_books (Call_No, Id, Name, Contact, Issue_time) values(?,?,?,?,CURRENT_TIMESTAMP)");
						 
						 p.setString(1,a);
					     p.setString(2,b);
					     p.setString(3,c);
					     p.setString(4,d);
					     
					     p.executeUpdate();
					     JOptionPane.showMessageDialog(null,"Book Issued!");
					  
					     stmt.close();
					     con.close();
				}
				  catch(Exception g)
				  {
					System.out.println("Database not connected");  
				  }
				  }
			}
	  
	  );

	}
}

class returnbook extends JFrame
{
	returnbook()
	 {
		final JLabel label= new JLabel("          Return Book                  "); 
		label.setBounds(100,30,700,50); 	
		
		    Container c=getContentPane();
			c.setBackground(Color.gray);
			
			JLabel l1=new JLabel("Book CallNo: ");
			l1.setBounds(100,100,420,30);
			
			JTextField text = new JTextField();
			text.setBounds(300,100,250,30);
			
			JLabel l2=new JLabel("Student Id: ");
			l2.setBounds(100,150,420,30);
			
			JTextField text2 = new JTextField();
			text2.setBounds(300,150,250,30);
			
			JButton b = new JButton("Delete");
			b.setBounds(330,220,150,40);
			
			JButton b1 = new JButton("Back");
			b1.setBounds(330,300,150,40);
			
			l1.setFont(new Font("chiller",Font.BOLD,40));
			l2.setFont(new Font("chiller",Font.BOLD,40));
			text.setFont(new Font("chiller",Font.BOLD,40));
			text2.setFont(new Font("chiller",Font.BOLD,40));
			b.setFont(new Font("chiller",Font.BOLD,40));
			b1.setFont(new Font("chiller",Font.BOLD,40));
			label.setFont(new Font("chiller",Font.BOLD,40));
			
			JFrame frame3 = new JFrame("Database Results");
		    frame3.setLayout(new FlowLayout());
			frame3.setLocationRelativeTo(null);
			setResizable(false);
		    frame3.setSize(800, 800);

		    //Setting the properties of JTable and DefaultTableModel
		    DefaultTableModel Model = new DefaultTableModel();
		    JTable table1 = new JTable(Model);
		    table1.setPreferredScrollableViewportSize(new Dimension(600, 600));
		    
		    table1.setFillsViewportHeight(true);
		    frame3.add(new JScrollPane(table1));
		    Model.addColumn("Call_No");
		    Model.addColumn("Id");
			Model.addColumn("Name");
			Model.addColumn("Contact");
			Model.addColumn("Issue date");
			
			table1.getColumnModel().getColumn(0).setPreferredWidth(100);
		    table1.getColumnModel().getColumn(1).setPreferredWidth(100);
			table1.getColumnModel().getColumn(2).setPreferredWidth(100);
		    table1.getColumnModel().getColumn(3).setPreferredWidth(100);
			table1.getColumnModel().getColumn(4).setPreferredWidth(100);
			
			add(label);add(l1);add(text);add(b);add(b1);add(l2);add(text2);
			
			setSize(600,400);
			setLayout(null);
			setTitle("Site Introduction");
			setVisible(true);
			setLocationRelativeTo(null);
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			b.addActionListener
			 ( 
					new ActionListener()
					{
					   public void actionPerformed(ActionEvent e)	
						{
						  try
						  {	
							  Class.forName("com.mysql.cj.jdbc.Driver");
							  
							  Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.11:3325/library?serverTimezone=UTC", "root" , "" ); 
							  String query= "delete FROM issue_books where Id = "+text2.getText()+"";
							  Statement stmt = con.createStatement();
							  stmt.executeUpdate(query);
							  				
							   JOptionPane.showMessageDialog(null,"Deleted Successfully!");
				
							   String query1 = "select * from issue_books";
							   ResultSet rs = stmt.executeQuery(query1);
								  
								  while(rs.next())
								  {
							       String i = rs.getString("Call_No");
						           String a = rs.getString("Id");
						           String b = rs.getString("Name");
						           String g = rs.getString("Contact");
						           String d = rs.getString("Issue_time");
						           Model.addRow(new Object[]{i,a,b,g,d});						   
								   frame3.setVisible(true);
								   frame3.validate();
								  }
								  stmt.close();
								  con.close();

							  }
							  catch(Exception ef)
							  {    
								  JOptionPane.showMessageDialog(null,"No record Found!!!");
							  }

						  }
					}
			  
			  );
			
	 }

}
