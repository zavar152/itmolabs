package itmo.zavar.lab2;

public class BattleLaunch 
{
	public static void main(String[] args)
	{
		/*Battle b = new Battle();
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
		b.go();*/
		/*BattleBuilder builder = new BattleBuilder();
		builder.addAlly(new PokemonDarkrai("Darkrai", 1), new PokemonClamperl("Clamperl", 1), new PokemonBounsweet("Bounsweet", 1));
		builder.addFoe(new PokemonHuntail("Huntail", 1), new PokemonSteenee("Steenee", 1), new PokemonTsareena("Tsareena", 1));
		builder.launchBattle();*/
		
		
		A a = new B();
		System.out.println(a.test);
		System.out.println(a.testM());
		System.out.println(a.testM2());
		a = null;
		//System.out.println(a.test);
		//System.out.println(a.testM());
		System.out.println(a.testM2());
	}
}

class A 
{    
	public int test = 4;  
	public int testM() 
	{ 
		return 1; 
	}    
	public static int testM2() 
	{ 
		return 3; 
	}	
} 

class B extends A 
{    
	public int test = 6;    
	public int testM() 
	{ 
		return 2; 
	}    
	public static int testM2() 
	{ 
		return 5; 
	} 
} 
