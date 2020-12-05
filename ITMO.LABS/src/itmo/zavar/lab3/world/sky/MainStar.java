package itmo.zavar.lab3.world.sky;

import itmo.zavar.lab3.util.Color;
import itmo.zavar.lab3.util.Size;

public final class MainStar extends Star
{
	private int pos;

	public MainStar(Size size, Color color, int pos, String name) 
	{
		super(size, color, name);
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
			if(super.equals(sun) && (sun.pos == pos))
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
