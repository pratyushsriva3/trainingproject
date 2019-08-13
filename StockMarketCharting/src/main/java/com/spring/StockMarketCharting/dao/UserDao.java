package com.spring.StockMarketCharting.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import com.spring.StockMarketCharting.model.User;

public class UserDao {
	
	@SuppressWarnings("null")
	public User validateinDatabase(String username, String password) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		User userData = new User();
		int size =0;
		try
		{
		System.out.println("Before going to jdbc in Class");
		Class.forName("com.mysql.jdbc.Driver");

		System.out.println("Before going to jdbc in dao Connection");
		Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_exchange_db","root","pass@word1");  
		//here sonoo is database name, root is username and password  

		System.out.println("Before going to jdbc in Statement");
		Statement stmt=(Statement) con.createStatement();

		System.out.println("Before going to jdbc in ResultSet");
		ResultSet rs=stmt.executeQuery("select * from user where email = '" +username+"' and password='" +password+"';" );  
	    
		System.out.println("AFter Statement");
		while(rs.next())  
		{
			
			userData.setId(rs.getInt(1));
			userData.setUsername(rs.getString(2));
			userData.setPassword(rs.getString(3));
			userData.setEmail(rs.getString(5));
			userData.setMobile(rs.getInt(6));
			userData.setUsertype(rs.getString(4));
			userData.setConfirmed(rs.getString(7));
			System.out.println("Setted as valid in side while");
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)
			+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)
			);  
		}
		
		if (rs != null) 
		{
		  rs.last();    // moves cursor to the last row
		  size = rs.getRow(); // get row id 
		}
		System.out.println("Size of Object Resultset :"+size);
		
		
			con.close();
		}
			
		catch(Exception e){ System.out.println(e);
		userData.setUsertype("Error");
		return userData;}
		if(size <= 0)
		{
			userData.setUsertype("IU");
		}
		return userData;  
			}

	public String registerInDatabase(String username, String password, String mail, String contact) {
		// TODO Auto-generated method stub
		
		try
		{
		System.out.println("Before going to jdbc in Class");
		Class.forName("com.mysql.jdbc.Driver");

		System.out.println("Before going to jdbc in dao Connection");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_exchange_db","root","pass@word1");  
		//here sonoo is database name, root is username and password  

		System.out.println("Before going to jdbc in Statement");
		Statement stmt=(Statement) con.createStatement();

		System.out.println("Before going to jdbc in ResultSet");
		int sql = stmt.executeUpdate("INSERT INTO `stock_exchange_db`.`user` (`username`, `password`, `usertype`, `email`, `mobilenumber`, `confirmed`)"
				+ " VALUES ('"+username+"', '"+password+"', '"+"UU"+"', '"+mail+"', '"+contact+"', '"+"0"+"')"
                  );  
	    
		System.out.println("Inserted Successfully : "+ sql);
		con.close();
		return "yes";
		
		
			
		}
			
		catch(Exception e){ System.out.println(e);
		return "no";
		}
		
	}

	public String updateInDatabase(String username, String mail, String userId,String otp) {
		// TODO Auto-generated method stub
		try
		{
		System.out.println("Before going to jdbc in Class");
		Class.forName("com.mysql.jdbc.Driver");

		System.out.println("Before going to jdbc in dao Connection");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_exchange_db","root","pass@word1");  
		//here sonoo is database name, root is username and password  

		System.out.println("Before going to jdbc in Statement");
		Statement stmt=(Statement) con.createStatement();

		System.out.println("Before going to jdbc in ResultSet");
		int result = Integer.parseInt(otp);
		System.out.println("Otp :  uytguy" + result);
		int sql = stmt.executeUpdate("UPDATE stock_exchange_db.user SET confirmed = "+result + " WHERE id = '"+userId+"'");  
	    
		System.out.println("Inserted Successfully : "+ sql);
		con.close();
		return "yes";
		
		
			
		}
			
		catch(Exception e){ System.out.println(e);
		return "no";
		}
	}

	public String getUserIdDatabase(String username, String mail) {
		// TODO Auto-generated method stub
		
		User userData = new User();
		int size =0;
		int userId;
		
		try
		{
		System.out.println("Before going to jdbc in Class");
		Class.forName("com.mysql.jdbc.Driver");

		System.out.println("Before going to jdbc in dao Connection");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_exchange_db","root","pass@word1");  
		//here sonoo is database name, root is username and password  

		System.out.println("Before going to jdbc in Statement");
		Statement stmt=(Statement) con.createStatement();

		System.out.println("Before going to jdbc in ResultSet");
		ResultSet rs=stmt.executeQuery("select * from user where username = '" +username+"' and email='" +mail+"';" );  
	    
		System.out.println("AFter Statement");
		int number = 0 ;
			while(rs.next())
			{
			number = rs.getInt(1);
			}
			con.close();
		 return String.valueOf(number);
			
		}
			
		catch(Exception e){ System.out.println(e);
		
		return "Error";}
		

		
		
	}

	public String verifyInDatabase(String mailid, String verification) {
		// TODO Auto-generated method stub
		
		User userData = new User();
		int size =0;
		int userId;
		
		try
		{
		System.out.println("Before going to jdbc in Class");
		Class.forName("com.mysql.jdbc.Driver");

		System.out.println("Before going to jdbc in dao Connection");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_exchange_db","root","pass@word1");  
		//here sonoo is database name, root is username and password  

		System.out.println("Before going to jdbc in Statement");
		Statement stmt=(Statement) con.createStatement();

		System.out.println("Before going to jdbc in ResultSet");
		System.out.println(" MAil id :"+ mailid);
		ResultSet rs=stmt.executeQuery("select * from user where email = '"+mailid+".com"+"' and confirmed='" +verification+ "'");  
		int number = 0 ;
		while(rs.next())
		{
		number = rs.getInt(1);
		}
		
			
			System.out.println("valu of result settt : "+ number);
		if( number != 0)
		{
			int sql = stmt.executeUpdate("UPDATE stock_exchange_db.user SET usertype = 'CU' WHERE id = '"+number+"'");  
			con.close();            
			if(sql > 0)
		                    {
			                   return "valid";
		                     }
		                 else
			                {
			                   return "invalid";
			                }
		}
		else
		{
			con.close();
			return "invalid";
		}
			
		}
			
		catch(Exception e){ System.out.println(e);
		
		return "Error";}
	}  
	
	

}
