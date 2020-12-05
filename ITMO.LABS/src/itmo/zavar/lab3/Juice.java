package itmo.zavar.lab3;

import itmo.zavar.lab3.item.Drinkable;
import itmo.zavar.lab3.item.Item;
import itmo.zavar.lab3.util.Color;

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
		final int seed = 30;
		int hash = 1;
		hash = seed * hash + color.hashCode();
		hash = seed * hash + (empty ? 6020 : 1370);
		hash = seed * hash + volume;
		hash = seed * hash + super.hashCode();
		return hash;
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
		if(obj instanceof Juice)
		{
			Juice juice = (Juice) obj;
			if(super.equals(juice) && (juice.volume == volume) && (juice.color == color))
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
