package itmo.zavar.lab3.world.sky;

import itmo.zavar.lab3.util.Color;
import itmo.zavar.lab3.util.Size;

public class Star 
{
	private Size size;
	private Color color;
	private int id;
	private String custom_name = "";

	public Star(int id, Size size, Color color) 
	{
		this.size = size;
		this.color  = color;
		this.id = id;
	}
	
	public final Size getSize() 
	{
		return size;
	}
	
	public final Color getColor() 
	{
		return color;
	}
	
	public final String getName()
	{
		if(!custom_name.isEmpty())
		{
			return custom_name;
		}
		else
		{
			return "Star" + hashCode();
		}
	}
	
	public final Star setCustomName(String name)
	{
		custom_name = name;
		return this;
	}
	
	@Override
	public final int hashCode() 
	{
		return id;
	}
	
	@Override
	public String toString() 
	{
		return getName() + "." + getSize() + "." + getColor();
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if(obj instanceof Star)
		{
			Star star = (Star) obj;
			if((star.getColor() == getColor()) && (star.getSize() == getSize()))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
}
