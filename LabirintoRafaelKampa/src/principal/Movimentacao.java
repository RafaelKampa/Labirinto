package principal;

import java.util.LinkedList;

public class Movimentacao {
	public int x;
	public int y;
	public int[] direcaoCima = {y-1, x};
	public int[] direcaoDireita = {y, x+1};
	public int[] direcaoAbaixo = {y+1, x};
	public int[] direcaoEsquerda = {y, x-1};
	public LinkedList<Movimentacao> caminho = new LinkedList<Movimentacao>();
	
	public Movimentacao(int y, int x) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = caminho.peek().x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = caminho.peek().y;
	}

	public int[] getDirecaoCima() {
		return direcaoCima;
	}

	public void setDirecaoCima(int[] direcaoCima) {
		this.direcaoCima = direcaoCima;
	}

	public int[] getDirecaoDireita() {
		return direcaoDireita;
	}

	public void setDirecaoDireita(int[] direcaoDireita) {
		this.direcaoDireita = direcaoDireita;
	}

	public int[] getDirecaoAbaixo() {
		return direcaoAbaixo;
	}

	public void setDirecaoAbaixo(int[] direcaoAbaixo) {
		this.direcaoAbaixo = direcaoAbaixo;
	}

	public int[] getDirecaoEsquerda() {
		return direcaoEsquerda;
	}

	public void setDirecaoEsquerda(int[] direcaoEsquerda) {
		this.direcaoEsquerda = direcaoEsquerda;
	}

}
