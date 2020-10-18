package itmo.zavar.lab2;

import itmo.zavar.lab2.pokemons.PokemonBounsweet;
import itmo.zavar.lab2.pokemons.PokemonClamperl;
import itmo.zavar.lab2.pokemons.PokemonDarkrai;
import itmo.zavar.lab2.pokemons.PokemonHuntail;
import itmo.zavar.lab2.pokemons.PokemonSteenee;
import itmo.zavar.lab2.pokemons.PokemonTsareena;
import ru.ifmo.se.pokemon.Battle;
import ru.ifmo.se.pokemon.Pokemon;

public class BattleLaunch 
{
	public static void main(String[] args)
	{
			Battle b = new Battle();
			Pokemon darkrai = new PokemonDarkrai("Darkrai", 1);
			Pokemon clamperl = new PokemonClamperl("Clamperl", 1);
			Pokemon bounsweet = new PokemonBounsweet("Bounsweet", 1);
			Pokemon huntail = new PokemonHuntail("Huntail", 1);
			Pokemon steenee = new PokemonSteenee("Steenee", 1);
			Pokemon tsareena = new PokemonTsareena("Tsareena", 1);
			b.addAlly(darkrai);
			b.addAlly(clamperl);
			b.addAlly(bounsweet);
			b.addFoe(huntail);
			b.addFoe(steenee);
			b.addFoe(tsareena);
			b.go(); 
	}
}
