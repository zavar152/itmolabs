package itmo.zavar.lab3.world.sky;

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
	public int hashCode() 
	{
		final int seed = 30;
		int hash = 1;
		hash = seed * hash + Arrays.hashCode(stars);
		return hash;
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
			if(Arrays.equals(sky.stars, stars))
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
