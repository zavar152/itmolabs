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
    		porch.setItem(0, new Gingerbread(Size.values()[(int)(Math.random()*5)], "ginger0", (int)((Math.random()*5) + 1), 0));
    		porch.setItem(1, new Gingerbread(Size.values()[(int)(Math.random()*5)], "ginger1", (int)((Math.random()*5) + 1), 0));
    		porch.setItem(2, new Gingerbread(Size.values()[(int)(Math.random()*5)], "ginger2", (int)((Math.random()*5) + 1), 0));
    	}
    	
    	public static void fillJuice(House.Porch porch)
    	{
    		porch.setItem(3, new Juice((int)((Math.random()*9) + 1), Color.values()[(int)(Math.random()*9)], "juice3", 0));
    		porch.setItem(4, new Juice((int)((Math.random()*9) + 1), Color.values()[(int)(Math.random()*9)], "juice4", 0));
    		porch.setItem(5, new Juice((int)((Math.random()*9) + 1), Color.values()[(int)(Math.random()*9)], "juice5", 0));
    	}
    }
    
    public static void delay(long time)
	{
		try 
		{
			Thread.sleep(time/100);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
    
    public static void systemMessage(String m)
    {
    	System.out.println("System: " + m);
    }
}
