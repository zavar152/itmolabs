package itmo.zavar.lab2.pokemons.attacks;

import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class MoveSplash extends StatusMove
{
	public MoveSplash() 
	{
		super(Type.NORMAL, 0, 0);
	}
	
	@Override
	protected String describe() 
	{
		return "Испольлзует Splash и ничего не делает";
	}
}
