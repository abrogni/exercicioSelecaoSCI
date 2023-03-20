package exe01;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/*
 * @author Antônio José Brogni
 */

public class Exe01 {
	public static void main(String[] args) {
		//chamada dos metodos
		List<Integer> numeros = guardaNumeros();
		Resultado resultado = parOuImpar(numeros);
		// retorno
		System.out.println("Números pares: " + resultado.getPares());
		System.out.println("Números ímpares: " + resultado.getImpares());
		System.out.println("Média geral: " + calculaMedia(numeros));

	}

	/*
	 * método solicita 5 valores inteiros e armazena em uma lista
	 * o while já valida para não ocorrer mais de 5 valores
	 * try catch trata a excessao de caso o valor lançado não for um número inteiro
	 */
	public static List<Integer> guardaNumeros() {
		//cria a lista de numeros inteiros
		List<Integer> numeros = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		//pede ao usuario para lançar os valores
		System.out.print("Digite 5 valores inteiros: ");
		while (numeros.size() < 5) {
			try {
				//adiciona os valores na lista
				int n = sc.nextInt();
				numeros.add(n);
			  //trata a excessao caso for digitado algo diferente de um numero inteiro
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
	 * percorre a lista e separa os valores pares dos impares cria um objeto
	 * resultado e adiciona o valor em sua devida lista
	 */
	public static Resultado parOuImpar(List<Integer> numeros) {
		//cria uma lista para pares e outra para impares
		List<Integer> pares = new ArrayList<Integer>();
		List<Integer> impares = new ArrayList<Integer>();

		//percorre o array de numeros
		for (int numero : numeros) {
			//se o resto da divisao for igual a 0 é par
			//se nao for é impar
			if (numero % 2 == 0) {
				pares.add(numero);
			} else {
				impares.add(numero);
			}
		}
		//retorno criando um objeto resultado e dando como parametros os valores pares e impares
		return new Resultado(pares, impares);
	}

	/*
	 * metodo calcula a média somando todos os valores da primeira lista e dividindo
	 * para o numero de valores da lista
	 */
	public static double calculaMedia(List<Integer> numeros) {
		//percorre o array de todos os numeros e guarda a soma de todos na variavel soma
		int soma = 0;
		for (int numero : numeros) {
			soma += numero;
		}
		//retorno do etodo é feito um cast pois o valor pode ser do tipo float
		//tambem é feito a divisao pelo tamanho do array numeros ou seja por quantos valores o array guarda
		return (double) soma / numeros.size();
	}

	/*
	 * classe resultado com os atributos pares e impares
	 */
	public static class Resultado {
		//atributos privados de resultado
		private List<Integer> pares;
		private List<Integer> impares;

		//construtor pedindo as listas de pares e impares como parametros
		public Resultado(List<Integer> pares, List<Integer> impares) {
			this.pares = pares;
			this.impares = impares;
		}

		//getters
		public List<Integer> getPares() {
			return pares;
		}

		public List<Integer> getImpares() {
			return impares;
		}
	}
}
