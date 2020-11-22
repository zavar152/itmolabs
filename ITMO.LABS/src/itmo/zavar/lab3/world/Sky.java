package itmo.zavar.lab3.world;

public class Sky 
{
	private Star[] stars;

	public Sky(Star ... stars) 
	{
		this.stars = stars;
	}
	
	public final Star getStar(int i)
	{
		return stars[i];
	}
	
	public final int getStarCount()
	{
		return stars.length;
	}
}
