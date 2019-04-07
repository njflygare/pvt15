import java.util.Random;
import java.util.Scanner;
public class GuessingGame {
	static Random rnd = new Random();
	static int secret;
	static int range;
	static int guessCount;
	static int loops;
	static int totalGuesses;
	static int minGuess;
	static int maxGuess;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		//System.out.println("Enter range: ");
		//range = scn.nextInt();
		loops = 1;
		totalGuesses = 0;
		for(int i = 0; i < loops; i++) {
			range = 200;
			generateSecret(range);
			startGuessing();
		}
		// Statistics
		System.out.println("Average guess count: " + totalGuesses/loops);
		System.out.println("Minimum amount of guesses: " + minGuess + ". Maximum amount of guesses: " + maxGuess + ".");
		scn.close();
		FibonacciBad fiBad = new FibonacciBad();
		for (int i = 1; i < 30; i++) System.out.println(fiBad.fibo(i));
		
		
	}

	public static void generateSecret(int range) {
		secret = rnd.nextInt(range)+1;
	}

	public static void startGuessing() {
		Boolean victory = false;
		int guess = range/2; // Start at midpoint. Best search
		//int guess = rnd.nextInt(range)+1; // Start at random
		int minPossible = 1;
		int maxPossible = range;
		
		while(!victory) {
			if (guess == secret) {
				victory = true; 
				System.out.println("Victory! Secret: " + secret + " After " + guessCount + " guesses.");
				if (guessCount > maxGuess) {maxGuess = guessCount;}
				if (guessCount < minGuess || minGuess == 0) {minGuess = guessCount;}
				totalGuesses += guessCount;
				guessCount = 1;
			}

			else if (guess > secret) {
				System.out.println(guess + " is too high! (" +secret + ")");
				maxPossible = guess-1;
				guess = minPossible+(maxPossible-minPossible)/2;
				guessCount++;
			}

			else {
				System.out.println(guess + " is too low! (" +secret + ")");
				minPossible = guess+1;
				guess = minPossible+(maxPossible-minPossible)/2;
				guessCount++;
			}
		}
	}
}
