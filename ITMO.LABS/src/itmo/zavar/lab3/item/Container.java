package itmo.zavar.lab3.item;

public interface Container 
{
	public void addItem(Item item);
	
	public Item getItem(int index);
	
	public int contSize();
}
