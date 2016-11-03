package algorithms;

import java.util.ArrayList;
import java.io.IOException;

public class BruteAutoComplete implements AutoComplete{
	AutoCompleteAPI terms;  //implementing terms from AutoCompleteAPI
	private double weightOfWord; // private field
	private ArrayList<String> matches; // array list of matches
	
	public BruteAutoComplete() throws IOException
	{
		terms = new AutoCompleteAPI(); // links autoCompleteApi to BruteAutoComplete
	}
	
	@Override
	public double weightOf(String term)// returns the weight of the term, or 0.0 if no such term exists.
	{
		weightOfWord= 0.0; // initializing private field to 0
		if(term != null) // checks if term is not null, i.e it exists
		{
			for(int i=0; i<terms.termList.size(); i++) //for int i is less then the termlist array 
			{
				if(term.equals(terms.termList.get(i).getWord()))// if i equals to the specified weight of a word
				{
					return terms.termList.get(i).getWeight(); //return the weight
				}
			}
		}
		return weightOfWord; //returns 0.0 as no weight for that Word has been found, so no word
	}

	@Override
	public String bestMatch(String prefix) // returns the highest matched word or null if no matched words exist
	{
		if(prefix !=null)  
		{
			for(int i=0; i<terms.termList.size(); i++) // for i is less then the value of terms in the arrayList.
			{
				if(terms.termList.get(i).getWord().startsWith(prefix))  //if terms in termlist array get index and get word and if the word starts with prefix then 
				{
					return terms.termList.get(i).getWord(); // return word in termlist array
				}
			}
		}
		return null; // else return null, i.e no matched words
	}

    // Returns the highest weighted k matching terms (in descending order of weight), as an
    // iterable.
    // If fewer than k matches, return all matching terms (in descending order
    // of weight).
	
	@Override
	public Iterable<String> matches(String prefix, int k)  // k = number of matching terms
	{
		matches = new ArrayList<String>(); // puts in matches found in an array list
		if(prefix == null)
		{
			return null;
		}
		if(k<terms.termList.size() && k>0)  // if k is less then the array list size and greater then 0
		{
			for(int i = 0; matches.size()<k && i<terms.termList.size(); i++) // matches array size is less k and index is less then value of termlist array size
			{
				if(terms.termList.get(i).getWord().startsWith(prefix) && matches.size()<k) // if termlist array has the word then get its start prefix and  if match array size is less then number of matching terms
				{
					matches.add(terms.termList.get(i).getWord()); // adds words to the matches array list
				}
			}
		}
		
		if(matches.size()==0)
		{
			return null;
		}
	  return matches;
	}

}
