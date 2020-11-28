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
		return (getSize().ordinal() + 1) + (getShuttersColor().ordinal() + 1);
	}
	
	@Override
	public String toString() 
	{
		return "House." + hashCode() + "." + getSize() + ".t" + String.valueOf(getTemp()).replace('.', ',') + ".sc" + getShuttersColor() + "." + getPorch().toString();
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if((obj.hashCode() == hashCode()) && (obj instanceof House))
		{
			House house = (House) obj;
			if((house.getPorch().equals(getPorch())) && (house.getShuttersColor() == getShuttersColor()) && (house.getSize() == getSize() && (house.getTemp() == getTemp())))
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
