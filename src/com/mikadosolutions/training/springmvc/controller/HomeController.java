package com.mikadosolutions.training.springmvc.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.ObjectError;
import org.springframework.validation.FieldError;
import java.util.Enumeration;
import org.springframework.context.ApplicationContext;
import com.mikadosolutions.training.springmvc.bean.User;
import com.mikadosolutions.training.springmvc.bean.Room;
import com.mikadosolutions.training.springmvc.dao.RoomMasterDAO;

@Controller
@RequestMapping("/")
public class HomeController 
{
	@RequestMapping("/")
	public String welcome()
	{
		return "welcome";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login()
	{
		User user = new User();
		user.setUsername("sanjay.makhija@mikadosolutions.com");
		user.setPassword("mikado");
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("user", user);
		return mv;
	}
	
	@RequestMapping(value="/authUser", method=RequestMethod.POST)
	public String authenticate(@Valid User user, BindingResult result, HttpSession session)
	{
		if (result.hasErrors())
		{
			return "login";
		}
		else if (user.getUsername().equals("sanjay.makhija@mikadosolutions.com") && user.getPassword().equals("mikado"))
		{
			session.setAttribute("user", user);
			return "userhome";
		}
		else
		{
			if (! user.getUsername().equals("sanjay.makhija@mikadosolutions.com"))
			{
				result.addError(new FieldError("user","username", "Username is incorrect"));
			}
			if (! user.getPassword().equals("mikado"))
			{
				result.addError(new FieldError("user","password", "Password is incorrect"));
			}
			return "login";
		}
	}
	
	@RequestMapping("secure/home")
	public String home()
	{
		return "userhome";
	}
	
	@RequestMapping("/back")
	public String back(HttpSession session)
	{
		User user = (User) session.getAttribute("user");
		if (user == null)
		{
			return "welcome";
		}
		else
		{
			return "userhome";
		}
	}
	
	@RequestMapping("/secure/logout")
	public String logout(HttpSession session)
	{
		session.removeAttribute("user");
		return "welcome";
	}
}