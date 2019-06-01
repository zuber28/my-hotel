package com.mikadosolutions.training.springmvc.bean;

public class RoomType 
{
	private int typeId;
	private String typeName;
	
	public RoomType()
	{
		
	}
	
	public RoomType(String typeName)
	{
		this.typeName = typeName;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}
