package itmo.zavar.lab3;

import java.util.ArrayList;

import itmo.zavar.lab3.item.Eatable;
import itmo.zavar.lab3.item.Item;
import itmo.zavar.lab3.util.Color;
import itmo.zavar.lab3.util.Size;
import itmo.zavar.lab3.world.sky.MainStar;
import itmo.zavar.lab3.world.sky.Sky;
import itmo.zavar.lab3.world.sky.Star;

public class Test {

	public static void main(String[] args) 
	{
		Sky sky = new Sky(1, new Star(0, Size.BIG, Color.YELLOW), new Star(1, Size.BIG, Color.GREEN));
				
		System.out.println(sky.toString());
		
		MainStar sun1 = new MainStar(4, Size.LARGE, Color.GREEN, 0);
		
		MainStar sun2 = new MainStar(4, Size.LARGE, Color.GREEN, 1);
		
		System.out.println(sun1.equals(sun2));
		
		Eatable food = new Gingerbread(76, Size.SMALL);
		
		Gingerbread gin = (Gingerbread) food;
		
		System.out.println(gin.getCount());
		
		ArrayList<Item> inventory = new ArrayList<Item>();
		
		inventory.add(new Gingerbread(5, Size.SMALL).setCustomName("s1"));
		inventory.add(new Gingerbread(1, Size.SMALL).setCustomName("s2"));
		inventory.add(new Gingerbread(2, Size.SMALL).setCustomName("s3"));
		inventory.add(new Gingerbread(6, Size.SMALL).setCustomName("s4"));
		inventory.add(new Gingerbread(4, Size.SMALL).setCustomName("s5"));
		inventory.add(new Juice(5, Color.YELLOW));
		
		System.out.println(inventory.get(0).equals(new Gingerbread(5, Size.SMALL)));
		
		for(int i = inventory.size()-1; i > -1; i--)
		{
			if(inventory.get(i) instanceof Eatable)
			{
				Gingerbread ginger = (Gingerbread) inventory.get(i);
				while(!ginger.isEaten())
				{
					//System.out.println(ginger.getCount());
					System.out.println(ginger.getName());
					ginger.takeBite();
				}
				inventory.remove(i);
				System.out.println();
			}
		}
	}

}
