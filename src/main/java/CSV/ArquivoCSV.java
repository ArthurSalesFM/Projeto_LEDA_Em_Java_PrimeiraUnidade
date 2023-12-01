package CSV;

import EstruturasDeDados.ListaEncadeada;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Arthur Felipe MS
 */
public class ArquivoCSV {
    
    public ArquivoCSV() {      
    }
    
    public String[] lerArquivoCSV(String nomeDoArquivo) {
        String caminhoCSV = "src/main/java/ArquivoBaseCSV/" + nomeDoArquivo;
        ListaEncadeada listaEncadeada = new ListaEncadeada();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoCSV))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                listaEncadeada.inserir(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaEncadeada.paraArray();
    }   
          
     public void criarArquivoCSV(String nomeDoArquivo, String[] conteudo) {
        String csvFilePath = "src/main/java/ArquivoBaseCSV/" + nomeDoArquivo;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFilePath))) {

            for (String linha : conteudo) {
                if (linha != null && !linha.trim().isEmpty()) {
                    bw.write(linha);
                    bw.newLine();
                }
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}