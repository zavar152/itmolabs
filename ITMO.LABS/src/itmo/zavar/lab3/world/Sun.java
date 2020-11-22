package itmo.zavar.lab3.world;

import itmo.zavar.lab3.util.Color;
import itmo.zavar.lab3.util.Size;

public class Sun extends Star
{
	private int pos;

	public Sun(int pos) 
	{
		super(Size.LARGE, Color.YELLOW);
		this.pos = pos;
	}

	public final void setPosition(int pos) 
	{
		this.pos = pos;
	}
	
	public final int getPosition() 
	{
		return pos;
	}
	
	@Override
	public String toString() 
	{
		return "Sun at " + getPosition() + " position";
	}
	
	@Override
	public int hashCode() 
	{
		return 0;
	}
}
