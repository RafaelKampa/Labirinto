/* Aluno: Rafael Gilberto Kampa
 * Mat�ria: Estrutura de dados
 * Professora: Marina de Lara Muller
 * Vers�o 1.0
*/

package principal;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		int i = 0;
		while(i < Labirinto.obterLabirintos().size()) {
			if (!Labirinto.acharSaida(Labirinto.obterLabirintos().get(i))) {
				System.out.println("N�o existe sa�da do labirinto");
			}
			i++;
		}
	}
}
