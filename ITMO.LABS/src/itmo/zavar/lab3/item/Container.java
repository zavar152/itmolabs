package itmo.zavar.lab3.item;

public interface Container 
{	
	public void setItem(int index, Item item);
	
	public void removeItem(int index);
	
	public void addItem(Item item);
	
	public Item getItem(int index);
	
	public int contSize();
}
