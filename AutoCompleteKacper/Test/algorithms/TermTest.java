package algorithms;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class TermTest {
	private AutoCompleteAPI terms;
	private Term term5;
	private Term term100;
	private Term term400;
	private Term term9999;
	
	@Before 
	public void setUp() throws IOException 
	{
		terms = new AutoCompleteAPI();
		term5 = new Term(1742063600, "in");
		term100 = new Term(92305300, "men");
		term400 = new Term(21129900.0, "mean");
		term9999 = new Term(392402, "wench");
	}
	
	//Tests 4 different known terms 
	public void testCreateList() 
	{
		//asserts if the weight and word of the term are what expected
		assertEquals(terms.termList.get(4).getWeight(), term5.getWeight(), 0.01);
		assertEquals(terms.termList.get(4).getWord(), term5.getWord());
		assertEquals(terms.termList.get(99).getWeight(), term100.getWeight(), 0.01);
		assertEquals(terms.termList.get(99).getWord(), term100.getWord());
		assertEquals(terms.termList.get(399).getWeight(), term400.getWeight(), 0.01);
		assertEquals(terms.termList.get(399).getWord(), term400.getWord());
		assertEquals(terms.termList.get(9998).getWeight(), term9999.getWeight(), 0.01);
		assertEquals(terms.termList.get(9998).getWord(), term9999.getWord());
	}
	
	//Tests to make sure the overall list size is 10000 terms long, which was what was provided to us.
	@Test
	public void testListSize()
	{
		assertEquals(terms.termList.size(), 10000);
	}

}