/* Aluno: Rafael Gilberto Kampa
 * Matéria: Estrutura de dados
 * Professora: Marina de Lara Muller
 * Versão 1.0
*/

package principal;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		int i = 0;
		while(i < Labirinto.obterLabirintos().size()) {
			if (!Labirinto.acharSaida(Labirinto.obterLabirintos().get(i))) {
				System.out.println("Não existe saída do labirinto");
			}
			i++;
		}
	}
}
