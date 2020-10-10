package itmo.zavar.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser 
{
	public static void main(String[] args) throws IOException 
	{
		File json = new File("src/itmo/zavar/parser/sample.json");
		String line, linesAsArray[];
        ArrayList<String> lines = new ArrayList<String>();
    	BufferedReader reader = null;
    	String jsonAsString = null;
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
				line.replace("\n", "");
			    lines.add(line);
				jsonAsString = jsonAsString + line;
				//System.out.println(line);
			}
			jsonAsString = jsonAsString.substring(4);
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
        
        jsonAsString = jsonAsString.substring(jsonAsString.indexOf('{')+1, jsonAsString.lastIndexOf('}')).trim();
        //System.out.println(jsonAsString);
        
        final String regex = "(\\\"\\w+\\\":)";//"(\\\"\\w+\\\":)\\s(\\[.*\\],)";

        final Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(jsonAsString);
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<String> work = new ArrayList<String>();
        int i = 0;
        
        while(matcher.find()) 
        {
        	res.add(matcher.group(1));
            //System.out.println(res.get(i));
            i++;
            res.add(jsonAsString.substring(matcher.end(1)));
        	//System.out.println(res.get(i));
        	i++;
        }
        //System.out.println();
        String ch = res.get(res.size()-2) + res.get(res.size()-1);
        work.add(ch);
        for(int y = 0; y < 2; y++)
        	res.remove(res.size()-1);
        
        for(int k = 0; k < (i-2)/2; k++)
        {
	        work.add(res.get(res.size()-2) + res.get(res.size()-1).substring(0, res.get(res.size()-1).indexOf(ch)));
	        for(int y = 0; y < 2; y++)
	        	res.remove(res.size()-1);
	        ch = work.get(work.size()-1) + ch;
        }
        
        Collections.reverse(work);
        
        //System.out.println(ch);
        
        for (String string : work) {
			System.out.println(string);
		}

        //System.out.println(res.get(res.size()-3));

        /*for (String string : work) {
			System.out.println(string);
		}*/
        
        
      //int i = 1;
    	//matcher = pattern.matcher();
        /*String[] str = jsonAsString.split(matcher.group(i));
        System.out.println(str[0]);
        matcher = pattern.matcher(str[1]);
        jsonAsString = str[1];*/
        //jsonAsString = jsonAsString.replaceAll(matcher.group(i), "").trim();
      //work with pairs
        
        //matcher = pattern.matcher(matcher.group(i-1));
        /*String test = matcher.group(2);
        
        matcher = pattern.matcher(test);
        if (matcher.find()) 
        {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }*/
        //(\"\w+\":)\s(\[.*\],)
	}
}
