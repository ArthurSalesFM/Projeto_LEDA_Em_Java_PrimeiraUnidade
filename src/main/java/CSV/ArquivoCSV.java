package CSV;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Arthur Felipe MS
 */
public class ArquivoCSV {
    
    public ArquivoCSV() {      
    }
     
    public String[] lerArquivoCSV(String nomeDoArquivo) {
        String csvFilePath = "src/main/java/ArquivoBaseCSV/" + nomeDoArquivo;
        List<String> linhas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                linhas.add(line);
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

    // Converter a lista em um vetor de strings
    String[] vetorDeLinhas = linhas.toArray(new String[0]);
    return vetorDeLinhas;
}
     
     public void criarArquivoCSV(String nomeDoArquivo, String[] conteudo) {
        String csvFilePath = "src/main/java/ArquivoBaseCSV/" + nomeDoArquivo;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFilePath))) {
            
            for (String linha : conteudo) {
                bw.write(linha);
                bw.newLine();
            }
            System.out.println("Arquivo CSV criado com sucesso: " + csvFilePath);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
     
    public void imprimeArray(String array[]){
        
        for(int x = 0; x < array.length; x++){
            System.out.println("Linhas: " + array[x]);
        }
    }
    
}
        
        

