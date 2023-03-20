package exe05;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * @author Antônio José Brogni
 */

public class Exe05 {
	public static void main(String[] args) {
		// chamada dos metodos
		Object[][] dadosAlunos = registraAluno();
		imprimeDados(dadosAlunos);
		coletaNome(dadosAlunos);

	}

	/*
	 * cria a matriz bidimensional e armazena os tres alunos com suas notas trata
	 * tambem caso o usuario insira um valor inválido para nota
	 */
	public static Object[][] registraAluno() {
		Scanner sc = new Scanner(System.in);
		// matriz bidimensional com 3 linhas para alunos e 5 colunas para nome e 4 notas
		Object[][] dadosAlunos = new Object[3][5];

		// laço for guarda em cada linha as informacoes de cada aluno
		for (int i = 0; i < dadosAlunos.length; i++) {
			System.out.print("Digite o nome do " + (i + 1) + "° aluno: ");
			String nome = sc.nextLine();
			dadosAlunos[i][0] = nome;
			// try trata caso o usuario lançe um valor que nao seja valido para nota
			// não se limita a 10, pois no enunciado não dava tal informacao
			try {
				// for aninhado guarda as 4 notas de cada aluno
				for (int j = 1; j < dadosAlunos[i].length; j++) {
					System.out.print("Digite a " + (j) + "° nota de " + nome + ": ");
					double nota = sc.nextDouble();
					dadosAlunos[i][j] = nota;
				}
			} catch (InputMismatchException e) {
				// para no caso da excessao de valor invalido
				System.out.println("Você digitou um valor inválido para nota. Tente novamente...");
				sc.nextLine();
			}
			sc.nextLine();
		}
		sc.close();
		return dadosAlunos;
	}

	/*
	 * metodo calcula a media do aluno
	 */
	public static double calculaMedia(Object[] aluno) {
		double soma = 0;
		//laço for percorre as notas de cada aluno e soma
		for (int j = 1; j < aluno.length; j++) {
			soma += (double) aluno[j];
		}
		//divide a soma total pelo tamanho da matriz -1 pois a primeira coluna armazena o nome do aluno
		double media = soma / ((aluno.length) - 1);
		return media;
	}

	/*
	 * metodo coleta os nomes dos alunos e armazena em uma matriz separada para
	 * possibilitar o tratamento dos dados
	 */
	public static String[] coletaNome(Object[][] dadosAlunos) {
		String[] nomes = new String[dadosAlunos.length];
		//for percorre os alunos e guarda o nome no array nomes
		for (int i = 0; i < dadosAlunos.length; i++) {
			nomes[i] = dadosAlunos[i][0].toString();
		}
		return nomes;
	}

	/*
	 * metodo analisa entre os alunos a menor e a maior média e imprime as medias de
	 * todos e o aluno que teve e maior e a menor media
	 */
	public static void imprimeDados(Object[][] dadosAlunos) {
		//declaracao das variaveis necessarias para os calculos
		double menorMedia = Double.MAX_VALUE;
		double maiorMedia = Double.MIN_VALUE;
		String nomeMenorMedia = "";
		String nomeMaiorMedia = "";

		//chamada do metodo coletaNome
		String[] nomes = coletaNome(dadosAlunos);

		//laço for percorre a lista coleta o nome do array nomes e as notas do array dadosAlunos
		//e em seguida chama o metodo do calculo da media
		for (int i = 0; i < dadosAlunos.length; i++) {
			String nome = nomes[i];
			Object[] aluno = dadosAlunos[i];
			double media = calculaMedia(aluno);
			
			//imprime os dados de cada aluno
			System.out.println(nome + ": Média de = " + String.valueOf(media));

			//laços if verificam a maior e a menor media
			if (media < menorMedia) {
				menorMedia = media;
				nomeMenorMedia = nome;
			}

			if (media > maiorMedia) {
				maiorMedia = media;
				nomeMaiorMedia = nome;
			}
		}
		//imprime a maior e a menor media
		System.out.println("Maior média: " + nomeMaiorMedia + " = " + String.valueOf(maiorMedia));
		System.out.println("Menor média: " + nomeMenorMedia + " = " + String.valueOf(menorMedia));
	}

}
