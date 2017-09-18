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
		
		a.print_Automata();
		
		System.out.println("Input a sentence: ");
		String sentence = scnr.next();
		int[] input = new int[sentence.length()];
		for(int i = 0; i < sentence.length(); i++)
		{
			input[i] = Character.getNumericValue(sentence.charAt(i));
		}
		boolean valid = a.check_Sentence(input);
		if(valid)
		{
			System.out.println("The sentence is accepted.");
		}
		else
		{
			System.out.println("The sentence is not accepted.");
		}
	}

}
