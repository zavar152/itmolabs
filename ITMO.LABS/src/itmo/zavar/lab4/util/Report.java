package itmo.zavar.lab4.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class Report implements AutoCloseable
{
	private FileOutputStream reportOut;
	private Properties prop = new Properties();
	private File report;
	
	public Report(String path)
	{
		try 
		{
			report = new File(path + "/report.properties");
			report.createNewFile();
			reportOut = new FileOutputStream(report);
		}  
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	/**
	 * @author Ярослав
	 * @apiNote 
	 * Keys:
	 * <li>carlson - убит ли Карлсон (false/true)
	 * <li>carlsonKilledBy - как убит Карлсон (false - жив; killed - убит; poisoned - отравлен)
	 * <li>gangTry - как пытался убить Карслона киллер (kill - убить; poison - отравить; both - оба варианта)
	 * <li>gang - убит ли киллер (false/true)
	 * <li>gangHame - имя киллер (тип String)
	 */
	public void write(Map<String, String> map)
	{
		prop.putAll(map);
		try 
		{
			prop.store(reportOut, null);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void close() throws Exception 
	{
		reportOut.close();
	}
}
