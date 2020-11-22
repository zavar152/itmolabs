package itmo.zavar.lab3.world;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import itmo.zavar.lab3.world.house.House;

public class World 
{
	private Sky sky;
	private Sun sun;
	private List<House> houses = new ArrayList<House>();
	private Time time;

	public World(Sun sun, Sky sky, House ... houses) 
	{
		this.sun = sun;
		this.sky = sky;
		this.houses = Arrays.asList(houses);
		time = Time.MORNING;
	}
	
	public Time getTime() 
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
	
	public Sky getSky() 
	{
		return sky;
	}
	
	public void setTime(Time time) 
	{
		//TODO
	}
	
	@Override
	public String toString() 
	{
		return "World" + hashCode();
	}
}
