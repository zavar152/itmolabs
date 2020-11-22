package itmo.zavar.lab3.item;

public abstract class Item 
{
	private int count;
	
	public void setCount(int count)
	{
		if(isCountable())
		{
			this.count = count;
		}
	}
	
	public int getCount()
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
		return "Item" + String.valueOf(hashCode());
	}
	
	public boolean isCountable()
	{
		return true;
	}
}
