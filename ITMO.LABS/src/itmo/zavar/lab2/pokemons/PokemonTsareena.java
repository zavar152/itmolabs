package itmo.zavar.lab2.pokemons;

import itmo.zavar.lab2.pokemons.attacks.MoveSplash;

public class PokemonTsareena extends PokemonSteenee
{
	public PokemonTsareena(String name, int level) 
	{
		super(name, level);
		setStats(72, 120, 98, 50, 98, 72);
		addMove(new MoveSplash());
	}
}
