package itmo.zavar.lab4.item;

public abstract class Item 
{
	private int count;
	private String custom_name = "";
	
	public Item(String name)
	{
		custom_name = name;
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
		return custom_name;
	}
	
	public boolean isCountable()
	{
		return true;
	}
	
	@Override
	public int hashCode() 
	{
		return getName().length();
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
