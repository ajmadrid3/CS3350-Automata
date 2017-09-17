import java.util.Scanner;
public class Automata 
{
	private int n;
	private int m;
	private int[][] state;
	private boolean[] final_state;
	Scanner scnr = new Scanner(System.in);
	
	public void create_Automata(int num_states, int num_symbols)
	{
		n = num_states;
		m = num_symbols;
		state = new int[n][m];
		final_state = new boolean[n];
		for(int current_state = 0; current_state < n; current_state++)
		{
			for(int symbol = 0; symbol < m; symbol++)
			{
				System.out.print("From state " + current_state + ", " + symbol + " will lead to: ");
				state[current_state][symbol] = scnr.nextInt();
			}
		}
		for(int current_state = 0; current_state < n; current_state++)
		{
			System.out.print("Is state " + current_state + " a final state (Enter true or false): ");
			final_state[current_state] = scnr.nextBoolean();
		}
		System.out.println("Automata created.");
	}
	
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
}
