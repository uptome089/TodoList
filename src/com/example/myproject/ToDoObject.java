package com.example.myproject;

import java.io.Serializable;
import java.net.URI;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import javax.jdo.annotations.*;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class ToDoObject {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private long id;
	
	@Persistent
	private String title;
	
	@Persistent
	private String desc;
	
	@Persistent
	private String target;
	
	@Persistent
	private String from_date;
	
	@Persistent
	private String to_date;
	
	@Persistent
	private boolean isDone;
	
	public ToDoObject(String title,String desc, String target, String from_date, String to_date, boolean isDone)
	{
		this.title = title;
		this.desc = desc;
		this.target = target;
		this.from_date = from_date;
		this.to_date = to_date;
		this.isDone = isDone;
	}
	
	public long getId()
	{
		return id;
	}
	public void setId(long id)
	{
		this.id = id;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getDesc()
	{
		return desc;
	}
	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	public String getTarget()
	{
		return target;
	}
	public void setTarget(String target)
	{
		this.target = target;
	}
	public String getFromDate()
	{
		return from_date;
	}
	public void setFromDate(String from_date)
	{
		this.from_date = from_date;
	}
	public String getToDate()
	{
		return to_date;
	}
	public void setToDate(String to_date)
	{
		this.to_date = to_date;
	}
	public boolean getIsDone()
	{
		return isDone;
	}
	public void setIsDone(boolean isDone)
	{
		this.isDone = isDone;
	}
}
