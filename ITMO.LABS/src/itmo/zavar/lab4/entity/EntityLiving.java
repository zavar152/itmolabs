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
		else if(hunger == getMaxHunger())
		{
			this.hunger = getMaxHunger();
		}
		if(hunger < 0)
		{
			kill();
		}
		return this;
	}
	
	public final boolean isAlive()
	{
		return status != EntityStatus.DEAD;
	}
	
	public final void kill()
	{
		status = EntityStatus.DEAD;
		hunger = -1;
	}
	
	@Override
	public String toString() 
	{
		return getName() + "." + getStatus();
	}
	
	@Override
	public int hashCode() 
	{
		final int seed = 30;
		int hash = 1;
		hash = seed * hash + ((!custom_name.isEmpty()) ? 0 : custom_name.hashCode());
		hash = seed * hash + hunger;
		hash = seed * hash + maxHunger;
		hash = seed * hash + status.hashCode();
		return hash;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if(obj instanceof EntityLiving)
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
