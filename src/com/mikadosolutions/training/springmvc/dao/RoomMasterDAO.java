package com.mikadosolutions.training.springmvc.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.mikadosolutions.training.springmvc.bean.Room;

@Repository
public class RoomMasterDAO extends BaseDAO
{	
	public Collection<Room> getAvailableRooms()
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Room> rooms = null;
		try
		{
			tx = session.beginTransaction();
			rooms = session.createQuery("FROM Room R where R.roomStatus = 'A' ").list();
			rooms.toString();
			tx.commit();
		}
		catch (HibernateException e)
		{
			if (tx != null)
			{
				tx.rollback();
			}
			System.out.println(tx);
		}
		finally
		{
			session.close();
		}
		return rooms;
	}
	
	public Collection<Room> getOccupiedRooms()
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Room> rooms = null;
		try
		{
			tx = session.beginTransaction();
			rooms = session.createQuery("FROM Room R where R.roomStatus = 'O' ").list();
			rooms.toString();
			tx.commit();
		}
		catch (HibernateException e)
		{
			if (tx != null)
			{
				tx.rollback();
			}
			System.out.println(tx);
		}
		finally
		{
			session.close();
		}
		return rooms;
	}
	
	public void allocateRoom(Room room)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			Room actualRoom = (Room) session.get(Room.class, room.getRoomNumber());
			actualRoom.setRoomStatus("O");
			session.update(actualRoom);
			tx.commit();
		}
		catch (HibernateException e)
		{
			if (tx != null)
			{
				tx.rollback();
			}
			System.out.println(tx);
		}
		finally
		{
			session.close();
		}
	}
	
	public void deallocateRoom(Room room)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			Room actualRoom = (Room) session.get(Room.class, room.getRoomNumber());
			actualRoom.setRoomStatus("A");
			session.update(actualRoom);
			tx.commit();
		}
		catch (HibernateException e)
		{
			if (tx != null)
			{
				tx.rollback();
			}
			System.out.println(tx);
		}
		finally
		{
			session.close();
		}
	}
}