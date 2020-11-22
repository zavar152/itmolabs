package itmo.zavar.lab3.world.house;

import itmo.zavar.lab3.util.Color;
import itmo.zavar.lab3.util.Size;

public class House 
{
	private Size size;
	private float temp;
	private Porch porch;
	private Color shuttersColor;

	public House(Size size, float temp, Porch porch, Color color) 
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
	
	public float getTemp() 
	{
		return temp;
	}
	
	public Color getShuttersColor() 
	{
		return shuttersColor;
	}
	
	public void setTemp(float temp) 
	{
		this.temp = temp;
	}
}
