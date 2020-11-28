package itmo.zavar.lab4.exception;

public class HouseTempException extends RuntimeException
{
	public HouseTempException(int temp)
	{
		super("Temperature is out of range (" + temp + ")");
	}
}
