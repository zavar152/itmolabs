package itmo.zavar.lab4;

import itmo.zavar.lab4.item.Eatable;
import itmo.zavar.lab4.item.Item;
import itmo.zavar.lab4.util.Size;

public final class Gingerbread extends Item implements Eatable
{
	private boolean eaten = false;
	private Size size;

	public Gingerbread(int c, Size size, String name) 
	{
		super(name);
		setCount(c);
		this.size = size;
	}
	
	public Size getSize() 
	{
		return size;
	}
	
	@Override
	public int hashCode() 
	{
		return (getSize().ordinal() + 1) + super.hashCode();
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
		if((obj.hashCode() == hashCode()) && (obj instanceof Gingerbread))
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
