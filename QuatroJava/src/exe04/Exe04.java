package exe04;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * @author Antônio José Brogni
 */

public class Exe04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//cria um vetor de 5 posicoes
		int[] vetor = new int[5];
		int i = 0;
		//laço while armazena os valores no vetor
		while (i < vetor.length) {
			try {
				//%d possibilita pedir todos os valores na mesma linha de codigo
				System.out.printf("Digite o %d valor: ", i + 1);
				vetor[i] = sc.nextInt();
				i++;
				//trata para o caso de ser lancado um valor invalido
			} catch (InputMismatchException e) {
				System.out.println("ERRO! Digite apenas números inteiro...");
				sc.next();
			}
		}
		sc.close();
		//imprime o terceiro valor do vetor usando o numero 2 como parametro pois o vetor comeca pelo 0
		System.out.println("O terceiro valor do vetor é: " + vetor[2]);
	}

}
