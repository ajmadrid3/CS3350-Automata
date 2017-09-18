/*
 * Andrew Madrid
 * CS 3350 - Automata
 * Assignment - General Finite Automaton
 * Fall 2017
 * Purpose: 
 * 	This class is used to create a finite automata.  All of the necessary requirements
 * 	are included when the user creates a new automata.  There are also methods that are 
 * 	used to either print the automata or will validate a sentence that the user enters.
 */
import java.util.Arrays;
import java.util.Scanner;
public class Automata 
{
	private int n;								// Number of States
	private int m;								// Number of Symbols
	private int[][] state;						// state[current state][value received] = next state
	private boolean[] final_state;				// Final States
	Scanner scnr = new Scanner(System.in);
	
	// Creates a new automata give the number of states and the number of symbols.
	public void create_Automata(int num_states, int num_symbols)
	{
		n = num_states;
		m = num_symbols;
		state = new int[n][m];
		final_state = new boolean[n];
		
		// User enters the paths for each state.
		for(int current_state = 0; current_state < n; current_state++)
		{
			for(int symbol = 0; symbol < m; symbol++)
			{
				System.out.print("From state " + current_state + ", " + symbol + " will lead to: ");
				state[current_state][symbol] = scnr.nextInt();
			}
		}
		
		// User enters which states are final states.
		for(int current_state = 0; current_state < n; current_state++)
		{
			System.out.print("Is state " + current_state + " a final state (Enter true or false): ");
			final_state[current_state] = scnr.nextBoolean();
		}
		System.out.println("Automata created.\n");
	}
	
	// Checks if the given sentence is accepted by the automata.
	public boolean check_Sentence(int[] input)
	{
		int current_state = 0;
		for(int i = 0; i < input.length; i++)
		{
			current_state = state[current_state][input[i]];
		}
		if(final_state[current_state])
		{
			return true;
		}
		return false;
	}
	
	// Prints the automata.
	public void print_Automata()
	{
		System.out.println("\nNumber of States (N): " + n);
		System.out.println("Number of Symbols (M): " + m);
		for(int i = 0; i < state.length; i++)
		{
			for(int j = 0; j < state[i].length; j++)
			{
				System.out.println("State[" + i + "][" + j + "] = " + state[i][j]);
			}
		}
		System.out.println("Final: " + Arrays.toString(final_state) + "\n");
	}
}
