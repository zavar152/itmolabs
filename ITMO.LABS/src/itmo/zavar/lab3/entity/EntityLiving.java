package itmo.zavar.lab3.entity;

import itmo.zavar.lab3.item.Drinkable;
import itmo.zavar.lab3.item.Eatable;

public abstract class EntityLiving 
{
	private String custom_name = "";
	private EntityStatus status = EntityStatus.DEFAULT;
	private int maxHunger = -1;
	private int hunger = -1;
	private int id;
	
	public abstract void drink(Drinkable drink);

	public abstract void eat(Eatable eat);
	
	public abstract void sleep(int time);
	
	public abstract void awake();
	
	public abstract void lookAt(Object obj);
	
	public abstract void say(String m);
	
	public EntityLiving(int id, int maxHunger)
	{
		this.id = id;
		this.maxHunger = maxHunger;
		hunger = maxHunger;
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
	
	public final EntityLiving setCustomName(String name)
	{
		custom_name = name;
		return this;
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
	
	public final EntityLiving setMaxHunger(int maxHunger) 
	{
		this.maxHunger = maxHunger;
		return this;
	}
	
	@Override
	public final int hashCode() 
	{
		return id;
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
