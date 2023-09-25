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
        
        String[] vetorDeLinhas = linhas.toArray(new String[0]);
        return vetorDeLinhas;
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