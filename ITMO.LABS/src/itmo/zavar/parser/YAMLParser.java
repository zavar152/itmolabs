package itmo.zavar.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class YAMLParser 
{
	public static void main(String[] args) 
	{
		File json = new File("src/itmo/zavar/parser/sample.yaml");
		String line, linesAsArray[];
        ArrayList<String> lines = new ArrayList<String>();
    	BufferedReader reader = null;
		try
		{
			reader = new BufferedReader(new FileReader(json));
		} 
		catch (FileNotFoundException e1) 
		{
			e1.printStackTrace();
		}
        try 
        {
			while((line = reader.readLine()) != null) 
			{
			    lines.add(line);
			    System.out.println(line);
			}
		}
        catch (IOException e) 
        {
			e.printStackTrace();			
        }
        linesAsArray = lines.toArray(new String[lines.size()]);	
        try 
        {
			reader.close();
		} 
        catch (IOException e) 
        {
			e.printStackTrace();
		}
        
        String result = "";
        result = "{\n";
        result = result + spaces(2) + quot(linesAsArray[0]) + ": [";
        int lessons = getNum(linesAsArray[1]);
        result = result + "\n" + spaces(4) +"{\n" + spaces(6) + getName(linesAsArray[1], 2) + " " + lessons + ",\n";
        
        int j = 2;
        for(int i = 1; i <= lessons; i++)
        {
        result = result + spaces(6) + getName(linesAsArray[j], 2) + " [\n" +
        		bracket(getTypeName(linesAsArray[j+1], 2) + " " +getArg(linesAsArray[j+1]), 8) + ",\n" +
        		bracket(getTypeName(linesAsArray[j+2], 2) + " " +getArg(linesAsArray[j+2]), 8) + ",\n" +
        		bracket(getTypeName(linesAsArray[j+3], 2) + " " +getNum(linesAsArray[j+3]), 8) + ",\n" +
        		bracket(getTypeName(linesAsArray[j+4], 2) + " " +getArg(linesAsArray[j+4]), 8) + ",\n" +
        		bracket(getTypeName(linesAsArray[j+5], 2) + " " +getArg(linesAsArray[j+5]), 8) + ",\n" +
        		bracket(getTypeName(linesAsArray[j+6], 2) + "\n" +bracket(getName(linesAsArray[j+7], 6) + " " +getTimeArg(linesAsArray[j+7]) + "," + "\n" 
        		+ spaces(12) + getName(linesAsArray[j+8], 6) + " " +getTimeArg(linesAsArray[j+8]),10), 8) + ",\n" + 
        		bracket(getTypeName(linesAsArray[j+9], 2) + " " +getArg(linesAsArray[j+9]), 8) + "\n" + spaces(6);
        	if(i == lessons)
        	{
        		result = result + "]\n";
        	}
        	else
        	{
        		result = result + "],\n";
        	}
        	j = j + 10;
        }
        result = result + spaces(4) + "}\n" + spaces(2) +"]\n" + "}";
        System.out.println(result);
	} 
	
	private static String getName(String in, int c)
	{
		return quot(in.split(": ")[0].substring(c)) + ":";
	}
	
	private static String getTypeName(String in, int c)
	{
		return quot(in.split(": ")[0].substring(c).replace("- ", "")) + ":";
	}
	
	private static String getTimeArg(String in)
	{
		return "\"" + in.split("\'")[1] + "\"";
	}
	
	private static String getArg(String in)
	{
		if(in.split(": ").length == 2)
		{
			return quot(in.split(": ")[1]);
		}
		else
		{
			return "null";
		}
	}
	
	private static int getNum(String in)
	{
		return Integer.parseInt(in.split(": ")[1]);
	}
	
	private static String quot(String in)
	{
		return "\"" +  in.replace(":", "") + "\"";
	}
	
	private static String bracket(String in, int sp)
	{
		return spaces(sp) + "{\n" + spaces(sp+2) + in + "\n" + spaces(sp) + "}";
	}
	
	private static String spaces(int c)
	{
		String out = "";
		for(int i = 0; i < c; i++)
		{
			out = out + " ";
		}
		return out;
	}
}
