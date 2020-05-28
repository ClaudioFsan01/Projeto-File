/*A ideia atrás do polimorfismo no pacote java.io é de utilizar fluxos de entrada ( InputStream ) e
de saída ( OutputStream ) para toda e qualquer operação, seja ela relativa a um arquivo, a um campo
blob do banco de dados, a uma conexão remota via sockets, ou até mesmo às entrada e saída padrão de
um programa (normalmente o teclado e o console).

As classes abstratas InputStream e OutputStream definem, respectivamente, o comportamento
padrão dos fluxos em Java: em um fluxo de entrada, é possível ler bytes e, no fluxo de saída, escrever
bytes.

Obs : InputStream e OutputStream classes "mães" abstratas. 

A grande vantagem dessa abstração pode ser mostrada em um método qualquer que utiliza um
OutputStream recebido como argumento para escrever em um fluxo de saída. Para onde o método está
escrevendo? Não se sabe e não importa: quando o sistema precisar escrever em um arquivo ou em uma
socket, basta chamar o mesmo método, já que ele aceita qualquer filha de OutputStream !

   INPUTSTREAM, INPUTSTREAMREADER E BUFFEREDREADER
   
   Para ler um byte de um arquivo, vamos usar o leitor de arquivo, o FileInputStream . Para um
FileInputStream conseguir ler um byte, ele precisa saber de onde ele deverá ler. Essa informação é tão
importante que quem escreveu essa classe obriga você a passar o nome do arquivo pelo construtor: sem
isso o objeto não pode ser construído.
*/

import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Principal {
	
	/*throws "avisa" da possibilidade de exceção obrigando quem chamar o método a tratala. Neste caso
	 * se trata de um método main por isso o tratamento dentro do proprio método. */
	
	public static void main(String [] args) throws IOException{
		try {
			//InputStream is = new FileInputStream("C:\\Users\\micro\\ProjetosJava\\Arquivos\\src\\file.txt"); // classe FileInputStream é filha da InputStream
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



/*A classe InputStream é abstrata e FileInputStream uma de suas filhas concretas.
FileInputStream vai procurar o arquivo no diretório em que a JVM fora invocada (no caso do
Eclipse, vai ser a partir de dentro do diretório do projeto). Alternativamente você pode usar um caminho
absoluto.*/






