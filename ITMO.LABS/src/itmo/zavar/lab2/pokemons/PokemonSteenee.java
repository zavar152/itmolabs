package itmo.zavar.lab2.pokemons;

import itmo.zavar.lab2.pokemons.attacks.MovePlayNice;
import itmo.zavar.lab2.pokemons.attacks.MoveRazorLeaf;
import itmo.zavar.lab2.pokemons.attacks.MoveRest;
import itmo.zavar.lab2.pokemons.attacks.MoveSplash;
import ru.ifmo.se.pokemon.Type;

public class PokemonSteenee extends PokemonBounsweet
{
	public PokemonSteenee(String name, int level) 
	{
		super(name, level);
		setStats(52, 40, 48, 40, 48, 62);
		setType(Type.GRASS);
		setMove(new MoveSplash(), new MovePlayNice(), new MoveRazorLeaf(), new MoveRest());
	}
}