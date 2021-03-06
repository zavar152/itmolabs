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
		super(Type.PSYCHIC, 0, 1);
	}
	
	@Override
	protected void applySelfEffects(Pokemon pok) 
	{
		Effect.sleep(pok);
		pok.setMod(Stat.HP, (int) -(pok.getStat(Stat.HP) - pok.getHP()));
	}
	
	@Override
	protected String describe() 
	{
		return "усыпляет самого себя (Rest)";
	}
	
}
