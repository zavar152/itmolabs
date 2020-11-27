package itmo.zavar.lab3.world.sky;

import itmo.zavar.lab3.util.Color;
import itmo.zavar.lab3.util.Size;

public final class MainStar extends Star
{
	private int pos;

	public MainStar(int id, Size size, Color color, int pos) 
	{
		super(id, size, color);
		this.pos = pos;
	}

	public void setPosition(int pos) 
	{
		this.pos = pos;
	}
	
	public int getPosition() 
	{
		return pos;
	}
	
	@Override
	public String toString() 
	{
		return "MainStar.pos" + getPosition() + "." + getName() + "." + getSize() + "." + getColor();
	}

	@Override
	public boolean equals(Object obj) 
	{
		if(obj instanceof MainStar)
		{
			MainStar sun = (MainStar) obj;
			if((sun.getPosition() == getPosition()) && super.equals(obj))
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
