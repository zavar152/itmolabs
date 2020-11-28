package itmo.zavar.lab4.exception;

public class ContainerCreateException extends RuntimeException 
{
	public ContainerCreateException(int size)
	{
		super("Container size can't be negative (" + size + ")");
	}
}
