package itmo.zavar.lab3.item;

public abstract class Item 
{
	private int count;
	private String custom_name = "";
	private int id;
	
	public Item(int id) 
	{
		this.id = id;
	}
	
	public final Item setCount(int count)
	{
		if(isCountable())
		{
			this.count = count;
		}
		return this;
	}
	
	public final int getCount()
	{
		if(isCountable())
		{
			return count;
		}
		else
		{
			return 1;
		}
	}
	
	public final String getName()
	{
		if(!custom_name.isEmpty())
		{
			return custom_name;
		}
		else
		{
			return "Item" + hashCode();
		}
	}
	
	public final Item setCustomName(String name)
	{
		custom_name = name;
		return this;
	}
	
	public boolean isCountable()
	{
		return true;
	}
	
	@Override
	public final int hashCode() 
	{
		return id;
	}
	
	@Override
	public String toString() 
	{
		return getName() + ".c" + getCount();
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if((obj.hashCode() == hashCode()) && (obj instanceof Item))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
