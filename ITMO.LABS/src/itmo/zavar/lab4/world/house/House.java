package itmo.zavar.lab4.world.house;

import java.util.ArrayList;

import itmo.zavar.lab4.entity.EntityLiving;
import itmo.zavar.lab4.entity.EntityStatus;
import itmo.zavar.lab4.exception.ContainerCreateException;
import itmo.zavar.lab4.exception.HouseTempException;
import itmo.zavar.lab4.item.Container;
import itmo.zavar.lab4.item.Item;
import itmo.zavar.lab4.util.Color;
import itmo.zavar.lab4.util.Size;

public final class House 
{
	private Size size;
	private int temp;
	private Porch porch;
	private Color shuttersColor;

	public House(Size size, int temp, Size porchSize, int cont, Color color) throws HouseTempException 
	{
		if(temp < 15 || temp > 25)
		{
			throw new HouseTempException(temp);
		}
		this.size = size;
		this.temp = temp;
		this.porch = new Porch(porchSize, cont);
		shuttersColor = color;
	}
	
	public Porch getPorch() 
	{
		return porch;
	}
	
	public Size getSize() 
	{
		return size;
	}
	
	public int getTemp() 
	{
		return temp;
	}
	
	public Color getShuttersColor() 
	{
		return shuttersColor;
	}
	
	public void setTemp(int temp) throws HouseTempException 
	{
		if(temp < 15 || temp > 25)
		{
			throw new HouseTempException(temp);
		}
		this.temp = temp;
	}
	
	@Override
	public int hashCode() 
	{
		final int seed = 30;
		int hash = 1;
		hash = seed * hash + porch.hashCode();
		hash = seed * hash + shuttersColor.hashCode();
		hash = seed * hash + size.hashCode();
		hash = seed * hash + temp;
		return hash;
	}
	
	@Override
	public String toString() 
	{
		return "House." + hashCode() + "." + getSize() + ".t" + String.valueOf(getTemp()).replace('.', ',') + ".sc" + getShuttersColor() + "." + getPorch().toString();
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if(obj instanceof House)
		{
			House house = (House) obj;
			if((house.porch.equals(porch)) && (house.shuttersColor == shuttersColor) && (house.size == size) && (house.temp == temp))
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
	
	public class Porch implements Container
	{
		private Size size;
		private EntityLiving entity;
		private ArrayList<Item> inventory = new ArrayList<Item>();
		
		public Porch(Size size, int cont) 
		{
			if(cont < 0)
			{
				throw new ContainerCreateException(cont);
			}
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
			if(entity.isAlive())
			{
				this.entity = entity;
				entity.setStatus(EntityStatus.SITTING);
			}
		}
		
		public void leave()
		{
			if(entity != null)
			{
				entity.setStatus(EntityStatus.DEFAULT);
				entity = null;
			}
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
			return (getSize().ordinal() + 1) * contSize();
		}
		
		@Override
		public String toString() 
		{
			return "Porch." + hashCode() + ".s" + getSize() + "." + inventory.toString();
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
}
