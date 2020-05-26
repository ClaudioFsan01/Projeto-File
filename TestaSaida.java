/* A ANALOGIA PARA A ESCRITA: OUTPUTSTREAM 
 Escrever em um arquivo � o mesmo processo da leitura
 
 OutputStream essa classe abstrata � a superclasse de todas as classes que representam um fluxo de sa�da de bytes. 
 
 FileOutputStream pode receber um booleano como segundo par�metro, para indicar se voc� quer reescrever
  no arquivo ou manter o que j� estava escrito ( append ).
O m�todo write do BufferedWriter n�o insere o(s) caractere(s) de quebra de linha. Para isso,
voc� pode chamar o m�todo newLine .

FileOutputStream cria um fluxo de sa�da de arquivo para gravar no arquivo com o nome especificado. Um novo objeto
FileDescriptor � criado para representar esta conex�o de arquivo.
 * */


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.io.BufferedWriter;
//import java.io.FileWriter;

public class TestaSaida {
	
	public void writeFile( List <String> letraMusica) throws IOException {
		
			OutputStream os = new FileOutputStream("C:\\Users\\micro\\ProjetosJava\\Arquivos\\src\\saida.txt"); /*FileOutputStream cria o arquivo no diretorio e converte os caracteres em bytes*/
			//FileWriter os = new FileWriter("saida.txt"); 
			OutputStreamWriter osw = new OutputStreamWriter(os); /*OutputStreamWriter escreve os caracteres desconcatenados no arquivo*/
			
		    BufferedWriter bw = new BufferedWriter(osw); /*BufferedWriter desconcatena a String em caracteres */
		    try {		
						
			for(String letra : letraMusica) 
			{
			    if(letra != null) {
			    	bw.write(letra);
			    	bw.newLine(); /* Escreve um separador de linhas. */    
			    }			
				
			}			
			
			bw.flush();			
			
			
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}finally {
			bw.close(); // encerra o fluxo 
		}
	
	}

}
