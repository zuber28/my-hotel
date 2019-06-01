package com.mikadosolutions.training.springmvc.bean;

public class Room {

	private int roomNumber;
	private RoomType roomType;
	String roomStatus;
	
	public Room()
	{
		
	}
	
	public Room(final int roomNumber, final RoomType roomType, final String roomStatus)
	{
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.roomStatus = roomStatus;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	
	public boolean equals(Object o)
	{
		if (o instanceof Room)
		{
			return ((Room)o).getRoomNumber() == roomNumber;
		}
		else
		{
			return false;
		}
	}
	
	public String toString()
	{
		return "roomNumber = " + roomNumber + " roomType = " + roomType;
	}
}
