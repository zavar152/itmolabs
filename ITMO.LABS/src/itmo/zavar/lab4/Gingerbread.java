package itmo.zavar.lab4;

import itmo.zavar.lab4.item.Eatable;
import itmo.zavar.lab4.item.Item;
import itmo.zavar.lab4.util.Size;

public final class Gingerbread extends Item implements Eatable
{
	private boolean eaten = false;
	private Size size;
	private int bites;
	private int saturation;

	public Gingerbread(Size size, String name, int bites, int saturation) 
	{
		super(name);
		this.size = size;
		this.bites = bites;
		if(bites <= 0)
		{
			eaten = true;
		}
		if(saturation == 0)
		{
			this.saturation = size.ordinal() + 1;
		}
	}
	
	@Override
	public int getSaturation() 
	{
		return saturation;
	}
	
	@Override
	public int getBites()
	{
		return bites;
	}
	
	public Size getSize() 
	{
		return size;
	}
	
	@Override
	public int hashCode() 
	{
		final int seed = 30;
		int hash = 1;
		hash = seed * hash + bites;
		hash = seed * hash + (eaten ? 6020 : 1370);
		hash = seed * hash + size.hashCode();
		hash = seed * hash + super.hashCode();
		return hash;
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
			bites--;
		}
		if(bites == 0)
		{
			eaten = true;
		}
	}
	
	@Override
	public String toString() 
	{
		return "Gingerbread." + getSize() + ".sat" + saturation;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if(obj instanceof Gingerbread)
		{
			Gingerbread ginger = (Gingerbread) obj;
			if(super.equals(ginger) && (ginger.size == size) && (ginger.bites == bites))
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
