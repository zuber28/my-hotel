package com.mikadosolutions.training.springmvc.bean;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User 
{
	@NotEmpty
	@Email
	String username;
	
	@NotEmpty
	String password;
	
	public User()
	{
		
	}
	
	public User(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() 
	{
		return username;
	}
	
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
}
