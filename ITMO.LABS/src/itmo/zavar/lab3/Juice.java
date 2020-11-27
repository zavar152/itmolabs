package itmo.zavar.lab3;

import itmo.zavar.lab3.item.Drinkable;
import itmo.zavar.lab3.item.Item;
import itmo.zavar.lab3.util.Color;

public final class Juice extends Item implements Drinkable
{
	private boolean empty = false;
	private int volume;
	private Color color;
	
	public Juice(int volume, Color color) 
	{
		super(2);
		this.volume = volume;
		this.color = color;
	}
	
	public Color getColor() 
	{
		return color;
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
		if(volume != 0)
		{
			volume--;
		}
		else
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
