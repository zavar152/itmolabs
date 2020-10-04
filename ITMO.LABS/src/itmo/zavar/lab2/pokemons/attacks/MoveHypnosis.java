package itmo.zavar.lab2.pokemons.attacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class MoveHypnosis extends StatusMove
{
	public MoveHypnosis() 
	{
		super(Type.PSYCHIC, 0, 60);
	}
	
	@Override
	protected void applyOppEffects(Pokemon pok) 
	{
		if(hits >= 1)
		{
			Effect.sleep(pok);
		}
		else
		{
			hits = 0;
		}
	}
	
	@Override
	protected String describe() 
	{
		return "Усыпляет противника (Hypnosis)";
	}
}
