import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

/*
 A partir do Java 5, temos a classe java.util.Scanner , que facilita bastante o trabalho de ler de um
InputStream . Al�m disso, a classe PrintStream possui um construtor que j� recebe o nome de um
arquivo como argumento. Dessa forma, a leitura do teclado com sa�da para um arquivo ficou muito
simples. Ex:
 */
public class ManipularFile {
	
	//Scanner sc = new Scanner(System.in);
		
	public void escreverArquivoDadosLidosTeclado() throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
      String diretorio = "C:\\Users\\micro\\ProjetosJava\\Arquivos\\src\\file2.txt";
		
		PrintStream ps = new PrintStream(diretorio); //escreve no arquivo  utilizando PrintStream
		
		InputStream is = System.in; // Dados ser�o lidos do teclado
		InputStreamReader isr = new InputStreamReader(is); //InputStreamReader ler o caracteres do teclado
		BufferedReader br = new BufferedReader(isr); //BufferedReader concatena os caracteres lido criando uma String
					
		
		try {	
			String frase;
			do {
				
				System.out.println(" Escreva no arquivo : \n");		
				frase = br.readLine();
											
					ps.println(frase);					
					
			 System.out.println(" Deseja continuar escrevendo no arquivo ? (1-sim) (2-n�o) : \n");	
			}while(sc.nextInt() != 2);		
		
		}catch(IllegalStateException e) {
			System.out.println(e.getMessage());
		}finally {
		  ps.close();
		  
		  System.out.println(" Arquivo fechado ! : \n");
		}	
		
		
	} // fechamento do m�todo escreverArquivo()
	
	
	
	



/*
 hasNextLine() Retorna true se houver outra linha na entrada deste scanner. 
Este m�todo pode bloquear enquanto aguarda a entrada.
 O scanner n�o avan�a al�m de nenhuma entrada.
 * */



/*Nenhum dos m�todos lan�a IOException : PrintStream lan�a FileNotFoundException se voc�
o construir passando uma String . Essa exce��o � filha de IOException e indica que o arquivo n�o foi
encontrado. O Scanner considerar� que chegou ao fim se uma IOException for lan�ada, mas o
PrintStream simplesmente engole exceptions desse tipo. Ambos possuem m�todos para voc� verificar
se algum problema ocorreu.*/


//Classe FileReader: para entrada baseada em caracteres de um arquivo.
//FileWriter: para sa�da baseada em caracteres para um arquivo.


public void lerCaracteresArquivo(String path) throws IOException {
	
	FileReader fr = new FileReader(path);	
	BufferedReader br = new BufferedReader(fr);
	
	String dadoLido = null;
	
	try {
		
		do {
			dadoLido = br.readLine();
			
			escreverCaracteresArquivo(dadoLido);
		    		
		}while(dadoLido != null);		
		
	}catch(FileNotFoundException e) {
		System.out.println(e.getMessage());
	}finally {
		br.close();
		System.out.println(" Arquivo lido encerrado ! \n");
	}
	
	
}


public void escreverCaracteresArquivo(String dado) throws IOException{
		
	String path ="C:\\Users\\micro\\ProjetosJava\\Arquivos\\src\\fileEscrito.txt";
	
	Scanner sc = new Scanner(System.in);
	
	BufferedWriter bw = new BufferedWriter(new FileWriter(path));
	try {	
			
			bw.append(dado+"\n");
			//bw.newLine();
			
		
	}catch(FileNotFoundException e) {
		
	}finally {
		bw.flush();
		bw.close();
		System.out.println(" Arquivo escrito encerrado ! \n");
		
	}
	
}


}





