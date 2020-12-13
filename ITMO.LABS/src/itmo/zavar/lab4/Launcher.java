package itmo.zavar.lab4;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

import itmo.zavar.lab4.entity.EntityLiving;
import itmo.zavar.lab4.entity.EntityStatus;
import itmo.zavar.lab4.exception.StatusException;
import itmo.zavar.lab4.item.Drinkable;
import itmo.zavar.lab4.item.Eatable;
import itmo.zavar.lab4.util.Color;
import itmo.zavar.lab4.util.Randomizable;
import itmo.zavar.lab4.util.Report;
import itmo.zavar.lab4.util.Size;
import itmo.zavar.lab4.util.Util;
import itmo.zavar.lab4.world.Time;
import itmo.zavar.lab4.world.World;
import itmo.zavar.lab4.world.house.House;
import itmo.zavar.lab4.world.sky.MainStar;
import itmo.zavar.lab4.world.sky.Sky;
import itmo.zavar.lab4.world.sky.Star;

public class Launcher 
{
	private static boolean gangTryPoison = false;
	private static boolean gangAttacked = false;

	public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException 
	{
		EntityLiving carlson = new EntityLiving(20, "Карлсон") {
			
			@Override
			public void sleep(int time) throws StatusException 
			{
				if(isAlive())
				{
					if(getStatus() != EntityStatus.DEFAULT && getStatus() != EntityStatus.SITTING)
					{
						throw new StatusException(EntityStatus.DEFAULT, EntityStatus.SITTING);
					}
					
					if(getStatus() == EntityStatus.DEFAULT || getStatus() == EntityStatus.SITTING)
					{
						say("Я спать!");
						setStatus(EntityStatus.SLEEPING);
						Util.delay(time);
					}
					else
					{
						say("И как я усну?");
					}
				}
			}
			
			@Override
			public void eat(Eatable eat) throws StatusException 
			{
				if(isAlive())
				{
					if(getStatus() != EntityStatus.SITTING)
					{
						throw new StatusException(EntityStatus.SITTING);
					}
					
					if((getStatus() == EntityStatus.SITTING) && (getHunger() < getMaxHunger()))
					{
						setStatus(EntityStatus.EATING);
						eat.takeBite();
						setHunger(getHunger() + eat.getSaturation());
						if(isAlive())
						{
							if(eat.getSaturation() < 0)
							{
								say("С этой едой что-то не так...");
							}
							setStatus(EntityStatus.SITTING);
							say("Вкусный пряник!");
						}
					}
					else
					{
						say("Я не хочу кушать!");
						setHunger(getHunger()-1);
					}
				}
			}
			
			@Override
			public void drink(Drinkable drink) throws StatusException 
			{
				if(isAlive())
				{
					if(getStatus() != EntityStatus.SITTING)
					{
						throw new StatusException(EntityStatus.SITTING);
					}
					
					if((getStatus() == EntityStatus.SITTING) && (getHunger() < getMaxHunger()))
					{
						setStatus(EntityStatus.DRINKING);
						drink.takeSip();
						setHunger(getHunger() + drink.getSaturation());
						if(isAlive())
						{
							if(drink.getSaturation() < 0)
							{
								say("С этим напитком что-то не так...");
							}
							setStatus(EntityStatus.SITTING);
							say("Вкусный сок!");
						}
					}
					else
					{
						say("Я не хочу пить!");
						setHunger(getHunger()-1);
					}
				}
			}

			@Override
			public void awake() throws StatusException
			{
				if(isAlive())
				{
					if(getStatus() != EntityStatus.SLEEPING)
					{
						throw new StatusException(EntityStatus.SLEEPING);
					}
					
					if(getStatus() == EntityStatus.SLEEPING)
					{
						setStatus(EntityStatus.AWAKENING);
						Util.delay(500);
						setStatus(EntityStatus.DEFAULT);
						say("Я проснулся!");
					}
					else
					{
						say("Я не сплю!");
					}
				}
			}

			@Override
			public void lookAt(Object obj) 
			{
				if(isAlive())
				{
					class Formatter
					{
						public String format(Star star)
						{
							return star.getSize().getLocale().replaceAll("ий|ой|ый", "ая").toLowerCase() + " " + star.getColor().getLocale().replaceAll("ий|ой|ый", "ая").toLowerCase();
						}
					}
					
					if(obj instanceof MainStar)
					{
						MainStar sun = (MainStar) obj;
						if(sun.getPosition() == Time.MORNING.ordinal())
						{
							say("Какое красивое " + sun.getName() + "!");
							Util.delay(1000);
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
							say("Какая красивая " + new Formatter().format(sky.getStar(star)) + " звезда на небе");
							Util.delay(1000);
						}
						else
						{
							say("Присесть бы!");
						}
					}
				}
			}
		};
		
		Randomizable rand = (min, max) -> {
			max -= min;
			return (int) (Math.random() * ++max) + min;
			};
		
		MainStar sun = new MainStar(Size.LARGE, Color.YELLOW, 0, "Солнце");
		
		//System.out.println(sun.toString());
		
		//System.out.println();
		
		Star[] stars = new Star[10];
		
		for(int i = 0; i < stars.length; i++)
		{
			int size = (int)(Math.random()*5);
			int color = (int)(Math.random()*9);
			stars[i] = new Star(Size.values()[size], Color.values()[color], "");
			//System.out.println(stars[i].toString());
		}
		
		//System.out.println();
		
		Sky sky = new Sky(stars);
		
		//System.out.println(sky.toString());
		
		//System.out.println();
		
		House carlsonHouse = new House(Size.SMALL, 25, Size.LITTLE, 6, Color.GREEN);
		
		//System.out.println(carlsonHouse.toString());
		
		House[] houses = new House[11];
		
		//System.out.println();
		
		houses[0] = carlsonHouse;
		
		for(int i = 1; i < houses.length; i++)
		{
			int size = (int)(Math.random()*5);
			int temp = rand.random(15, 25);
			int color = (int)(Math.random()*9);
			houses[i] = new House(Size.values()[size], temp, Size.values()[(int)(Math.random()*4)], 2, Color.values()[color]);
			//System.out.println(houses[i].toString());
		}
		
		//System.out.println();
		
		World ostermalm = new World(sun, sky, houses);
		
		//System.out.println(ostermalm.toString());
		
		Util.Filler.fillGinger(ostermalm.getHouse(0).getPorch());
		Util.Filler.fillJuice(ostermalm.getHouse(0).getPorch());
		
		carlson.setStatus(EntityStatus.SLEEPING);
		
		int gIndex = 0;
		int jIndex = 0;
		
		Gangster gang = new Gangster(10, "Афоня");
		
		
		//System.out.println(ostermalm.getHouse(0).getPorch().toString());
		//System.out.println(ostermalm.getHouse(0).getPorch().contSize());
		
		carlson.setHunger((int)((Math.random()*carlson.getMaxHunger()) + 1));
		
		if(Math.random() <= 0.40)
		{
			gang.say("Отравлю его еду...");
			gangTryPoison = true;
			try
			{
				gang.poisonItems(ostermalm.getHouse(0).getPorch());
			} 
			catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException
					| NoSuchMethodException | InvocationTargetException e) 
			{
				e.printStackTrace();
			}
		}
		
		while(true)
		{
			//утро	
			ostermalm.setTime(Time.MORNING);
			try 
			{
				carlson.awake();
			} 
			catch (StatusException e) 
			{
				e.printStackTrace();
			}
			if(ostermalm.getHouse(0).getPorch().isBusy())
			{
				Util.delay(3000);
				carlson.lookAt(ostermalm.getMainStar());
				ostermalm.getHouse(0).getPorch().leave();
				carlson.say("Пойду в домик!");
			}
			else
			{
				Util.delay(3000);
				carlson.say("Хорошо спалось в домике!");
			}
			//день
			//System.out.println("***голод Карлсона - " + carlson.getHunger() + "/" + carlson.getMaxHunger() + "***");
			Util.systemMessage("голод Карлсона - " + carlson.getHunger() + "/" + carlson.getMaxHunger());
			carlson.say("Эх, пойду на крыльцо!");
			Util.delay(1500);
			ostermalm.getHouse(0).getPorch().join(carlson);
			
			Gingerbread[] ginger = new Gingerbread[3]; //= (Gingerbread) ostermalm.getHouse(0).getPorch().getItem(0);
			Juice[] juice = new Juice[3]; //= (Juice) ostermalm.getHouse(0).getPorch().getItem(1);
			
			for(int i = 0; i < 3; i++)
			{
				ginger[i] = (Gingerbread) ostermalm.getHouse(0).getPorch().getItem(i);
				juice[i] = (Juice) ostermalm.getHouse(0).getPorch().getItem(i + 3);
			}
			
			carlson.say("Поем пряников!");
			Util.delay(2000);

			if(ginger[gIndex] != null)
			{
				if(ginger[gIndex].isEaten())
				{
					//System.out.println("***nextG***");
					gIndex++;
				}
				if(3 == gIndex)
				{
					carlson.say("Эх, пряники закончились, надо пополнить запасы");
					Util.Filler.fillGinger(ostermalm.getHouse(0).getPorch());
					Util.systemMessage("запас пряников пополнен");
					gIndex = 0;
				}
				else
				{
					Util.systemMessage("Масса пряника в у.е = " + ginger[gIndex].getBites());
						try 
						{
							carlson.eat(ginger[gIndex]);
						} 
						catch (StatusException e) 
						{
							e.printStackTrace();
						}
						if(!carlson.isAlive())
						{
							break;
						}
						Util.systemMessage("Масса пряника в у.е = " + ginger[gIndex].getBites());
				}
			}
			else
			{
				carlson.say("Где мой пряник?!");
				carlson.setHunger(carlson.getHunger()-1);
			}
			Util.systemMessage("голод Карлсона - " + carlson.getHunger() + "/" + carlson.getMaxHunger());
			
			carlson.say("Попью сок!");
			Util.delay(2000);
			
			if(juice[jIndex] != null)
			{
				if(juice[jIndex].isEmpty())
				{
					//System.out.println("***nextJ***");
					jIndex++;
				}
				if(3 == jIndex)
				{
					carlson.say("Эх, сок закончился, надо пополнить запасы");
					Util.Filler.fillJuice(ostermalm.getHouse(0).getPorch());
					Util.systemMessage("запас сока пополнен");
					jIndex = 0;
					if(jIndex == 0 && gIndex == 0)
					{
						gangTryPoison = false;
						gang.say("Чёрт, отравить не получилось!");
					}
				}
				else
				{
						Util.systemMessage("Объём оставшегося сока - " + juice[jIndex].getVolume());
						try 
						{
							carlson.drink(juice[jIndex]);
						} 
						catch (StatusException e) 
						{
							e.printStackTrace();
						}
						if(!carlson.isAlive())
						{
							break;
						}
						Util.systemMessage("Объём оставшегося сока - " + juice[jIndex].getVolume());
				}
			}
			else
			{
				carlson.say("Где мой сок?!");
				carlson.setHunger(carlson.getHunger()-1);
			}
			Util.systemMessage("голод Карлсона - " + carlson.getHunger() + "/" + carlson.getMaxHunger());
			
			Util.delay(3000);
			
			//вечер
			ostermalm.setTime(Time.EVENING);
			carlson.say("Буду любоваться звёздами!");
			for(int i = 0; i < 10; i++)
			{
				carlson.lookAt(ostermalm.getSky());
			}
			Util.delay(3000);
			//ночь
			ostermalm.setTime(Time.NIGHT);
			ostermalm.getHouse(0).setTemp(rand.random(15, 25));
			
			if(!gangAttacked && !gangTryPoison)
			{
				gang.say("Ну все, Карлсон, тебе конец.");
				Util.delay(1000);
				Util.systemMessage("На Карлсона напали");
				Util.delay(1000);
				if(Math.random() <= 0.835)
				{
					gang.killEntity(carlson);
					gangAttacked = true;
					break;
				}
				else
				{
					gang.say("Ай, чёрт!");
					Util.delay(1000);
					carlson.say("Слышь, урод!");
					Util.delay(1000);
					gang.say("Пора валить...");
					Util.delay(1000);
					Util.systemMessage("Карлсон пытается поймать " + gang.getName().replace('я', 'ю'));
					Util.delay(1000);
					if(Math.random() <= 0.45)
					{
						gang.say("НЕТ!!!");
						Util.delay(1000);
						gang.kill();
						carlson.say("Отдохни...");
						Util.delay(1000);
						Util.systemMessage("Карлсон убил " + gang.getName().replace('я', 'ю'));
					}
					else
					{
						gang.say("Фух, удрал...");
						Util.delay(1000);
						Util.systemMessage("Карлсон не смог поймать " + gang.getName().replace('я', 'ю'));
						Util.delay(1000);
						carlson.say("Ну все, я тебя найду! Звоню Малышу...");
					}
					createReport(gang, carlson);
				}
				gangAttacked = true;
			}
			
			if(ostermalm.getHouse(0).getTemp() >= 20)
			{
				carlson.say("Жарко в домике, буду спать на крылечке.");
				try 
				{
					carlson.sleep(7000);
				} 
				catch (StatusException e) 
				{
					e.printStackTrace();
				}
			}
			else
			{
				carlson.say("В домике хорошо, буду спать в нём.");
				ostermalm.getHouse(0).getPorch().leave();
				try 
				{
					carlson.sleep(7000);
				} 
				catch (StatusException e) 
				{
					e.printStackTrace();
				}
			}
		}
		if(gangAttacked)
		{
			System.err.println("Карлсона убили!");
		}
		else if(gangTryPoison)
		{
			System.err.println("Карлсона отравили!");
		}
		createReport(gang, carlson);
	}
	
	private static void createReport(Gangster gang, EntityLiving carlson)
	{
		try(Report r = new Report(System.getProperty("user.home")))
		{
			Map<String, String> map = new LinkedHashMap<String, String>();
			map.put("carlson", "");
			map.put("killedBy", "false");
			map.put("gang", "");
			map.replace("carlson", Boolean.toString(!carlson.isAlive()));
			map.replace("gang", Boolean.toString(!gang.isAlive()));	
			if(gang.isAlive())
			{
				if(gangAttacked)
				{
					map.replace("killedBy", "killed");
				}
				else if(gangTryPoison)
				{
					map.replace("killedBy", "poisoned");
				}
			}
			else
			{
				map.replace("killedBy", "false");
			}
			r.write(map);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
