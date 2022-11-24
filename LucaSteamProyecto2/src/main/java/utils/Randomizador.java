package utils;

import java.util.Random;

public class Randomizador {
	public static Random random = new Random();
	public static int randomNumber(int limInferior, int limSuperior) {
		int n = random.nextInt(limSuperior + 1 - limInferior); //+1 para que esten ambos incluidos
		n+=limInferior;
		return n;
	}
}
