package itmo.zavar.lab2.pokemons;

import itmo.zavar.lab2.pokemons.attacks.MovePlayNice;

public class PokemonSteenee extends PokemonBounsweet
{
	public PokemonSteenee(String name, int level) 
	{
		super(name, level);
		setStats(52, 40, 48, 40, 48, 62);
		addMove(new MovePlayNice());
	}
}