package itmo.zavar.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class YAMLParser 
{
	public static void main(String[] args) 
	{
		File json = new File("src/itmo/zavar/parser/sample.yaml");
		String line, linesAsArray[];
        ArrayList<String> lines = new ArrayList<String>();
    	BufferedReader reader = null;
    	String yamlAsString = null;
    	List list = new Stack();
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
				//line.replace("\n", "");
			    lines.add(line);
				yamlAsString = yamlAsString + line; 
				System.out.println(line);
			}
			yamlAsString = yamlAsString.substring(4);
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
        
        if(linesAsArray[0].equals("---"))
        {

        }
        else
        {
        	System.out.println("It isn't a yaml");
        }
	}
	/*
	 * boolean found = false;
            while(!found)
            {
	            for(int i = 0; i < linesAsArray.length; i++)
	            {
	            	matcher = pattern.matcher(linesAsArray[i]);	
		            if(matcher.find()) 
		            {
		            	System.out.println("Found" + snum);
		            	found = true;
		            	//System.out.println(matcher.group(1));
		            	//System.out.println(yamlAsString.substring(matcher.end(1)));
		             	//res.add(matcher.group(1));
		                //i++;
		                //res.add(yamlAsString.substring(matcher.end(1)));
		             	//System.out.println(res.get(i));
		             	//i++;
		            }
	            }
	            snum++;
	            regex = "(^\\s{" + snum + "}\\w)";
	            pattern = Pattern.compile(regex);
            }
	 */
}
