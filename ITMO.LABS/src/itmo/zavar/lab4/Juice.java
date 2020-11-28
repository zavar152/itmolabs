package itmo.zavar.lab4;

import itmo.zavar.lab4.item.Drinkable;
import itmo.zavar.lab4.item.Item;
import itmo.zavar.lab4.util.Color;

public final class Juice extends Item implements Drinkable
{
	private boolean empty = false;
	private int volume;
	private Color color;
	
	public Juice(int volume, Color color, String name) 
	{
		super(name);
		this.volume = volume;
		this.color = color;
	}
	
	public Color getColor() 
	{
		return color;
	}
	
	@Override
	public int hashCode() 
	{
		return (getColor().ordinal() + 1) + super.hashCode();
	}
	
	@Override
	public boolean isCountable() 
	{
		return false;
	}
	
	@Override
	public boolean isEmpty() 
	{
		return empty;
	}

	@Override
	public void takeSip() 
	{
		if(!empty)
		{
			volume--;
		}
		if(volume == 0)
		{
			empty = true;
		}
	}

	@Override
	public int getVolume() 
	{
		return volume;
	}
	
	@Override
	public String toString() 
	{
		return "Juice.vol" + getVolume() + "." + getColor();
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if((obj.hashCode() == hashCode()) && (obj instanceof Juice))
		{
			Juice juice = (Juice) obj;
			if((juice.getVolume() == getVolume()) && (juice.getColor() == getColor()))
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
