/*
 * Andrew Madrid
 * CS 3350 - Automata
 * Assignment - General Finite Automaton
 * Fall 2017
 * Purpose:
 * 	This class acts as a menu system for the program.  This will allow the user
 * 	to choose which option to select.  
 */
import java.util.Scanner;
public class Finite_Automata 
{
	public static void main(String[] args) 
	{
		// Creates a new Automata at the start.
		Scanner scnr = new Scanner(System.in);
		System.out.print("Enter the number of states: ");
		int states = scnr.nextInt();
		System.out.print("Enter the number of symbols: ");
		int symbols = scnr.nextInt();
		
		Automata a = new Automata();
		a.create_Automata(states, symbols);
		
		int option = 0;
		while(option != 4)
		{
			System.out.println("What would you like to do?");
			System.out.println("1 - Check a Sentence");
			System.out.println("2 - Print Automata");
			System.out.println("3 - Create a new Automata");
			System.out.println("4 - Exit Program");
			System.out.print("Enter Choice: ");
			option = scnr.nextInt();
			
			// Validate a sentence.
			if(option == 1)
			{
				System.out.println("\nInput a sentence: ");
				String sentence = scnr.next();
				int[] input = new int[sentence.length()];
				for(int i = 0; i < sentence.length(); i++)
					input[i] = Character.getNumericValue(sentence.charAt(i));
				
				boolean valid = a.check_Sentence(input);
				
				if(valid)
					System.out.println("The sentence is accepted.\n");
				else
					System.out.println("The sentence is not accepted.\n");
			}
			// Print Automata.
			else if(option == 2)
			{
				a.print_Automata();
			}
			// Create a new Automata.
			else if(option == 3)
			{
				System.out.print("Enter the number of states: ");
				states = scnr.nextInt();
				System.out.print("Enter the number of symbols: ");
				symbols = scnr.nextInt();
				a.create_Automata(states, symbols);
			}
			// Exit program.
			else if(option == 4)
			{
				System.out.println("Ending program.");
			}
			// Invalid input, returns to start.
			else
			{
				System.out.println("Invalid option entered.");
			}
		}
	}

}
