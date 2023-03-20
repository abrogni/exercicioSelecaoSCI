package exe03;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/*
 * @author Antônio José Brogni
 */

public class Exe03 {

	public static void main(String[] args) {
		//formatacao para imprimir 2 casas decimais
		DecimalFormat df = new DecimalFormat("#.00");
		//chamada do metodo
		List<Aluno> alunos = registraAluno();
		//laço for faz a verificacao da media para aprovado ou reprovado
		for(Aluno aluno : alunos) {
			String aprovacao = "APROVADO"; 
			if(aluno.getMedia() < 6) {
				aprovacao = "REPROVADO";
			}
			//imprime os dados do aluno
			System.out.println(aluno.getNome() + ": Média = " + aluno.getMediaFormatada(df) + " Situação: " + aprovacao);
		}
	}

	/*
	 * método recebe os dados e registra um novo aluno
	 */
	public static List<Aluno> registraAluno() {
		Scanner sc = new Scanner(System.in);
		boolean continuar = true;
		List<Aluno> alunos = new ArrayList<>();
		
		//laço while para coletar as informacoes dos alunos
		while (continuar) {
			try {
				System.out.print("Digite o nome do aluno: ");
				String nome = sc.nextLine();

				System.out.print("Digite a primeira nota: ");
				double nota1 = sc.nextDouble();

				System.out.print("Digite a segunda nota: ");
				double nota2 = sc.nextDouble();

				System.out.print("Digite a terceira nota: ");
				double nota3 = sc.nextDouble();

				System.out.print("Digite a quarta nota: ");
				double nota4 = sc.nextDouble();

				sc.nextLine();

				//array para guardar apenas as notas de cada aluno
				List<Double> notas = new ArrayList<>();
				notas.add(nota1);
				notas.add(nota2);
				notas.add(nota3);
				notas.add(nota4);

				//cria um objeto aluno com os parametro nome e o array de notas
				Aluno aluno = new Aluno(nome, notas);
				alunos.add(aluno);

				boolean respostaValida = false;

				//recebe do usuario se quer adicionar ou nao um novo aluno
				while (!respostaValida) {
					System.out.println("Deseja registrar outro aluno? (s/n)");
					String resposta = sc.nextLine();

					if (resposta.equalsIgnoreCase("s")) {
						respostaValida = true;
					} else if (resposta.equalsIgnoreCase("n")) {
						continuar = false;
						respostaValida = true;

					} else {
						//trata para caso for lançado um valor invalido para continuar ou nao
						System.out.println("Erro: você deve digitar s para sim ou n para não. Tente novamente");
					}
				}

			} catch (InputMismatchException e) {
				//trata caso for lançado um valor invalido para nota
				System.out.println("Você digitou um valor inválido para nota. Tente novamente...");
				sc.nextLine(); //limpa o buffer do scanner
			}
		}
		sc.close();
		return alunos;

	}
	
	
	/*
	 * objeto aluno
	 */
	public static class Aluno {
		//atributos privados
		private String nome;
		private List<Double> notas;

		//construtor pedindo nome e o array de notas como parametro
		public Aluno(String nome, List<Double> notas) {
			this.nome = nome;
			this.notas = notas;
		}
		//getters
		public String getNome() {
			return nome;
		}

		public List<Double> getNotas() {
			return notas;
		}
		//get media retorna a media fazendo o calculo no array de notas do aluno
		public double getMedia() {
			double soma = 0;
			for(Double nota : notas) {
				soma += nota;
			}
			double resultado = soma / notas.size();
			return resultado;
		}
		
		//retorna a media formatada
		public String getMediaFormatada(DecimalFormat df) {
			return df.format(getMedia());
		}
	}
}
