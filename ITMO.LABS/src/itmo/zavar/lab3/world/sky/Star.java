package itmo.zavar.lab3.world.sky;

import itmo.zavar.lab3.util.Color;
import itmo.zavar.lab3.util.Size;

public class Star 
{
	private Size size;
	private Color color;
	private String custom_name = null;

	public Star(Size size, Color color, String name) 
	{
		this.size = size;
		this.color  = color;
		custom_name = name;
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
		if(custom_name.isEmpty() || custom_name == null)
		{
			return "Star." + hashCode();
		}
		else
		{
			return custom_name;
		}
	}
	
	@Override
	public final int hashCode() 
	{
		final int seed = 30;
		int hash = 1;
		hash = seed * hash + color.hashCode();
		hash = seed * hash + ((custom_name == null) ? 0 : custom_name.hashCode());
		hash = seed * hash + size.hashCode();
		return hash;
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
			if((star.color == color) && (star.size == size) && (star.custom_name.equals(custom_name)))
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
