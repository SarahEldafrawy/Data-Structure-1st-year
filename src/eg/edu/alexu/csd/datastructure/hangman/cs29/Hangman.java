package eg.edu.alexu.csd.datastructure.hangman.cs29;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import eg.edu.alexu.csd.datastructure.hangman.IHangman;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
/**
 */
public class Hangman implements IHangman {
	/**
	 * @return dictionary
	 * @throws FileNotFoundException for empty file
	 */
	public String[] readFromFile() throws FileNotFoundException {
		List<String> linesInTheFile = new ArrayList<String>();
		BufferedReader readFromFile =
		new BufferedReader(new FileReader("Dictionary.txt"));
		String str;
		try {
		while ((str = readFromFile.readLine()) != null) {
			linesInTheFile.add(str);
		}
		readFromFile.close();
		String[] listOfWords =
		linesInTheFile.toArray(new String[linesInTheFile.size()]);

		return listOfWords;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	/**
	 */
	private int wrongGuessesLeft = 0;
	/**
	 */
	private String secretWord;
	/**
	 */
	private String stringDisplayed;
	/**
	 */
	private String[] words;
	//HashSet<Character> WrongGuessList = new HashSet <Character>();
	/**
	 */
	@Override
	public void setDictionary(final String[] words) {
	    this.words = words;
	}
	/**
	 */
	@Override
	public String selectRandomSecretWord() {

		if (words == null || words.length == 0) {
			  return null;
		}
	//	WrongGuessList.clear();

		Date date = new Date();
		long diff = date.getTime();

		Random randomNo = new Random();
		randomNo.setSeed((diff % 5 + 13) % 7 - 3);
		int value = randomNo.nextInt(words.length);
		secretWord = words[value].toUpperCase();
		stringDisplayed = secretWord;

		char[] tempStringDisplayed = stringDisplayed.toCharArray();
		for (int i = 0; i < stringDisplayed.length(); i++) {
			tempStringDisplayed[i] = '-';
		}
		stringDisplayed = String.valueOf(tempStringDisplayed);
		return secretWord;
	}
	/**
	 */
	@Override
	public String guess(final Character c) {
		if (c == null) {
			return stringDisplayed;
		}
		char ch = c;
		if (c >= 'a' && c <= 'z') {
			ch = Character.toUpperCase(c);
		}
		int found = 0;
		if (stringDisplayed != null) {
		char[] tempStringDisplayed = stringDisplayed.toCharArray();
			for (int i = 0; i < stringDisplayed.length(); i++) {
				if (secretWord.charAt(i) == ch) {
					tempStringDisplayed[i] = ch;
					found = 1;
				}
			}
			stringDisplayed = String.valueOf(tempStringDisplayed);
		}
		if (found == 0 /*&& !WrongGuessList.contains(c)*/) {
			wrongGuessesLeft--;
			//WrongGuessList.add(c);
		}
		if (wrongGuessesLeft <= 0) {
			return null;
		} else {
			return stringDisplayed;
		}
	}
	/**
	 */
	@Override
	public void setMaxWrongGuesses(final Integer max) {
		if (max == null) {
			wrongGuessesLeft = 0;
		} else {
			wrongGuessesLeft = max;
		}
	}
}
