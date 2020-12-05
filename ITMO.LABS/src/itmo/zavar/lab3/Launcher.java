package itmo.zavar.lab3;

import itmo.zavar.lab3.entity.EntityLiving;
import itmo.zavar.lab3.entity.EntityStatus;
import itmo.zavar.lab3.item.Drinkable;
import itmo.zavar.lab3.item.Eatable;
import itmo.zavar.lab3.util.Color;
import itmo.zavar.lab3.util.Size;
import itmo.zavar.lab3.world.Time;
import itmo.zavar.lab3.world.World;
import itmo.zavar.lab3.world.house.House;
import itmo.zavar.lab3.world.house.Porch;
import itmo.zavar.lab3.world.sky.MainStar;
import itmo.zavar.lab3.world.sky.Sky;
import itmo.zavar.lab3.world.sky.Star;

public class Launcher 
{
	public static void main(String[] args) 
	{
		EntityLiving carlson = new EntityLiving(20, "Карлсон") {
			
			@Override
			public void sleep(int time) 
			{
				if(getStatus() == EntityStatus.DEFAULT || getStatus() == EntityStatus.SITTING)
				{
					say("Я спать!");
					setStatus(EntityStatus.SLEEPING);
					try 
					{
						Thread.sleep(time);
					} 
					catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
				}
				else
				{
					say("И как я усну?");
				}
			}
			
			@Override
			public void eat(Eatable eat) 
			{
				if((getStatus() == EntityStatus.SITTING) && (getHunger() < getMaxHunger()))
				{
					setStatus(EntityStatus.EATING);
					eat.takeBite();
					setHunger(getHunger() + ((Gingerbread) eat).getSize().ordinal() + 1);
					setStatus(EntityStatus.SITTING);
					say("Вкусный был пряник!");
				}
				else
				{
					say("Я не хочу кушать!");
				}
			}
			
			@Override
			public void drink(Drinkable drink) 
			{
				if((getStatus() == EntityStatus.SITTING) && (getHunger() < getMaxHunger()))
				{
					setStatus(EntityStatus.DRINKING);
					drink.takeSip();
					setHunger(getHunger() + 1);
					setStatus(EntityStatus.SITTING);
					say("Вкусный сок!");
				}
				else
				{
					say("Я не хочу пить!");
				}
			}

			@Override
			public void awake()
			{
				if(getStatus() == EntityStatus.SLEEPING)
				{
					setStatus(EntityStatus.AWAKENING);
					try 
					{
						Thread.sleep(500);
					} 
					catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
					setStatus(EntityStatus.DEFAULT);
					say("Я проснулся!");
				}
				else
				{
					say("Я не сплю!");
				}
			}

			@Override
			public void lookAt(Object obj) 
			{
				if(obj instanceof MainStar)
				{
					MainStar sun = (MainStar) obj;
					if(sun.getPosition() == Time.MORNING.ordinal())
					{
						say("Какое красивое " + sun.getName() + "!");
						try 
						{
							Thread.sleep(1000);
						}
						catch (InterruptedException e) 
						{
							e.printStackTrace();
						}
					}
					else
					{
						say("Эх... " + sun.getName() + " уже давно встало...");
					} 
				}
				else if(obj instanceof Sky)
				{
					Sky sky = (Sky) obj;
					if(getStatus() == EntityStatus.SITTING)
					{
						int star = (int)(Math.random()*sky.getStarCount());
						say("Какая красивая " + sky.getStar(star).getSize().getLocale().replaceAll("ий|ой|ый", "ая").toLowerCase() + " " + sky.getStar(star).getColor().getLocale().replaceAll("ий|ой|ый", "ая").toLowerCase() + " звезда на небе");
						try 
						{
							Thread.sleep(1000);
						} 
						catch (InterruptedException e) 
						{
							e.printStackTrace();
						}
					}
					else
					{
						say("Присесть бы!");
					}
				}
			}
		};
		
		MainStar sun = new MainStar(Size.LARGE, Color.YELLOW, 0, "Солнце");
		
		System.out.println(sun.toString());
		
		System.out.println();
		
		Star[] stars = new Star[10];
		
		for(int i = 0; i < stars.length; i++)
		{
			int size = (int)(Math.random()*5);
			int color = (int)(Math.random()*9);
			stars[i] = new Star(Size.values()[size], Color.values()[color], "");
			System.out.println(stars[i].toString());
		}
		
		System.out.println();
		
		Sky sky = new Sky(stars);
		
		System.out.println(sky.toString());
		
		System.out.println();
		
		House carlsonHouse = new House(Size.SMALL, 25, new Porch(Size.LITTLE, 6), Color.GREEN);
		
		System.out.println(carlsonHouse.toString());
		
		House[] houses = new House[11];
		
		System.out.println();
		
		houses[0] = carlsonHouse;
		
		for(int i = 1; i < houses.length; i++)
		{
			int size = (int)(Math.random()*5);
			int temp = (int) ((Math.random()*11) + 20);
			int color = (int)(Math.random()*9);
			houses[i] = new House(Size.values()[size], temp, new Porch(Size.values()[(int)(Math.random()*3)], 2), Color.values()[color]);
			System.out.println(houses[i].toString());
		}
		
		System.out.println();
		
		World ostermalm = new World(sun, sky, houses);
		
		System.out.println(ostermalm.toString());
		
		fillGinger(ostermalm.getHouse(0).getPorch());
		fillJuice(ostermalm.getHouse(0).getPorch());
		
		carlson.setStatus(EntityStatus.SLEEPING);
		
		int gIndex = 0;
		int jIndex = 0;
		
		while(true)
		{
			//утро
			ostermalm.setTime(Time.MORNING);
			carlson.awake();
			if(ostermalm.getHouse(0).getPorch().isBusy())
			{
				waiting(3000);
				carlson.lookAt(ostermalm.getMainStar());
				ostermalm.getHouse(0).getPorch().leave();
				carlson.say("Пойду в домик!");
			}
			else
			{
				waiting(3000);
				carlson.say("Хорошо спалось в домике!");
			}
			//день
			carlson.setHunger((int)((Math.random()*carlson.getMaxHunger()) + 1));
			System.out.println("***голод Карлсона - " + carlson.getHunger() + "/" + carlson.getMaxHunger() + "***");
			carlson.say("Эх, пойду на крыльцо!");
			waiting(1500);
			ostermalm.getHouse(0).getPorch().join(carlson);
			
			Gingerbread[] ginger = new Gingerbread[3]; //= (Gingerbread) ostermalm.getHouse(0).getPorch().getItem(0);
			Juice[] juice = new Juice[3]; //= (Juice) ostermalm.getHouse(0).getPorch().getItem(1);
			
			for(int i = 0; i < 3; i++)
			{
				ginger[i] = (Gingerbread) ostermalm.getHouse(0).getPorch().getItem(i);
				juice[i] = (Juice) ostermalm.getHouse(0).getPorch().getItem(i + 3);
			}
			
			carlson.say("Поем пряников!");
			waiting(2000);
			if(ginger[gIndex].isEaten())
			{
				//System.out.println("***nextG***");
				gIndex++;
			}
			if(3 == gIndex)
			{
				carlson.say("Эх, пряники закончились, надо пополнить запасы");
				fillGinger(ostermalm.getHouse(0).getPorch());
				System.out.println("***запас пряников пополнен***");
				gIndex = 0;
			}
			else
			{
				carlson.say("Масса пряника в у.е = " + ginger[gIndex].getBites());
				carlson.eat(ginger[gIndex]);
				System.out.println("***голод Карлсона - " + carlson.getHunger() + "/" + carlson.getMaxHunger() + "***");
				carlson.say("Масса пряника в у.е = " + ginger[gIndex].getBites());
			}
			
			carlson.say("Попью сок!");
			waiting(2000);
			if(juice[jIndex].isEmpty())
			{
				//System.out.println("***nextJ***");
				jIndex++;
			}
			if(3 == jIndex)
			{
				carlson.say("Эх, сок закончился, надо пополнить запасы");
				fillJuice(ostermalm.getHouse(0).getPorch());
				System.out.println("***запас сока пополнен***");
				jIndex = 0;
			}
			else
			{
				carlson.say("Объём оставшегося сока - " + juice[jIndex].getVolume());
				carlson.drink(juice[jIndex]);
				System.out.println("***голод Карлсона - " + carlson.getHunger() + "/" + carlson.getMaxHunger() + "***");
				carlson.say("Объём оставшегося сока - " + juice[jIndex].getVolume());
			}
			
			waiting(3000);
			//вечер
			ostermalm.setTime(Time.EVENING);
			carlson.say("Буду любоваться звёздами!");
			for(int i = 0; i < 10; i++)
			{
				carlson.lookAt(ostermalm.getSky());
			}
			waiting(3000);
			//ночь
			ostermalm.setTime(Time.NIGHT);
			ostermalm.getHouse(0).setTemp((int) ((Math.random()*11) + 20));
			if(ostermalm.getHouse(0).getTemp() >= 25)
			{
				carlson.say("Жарко в домике, буду спать на крылечке.");
				carlson.sleep(7000);
			}
			else
			{
				carlson.say("В домике хорошо, буду спать в нём.");
				ostermalm.getHouse(0).getPorch().leave();
				carlson.sleep(7000);
			}
		}
	}
	
	private static void fillGinger(Porch porch)
	{
		int size = (int)(Math.random()*5);
		porch.setItem(0, new Gingerbread(Size.values()[size], "ginger0", (int)((Math.random()*5) + 1)));
		porch.setItem(1, new Gingerbread(Size.values()[size], "ginger1", (int)((Math.random()*5) + 1)));
		porch.setItem(2, new Gingerbread(Size.values()[size], "ginger2", (int)((Math.random()*5) + 1)));
	}
	
	private static void fillJuice(Porch porch)
	{
		int color = (int)(Math.random()*9);
		porch.setItem(3, new Juice((int)((Math.random()*9) + 1), Color.values()[color], "juice3"));
		porch.setItem(4, new Juice((int)((Math.random()*9) + 1), Color.values()[color], "juice4"));
		porch.setItem(5, new Juice((int)((Math.random()*9) + 1), Color.values()[color], "juice5"));
	}
	
	private static void waiting(long time)
	{
		try 
		{
			Thread.sleep(time);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
