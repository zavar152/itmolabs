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
		if(Math.random() <= 0.1)
		{
			Effect.freeze(var1);;
		}
	}
	
	@Override
	protected String describe() 
	{
		return "замораживает соперника (Ice Beam)";
	}
}
