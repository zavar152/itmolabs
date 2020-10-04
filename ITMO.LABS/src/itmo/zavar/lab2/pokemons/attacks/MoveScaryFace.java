package itmo.zavar.lab2.pokemons.attacks;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class MoveScaryFace extends StatusMove
{
	public MoveScaryFace() 
	{
		super(Type.NORMAL, 0, 100);
	}
	
	@Override
	protected void applyOppEffects(Pokemon pok) 
	{
		pok.setMod(Stat.SPEED, -2);
	}
	
	@Override
	protected String describe() 
	{
		return "Уменьшает скорость противника на 2 пункта (Scary Face)";
	}
}
