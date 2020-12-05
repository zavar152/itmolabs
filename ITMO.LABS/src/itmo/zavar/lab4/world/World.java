package itmo.zavar.lab4.world;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import itmo.zavar.lab4.world.house.House;
import itmo.zavar.lab4.world.sky.MainStar;
import itmo.zavar.lab4.world.sky.Sky;

public class World 
{
	private Sky sky;
	private MainStar sun;
	private List<House> houses = new ArrayList<House>();
	private Time time;

	public World(MainStar sun, Sky sky, House ... houses) 
	{
		this.sun = sun;
		this.sky = sky;
		this.houses = Arrays.asList(houses);
		time = Time.values()[sun.getPosition()];
	}
	
	public final Time getTime() 
	{
		return time;
	}
	
	public House getHouse(int i) 
	{
		return houses.get(i);
	}
	
	public void addHouse(House house)
	{
		houses.add(house);
	}
	
	public int getHousesCount()
	{
		return houses.size();
	}
	
	public final Sky getSky() 
	{
		return sky;
	}
	
	public final MainStar getMainStar() 
	{
		return sun;
	}
	
	public final void setTime(Time time) 
	{
		this.time = time;
		sun.setPosition(time.ordinal());
	}
	
	@Override
	public int hashCode() 
	{
		final int seed = 30;
		int hash = 1;
		hash = seed * hash + houses.hashCode();
		hash = seed * hash + sky.hashCode();
		hash = seed * hash + sun.hashCode();
		hash = seed * hash + time.hashCode();
		return hash;
	}
	
	@Override
	public String toString() 
	{
		return "World." + hashCode() + "." + getMainStar().toString() + "." + getSky().toString() + "." + houses.toString();
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if(obj instanceof World)
		{
			World world = (World) obj;
			if(world.sun.equals(sun) && world.sky.equals(sky) && world.time == time)
			{
				House[] houses1 = new House[world.getHousesCount()];
				House[] houses2 = new House[getHousesCount()];
				
				for(int i = 0; i < houses1.length; i++)
				{
					houses1[i] = world.getHouse(i);
				}
				for(int i = 0; i < houses2.length; i++)
				{
					houses2[i] = getHouse(i);
				}
				
				return Arrays.equals(houses1, houses2);
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
