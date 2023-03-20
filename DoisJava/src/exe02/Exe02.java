package exe02;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/*
 * @author Antônio José Brogni
 */

public class Exe02 {

	public static void main(String[] args) {
		//chamada do metodo 
		List<Integer> numeros = guardaNumeros();
		System.out.println("Maior valor: " + maiorValor(numeros));
		System.out.println("Menor valor: " + menorValor(numeros));
	}

	/*
	 * método solicita 5 valores inteiros e armazena em uma lista o while já valida
	 * para não ocorrer mais de 5 valores
	 * try catch trata a excessao de caso o valor lançado não for um número inteiro
	 */
	public static List<Integer> guardaNumeros() {
		List<Integer> numeros = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite 5 valores inteiros: ");
		while (numeros.size() < 5) {
			try {
				int n = sc.nextInt();
				numeros.add(n);
			} catch (InputMismatchException e) {
				System.out.println("Valor inválido, digite apenas números inteiros.");
				//pula para o próximo valor a ser digitado
				sc.next(); 
			}
		}
		sc.close();
		return numeros;
	}

	/*
	 * metodo percorre a lista de todos os valores e verifica qual o menor valor
	 */
	public static int menorValor(List<Integer> numeros) {
		int menor = numeros.get(0);
		//variavel menor recebe o primeiro valor do array
		//se houver um numero menor que o primeiro valor a variavel menor recebe este numero
		for (int i = 0; i < numeros.size(); i++) {
			if (numeros.get(i) < menor) {
				menor = numeros.get(i);
			}
		}
		return menor;
	}

	/*
	 * metodo percorre a lista de todos os valores e verifica qual o maior valor
	 */
	public static int maiorValor(List<Integer> numeros) {
		int maior = numeros.get(0);
		//variavel maior recebe o primeiro valor do array
		//se houver um numero maior que o primeiro valor a variavel maior recebe este numero
		for (int i = 0; i < numeros.size(); i++) {
			if (numeros.get(i) > maior) {
				maior = numeros.get(i);
			}
		}
		return maior;
	}

}
