package Game;

import java.util.Random;

public class Words {
	
	private String[] randomWords = {"animals","happiness","indefinite","steady",
			"birthday","extreme","rights","properties","ceremony","independence",
			"beneath","information","students","employee","hola","vida","universidad"};
	
	private String selectedWord;
	
	private Random random = new Random();
	
	private char[] letters; //una lista con cada una de las letras de la palabra elegida [a,g,u,a]
	
	public Words() { //Constructor
		//Esto hace que se seleccione un random dentro del largo de la lista por su indice(0 a 13)
		selectedWord = randomWords[random.nextInt(randomWords.length)];
		letters = new char[selectedWord.length()];
		
	}
	
	public String toString() {
		
		StringBuilder text = new StringBuilder();
		
		for(char letter:letters) {
			//si la letra es nula, añade el guión, si no, añade la letra
			text.append(letter == '\u0000'? '-':letter);
						//null
//			if(letter == '\u0000') {
//				text.append('-');
//			}
//			else {
//				text.append(letter) ;
//			}
			text.append(" ");
		}
		return text.toString(); 
		
		
	}
	
	public boolean isGuessedRight() {
		for(char letter: letters) {
			if(letter == '\u0000') {
				return false;
			}
		}
		return true;
	}

	public boolean guess(char letter) {
		
		boolean guessedRight = false;
		
		
		for(int i = 0; i < selectedWord.length();i++) {
			if (letter == selectedWord.charAt(i)) {
				letters[i] = letter;
				guessedRight = true;
			}
		}
		
		return guessedRight;
	}
	
	

}
