package Classificações_Transformações;

/**
 *
 * @author Arthur Felipe MS
 */
public class Transformacoes {
    
    public Transformacoes(){
        
    }
    
    public String[] transformaData(String vetor[]){        
        String dataModificada = "";       
        
        for (int x = 1; x < vetor.length; x++) {            
            
            String[] partesDaLinha = vetor[x].split(",");            
            String dataHora[] = partesDaLinha[partesDaLinha.length - 2].split(" ");            
            String data[] = dataHora[0].split("-");
            
            dataModificada =  partesDaLinha[0] + "," + partesDaLinha[1] + "," + partesDaLinha[2]  + "," + data[2] + "/" + data[1] + "/" + data[0] + "," + partesDaLinha[4];
                        
            vetor[x] = dataModificada;
        }
        return vetor;
    }

}