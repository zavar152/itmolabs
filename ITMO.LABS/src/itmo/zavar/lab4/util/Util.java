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
    		porch.setItem(0, new Gingerbread(Size.values()[size], "ginger0", (int)((Math.random()*5) + 1)));
    		porch.setItem(1, new Gingerbread(Size.values()[size], "ginger1", (int)((Math.random()*5) + 1)));
    		porch.setItem(2, new Gingerbread(Size.values()[size], "ginger2", (int)((Math.random()*5) + 1)));
    	}
    	
    	public static void fillJuice(House.Porch porch)
    	{
    		int color = (int)(Math.random()*9);
    		porch.setItem(3, new Juice((int)((Math.random()*9) + 1), Color.values()[color], "juice3"));
    		porch.setItem(4, new Juice((int)((Math.random()*9) + 1), Color.values()[color], "juice4"));
    		porch.setItem(5, new Juice((int)((Math.random()*9) + 1), Color.values()[color], "juice5"));
    	}
    }
    
    public static void delay(long time)
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
}
