package com.spring.StockMarketCharting.service;

import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;

import com.spring.StockMarketCharting.dao.UserDao;
import com.spring.StockMarketCharting.model.User;

 
public class LoginService {

	

public User validateInDatabase(String username, String password) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	System.out.println("Username :" + username);
	System.out.println("Password :" + password);
	System.out.println("Before going to dao in service");
	UserDao userDao = new UserDao();
	User userdata = new User();
	userdata=userDao.validateinDatabase(username,password);
	System.out.println("Before going to dao in service");
	System.out.println("flag in service" + userdata);
	return userdata;
}

public String registerInDatabase(String username, String password, String mail, String contact) {
	// TODO Auto-generated method stub
	UserDao userDao = new UserDao();
	
	String IsInserted;
	IsInserted=userDao.registerInDatabase(username,password,mail,contact);
	System.out.println("Before going to dao in service");
	System.out.println("flag in service" + IsInserted);
	return IsInserted;
}




public String confirmuser(String mailid, String verification) {
	// TODO Auto-generated method stub
	UserDao userDao = new UserDao();
	String verified;
	verified=userDao.verifyInDatabase(mailid,verification);
	return verified;
}

public String updateInDatabase(String username, String mail,String userId, String otp) {
	// TODO Auto-generated method stub
	UserDao userDao = new UserDao();
	String IsInserted;
	IsInserted=userDao.updateInDatabase(username,mail,userId,otp);
	return IsInserted;
}

public String getUserId(String username, String mail) {
	// TODO Auto-generated method stub
	UserDao userDao = new UserDao();
	String userId;
	userId=userDao.getUserIdDatabase(username,mail);
	return userId;
}
}
