package com.mikadosolutions.training.springmvc.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

public class BaseDAO 
{
	protected SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}

	@Resource(name="hibernate4SessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}	
}