package itmo.zavar.lab4.world.sky;

import itmo.zavar.lab4.util.Color;
import itmo.zavar.lab4.util.Size;

public class Star 
{
	private Size size;
	private Color color;
	private String custom_name = "";

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
		return (getColor().ordinal() + 1) + (getSize().ordinal() + 1);
	}
	
	@Override
	public String toString() 
	{
		return getName() + "." + getSize() + "." + getColor();
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if((obj.hashCode() == hashCode()) && (obj instanceof Star))
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
