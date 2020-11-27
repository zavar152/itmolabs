package itmo.zavar.lab3.util;

public enum Color 
{
	BLACK("Чёрный"),
	WHITE("Белый"),
	RED("Красный"),
	ORANGE("Оранжевый"),
	YELLOW("Жёлтый"),
	GREEN("Зелёный"),
	CYAN("Голубой"),
	BLUE("Синий"),
	MAGENTA("Пурпурный");
	
	private String locale;
	
	private Color(String locale)
	{
		this.locale = locale;
	}
	
	public String getLocale() 
	{
		return locale;
	}
}
