package itmo.zavar.lab3;

import itmo.zavar.lab3.item.Eatable;
import itmo.zavar.lab3.item.Item;
import itmo.zavar.lab3.util.Size;

public final class Gingerbread extends Item implements Eatable
{
	private boolean eaten = false;
	private Size size;

	public Gingerbread(int c, Size size) 
	{
		super(1);
		setCount(c);
		this.size = size;
	}
	
	public Size getSize() 
	{
		return size;
	}
	
	@Override
	public boolean isEaten() 
	{
		return eaten;
	}

	@Override
	public void takeBite() 
	{
		if(!eaten)
		{
			setCount(getCount()-1);
		}
		if(getCount() == 0)
		{
			eaten = true;
		}
	}
	
	@Override
	public String toString() 
	{
		return "Gingerbread.c" + getCount() + "." + getSize();
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if(obj instanceof Gingerbread)
		{
			Gingerbread ginger = (Gingerbread) obj;
			if((ginger.getCount() == getCount()) && (ginger.getSize() == getSize()))
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
