package itmo.zavar.lab4.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class Report implements AutoCloseable
{
	private FileInputStream reportIn;
	private FileOutputStream reportOut;
	private Properties prop = new Properties();
	private File report;
	
	public Report(String path)
	{
		try 
		{
			report = new File(path + "/report.properties");
			report.createNewFile();
			reportIn = new FileInputStream(report);
		} 
		catch (FileNotFoundException e1) 
		{
			e1.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			prop.load(reportIn);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void write(Map<String, String> map)
	{
		try 
		{
			reportOut = new FileOutputStream(report);
		} 
		catch (FileNotFoundException e1) 
		{
			e1.printStackTrace();
		}
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
		reportIn.close();
		reportOut.close();
	}
}
