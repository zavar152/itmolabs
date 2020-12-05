package itmo.zavar.lab3.world.house;

import itmo.zavar.lab3.util.Color;
import itmo.zavar.lab3.util.Size;

public final class House 
{
	private Size size;
	private int temp;
	private Porch porch;
	private Color shuttersColor;

	public House(Size size, int temp, Porch porch, Color color) 
	{
		this.size = size;
		this.temp = temp;
		this.porch = porch;
		shuttersColor = color;
	}
	
	public Porch getPorch() 
	{
		return porch;
	}
	
	public Size getSize() 
	{
		return size;
	}
	
	public int getTemp() 
	{
		return temp;
	}
	
	public Color getShuttersColor() 
	{
		return shuttersColor;
	}
	
	public void setTemp(int temp) 
	{
		this.temp = temp;
	}
	
	@Override
	public int hashCode() 
	{
		final int seed = 30;
		int hash = 1;
		hash = seed * hash + porch.hashCode();
		hash = seed * hash + shuttersColor.hashCode();
		hash = seed * hash + size.hashCode();
		hash = seed * hash + temp;
		return hash;
	}
	
	@Override
	public String toString() 
	{
		return "House." + hashCode() + "." + getSize() + ".t" + String.valueOf(getTemp()).replace('.', ',') + ".sc" + getShuttersColor() + "." + getPorch().toString();
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if(obj instanceof House)
		{
			House house = (House) obj;
			if((house.porch.equals(porch)) && (house.shuttersColor == shuttersColor) && (house.size == size) && (house.temp == temp))
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
