package itmo.zavar.lab3;

import itmo.zavar.lab3.item.Drinkable;
import itmo.zavar.lab3.item.Item;

public class Juice extends Item implements Drinkable
{
	private boolean empty = false;
	private int volume;
	
	public Juice(int volume) 
	{
		this.volume = volume;
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
	public int hashCode() 
	{
		return 2;
	}

	@Override
	public int getVolume() 
	{
		return volume;
	}
}
