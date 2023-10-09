package DadosDasOrdenacoes;

/**
 *
 * @author Arthur Felipe MS
 */
public class MatrizDosDados {
    
    private double matriz[][] = new double[7][9];
    
    public MatrizDosDados(){
        this.preencheMatriz();
    }
    
    public void inserirValoresNaMatriz(double tempo, int linha, int coluna){
        matriz[linha][coluna] = tempo;
    }
    
    public void imprimeInfoMatriz(){
        for(int linha = 0; linha < 7; linha ++){
            for(int coluna = 0; coluna < 9; coluna ++){
                System.out.print(matriz[linha][coluna] + "\t");
            }
            System.out.print("\n");
        }        
    }
    
    private void preencheMatriz(){
        for(int linha = 0; linha < 7; linha ++){
            for(int coluna = 0; coluna < 9; coluna ++){
                matriz[linha][coluna] = 0;
            }
        }
    }    
    
}
