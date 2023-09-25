package Classificações_Transformações;

/**
 *
 * @author Arthur Felipe MS
 */
public class Transformacoes {
    
    public Transformacoes(){
        
    }
    
    public String[] transformaData(String vetor[]) {
        String dataModificada = "";

        try {
            for (int x = 0; x < vetor.length; x++) {
                String[] partesDaLinha = vetor[x].split(",");

                if (x == 0) {
                    dataModificada = vetor[x];
                    vetor[x] = dataModificada;
                } 
                else {
                    String[] parteEspecificaDaData = partesDaLinha[3].split(" ")[0].split("-");
                    dataModificada = parteEspecificaDaData[2] + "/" + parteEspecificaDaData[1] + "/" + parteEspecificaDaData[0];
                    partesDaLinha[3] = dataModificada;
                    vetor[x] = String.join(",", partesDaLinha);
                }
            }
        } 
        catch (Exception e) {
            
        }

        return vetor;
    }

}