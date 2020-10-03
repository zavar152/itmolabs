package itmo.zavar.lab2.pokemons.attacks;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class MovePlayNice extends StatusMove
{
    public MovePlayNice()
    {
        super(Type.NORMAL, 0, 0);
    }
    
	@Override
	protected void applyOppEffects(Pokemon pok)
	{
	    pok.setMod(Stat.ATTACK, -1);
	}
	
	@Override
	protected String describe()
	{
	    return "ѕонижает атаку противника на один пункт";
	}
}
