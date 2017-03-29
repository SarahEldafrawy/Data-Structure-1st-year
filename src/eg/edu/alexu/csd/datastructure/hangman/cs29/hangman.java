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

public class hangman implements IHangman {

	public String[] readFromFile() throws FileNotFoundException {
		List<String> LinesInTheFile = new ArrayList<String>();
		BufferedReader ReadFromFile = new BufferedReader(new FileReader("Dictionary.txt"));
		String str;
		try {
			while ((str = ReadFromFile.readLine()) != null) {
				LinesInTheFile.add(str);
			}
			ReadFromFile.close();
			String[] ListOfWords = LinesInTheFile.toArray(new String[LinesInTheFile.size()]);

			return ListOfWords;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private int WrongGuessesLeft = 0;
	private String SecretWord;
	private String StringDisplayed; 
	private String[] words;
	//HashSet<Character> WrongGuessList = new HashSet <Character>();

	@Override
	public void setDictionary(String[] words) {
	    this.words = words;
	}

	@Override
	public String selectRandomSecretWord() {

		if (words == null || words.length == 0) {
			  return null;
		}
	//	WrongGuessList.clear();

		Date date = new Date();
		long diff = date.getTime();

		Random RandomNo = new Random();
		RandomNo.setSeed((diff % 5 + 13) % 7 - 3);
		int value = RandomNo.nextInt(words.length);
		SecretWord = words[value].toUpperCase();
		StringDisplayed = SecretWord;

		char[] tempStringDisplayed = StringDisplayed.toCharArray();
		for (int i = 0; i < StringDisplayed.length(); i++) {
			tempStringDisplayed[i] = '-';
		}
		StringDisplayed = String.valueOf(tempStringDisplayed);
		return SecretWord;
	}

	@Override
	public String guess(Character c) {

		if (c == null) {
			return StringDisplayed;
		}

		if (c >= 'a' && c <= 'z') {
			c = Character.toUpperCase(c);
		}
		int found = 0;
		if (StringDisplayed != null) {
			char[] tempStringDisplayed = StringDisplayed.toCharArray();
			for (int i = 0; i < StringDisplayed.length(); i++) {
				if (SecretWord.charAt(i) == c) {
					tempStringDisplayed[i] = c;
					found = 1;
				}
			}
			StringDisplayed = String.valueOf(tempStringDisplayed);
		}
		if (found == 0 /*&& !WrongGuessList.contains(c)*/) {
			WrongGuessesLeft--;
			//WrongGuessList.add(c);
		}
		if (WrongGuessesLeft <= 0) {
			return null;
		} else {
			return StringDisplayed;
		}
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		if (max == null) {
			WrongGuessesLeft = 0;
		} else {
			WrongGuessesLeft = max;
		}
	}
}
