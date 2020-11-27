package itmo.zavar.lab3.world;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import itmo.zavar.lab3.world.house.House;
import itmo.zavar.lab3.world.sky.MainStar;
import itmo.zavar.lab3.world.sky.Sky;

public class World 
{
	private Sky sky;
	private MainStar sun;
	private List<House> houses = new ArrayList<House>();
	private Time time;
	private int id;

	public World(int id, MainStar sun, Sky sky, House ... houses) 
	{
		this.sun = sun;
		this.sky = sky;
		this.houses = Arrays.asList(houses);
		time = Time.values()[sun.getPosition()];
		this.id = id;
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
	public final int hashCode() 
	{
		return id;
	}
	
	@Override
	public String toString() 
	{
		return "World." + hashCode() + "." + getMainStar().toString() + "." + getSky().toString() + "." + houses.toString();
	}
}
