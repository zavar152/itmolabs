package itmo.zavar.lab2.pokemons;

import itmo.zavar.lab2.pokemons.attacks.MoveConfide;
import itmo.zavar.lab2.pokemons.attacks.MoveRazorLeaf;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class PokemonBounsweet extends Pokemon
{
	public PokemonBounsweet(String name, int level) 
	{
		super(name, level);
		setStats(42, 30, 38, 30, 38, 32);
		setType(Type.GRASS);
		setMove(new MoveConfide(), new MoveRazorLeaf());
	}
}
