package algorithms;

public class BruteAutoComplete implements AutoComplete{
	AutoCompleteAPI terms;  //implementing terms from AutoCompleteAPI
	private double weightOfWord; // private field
	
	@Override
	public double weightOf(String term)// returns the weight of the term, or 0.0 if no such term exists.
	{
		weightOfWord= 0.0; // initializing private field to 0
		if(term != null) // checks if term is not null, i.e it exists
		{
			for(int i=0; i<terms.termList.size(); i++)// iterates through the arraylist of word against the entered term
			{
				if(term.equals(terms.termList.get(i).getWord()))// if i equals to the specified weight
				{
					return terms.termList.get(i).getWeight(); //return the weight
				}
			}
		}
		return weightOfWord; //returns 0 as no weight for that Word has been found
	}

	@Override
	public String bestMatch(String prefix) // returns the highest matched word or null if no matched words exist
	{
		String bestTerm = null;
		if(prefix !=null) //if prefix is not empty go into the loop 
		{
			Boolean matchObtained = false; // Initializing to false 
			for(int i=0; matchObtained ==false && i<terms.termList.size(); i++) // for int i, matchfound is false AND (&&) i is less then the value of terms in the arrayList.
			{
				matchObtained =true;
				return terms.termList.get(i).getWord();
			}
			
		}
		return bestTerm;
	}

	@Override
	public Iterable<String> matches(String prefix, int k) {
		// TODO Auto-generated method stub
		return null;
	}
	
}