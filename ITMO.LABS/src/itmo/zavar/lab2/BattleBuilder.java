package itmo.zavar.lab2;

import ru.ifmo.se.pokemon.Battle;
import ru.ifmo.se.pokemon.Pokemon;

public class BattleBuilder 
{
	private boolean hasAlly = false;
	private boolean hasFoe = false;
	private Battle battle;
	
	public BattleBuilder()
	{
		battle = new Battle();
	}
	
	public void launchBattle()
	{
		if(!hasAlly | !hasFoe)
		{
			System.err.print("Заполните все команды покемонами");
		}
		else
		{
			battle.go();
		}
	}
	
	public void addAlly(Pokemon ... pok)
	{
		for(int i = 0; i < pok.length; i++)
		{
			battle.addAlly(pok[i]);
		}
		hasAlly = true;
	}
	
	public void addFoe(Pokemon ... pok)
	{
		for(int i = 0; i < pok.length; i++)
		{
			battle.addFoe(pok[i]);
		}
		hasFoe = true;
	}
}
