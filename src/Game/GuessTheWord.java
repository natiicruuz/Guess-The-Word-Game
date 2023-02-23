package Game;

import java.util.Scanner;
//LOOP DO WHILE, porque necesitamos que la 1ra interacción ocurra siempre, 
//porque no se puede perder en el 1er intento.

/*Vamos a 
1. mostrar una palabra o espacios en blanco de la palabra que el jugador tiene que adivinar.
2. 2. Pedir al jugador que introduzca la palabra
3. Comprobar la entrada*/

public class GuessTheWord {

	private boolean play = true; //activa el loop 

	private Words randomWord = new Words(); //llama a clase Words

	private Scanner scanner = new Scanner(System.in);

	private int rounds = 10; 

	private char lastRound; //char size: valor minimo: '\u0000' (o 0) y valor maximo: '\uffff

	public void start() {
		do { //esto es para que se ejecuten siempre estos 3 metodos en cada ronda mientras se juega

			showWord(); // Mostrar la palabra al jugador
			getInput();// Obtener la entrada que ha añadido el jugador
			checkInput();//comprobar la entrada

		} while (play);
	}

	void showWord() {
		System.out.println(randomWord);
		System.out.println("Te quedan: "+rounds+" intentos!");
	}

	void getInput() {
		System.out.println("Ingresa una letra para adivinar la palabra: ");
		String userGuess = scanner.nextLine();
		lastRound = userGuess.charAt(0); //El método charAt() devuelve el carácter en el índice especificado en una cadena, en este caso pos 0
	}

	void checkInput() {

		boolean isGuessedRight = randomWord.guess(lastRound);

		if (isGuessedRight) { 
			if (randomWord.isGuessedRight()) {
				System.out.println("Felicidades, has ganado!");
				System.out.println("La palabra es: " + randomWord);
				play = false; //se acaba el juego, el loop
			}
		}
		else {
			rounds--; //pierde intentos
			
			if (rounds == 0) {
				System.out.println("JUEGO TERMINADO! :(");
				play = false; //se acaba el juego, el loop
			}
		}
	}

	public void end() {
		scanner.close();

	}
}
