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
        
        for (int x = 0; x < vetor.length; x++) {
            String[] partesDaLinha = vetor[x].split(",");

            if (partesDaLinha.length > 4) {                
                int tamanhoTotal = partesDaLinha.length;
                int ondeDeveComecarAData = tamanhoTotal - 2;
                
                String dataOriginal = partesDaLinha[ondeDeveComecarAData].trim();
                dataModificada = "";

                if (dataOriginal.contains(" ")) {                
                    String[] dataHora = dataOriginal.split(" ");
                    String data = dataHora[0];
                    dataModificada = data;

                    if (data.contains("-")) {                    
                        String[] partesData = data.split("-");
                        dataModificada = partesData[2] + "/" + partesData[1] + "/" + partesData[0];
                    }
                } 
                else {                
                    dataModificada = dataOriginal;
                }
                
            }
            else{
                String dataOriginal = partesDaLinha[3].trim();
                dataModificada = "";

                if (dataOriginal.contains(" ")) {                
                    String[] dataHora = dataOriginal.split(" ");
                    String data = dataHora[0];
                    dataModificada = data;

                    if (data.contains("-")) {                    
                        String[] partesData = data.split("-");
                        dataModificada = partesData[2] + "/" + partesData[1] + "/" + partesData[0];
                    }
                } 
                else {                
                    dataModificada = dataOriginal;
                }
            }
            partesDaLinha[3] = dataModificada;
                vetor[x] = String.join(",", partesDaLinha);
        }
        return vetor;
    }

}