package eg.edu.alexu.csd.datastructure.hangman.cs29;

import java.io.*;

class TestHangman{
	
	public static void main(String[] args) {
	
	hangman x= new hangman();
	String[] words= { "hyThm21"};
	x.setDictionary(words);
	String secretword=x.selectRandomSecretWord();
	System.out.println(secretword);
	x.setMaxWrongGuesses(2);
	
	String ch=x.guess(null);
	System.out.println(ch);
	
		
	}
	
 }


