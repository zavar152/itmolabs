package itmo.zavar.lab4.util;

public enum Size 
{
	LITTLE("Миниатурный"),
	SMALL("Маленький"),
	MEDIUM("Средний"),
	BIG("Большой"),
	LARGE("Огромный");
	
	private String locale;
	
	private Size(String locale)
	{
		this.locale = locale;
	}
	
	public String getLocale() 
	{
		return locale;
	}
}
