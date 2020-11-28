package itmo.zavar.lab4.world.sky;

import java.util.Arrays;

public class Sky 
{
	private Star[] stars;

	public Sky(Star ... stars) 
	{
		this.stars = stars;
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
		return getStarCount() + getStar(0).hashCode();
	}
	
	@Override
	public String toString() 
	{
		return "Sky" + "." + hashCode() + ":" + Arrays.toString(stars);
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if((obj.hashCode() == hashCode()) && (obj instanceof Sky))
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
