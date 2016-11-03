package algorithms;

import java.io.IOException;
import java.util.Scanner;

public class Driver {
	private Scanner input;
	private BruteAutoComplete bruteauto;
	
	public Driver()
	{
		input = new Scanner(System.in);
	}
	
	public static void main(String[] arg) throws IOException
	{
		Driver app = new Driver();
		app.run();
	}
	
	 private int menu(){ // Menu
	        System.out.println("  1) BruteAutoComplete");    
	        System.out.println("  0) Exit");
	        System.out.print("Enter option -> ");
	        int option = input.nextInt();
	        return option;
	    }
	
	private void run() throws IOException
	{
		int option = menu();
		while (option !=0)
		{
			switch (option)
			{
            case 1:    runBrute();
         	          	break;
            default:    System.out.println("Invalid option entered: " + option);
                        break;
			}
         option = menu();
		}
	}
	
	private void runBrute()throws IOException
	{
		bruteauto = new BruteAutoComplete();
		System.out.println("Please enter character(s) to autocomplete for ");
		System.out.println("--> ");
		String prefix = input.nextLine();
		prefix = input.nextLine(); // makes sure that prefix is entered at next line
		System.out.println("How many matches would you like?: "); 
		System.out.println("--> ");
		int k = input.nextInt();
		System.out.println(bruteauto.matches(prefix, k));	
	}
}