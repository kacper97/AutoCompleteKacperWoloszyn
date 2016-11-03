package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.net.URL;
import java.io.IOException;
import java.io.BufferedReader; //Reads text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines.
import java.io.InputStreamReader; //bridge from byte streams to character streams: It reads bytes and decodes them into characters using a specified charset.

public class AutoCompleteAPI 
{
	public List<Term> termList = new ArrayList<Term>();

	public AutoCompleteAPI() throws IOException
	{
		createList();
	}

	private void createList() throws IOException  
	{
	  BufferedReader in= null; //Initializes buffer to null
	  try
		{
		in = new BufferedReader(new InputStreamReader(new URL("https://wit-computing.github.io/algorithms-2016/topic04/book-2/data/wiktionary.txt").openStream())); //Opens a connection to this URL and returns an InputStream for reading from that connection
		String inputLine;
		double weight;
		String word;
		String delims = "\t";   // the weight and the word is (delimited) by a space.
		in.readLine();
		 //reading the weights and terms
			while ((inputLine = in.readLine()) != null) // if the input line is not equal to null
			{
				String[] data= inputLine.split(delims); // split the line of data into a String[] by the tab divider
				weight = Double.parseDouble(data[0]); // changes weight from String to Double as it is read in from the Link
				word = data[1]; //data 1 is the second part of the read in url 
				termList.add(new Term (weight,word)); // adds term to an arraylist
				}
		
		 	}
		    finally 
		    {	
		    	if (in != null)
		    	{
		        in.close();
		    	}
		    }
	}
}

//delimiter is used if you want to divide up a phrase into words, or in this case each character.
