package itmo.zavar.lab4;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import itmo.zavar.lab4.entity.EntityLiving;
import itmo.zavar.lab4.exception.StatusException;
import itmo.zavar.lab4.item.Container;
import itmo.zavar.lab4.item.Drinkable;
import itmo.zavar.lab4.item.Eatable;
import itmo.zavar.lab4.item.Item;

public class Gangster extends EntityLiving
{
	public Gangster(int maxHunger, String name) 
	{
		super(maxHunger, name);
	}

	@Override
	public void drink(Drinkable drink) throws StatusException 
	{
		
	}

	@Override
	public void eat(Eatable eat) throws StatusException
	{
		
	}

	@Override
	public void sleep(int time) throws StatusException 
	{
		
	}

	@Override
	public void awake() throws StatusException 
	{
		
	}

	@Override
	public void lookAt(Object obj) 
	{
		
	}
	
	public void stealItemFrom(Container cont, int index) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		Field f = cont.getClass().getDeclaredField("inventory");
		f.setAccessible(true);
		ArrayList<Item> c = (ArrayList<Item>) f.get(cont);
		c.set(index, null);
	}

	public void poisonItems(Container cont) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException
	{
		Field f = cont.getClass().getDeclaredField("inventory");
		f.setAccessible(true);
		ArrayList<Item> c = (ArrayList<Item>) f.get(cont);
		for(Item item : c)
		{
			Field f2 = item.getClass().getDeclaredField("saturation");
			f2.setAccessible(true);
			f2.set(item, (int) -((int)(Math.random()*10)));
		}
		System.out.println(c.toString());
	}
	
	public void killEntity(EntityLiving entity)
	{
		say("Прощай, " + entity.getName() + "!");
		entity.kill();
	}
}
