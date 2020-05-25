/* A ANALOGIA PARA A ESCRITA: OUTPUTSTREAM 
 Escrever em um arquivo é o mesmo processo da leitura
 
 OutputStream essa classe abstrata é a superclasse de todas as classes que representam um fluxo de saída de bytes. 
 
 FileOutputStream pode receber um booleano como segundo parâmetro, para indicar se você quer reescrever
  no arquivo ou manter o que já estava escrito ( append ).
O método write do BufferedWriter não insere o(s) caractere(s) de quebra de linha. Para isso,
você pode chamar o método newLine .

FileOutputStream cria um fluxo de saída de arquivo para gravar no arquivo com o nome especificado. Um novo objeto
FileDescriptor é criado para representar esta conexão de arquivo.
 * */


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class TestaSaida {
	
	public void writeFile() throws IOException {
		
		//OutputStream os = new FileOutputStream("saida.txt"); /*FileOutputStream cria o arquivo no diretorio e converte os caracteres em bytes*/
		FileWriter os = new FileWriter("saida.txt"); 
		/*OutputWriter osw = new OutputWriter(os); OutputStreamWriter escreve os caracteres desconcatenados no arquivo*/
		BufferedWriter bw = new BufferedWriter(os); /*BufferedWriter desconcatena a String em caracteres */
		
		bw.write("Claudio"); /* Escreve uma matriz de caracteres.*/
		bw.flush();
		bw.close(); // encerra o fluxo 
		
	}

}
