package eg.edu.alexu.csd.datastructure.hangman.cs29;

import java.io.*;
import java.util.Scanner;

class main {
	public static void maintest(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(System.in);
		hangman x = new hangman();
		String[] words;
		words = x.readFromFile();
		x.setDictionary(words);
		String secretword = x.selectRandomSecretWord();
		System.out.println("Enter Max Wrong Guesses");
		int MaxTries = in.nextInt();
		x.setMaxWrongGuesses(MaxTries);
		int winner = 0;
		char ch;
		String StringDisplayed = x.guess(null);
		while (StringDisplayed != null) {
			System.out.println(StringDisplayed);
			ch = in.next().charAt(0);
			StringDisplayed = x.guess(ch);
			if (StringDisplayed != null && StringDisplayed.indexOf('-') == -1){
				winner = 1;
				break;
			}
		}
		in.close();
		if (winner == 1) {
			System.out.println(StringDisplayed);
			System.out.println("You Won!!");
		}else {
			System.out.println("Try Again");
		}
	}

 }