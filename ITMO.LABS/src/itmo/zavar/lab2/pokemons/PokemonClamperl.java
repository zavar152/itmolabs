package itmo.zavar.lab2.pokemons;

import itmo.zavar.lab2.pokemons.attacks.MoveBlizzard;
import itmo.zavar.lab2.pokemons.attacks.MoveConfide;
import itmo.zavar.lab2.pokemons.attacks.MoveIceBeam;
import itmo.zavar.lab2.pokemons.attacks.MoveRest;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class PokemonClamperl extends Pokemon
{
	public PokemonClamperl(String name, int level) 
	{
		super(name, level);
		setStats(35, 64, 85, 74, 55, 32);
		setType(Type.WATER);
		setMove(new MoveBlizzard(), new MoveIceBeam(), new MoveRest(), new MoveConfide());
	}
}
