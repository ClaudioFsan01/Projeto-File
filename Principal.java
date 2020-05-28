/*A ideia atr�s do polimorfismo no pacote java.io � de utilizar fluxos de entrada ( InputStream ) e
de sa�da ( OutputStream ) para toda e qualquer opera��o, seja ela relativa a um arquivo, a um campo
blob do banco de dados, a uma conex�o remota via sockets, ou at� mesmo �s entrada e sa�da padr�o de
um programa (normalmente o teclado e o console).

As classes abstratas InputStream e OutputStream definem, respectivamente, o comportamento
padr�o dos fluxos em Java: em um fluxo de entrada, � poss�vel ler bytes e, no fluxo de sa�da, escrever
bytes.

Obs : InputStream e OutputStream classes "m�es" abstratas. 

A grande vantagem dessa abstra��o pode ser mostrada em um m�todo qualquer que utiliza um
OutputStream recebido como argumento para escrever em um fluxo de sa�da. Para onde o m�todo est�
escrevendo? N�o se sabe e n�o importa: quando o sistema precisar escrever em um arquivo ou em uma
socket, basta chamar o mesmo m�todo, j� que ele aceita qualquer filha de OutputStream !

   INPUTSTREAM, INPUTSTREAMREADER E BUFFEREDREADER
   
   Para ler um byte de um arquivo, vamos usar o leitor de arquivo, o FileInputStream . Para um
FileInputStream conseguir ler um byte, ele precisa saber de onde ele dever� ler. Essa informa��o � t�o
importante que quem escreveu essa classe obriga voc� a passar o nome do arquivo pelo construtor: sem
isso o objeto n�o pode ser constru�do.
*/

import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Principal {
	
	/*throws "avisa" da possibilidade de exce��o obrigando quem chamar o m�todo a tratala. Neste caso
	 * se trata de um m�todo main por isso o tratamento dentro do proprio m�todo. */
	
	public static void main(String [] args) throws IOException{
		try {
			//InputStream is = new FileInputStream("C:\\Users\\micro\\ProjetosJava\\Arquivos\\src\\file.txt"); // classe FileInputStream � filha da InputStream
			//int numero = is.read();
			
			//System.out.println(" Foi lido arquivo o numero : "+ numero);
			
			TestaEntrada te = new TestaEntrada();
			ManipularFile mf = new ManipularFile();
		
			mf.escreverArquivoDadosLidosTeclado();
			// lendo os dados do arquivo entrada e escrevendo no arquivo saida
			
			te.readFile();
			
		
			
						
		}catch(FileNotFoundException e) {
			System.out.println(" Erro : "+ e.getMessage());
		}catch(IOException e) {
			System.out.println(" Erro : "+ e.getMessage());
		}
	}

}



/*A classe InputStream � abstrata e FileInputStream uma de suas filhas concretas.
FileInputStream vai procurar o arquivo no diret�rio em que a JVM fora invocada (no caso do
Eclipse, vai ser a partir de dentro do diret�rio do projeto). Alternativamente voc� pode usar um caminho
absoluto.*/






