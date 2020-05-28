import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

/*
 A partir do Java 5, temos a classe java.util.Scanner , que facilita bastante o trabalho de ler de um
InputStream . Além disso, a classe PrintStream possui um construtor que já recebe o nome de um
arquivo como argumento. Dessa forma, a leitura do teclado com saída para um arquivo ficou muito
simples. Ex:
 */
public class ManipularFile {
	
	//Scanner sc = new Scanner(System.in);
		
	public void escreverArquivoDadosLidosTeclado() throws IOException {
		
      String diretorio = "C:\\Users\\micro\\ProjetosJava\\Arquivos\\src\\file2.txt";
		
		PrintStream ps = new PrintStream(diretorio); //escreve no arquivo  utilizando PrintStream
		
		InputStream is = System.in; // Dados serão lidos do teclado
		InputStreamReader isr = new InputStreamReader(is); //InputStreamReader ler o caracteres do teclado
		BufferedReader br = new BufferedReader(isr); //BufferedReader concatena os caracteres lido criando uma String
					
		
		try {	
			String frase;
			do {
				
				System.out.println(" Escreva no arquivo : \n");		
				frase = br.readLine();
											
					ps.println(frase);					
					
				
			}while(frase != "");		
		
		}catch(IllegalStateException e) {
			System.out.println(e.getMessage());
		}finally {
		  ps.close();
		  
		  System.out.println(" Arquivo fechado ! : \n");
		}	
		
		
	} // fechamento do método escreverArquivo()
	
	

}

/*
 hasNextLine() Retorna true se houver outra linha na entrada deste scanner. 
Este método pode bloquear enquanto aguarda a entrada.
 O scanner não avança além de nenhuma entrada.
 * */



/*Nenhum dos métodos lança IOException : PrintStream lança FileNotFoundException se você
o construir passando uma String . Essa exceção é filha de IOException e indica que o arquivo não foi
encontrado. O Scanner considerará que chegou ao fim se uma IOException for lançada, mas o
PrintStream simplesmente engole exceptions desse tipo. Ambos possuem métodos para você verificar
se algum problema ocorreu.*/