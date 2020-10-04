package itmo.zavar.lab2.pokemons;

import itmo.zavar.lab2.pokemons.attacks.MoveBlizzard;
import itmo.zavar.lab2.pokemons.attacks.MoveHypnosis;
import itmo.zavar.lab2.pokemons.attacks.MoveIceBeam;
import itmo.zavar.lab2.pokemons.attacks.MoveSludgeBomb;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class PokemonDarkrai extends Pokemon
{
	public PokemonDarkrai(String name, int level)
	{
		super(name, level);
		setStats(70, 90, 90, 135, 90, 125);
		setType(Type.DARK);
		setMove(new MoveHypnosis(), new MoveSludgeBomb(), new MoveIceBeam(), new MoveBlizzard());
	}
}
