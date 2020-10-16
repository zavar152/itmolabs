package itmo.zavar.lab2.pokemons.attacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class MoveSludgeBomb extends SpecialMove
{
	public MoveSludgeBomb() 
	{
		super(Type.POISON, 90, 100);
	}
	
	@Override
	protected void applyOppEffects(Pokemon var1) 
	{
		if(Math.random() <= 0.3)
		{
			Effect.poison(var1);
		}
	}
	
	@Override
	protected String describe() 
	{
		return "отравляет соперника (Sludge Bomb)";
	}
}
