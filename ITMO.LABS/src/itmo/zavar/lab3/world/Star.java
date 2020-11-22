package itmo.zavar.lab3.world;

import itmo.zavar.lab3.util.Color;
import itmo.zavar.lab3.util.Size;

public class Star 
{
	private Size size;
	private Color color;

	public Star(Size size, Color color) 
	{
		this.size = size;
		this.color  = color;
	}
	
	public Size getSize() 
	{
		return size;
	}
	
	public Color getColor() 
	{
		return color;
	}
}
