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
		Pokemon p1 = new PokemonDarkrai("Darkrai", 1);
		Pokemon p2 = new PokemonClamperl("Clamperl", 1);
		Pokemon p3 = new PokemonBounsweet("Bounsweet", 1);
		Pokemon p4 = new PokemonHuntail("Huntail", 1);
		Pokemon p5 = new PokemonSteenee("Steenee", 1);
		Pokemon p6 = new PokemonTsareena("Tsareena", 1);
		b.addAlly(p1);
		b.addAlly(p2);
		b.addAlly(p3);
		b.addFoe(p4);
		b.addFoe(p5);
		b.addFoe(p6);
		b.go();
	}
}
