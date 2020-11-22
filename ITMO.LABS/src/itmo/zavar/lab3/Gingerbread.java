package itmo.zavar.lab3;

import itmo.zavar.lab3.item.Eatable;
import itmo.zavar.lab3.item.Item;

public class Gingerbread extends Item implements Eatable
{
	private boolean eaten = false;

	public Gingerbread(int c) 
	{
		setCount(c);
	}
	
	@Override
	public final boolean isEaten() 
	{
		return eaten;
	}

	@Override
	public final void takeBite() 
	{
		if(getCount() != 0)
		{
			setCount(getCount()-1);
		}
		else
		{
			eaten = true;
		}
	}
	
	@Override
	public final int hashCode() 
	{
		return 1;
	}
	
	@Override
	public final String toString() 
	{
		return "Count of Gingerbreads: " + getCount();
	}
	
	@Override
	public final boolean equals(Object obj) 
	{
		Gingerbread ginger = (Gingerbread) obj;
		if(ginger.getCount() == getCount())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
