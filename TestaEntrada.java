/*Quando trabalhamos com java.io , diversos m�todos lan�am IOException , que � uma exception
 do tipo checked - o que nos obriga a trat�-la ou declar�-la. Nos exemplos aqui, estamos declarando
IOException atrav�s da clausula throws do main apenas para facilitar o exemplo como exemplo mostrado na classe Principal. Caso a exception
ocorra, a JVM vai parar, mostrando a stacktrace. Esta n�o � uma boa pr�tica em uma aplica��o real: trate
suas exceptions para sua aplica��o poder abortar elegantemente.

InputStream tem diversas outras filhas, como ObjectInputStream , AudioInputStream ,
ByteArrayInputStream , entre outras.
Para recuperar um caractere, precisamos traduzir os bytes com o encoding dado para o respectivo
c�digo unicode, isso pode usar um ou mais bytes. Escrever esse decodificador � muito complicado, quem
faz isso por voc� � a classe InputStreamReader .
 * */


import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class TestaEntrada {
	
	public void readFile() throws IOException{
		InputStream is = new FileInputStream("C:\\Users\\micro\\ProjetosJava\\Arquivos\\src\\file2.txt"); 
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String s;
		 do{
			 s =  br.readLine();
			System.out.println(s);
			
		}while(s != null);		
		 
		 br.close(); // Fecha o fluxo e libera todos os recursos do sistema associados a ele.
		 
	}

}


/* InputStreamReader � filha da classe abstrata Reader , que possui diversas outras filhas - s�o
 classes que manipulam chars. 
 
 *OBS : O construtor de InputStreamReader pode receber o encoding a ser utilizado como par�metro, se
desejado, tal como UTF-8 ou ISO-8859-1 .

Apesar da classe abstrata Reader j� ajudar no trabalho de manipula��o de caracteres, ainda seria.
dif�cil pegar uma String . A classe BufferedReader � um Reader que recebe outro Reader pelo
construtor e concatena os diversos chars para formar uma String atrav�s do m�todo readLine :

Como o pr�prio nome diz, essa classe l� do Reader por peda�os (usando o buffer) para evitar
realizar muitas chamadas ao sistema operacional. Voc� pode at� configurar o tamanho do buffer pelo
construtor.


O m�todo readLine devolve a linha que foi lida e
muda o cursor para a pr�xima linha. Caso ele chegue ao fim do Reader (no nosso caso, fim do
arquivo), ele vai devolver null . Ent�o, com um simples la�o, podemos ler o arquivo por inteiro:

*/



