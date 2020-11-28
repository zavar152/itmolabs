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
		EntityLiving carlson = new EntityLiving(0, 20) {
			
			@Override
			public void sleep(int time) 
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
				if((getStatus() == EntityStatus.SITTING) && (getHunger() + 1 < getMaxHunger()))
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
			public void say(String m)
			{
				System.out.println("Карлсон: " + m);
			}

			@Override
			public void awake()
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
		
		MainStar sun = new MainStar(0, Size.LARGE, Color.YELLOW, 0);
		sun.setCustomName("Солнце");
		
		System.out.println(sun.toString());
		
		System.out.println();
		
		Star[] stars = new Star[10];
		
		for(int i = 0; i < stars.length; i++)
		{
			int size = (int)(Math.random()*4);
			int color = (int)(Math.random()*8);
			stars[i] = new Star(i+1, Size.values()[size], Color.values()[color]);
			System.out.println(stars[i].toString());
		}
		
		System.out.println();
		
		Sky sky = new Sky(0, stars);
		
		System.out.println(sky.toString());
		
		System.out.println();
		
		House carlsonHouse = new House(0, Size.SMALL, 25, new Porch(0, Size.LITTLE), Color.GREEN);
		
		System.out.println(carlsonHouse.toString());
		
		House[] houses = new House[11];
		
		System.out.println();
		
		houses[0] = carlsonHouse;
		
		for(int i = 1; i < houses.length; i++)
		{
			int size = (int)(Math.random()*4);
			int temp = (int) ((Math.random()*11) + 20);
			int color = (int)(Math.random()*8);
			houses[i] = new House(i, Size.values()[size], temp, new Porch(i, Size.values()[(int)(Math.random()*3)]), Color.values()[color]);
			System.out.println(houses[i].toString());
		}
		
		System.out.println();
		
		World ostermalm = new World(0, sun, sky, houses);
		
		System.out.println(ostermalm.toString());
		
		fillGinger(ostermalm.getHouse(0).getPorch());
		fillJuice(ostermalm.getHouse(0).getPorch());
		
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
			carlson.say("Эх, пойду на крыльцо!");
			waiting(1500);
			ostermalm.getHouse(0).getPorch().join(carlson);
			Gingerbread ginger = (Gingerbread) ostermalm.getHouse(0).getPorch().getItem(0);
			Juice juice = (Juice) ostermalm.getHouse(0).getPorch().getItem(1);
			
			carlson.say("Поем пряников!");
			waiting(2000);
			if(!ginger.isEaten())
			{
				carlson.say("Пряников осталось - " + ginger.getCount());
				carlson.eat(ginger);
				System.out.println("***голод Карлсона - " + carlson.getHunger() + "/" + carlson.getMaxHunger() + "***");
			}
			else
			{
				carlson.say("Эх, пряники закончились, надо пополнить запасы");
				fillGinger(ostermalm.getHouse(0).getPorch());
				System.out.println("***запас пряников пополнен, пряников - " + ostermalm.getHouse(0).getPorch().getItem(0).getCount() + "***");
			}
			
			carlson.say("Попью сок!");
			waiting(2000);
			if(!juice.isEmpty())
			{
				carlson.say("Объём оставшегося сока - " + juice.getVolume());
				carlson.drink(juice);
				System.out.println("***голод Карлсона - " + carlson.getHunger() + "/" + carlson.getMaxHunger() + "***");
			}
			else
			{
				carlson.say("Эх, сок закончился, надо пополнить запасы");
				fillJuice(ostermalm.getHouse(0).getPorch());
				System.out.println("***запас сока пополнен, объём сока - " + ((Juice)ostermalm.getHouse(0).getPorch().getItem(1)).getVolume() + "***");
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
		int size = (int)(Math.random()*4);
		porch.setItem(0, new Gingerbread((int)((Math.random()*5) + 1), Size.values()[size]).setCustomName("ginger"));
	}
	
	private static void fillJuice(Porch porch)
	{
		int color = (int)(Math.random()*8);
		porch.setItem(1, new Juice((int)((Math.random()*9) + 1), Color.values()[color]).setCustomName("juice"));
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
