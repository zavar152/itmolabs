package itmo.zavar.lab2.pokemons.attacks;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class MoveRazorLeaf extends PhysicalMove
{
	public MoveRazorLeaf()
	{
		super(Type.GRASS, 55, 95);
	}
	
	@Override
	protected double calcCriticalHit(Pokemon var1, Pokemon var2) 
	{
		return 1/8D;
	}
	
	@Override
	protected String describe() 
	{
		return "Увеличение множителя критического урона (Razor Leaf)";
	}
}
