package algorithms;

public class Term {
	
	private double weight;
	private String word;
	
	
	public Term (double weight, String word)
	{
		this.weight = weight;
		this.word = word;
	}
	
	//getters
	public double getWeight()
	{
		return weight;
	}
	
	public String getword()
	{
		return word;
	}
}