package itmo.zavar.lab4.item;

public abstract class Item 
{
	private String custom_name = null;
	
	public Item(String name)
	{
		custom_name = name;
	}
	
	public final String getName()
	{
		if(custom_name.isEmpty() || custom_name == null)
		{
			return "Item." + hashCode();
		}
		else
		{
			return custom_name;
		}
	}
	
	@Override
	public String toString() 
	{
		return getName();
	}
	
	@Override
	public int hashCode() 
	{
		final int seed = 30;
		int hash = 1;
		hash = seed * hash + ((custom_name == null) ? 0 : custom_name.hashCode());
		return hash;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if(obj instanceof Item)
		{
			Item item = (Item) obj;
			if(item.custom_name.equals(custom_name))
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
