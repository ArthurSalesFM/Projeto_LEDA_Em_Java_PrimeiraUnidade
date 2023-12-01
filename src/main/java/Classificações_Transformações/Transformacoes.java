package Classificações_Transformações;

import EstruturasDeDados.Fila;

/**
 *
 * @author Arthur Felipe MS
 */
public class Transformacoes {
    
    public Transformacoes(){
        
    }
    
    public String[] transformaData(String vetor[]){        
        Fila fila = new Fila();
        
        for (int x = 1; x < vetor.length; x++) {            
            fila.enfileirar(vetor[x]); 
        }
        
        realizarTransformacoes(fila);        
        return fila.paraArray();
    }
    
    private void realizarTransformacoes(Fila fila) {
        Fila filaTransformada = new Fila(); 
        
        while (!fila.estaVazia()) {
            String linha = fila.desenfileirar(); 
           
            String[] partesDaLinha = linha.split(",");            
            String dataHora[] = partesDaLinha[partesDaLinha.length - 2].split(" ");            
            String data[] = dataHora[0].split("-");
            
            String dataModificada = partesDaLinha[0] + "," + partesDaLinha[1] + "," + partesDaLinha[2]  + "," + data[2] + "/" + data[1] + "/" + data[0] + "," + partesDaLinha[4];
                        
            filaTransformada.enfileirar(dataModificada);
        }
        
        while (!filaTransformada.estaVazia()) {
            fila.enfileirar(filaTransformada.desenfileirar());
        }
    }
   
}