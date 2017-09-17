import java.util.Scanner;
public class Finite_Automata 
{

	public static void main(String[] args) 
	{
		Scanner scnr = new Scanner(System.in);
		System.out.print("Enter the number of states: ");
		int states = scnr.nextInt();
		System.out.print("Enter the number of symbols: ");
		int symbols = scnr.nextInt();
		
		Automata a = new Automata();
		a.create_Automata(states, symbols);
		
	}

}
