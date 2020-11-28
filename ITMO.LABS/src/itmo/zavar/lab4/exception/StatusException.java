package itmo.zavar.lab4.exception;

import java.util.Arrays;

import itmo.zavar.lab4.entity.EntityStatus;

public class StatusException extends Exception 
{
	public StatusException(EntityStatus ... status)
	{
		super("Entity must have a " + Arrays.toString(status).replace("[", "").replace("]", "").replace(",", " or") + " status");
	}
}
