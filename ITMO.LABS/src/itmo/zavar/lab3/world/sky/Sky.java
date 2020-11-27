package itmo.zavar.lab3.world.sky;

import java.util.Arrays;

public class Sky 
{
	private Star[] stars;
	private int id;

	public Sky(int id, Star ... stars) 
	{
		this.stars = stars;
		this.id = id;
	}
	
	public final Star getStar(int i)
	{
		return stars[i];
	}
	
	public final int getStarCount()
	{
		return stars.length;
	}
	
	@Override
	public final int hashCode() 
	{
		return id;
	}
	
	@Override
	public String toString() 
	{
		return "Sky" + "." + hashCode() + ":" + Arrays.toString(stars);
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if(obj instanceof Sky)
		{
			Sky sky = (Sky) obj;
			Star[] stars1 = new Star[sky.getStarCount()];
			Star[] stars2 = new Star[getStarCount()];
			
			for(int i = 0; i < stars1.length; i++)
			{
				stars1[i] = sky.getStar(i);
			}
			for(int i = 0; i < stars2.length; i++)
			{
				stars2[i] = getStar(i);
			}
			
			return Arrays.equals(stars1, stars2);
		}
		else
		{
			return false;
		}
	}
}
