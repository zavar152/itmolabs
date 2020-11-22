package itmo.zavar.lab3;

import java.util.ArrayList;

import itmo.zavar.lab3.item.Item;

public class Test {

	public static void main(String[] args) 
	{
		Juice juice = new Juice(5);
		
		ArrayList<Item> inventory = new ArrayList<Item>();
		
		inventory.add(new Gingerbread(5));
		inventory.add(new Gingerbread(1));
		inventory.add(new Gingerbread(2));
		inventory.add(new Gingerbread(6));
		inventory.add(new Gingerbread(4));
		for(int i = inventory.size()-1; i > -1; i--)
		{
			Gingerbread ginger = (Gingerbread) inventory.get(i);
			while(!ginger.isEaten())
			{
				//System.out.println(ginger.getCount());
				//System.out.println(ginger.getName());
				ginger.takeBite();
			}
			inventory.remove(i);
			System.out.println();
		}
	}

}
