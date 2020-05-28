/*Quando trabalhamos com java.io , diversos métodos lançam IOException , que é uma exception
 do tipo checked - o que nos obriga a tratá-la ou declará-la. Nos exemplos aqui, estamos declarando
IOException através da clausula throws do main apenas para facilitar o exemplo como exemplo mostrado na classe Principal. Caso a exception
ocorra, a JVM vai parar, mostrando a stacktrace. Esta não é uma boa prática em uma aplicação real: trate
suas exceptions para sua aplicação poder abortar elegantemente.

InputStream tem diversas outras filhas, como ObjectInputStream , AudioInputStream ,
ByteArrayInputStream , entre outras.
Para recuperar um caractere, precisamos traduzir os bytes com o encoding dado para o respectivo
código unicode, isso pode usar um ou mais bytes. Escrever esse decodificador é muito complicado, quem
faz isso por você é a classe InputStreamReader .
 * */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;


public class TestaEntrada {
	
	public void readFile() throws IOException{
		InputStream is = new FileInputStream("C:\\Users\\micro\\ProjetosJava\\Arquivos\\src\\entrada.txt"); /*FileInputStream para entrada baseada em bytes de um arquivo*/
		InputStreamReader isr = new InputStreamReader(is); //InputStreamReader ler o caracteres do arquivo
		BufferedReader br = new BufferedReader(isr); //BufferedReader concatena os caracteres lido criando uma String
		TestaSaida ts = new TestaSaida();		
	    List <String> letraMusica = new ArrayList<>();
		
		  try {			 
				String letra =  br.readLine();
				
				while(letra != null)
				{	
							
				//System.out.println(s);			
					letraMusica.add(letra);					
					letra =  br.readLine();
			    }
				
			  ts.writeFile(letraMusica);		
		  }catch(FileNotFoundException e) { 
			  System.out.println(e.getMessage());
		  }catch(IOException e) {
			  System.out.println(e.getMessage());
		  }finally{
			  br.close(); // Fecha o fluxo e libera todos os recursos do sistema associados a ele.
		  }
			 
		
		 
	}

}

/*O método readLine devolve a linha que foi lida e
muda o cursor para a próxima linha. Caso ele chegue ao fim do Reader (no nosso caso, fim do
arquivo), ele vai devolver null . Então, com um simples laço, podemos ler o arquivo por inteiro:*/


/* InputStreamReader é filha da classe abstrata Reader , que possui diversas outras filhas - são
 classes que manipulam chars. 
 
 *OBS : O construtor de InputStreamReader pode receber o encoding a ser utilizado como parâmetro, se
desejado, tal como UTF-8 ou ISO-8859-1 .

Apesar da classe abstrata Reader já ajudar no trabalho de manipulação de caracteres, ainda seria.
difícil pegar uma String . A classe BufferedReader é um Reader que recebe outro Reader pelo
construtor e concatena os diversos chars para formar uma String através do método readLine :

Como o próprio nome diz, essa classe lê do Reader por pedaços (usando o buffer) para evitar
realizar muitas chamadas ao sistema operacional. Você pode até configurar o tamanho do buffer pelo
construtor.


O método readLine devolve a linha que foi lida e
muda o cursor para a próxima linha. Caso ele chegue ao fim do Reader (no nosso caso, fim do
arquivo), ele vai devolver null . Então, com um simples laço, podemos ler o arquivo por inteiro:


Esse padrão de composição é bastante utilizado e conhecido. É o Decorator Pattern. (Padrão decorador)

*/



