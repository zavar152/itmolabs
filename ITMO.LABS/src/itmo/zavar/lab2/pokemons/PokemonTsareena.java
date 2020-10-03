package itmo.zavar.lab2.pokemons;

import itmo.zavar.lab2.pokemons.attacks.MovePlayNice;
import itmo.zavar.lab2.pokemons.attacks.MoveRazorLeaf;
import itmo.zavar.lab2.pokemons.attacks.MoveRest;
import itmo.zavar.lab2.pokemons.attacks.MoveSplash;
import ru.ifmo.se.pokemon.Type;

public class PokemonTsareena extends PokemonSteenee
{
	public PokemonTsareena(String name, int level) 
	{
		super(name, level);
		setStats(72, 120, 98, 50, 98, 72);
		setType(Type.GRASS);
		setMove(new MoveSplash(), new MovePlayNice(), new MoveRazorLeaf(), new MoveRest());
	}
}
