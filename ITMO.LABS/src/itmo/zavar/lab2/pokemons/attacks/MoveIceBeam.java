package itmo.zavar.lab2.pokemons.attacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class MoveIceBeam extends SpecialMove
{
	public MoveIceBeam() 
	{
		super(Type.ICE, 90, 100);
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
		return "With a 10% chance, freezes the opponent (Ice Beam)";
	}
}
