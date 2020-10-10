package itmo.zavar.lab2.pokemons.attacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class MoveRest extends StatusMove
{
	public MoveRest() 
	{
		super(Type.PSYCHIC, 0, 0);
	}
	
	@Override
	protected void applySelfEffects(Pokemon pok) 
	{
		if(pok.getHP() == pok.getStat(Stat.HP))
			Effect.sleep(pok);
	}
	
	@Override
	protected String describe() 
	{
		return "Puts himself to sleep (Rest)";
	}
	
}
