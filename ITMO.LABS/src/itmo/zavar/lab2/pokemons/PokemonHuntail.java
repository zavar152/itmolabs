package itmo.zavar.lab2.pokemons;

import itmo.zavar.lab2.pokemons.attacks.MoveScaryFace;

public class PokemonHuntail extends PokemonClamperl
{
	public PokemonHuntail(String name, int level) 
	{
		super(name, level);
		addMove(new MoveScaryFace());
	}
}
