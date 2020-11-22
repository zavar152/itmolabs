package itmo.zavar.lab3.world.house;

import java.util.ArrayList;

import itmo.zavar.lab3.entity.EntityLiving;
import itmo.zavar.lab3.entity.EntityStatus;
import itmo.zavar.lab3.item.Container;
import itmo.zavar.lab3.item.Item;
import itmo.zavar.lab3.util.Size;

public class Porch implements Container
{
	private Size size;
	private EntityLiving entity;
	private ArrayList<Item> inventory = new ArrayList<Item>();

	public Porch(Size size) 
	{
		this.size = size;
	}

	public final Size getSize() 
	{
		return size;
	}
	
	public final void join(EntityLiving entity)  
	{
		this.entity = entity;
		this.entity.setStatus(EntityStatus.SITTING);
	}
	
	public final void leave()
	{
		this.entity.setStatus(EntityStatus.DEFAULT);
		this.entity = null;
	}
	
	@Override
	public final void addItem(Item item) 
	{
		inventory.add(item);
	}

	@Override
	public final Item getItem(int index) 
	{
		return inventory.get(index);
	}

	@Override
	public final int contSize() 
	{
		return inventory.size();
	}
	
	public final boolean isEmpty() 
	{
		return inventory.isEmpty();
	}
}
