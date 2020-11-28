package itmo.zavar.lab4.util;

import itmo.zavar.lab4.Gingerbread;
import itmo.zavar.lab4.Juice;
import itmo.zavar.lab4.world.house.House;

public class Util 
{
    public static class Filler  
    {
    	public static void fillGinger(House.Porch porch)
    	{
    		int size = (int)(Math.random()*5);
    		porch.setItem(0, new Gingerbread((int)((Math.random()*5) + 1), Size.values()[size], "ginger"));
    	}
    	
    	public static void fillJuice(House.Porch porch)
    	{
    		int color = (int)(Math.random()*9);
    		porch.setItem(1, new Juice((int)((Math.random()*9) + 1), Color.values()[color], "juice"));
    	}
    }
    
    public static void waiting(long time)
	{
		try 
		{
			Thread.sleep(time);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static int random(int min, int max)
	{
		max -= min;
		return (int) (Math.random() * ++max) + min;
	}
}
