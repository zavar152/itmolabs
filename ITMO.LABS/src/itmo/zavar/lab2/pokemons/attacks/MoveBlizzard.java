package itmo.zavar.lab2.pokemons.attacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class MoveBlizzard extends SpecialMove
{
	public MoveBlizzard() 
	{
		super(Type.ICE, 110, 70);
	}
	
	@Override
	protected void applyOppEffects(Pokemon var1) 
	{
		if((int)(Math.random()*100.1) <= 10)
		{
			Effect.freeze(var1);;
		}
	}
	
	@Override
	protected String describe()
	{
		return "Замораживает противника с 10% шансом (Blizzard)";
	}
}
