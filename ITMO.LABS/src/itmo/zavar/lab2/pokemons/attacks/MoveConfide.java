package itmo.zavar.lab2.pokemons.attacks;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class MoveConfide extends StatusMove
{
	public MoveConfide() 
	{
		super(Type.NORMAL, 0, 1);
	}
	
	@Override
	protected void applyOppEffects(Pokemon pok) 
	{
		pok.setMod(Stat.SPECIAL_ATTACK, -1);
	}
	
	@Override
	protected String describe()
	{
	    return "понижает показатель атаки соперника на один пункт (Confide)";
	}
}
