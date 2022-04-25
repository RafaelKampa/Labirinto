package principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Labirinto {
	public int[][] labirinto;
	public LinkedList<Movimentacao> caminho = new LinkedList<Movimentacao>();
	public Movimentacao inicio;
	
	
	protected static ArrayList<Labirinto> obterLabirintos() throws FileNotFoundException {
		ArrayList<Labirinto> labirintos = new ArrayList<Labirinto>();
		Scanner sc = new Scanner(new File("Labirintos.txt"));	
		
		while(sc.hasNext()) {

			Labirinto l = new Labirinto();
			//A primeira linha antes do labirinto no arquivo txt é a quantia de linhas do labirinto
			int qtdLinhas = Integer.parseInt(sc.nextLine());
			l.labirinto = new int[qtdLinhas][];
			
			for (int i = 0; i < qtdLinhas; i++) {
				String linhaAtual = sc.nextLine();
				l.labirinto[i] = Arrays.stream(linhaAtual.split(",")).mapToInt(Integer::parseInt).toArray();
			}
			//A posição de início são as 2 linhas após a declaração de cada matriz do labirinto
			//a primeira é para o Y e a segunda para o X
			l.inicio = new Movimentacao(Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
			sc.nextLine();//Pula uma linha para a identificação de um novo labirinto
			labirintos.add(l);
		}
		sc.close();
		
		return labirintos;
	}
	
	protected static boolean acharSaida(Labirinto l) throws FileNotFoundException {
		Movimentacao mov = l.inicio;
		l.caminho.push(mov);
		System.out.println("Começou na linha: " + (mov.y) + ", coluna: " + (mov.x));

		while(true) {
			//Não consegui executar o programa utilizando somente getY e getX
			//por isso declarei variáveis locais que recebiam eles...
			int y = l.caminho.peek().getY();
			int x = l.caminho.peek().getX();
			
			l.labirinto[y][x] = 0;
			
			//Cima
			if (caminhoValido(mov.getDirecaoCima(), l)) {
				String txtDirecao = "Caminhou para Cima";
				int[] direcao = {y-1, x};
				if (l.labirinto[direcao[0]][direcao[1]] == 2) {
					System.out.println(txtDirecao + " e conseguiu sair na linha: " + direcao[0] + " e coluna:  " + direcao[1]);
					System.out.println("-------------------------------------------------------------------\n");
					return true;
				} else if (l.labirinto[direcao[0]][direcao[1]] == 1) {
					System.out.println(txtDirecao + " na linha: " + direcao[0] + " e coluna: " + direcao[1]);
					l.caminho.push(new Movimentacao(direcao[0], direcao[1]));
					continue;
				}
			}
			
			//Direita
			if (caminhoValido(mov.getDirecaoDireita(), l)) {
				String txtDirecao = "Caminhou para a Direita";
				int[] direcao = {y, x+1};
				if (l.labirinto[direcao[0]][direcao[1]] == 2) {
					System.out.println(txtDirecao + " e conseguiu sair na linha: " + direcao[0] + " e coluna:  " + direcao[1]);
					System.out.println("-------------------------------------------------------------------\n");
					return true;
				} else if (l.labirinto[direcao[0]][direcao[1]] == 1) {
					System.out.println(txtDirecao + " na linha: " + direcao[0] + " e coluna: " + direcao[1]);
					l.caminho.push(new Movimentacao(direcao[0], direcao[1]));
					continue;
				}
			}

			//Abaixo
			if (caminhoValido(mov.getDirecaoAbaixo(), l)) {
				String txtDirecao = "Caminhou para Baixo";
				int[] direcao = {y+1, x};
				if (l.labirinto[direcao[0]][direcao[1]] == 2) {
					System.out.println(txtDirecao + " e conseguiu sair na linha: " + direcao[0] + " e coluna:  " + direcao[1]);
					System.out.println("-------------------------------------------------------------------\n");
					return true;
				} else if (l.labirinto[direcao[0]][direcao[1]] == 1) {
					System.out.println(txtDirecao + " na linha: " + direcao[0] + " e coluna: " + direcao[1]);
					l.caminho.push(new Movimentacao(direcao[0], direcao[1]));
					continue;
				}
			}
			
			//Esquerda
			if (caminhoValido(mov.getDirecaoEsquerda(), l)) {
				String txtDirecao = "Caminhou para a Esquerda";
				int[] direcao = {y, x-1};
				if (l.labirinto[direcao[0]][direcao[1]] == 2) {
					System.out.println();
					System.out.println(txtDirecao + " e conseguiu sair na linha: " + direcao[0] + " e coluna:  " + direcao[1]);
					System.out.println("-------------------------------------------------------------------\n");
					return true;
				} else if (l.labirinto[direcao[0]][direcao[1]] == 1) {
					System.out.println(txtDirecao + " na linha: " + direcao[0] + " e coluna: " + direcao[1]);
					l.caminho.push(new Movimentacao(direcao[0], direcao[1]));
					continue;
				}
			}
			
			l.caminho.pop();
			System.out.println("Retornou para a linha: " + y + ", coluna: " + x);
			if(l.caminho.size() <= 0) {
				return false;
			}
		}
		
	}

	public static boolean caminhoValido(int[] direcao, Labirinto l) {
		Movimentacao p = l.inicio;
		if (p.getY() < 0 || p.getY() >= l.labirinto.length || p.getX() < 0 || p.getX() >= l.labirinto[p.getY()].length) {
			return false;
		}
		return true;
	}
	
}
