package eg.edu.alexu.csd.datastructure.hangman.cs29;

import java.io.*; // for files to make the function
import java.util.*;
import eg.edu.alexu.csd.datastructure.hangman.IHangman;
import java.util.Date;

public class hangman implements IHangman {
	
	/*public String[] readFromFile(){
		
	File dictionary = new File ("Dictionary.txt");	
	dictionary.createNewFile();
	FileReader fr = new FileReader (dictionary);

	
         
      return ListOfWords;     
	}*/
	
	private int WrongGuessesLeft=0;
	private String SecretWord;
	private String StringDisplayed; 
	private String[] words;
	
	@Override
	public void setDictionary(String[] words) {
	    this.words=words;  
	}
	
	@Override
	public String selectRandomSecretWord() {
		
		if (words == null) {
			  return null;	
		}
		Date date = new Date();
		long diff = date.getTime();
		
		Random RandomNo = new Random();
		RandomNo.setSeed((diff%5+13)%7-3);
		int value = RandomNo.nextInt(words.length);
		SecretWord = words [value].toUpperCase();
		StringDisplayed=SecretWord;
		
		char tempStringDisplayed[]=StringDisplayed.toCharArray();
		for(int i = 0; i < StringDisplayed.length(); i++){
			tempStringDisplayed[i]='_'; 
		}
		StringDisplayed=String.valueOf(tempStringDisplayed);
		return SecretWord;
	}

	@Override
	public String guess(Character c) {
		
		//loop for wrong guesses to check letters repeated should be implemented here 
		if(c == null){
			return StringDisplayed;
		}
		
		if(c >='a' && c <= 'z'){
			c = Character.toUpperCase(c);
		}
		int i,found=0;
		char tempStringDisplayed[]=StringDisplayed.toCharArray();
		
		for(i = 0; i < StringDisplayed.length(); i++){
		      if(SecretWord.charAt(i)==c){
		    	  tempStringDisplayed[i] =c;
		    	  found=1;
		      }
		}
		StringDisplayed=String.valueOf(tempStringDisplayed);
		if(found==0){
			WrongGuessesLeft--;
		}
		if( WrongGuessesLeft <=0){
			return null;
		}else{
			return StringDisplayed;
		}
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		if(max==null){
			WrongGuessesLeft=0;
		}else{
			WrongGuessesLeft=max;
		}
	}
	
}