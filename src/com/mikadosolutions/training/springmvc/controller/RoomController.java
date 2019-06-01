package com.mikadosolutions.training.springmvc.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
//import javax.validation.Valid;
//import javax.servlet.http.HttpSession;
//import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.ObjectError;
import org.springframework.validation.FieldError;
import java.util.Enumeration;
import org.springframework.context.ApplicationContext;
//import com.mikadosolutions.training.springmvc.bean.User;
import com.mikadosolutions.training.springmvc.bean.Room;
import com.mikadosolutions.training.springmvc.dao.RoomMasterDAO;

@Controller
@RequestMapping("/")
public class RoomController 
{
	@Autowired
	RoomMasterDAO dao;
	
	@RequestMapping("general/getAvailableRooms")
	public ModelAndView getAvailableRooms()
	{
		Collection<Room> rooms = dao.getAvailableRooms();
		ModelAndView mv = new ModelAndView("roomList");
		mv.addObject("rooms", rooms);
		mv.addObject("status", "A");
		return mv;
	}
	
	@RequestMapping("secure/getOccupiedRooms")
	public ModelAndView getOccupiedRooms()
	{
		Collection<Room> rooms = dao.getOccupiedRooms();
		ModelAndView mv = new ModelAndView("roomList");
		mv.addObject("rooms", rooms);
		mv.addObject("status", "O");
		return mv;
	}
	
	@RequestMapping("secure/allocateRoom")
	public String allocateRoom(Room room)
	{
		dao.allocateRoom(room);
		return "roomAllocated";
	}
	
	@RequestMapping("secure/deAllocateRoom")
	public String deAllocateRoom(Room room)
	{
		dao.deallocateRoom(room);
		return "roomDeallocated";
	}
}