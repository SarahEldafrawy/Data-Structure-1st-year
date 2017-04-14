package eg.edu.alexu.csd.datastructure.hangman.cs29;

import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 */
class Main {
	/**
	 * @param args for arguments?!
	 * @throws FileNotFoundException for empty file
	 */
	public static void main(final String[] args)
			throws FileNotFoundException {

		Scanner in = new Scanner(System.in);
		Hangman x = new Hangman();
		String[] words;
		words = x.readFromFile();
		x.setDictionary(words);
		String secretword = x.selectRandomSecretWord();
		System.out.println("Enter Max Wrong Guesses");
		int maxTries = in.nextInt();
		x.setMaxWrongGuesses(maxTries);
		int winner = 0;
		char ch;
		String stringDisplayed = x.guess(null);
		while (stringDisplayed != null) {
			System.out.println(stringDisplayed);
			ch = in.next().charAt(0);
			stringDisplayed = x.guess(ch);
	if (stringDisplayed != null && stringDisplayed.indexOf('-') == -1) {
				winner = 1;
				break;
			}
		}
		in.close();
		if (winner == 1) {
			System.out.println(stringDisplayed);
			System.out.println("You Won!!");
		} else {
			System.out.println("Try Again");
		}
	}

}
