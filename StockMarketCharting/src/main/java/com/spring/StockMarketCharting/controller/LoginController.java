package com.spring.StockMarketCharting.controller;

import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.StockMarketCharting.model.User;
import com.spring.StockMarketCharting.service.LoginService;

public class LoginController {
    
	/*@Autowired
    private AdminService adminService;
	*/
	@Autowired
    private LoginService loginService;
	

	
	@RequestMapping(value = "/signup")
	 public String redirect()
	 {
		 return "SignUpPage";
	 }
	
	@RequestMapping(value = "/forgot")
	 public String redirect1()
	 {
		 return "ForgotPassword";
	 }
	
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
    public ModelAndView validateUsr(HttpServletRequest request,HttpServletResponse response,@RequestParam("username")String username, @RequestParam("password")String password,RedirectAttributes redirectAttributes, HttpSession session) throws ClassNotFoundException, SQLException 
    {
		System.out.println("Username :" + username);
		System.out.println("Password :" + password);
		User userdata = new User();
		userdata= loginService.validateInDatabase(username,password);
		 ModelAndView mv = new ModelAndView();
		 System.out.println("After Checking");
		 System.out.println("usertype : "+userdata.getUsertype());
		if(userdata.getUsertype().equals("IU"))
		 {
			 mv.setViewName("LoginPage");
			 System.out.println("Inavalid Credentials");
		 }
		else  if(userdata.getUsertype().equals("Error"))
		 {
			
			 System.out.println("Error page");
			 mv.setViewName("LoginPage");
		 }
		 else  if(userdata.getUsertype().equals("A"))
		 {
			 System.out.println("Admin Landing page");
			 mv.setViewName("LoginPage");
		 }
		 else if(userdata.getUsertype().equals("CU"))
		 {
			 System.out.println("User Landing page");
			 mv.setViewName("LoginPage");
		 }
		 else if(userdata.getUsertype().equals("UU"))
		 {
			 System.out.println("Unconfirmed user Landing page");
			 mv.setViewName("ConfirmationPage");
			 mv.addObject("username",username);
			 mv.addObject("mail",username);
		 }
		 
         return mv;
		
    }
	public static String send(String from,String password,String to,String sub,String msg){  
	    //Get properties object    
	    Properties props = new Properties();    
	      
	    props.put("mail.smtp.host", "smtp.gmail.com");    
	    props.put("mail.smtp.socketFactory.port", "465");    
	    props.put("mail.smtp.socketFactory.class",    
	              "javax.net.ssl.SSLSocketFactory");    
	    props.put("mail.smtp.auth", "true");    
	    props.put("mail.smtp.port", "465"); 
	    Session session = Session.getDefaultInstance(props,   
	     new javax.mail.Authenticator() {    
	     protected PasswordAuthentication getPasswordAuthentication() {    
	     return new PasswordAuthentication(from,password);  
	     }    
	    });    
	    //compose message    
	    try {    
	     MimeMessage message = new MimeMessage(session);    
	     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
	     message.setSubject(sub);    
	     message.setText(msg);    
	     //send message  
	     Transport.send(message);    
	     System.out.println("message sent successfully"); 
	     return "Success";
	    } catch (MessagingException e) {throw new RuntimeException(e);
	    
	    } 
	}
	@RequestMapping(value = "/registeruser", method = RequestMethod.POST)
    public ModelAndView SignUpUser(HttpServletRequest request,HttpServletResponse response,@RequestParam("Username")String username, @RequestParam("Password")String password,@RequestParam("E_Mail")String mail,@RequestParam("Contact")String contact,RedirectAttributes redirectAttributes, HttpSession session) throws ClassNotFoundException, SQLException 
    {
		@SuppressWarnings("unused")
		User userdata = new User();
		String IsInserted;
		IsInserted= loginService.registerInDatabase(username,password,mail,contact);
		ModelAndView mv = new ModelAndView();
		if(IsInserted.equals("yes")) {
			
			//mm.sendMail("shashidharreddy082@gmail.com","shashidharreddy994@gmail.com","Testing123", "Testing only \n\n Hello Spring Email Sender");
			int randomPin   =(int)(Math.random()*9000)+1000;
			String otp  =String.valueOf(randomPin);
			System.out.println("OTP : "+otp);
		    System.out.println("Verification Code : "+otp);
		    String message = " Verification Code is : "+otp+"\n Happy Exploring!!";
		    LoginController.send("shashidharreddy082@gmail.com","Bharath@123",mail,"Verification code for Stock Exchange",message);
		    String userId = loginService.getUserId(username,mail);
		    System.out.println("User Id ::"+userId);
		    String updateOtp = loginService.updateInDatabase(username,mail,userId,otp);
		    if(updateOtp.contentEquals("yes"))
		    {
		    	 mv.setViewName("ConfirmationPage");
				 mv.addObject("username",username);
				 mv.addObject("mail",mail);
		    }
		    else
		    {
		    	System.out.println("Error while sending Verification code");
				mv.setViewName("SignUpPage"); 
		    }
			
		}
		else
		{
			System.out.println("Error while inserting Try after sometime");
			mv.setViewName("SignUpPage"); 
		}
		
		 
         return mv;
    }
}
