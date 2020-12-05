package itmo.zavar.lab3.world.house;

import java.util.ArrayList;

import itmo.zavar.lab3.entity.EntityLiving;
import itmo.zavar.lab3.entity.EntityStatus;
import itmo.zavar.lab3.item.Container;
import itmo.zavar.lab3.item.Item;
import itmo.zavar.lab3.util.Size;

public final class Porch implements Container
{
	private Size size;
	private EntityLiving entity;
	private ArrayList<Item> inventory = new ArrayList<Item>();
	
	public Porch(Size size, int cont) 
	{
		this.size = size;
		for(int i = 0; i < cont; i++)
		{
			addItem(null);
		}
	}

	public Size getSize() 
	{
		return size;
	}
	
	public void join(EntityLiving entity)  
	{
		this.entity = entity;
		entity.setStatus(EntityStatus.SITTING);
	}
	
	public void leave()
	{
		entity.setStatus(EntityStatus.DEFAULT);
		entity = null;
	}
	
	public boolean isBusy()
	{
		if(entity == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	@Override
	public void setItem(int index, Item item) 
	{
		inventory.set(index, item);
	}
	
	@Override
	public void removeItem(int index) 
	{
		inventory.remove(index);
	}
	
	@Override
	public void addItem(Item item) 
	{
		inventory.add(item);
	}

	@Override
	public Item getItem(int index) 
	{
		return inventory.get(index);
	}

	@Override
	public int contSize() 
	{
		return inventory.size();
	}
	
	public boolean isEmpty() 
	{
		return inventory.isEmpty();
	}
	
	@Override
	public int hashCode() 
	{
		final int seed = 30;
		int hash = 1;
		hash = seed * hash + ((entity == null) ? 0 : entity.hashCode());
		hash = seed * hash + inventory.hashCode();
		hash = seed * hash + size.hashCode();
		return hash;
	}
	
	@Override
	public String toString() 
	{
		return "Porch." + hashCode() + ".s" + getSize();
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if(obj instanceof Porch)
		{
			Porch porch = (Porch) obj;
			if((porch.size == size) && (porch.inventory.size() == inventory.size()) && (porch.isBusy() == isBusy()))
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
