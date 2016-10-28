package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.net.URL;
import java.io.IOException;
import java.io.BufferedReader; //Reads text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines.
import java.io.InputStreamReader; //bridge from byte streams to character streams: It reads bytes and decodes them into characters using a specified charset.

public class AutoCompleteAPI 
{
	private static final String urlData = "https://wit-computing.github.io/algorithms-2016/topic04/book-2/data/wiktionary.txt";
	public List<Term> termList = new ArrayList<Term>();

	public AutoCompleteAPI() throws IOException
	{
		createList();
	}

	private void createList() throws IOException  
	{
	  BufferedReader in= null; 
	  try
		{
		in = new BufferedReader(new InputStreamReader(new URL(urlData).openStream())); //Opens a connection to this URL and returns an InputStream for reading from that connection
		String inputLine;
		double weight;
		String word;
		String delims = "\t";   // the weight and the word is (delimited) by a space.
		in.readLine();
		 //reading the weights and terms
			while ((inputLine = in.readLine()) != null)
			{
				String[] dataList= inputLine.split(delims); // parse user details string
				weight = Double.parseDouble(dataList[0]); // changes weight from String to Double as it is read in from the Link
				word = dataList[1];
				termList.add(new Term (weight,word));
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
