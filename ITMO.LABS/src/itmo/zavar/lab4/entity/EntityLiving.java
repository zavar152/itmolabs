package itmo.zavar.lab4.entity;

import itmo.zavar.lab4.exception.StatusException;
import itmo.zavar.lab4.item.Drinkable;
import itmo.zavar.lab4.item.Eatable;

public abstract class EntityLiving 
{
	private String custom_name = "";
	private EntityStatus status = EntityStatus.DEFAULT;
	private int maxHunger = -1;
	private int hunger = -1;
	
	public abstract void drink(Drinkable drink) throws StatusException;

	public abstract void eat(Eatable eat) throws StatusException;
	
	public abstract void sleep(int time) throws StatusException;
	
	public abstract void awake() throws StatusException;
	
	public abstract void lookAt(Object obj);
	
	public void say(String m)
	{
		System.out.println(getName() + ": " + m);
	}
	
	public EntityLiving(int maxHunger, String name)
	{
		this.maxHunger = maxHunger;
		hunger = maxHunger;
		custom_name = name;
	}
	
	public final String getName()
	{
		if(!custom_name.isEmpty())
		{
			return custom_name;
		}
		else
		{
			return "Entity" + hashCode();
		}
	}
	
	public final EntityStatus getStatus() 
	{
		return status;
	}
	
	public final EntityLiving setStatus(EntityStatus status) 
	{
		this.status = status;
		return this;
	}
	
	public final int getHunger() 
	{
		return hunger;
	}
	
	public final int getMaxHunger() 
	{
		return maxHunger;
	}
	
	public final EntityLiving setHunger(int hunger) 
	{
		if(hunger <= getMaxHunger())
		{
			this.hunger = hunger;
		}
		else
		{
			this.hunger = getMaxHunger();
		}
		return this;
	}
	
	@Override
	public final int hashCode() 
	{
		return custom_name.length() + maxHunger;
	}
	
	@Override
	public String toString() 
	{
		return getName() + "." + getStatus();
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if((obj.hashCode() == hashCode()) && (obj instanceof EntityLiving))
		{
			EntityLiving entity = (EntityLiving) obj;
			if((entity.getHunger() == getHunger()) && (entity.getMaxHunger() == getMaxHunger()) && (entity.getStatus() == getStatus()))
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
