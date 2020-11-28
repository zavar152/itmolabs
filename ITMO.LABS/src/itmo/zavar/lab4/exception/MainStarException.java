package itmo.zavar.lab4.exception;

public class MainStarException extends RuntimeException
{
	public MainStarException(int pos)
	{
		super("MainStar's position is incorrect (" + pos + ")");
	}
}
