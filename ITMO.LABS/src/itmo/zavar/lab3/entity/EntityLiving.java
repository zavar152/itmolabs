package itmo.zavar.lab3.entity;

import itmo.zavar.lab3.item.Drinkable;
import itmo.zavar.lab3.item.Eatable;

public abstract class EntityLiving 
{
	private String name;
	private EntityStatus status = EntityStatus.DEFAULT;
	private int maxHunger = -1;
	private int hunger = -1;
	
	public abstract void drink(Drinkable drink);

	public abstract void eat(Eatable eat);
	
	public abstract void sleep(int time);
	
	public abstract void awake();
	
	public String getName()
	{
		return name;
	}
	
	public final EntityStatus getStatus() 
	{
		return status;
	}
	
	public final void setStatus(EntityStatus status) 
	{
		this.status = status;
	}
	
	public final int getHunger() 
	{
		return hunger;
	}
	
	public final int getMaxHunger() 
	{
		return maxHunger;
	}
	
	public final void setHunger(int hunger) 
	{
		this.hunger = hunger;
	}
	
	public final void setMaxHunger(int maxHunger) 
	{
		this.maxHunger = maxHunger;
	}
}
